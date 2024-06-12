import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.util.*;
import java.io.*;
import java.security.SecureRandom;
import java.util.Base64;

public class PasswordManager3 {

    private static final String PASSWORD_FILE = "passwords.txt";
    //where passwords are stored
    private static final String ENCRYPTED_KEY_FILE = "encryptedKey.txt";
    //file to store encrypted secret key so that the shared key for encryption and decryption is
    //secure
    private static final int KEY_LENGTH = 16;
    //length of AES-128 key (16 bytes) needed for usability
    private static final int IV_LENGTH = 16;
    //AES block size for CBC mode

    public static void main(String[] args) {
        try {
            //generate a new one time pad to protect the secret key
            String otp = generateRandomKey(KEY_LENGTH);
            //one time pad which can only be used once

            //encrypt the secret key with OTP and store both encrypted key and OTP
            //encrypt the key with otp and store the otp and encrypted key
            //need the OTP for decryption later
            SecretKeySpec keySpec = generateSecretKey();
            //key that will be used for AES protection during
            //encryption and decryption
            String encryptedKey = encryptWithOTP(Base64.getEncoder().encodeToString(keySpec.getEncoded()), otp);
            storeEncryptedKey(encryptedKey, otp);//store encrypted key with OTP

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("1 = Add Password");
                System.out.println("2 = Get Password");
                System.out.println("3 = Exit");
                System.out.print("Choose a number corresponding to a task: ");
                int choice = scanner.nextInt();
                scanner.nextLine();
                //gets user input for actions by code
                switch (choice) {
                    case 1:
                        System.out.print("Enter website name: ");
                        String website = scanner.nextLine();
                        System.out.print("Enter password: ");
                        String password = scanner.nextLine();
                        addPassword(website, password);
                        System.out.println("Password added.");
                        break;
                    case 2:
                        System.out.print("Enter website name: ");
                        website = scanner.nextLine();
                        String retrievedPassword = retrievePassword(website);
                        if (retrievedPassword != null) {
                            System.out.println("Password for " + website + ": " + retrievedPassword);
                        } else {
                            System.out.println("No password found for " + website);
                        }
                        break;
                    case 3:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        //all cases of inputs by user trying the different tasks
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); //displays error information if keys are wrong
        }
    }

    //generate a random secret key for AES-128
    private static SecretKeySpec generateSecretKey() {
        return new SecretKeySpec("mysecretkey12345".getBytes(), "AES");
        //protected AES key
    }

    //generates a random one-time pad (OTP)
    private static String generateRandomKey(int length) {
        SecureRandom random = new SecureRandom();
        byte[] keyBytes = new byte[length];
        random.nextBytes(keyBytes); //randomness with random function provided
        return Base64.getEncoder().encodeToString(keyBytes); //return as a string with Base64 so that
        //binary and text data are not confused
    }
    //encrypt text with an OTP
    private static String encryptWithOTP(String text, String otp) {
        byte[] textBytes = Base64.getDecoder().decode(text);
        byte[] otpBytes = Base64.getDecoder().decode(otp);
        byte[] encryptedBytes = new byte[textBytes.length];

        for (int i = 0; i < textBytes.length; i++) {
            encryptedBytes[i] = (byte) (textBytes[i] ^ otpBytes[i]); //XOR for OTP encryption
        }

        return Base64.getEncoder().encodeToString(encryptedBytes);
        //return encrypted text as Base64
    }

    //decrypt text with an OTP
    private static String decryptWithOTP(String text, String otp) {
        byte[] textBytes = Base64.getDecoder().decode(text);
        byte[] otpBytes = Base64.getDecoder().decode(otp);
        byte[] decryptedBytes = new byte[textBytes.length];

        for (int i = 0; i < textBytes.length; i++) {
            decryptedBytes[i] = (byte) (textBytes[i] ^ otpBytes[i]);//XOR for OTP decryption
        }

        return Base64.getEncoder().encodeToString(decryptedBytes); //return decrypted text as Base64
    }

    private static void storeEncryptedKey(String encryptedKey, String otp) throws Exception {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ENCRYPTED_KEY_FILE))) {
            writer.write(encryptedKey + ":" + otp); //write in and store encrypted key and OTP
            //cause both will still be needed
        }
    }

    //decrypt and retrieve the secret key using OTP
    private static SecretKeySpec decryptSecretKey() throws Exception {
        String encryptedKeyWithOtp;
        try (BufferedReader reader = new BufferedReader(new FileReader(ENCRYPTED_KEY_FILE))) {
            encryptedKeyWithOtp = reader.readLine(); //read the stored encrypted key and OTP
        }

        String[] parts = encryptedKeyWithOtp.split(":");
        //so they can be used for decryption correctly
        String encryptedKey = parts[0];
        String otp = parts[1];

        //decrypt the secret key with the OTP you just got from above^^^^
        String decryptedKey = decryptWithOTP(encryptedKey, otp);
        byte[] keyBytes = Base64.getDecoder().decode(decryptedKey);

        return new SecretKeySpec(keyBytes, "AES");
        //return decrypted SecretKeySpec
    }
    //OTP was used to protect AES key
    //AES needs AES key to needed to encrypt and decrypt passwords (so they are secure for user
    //inside the manager system)

    private static void addPassword(String website, String password) throws Exception {
        SecretKeySpec keySpec = decryptSecretKey();

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

        //generate a new random IV for each encryption for CBC mode
        byte[] iv = new byte[IV_LENGTH];
        SecureRandom random = new SecureRandom();
        random.nextBytes(iv);

        IvParameterSpec ivSpec = new IvParameterSpec(iv);

        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
        byte[] encryptedBytes = cipher.doFinal(password.getBytes());

        //store the IV along with the encrypted password, so it can be used for decryption later
        String encryptedPassword = Base64.getEncoder().encodeToString(iv) + ":" + Base64.getEncoder().encodeToString(encryptedBytes);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PASSWORD_FILE, true))) {
            writer.write(website + ":" + encryptedPassword + "\n");
            //write encrypted password to password file
        }
    }

    private static String retrievePassword(String website) throws Exception {
        SecretKeySpec keySpec = decryptSecretKey();

        try (BufferedReader reader = new BufferedReader(new FileReader(PASSWORD_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts[0].equals(website)) {
                    //fine password to specfic website
                    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

                    //get the IV and the encrypted password
                    String ivString = parts[1];
                    String encryptedPasswordString = parts[2];

                    IvParameterSpec ivSpec = new IvParameterSpec(Base64.getDecoder().decode(ivString));

                    cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
                    byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedPasswordString));
                    //decrypt encrypted password to get user inputted password
                    return new String(decryptedBytes);
                }
            }
        }
        return null;
    }
}
