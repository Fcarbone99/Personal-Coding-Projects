<?php 
// Ensure a session is active
if (session_status() === PHP_SESSION_NONE) {
    session_start();
}

// Include the database connection file
require_once 'conn.php'; // Ensure 'conn.php' initializes $conn correctly

// Check if the user is logged in
if (!isset($_SESSION['user_id'])) {
    echo "<div class='container d-flex justify-content-center' style='height: 100vh;'><h1>Access denied. Please log in.</h1></div>";
    exit;
}

try {
    // Get the logged-in user's ID from the session
    $user_id = $_SESSION['user_id'];

    // Prepare a query to check if the user is an admin
    $stmt = $conn->prepare("SELECT is_admin FROM users WHERE id = :id");
    $stmt->bindParam(':id', $user_id, PDO::PARAM_INT);
    $stmt->execute();

    // Fetch user details
    $user = $stmt->fetch(PDO::FETCH_ASSOC);

    // Check if the user is an admin
    if ($user && $user['is_admin'] == 1) {
        echo "<div class='container d-flex flex-column align-items-center justify-content-center' style='height: 80vh;'>";
        echo "  <h1>Admin Privileges Only</h1>";
        echo "  <div class='mt-4'>";
        echo "    <h2 style='border-bottom: 2px solid #000000; padding-bottom: 10px;'>Admin Dashboard</h2>";
        
        // Fetch total number of users
        $stmt = $conn->prepare("SELECT COUNT(*) AS total_users FROM users");
        $stmt->execute();
        $user_count = $stmt->fetch(PDO::FETCH_ASSOC);

        // Fetch total number of messages
        $stmt = $conn->prepare("SELECT COUNT(*) AS total_messages FROM messages");
        $stmt->execute();
        $message_count = $stmt->fetch(PDO::FETCH_ASSOC);

        // Display statistics
        echo "    <p>Total Users: " . $user_count['total_users'] . "</p>";
        echo "    <p>Total Messages: " . $message_count['total_messages'] . "</p>";

        // Fetch recent users
        $stmt = $conn->prepare("SELECT username, email, created_at FROM users ORDER BY created_at DESC LIMIT 5");
        $stmt->execute();
        $recent_users = $stmt->fetchAll(PDO::FETCH_ASSOC);

        echo "    <h3>Recent Users</h3>";
        echo "    <ul>";
        foreach ($recent_users as $user) {
            echo "<li>" . htmlspecialchars($user['username']) . " (" . htmlspecialchars($user['email']) . ") - " . $user['created_at'] . "</li>";
        }
        echo "    </ul>";

        // Fetch recent messages
        $stmt = $conn->prepare("SELECT name, phone, message, created_at FROM messages ORDER BY created_at DESC LIMIT 5");
        $stmt->execute();
        $recent_messages = $stmt->fetchAll(PDO::FETCH_ASSOC);

        echo "    <h3>Recent Messages</h3>";
        echo "    <ul>";
        foreach ($recent_messages as $message) {
            echo "<li><strong>Name:</strong> " . htmlspecialchars($message['name']) . 
                 " | <strong>Phone:</strong> " . htmlspecialchars($message['phone']) . 
                 " | <strong>Message:</strong> " . htmlspecialchars($message['message']) . 
                 " | <strong>Created_at:</strong> " . $message['created_at'] . "</li>";
        }
        echo "    </ul>";

        echo "  </div>";
        echo "</div>";

    } else {
        echo "<div class='container d-flex justify-content-center' style='height: 100vh; padding-top: 20px;'><h1>Need admin privileges.</h1></div>";
    }
} catch (PDOException $e) {
    // Handle database errors
    echo "<div class='container d-flex justify-content-center' style='height: 100vh; padding-top: 20px;'><h1>Error: " . $e->getMessage() . "</h1></div>";
}
?>
