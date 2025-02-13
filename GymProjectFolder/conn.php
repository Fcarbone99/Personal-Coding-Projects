
<?php
// conn.php

// Define your database server details
$servername = "localhost"; // Or your database server's address
$username = "root";        // Your MySQL username
$password = "";            // Your MySQL password
$dbname = "myDBPDO";       // Your database name

try {
    // Create a new PDO instance
    $conn = new PDO("mysql:host=$servername;dbname=$dbname", $username, $password);

    // Set the PDO error mode to exception to handle errors
    $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

    //echo "Database connection successful!<br>";
} catch (PDOException $e) {
    echo "Database connection failed: " . $e->getMessage() . "<br>";
    exit(); // Stop script if connection fails
}
?>