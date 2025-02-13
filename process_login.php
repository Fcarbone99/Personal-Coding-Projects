<?php
session_start();
include './includes/conn.php';

$error = "";

// Check if the form is submitted with the POST method
if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    // Retrieve the username and password from the form submission
    $username = trim($_POST['username']);
    $password = trim($_POST['password']);

    echo $username . "<br>";
    echo $password . "<br>";

    // Check if $conn is defined and available
    if (isset($conn)) {
        // Database name
        $dbname = "myDBPDO";

        try {
            // Select the database
            $conn->exec("USE $dbname");

            // Prepare the SQL query to fetch the user by username
            $sql = "SELECT id, username, password, full_name, FileData FROM users WHERE username = :username";
            $stmt = $conn->prepare($sql);
            $stmt->bindParam(':username', $username, PDO::PARAM_STR);
            $stmt->execute();

            // Check if a user with the provided username exists
            if ($stmt->rowCount() > 0) {
                $user = $stmt->fetch(PDO::FETCH_ASSOC);

                // Verify the password
                if (password_verify($password, $user['password'])) {
                    // Password is correct, set up the session
                    $_SESSION['user_id'] = $user['id'];
                    $_SESSION['username'] = $user['username'];
                    $_SESSION['full_name'] = $user['full_name'];
                    $_SESSION['user_image'] = $user['FileData'] ? 'data:image/jpeg;base64,' . base64_encode($user['FileData']) : '';

                    // Redirect to the home page
                    header('Location: home.php');
                    exit();
                } else {
                    // Password is incorrect
                    $error = "Invalid username or password.";
                }
            } else {
                // No user found with that username
                $error = "Invalid username or password.";
            }
        } catch (PDOException $e) {
            $error = "Database error: " . $e->getMessage();
        }
    } else {
        $error = "Database connection unavailable.";
    }

    // If there's an error, store it in the session and redirect to the login page
    if (!empty($error)) {
        $_SESSION['login_error'] = $error;
        header('Location: index.php');
        exit();
    }
} else {
    // If not a POST request, display an error message
    $error = "Invalid request method.";
    $_SESSION['login_error'] = $error;
    header('Location: index.php');
    exit();
}