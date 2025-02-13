<?php
// Include the database connection
include('conn.php');

// Replace these with your actual business details
$businessName = "The Movement Collective";
$address = "290 Pratt Street, Unit 1331, Meriden, CT 06450";
$phone = "(203) 507-8708";

// Handle form submission
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $name = htmlspecialchars($_POST['name']);
    $phone = htmlspecialchars($_POST['phone']);
    $message = htmlspecialchars($_POST['message']);

    try {
        // Prepare the SQL query to insert the data into the 'messages' table
        $stmt = $conn->prepare("INSERT INTO messages (name, phone, message) VALUES (:name, :phone, :message)");

        // Bind the parameters
        $stmt->bindParam(':name', $name);
        $stmt->bindParam(':phone', $phone);
        $stmt->bindParam(':message', $message);

        // Execute the query
        if ($stmt->execute()) {
            $successMessage = "Thank you for contacting us! Your message has been received.";
        } else {
            $errorMessage = "Sorry, something went wrong. Please try again later.";
        }
    } catch (PDOException $e) {
        // Handle any errors that occur during the query execution
        $errorMessage = "Error: " . $e->getMessage();
    }
}
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Contact Us - <?php echo $businessName; ?></title>
    <link rel="icon" type="image/x-icon" href="./images/mvmtpic.png">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link rel="stylesheet" href="css/styles.css">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <style>
        body {
            line-height: 1.6;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 800px;
            margin: 0px auto;
            padding: 20px;
            border: 0px solid #ccc;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }
        h1, h2 {
            text-align: center;
        }
        form {
            margin-top: 20px;
        }
        input, textarea {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        button {
            background-color: #007BFF;
            color: white;
            border: none;
            padding: 10px 20px;
            cursor: pointer;
            border-radius: 4px;
        }
        button:hover {
            background-color: #0056b3;
        }
        .message {
            padding: 10px;
            margin-bottom: 10px;
            border-radius: 4px;
            text-align: center;
        }
        .success {
            background-color: #d4edda;
            color: #155724;
        }
        .error {
            background-color: #f8d7da;
            color: #721c24;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Contact Us</h1>
    <p>Feel free to reach out to us using the form below or through our contact information.</p>
    <h2><?php echo $businessName; ?></h2>
    <p><strong>Address:</strong> <?php echo $address; ?></p>
    <p><strong>Phone:</strong> <?php echo $phone; ?></p>

    <?php if (!empty($successMessage)): ?>
        <div class="message success"><?php echo $successMessage; ?></div>
    <?php elseif (!empty($errorMessage)): ?>
        <div class="message error"><?php echo $errorMessage; ?></div>
    <?php endif; ?>

    <form action="" method="POST">
        <input type="text" name="name" placeholder="Your Name" required>
        <input type="text" name="phone" placeholder="Your Phone Number" required>
        <textarea name="message" rows="5" placeholder="Your Message" required></textarea>
        <button type="submit">Send Message</button>
    </form>
</div>
</body>
</html>
