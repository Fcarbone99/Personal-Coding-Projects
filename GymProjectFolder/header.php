<?php 
session_start();

// Check if the user is logged in
if (!isset($_SESSION['user_id'])) {
    // Redirect to the index page if not logged in
    header('Location: index.php');
    exit();
}

// Retrieve user data from the session
$fullName = $_SESSION['full_name'];
$userImage = $_SESSION['user_image'];
?>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/5.3.0/css/bootstrap.min.css" rel="stylesheet">
<style>
    header {
        background: linear-gradient(135deg, #f06, #f90);
        color: white;
        height: 20vh;
        display: flex;
        align-items: center;
        justify-content: center; /* Center horizontally */
        margin: 0; /* Remove default margin */
    }

    header {
        text-align: center;
        padding: 20px;
        width: 100%;
    }

    .user-info {
        position: absolute;
        top: 10px;
        right: 10px;
        display: flex;
        align-items: center;
        flex-direction: column;
    }

    .user-info img {
        border-radius: 50%;
        width: 40px;
        height: 40px;
        margin: 5px 0;
    }

    .logout-link {
        margin-top: 5px;
        font-size: 14px;
    }
</style>

<body>
    <header>
        <h1>The Movement Collective Gym</h1>
        <?php if (isset($_SESSION['user_id'])): ?>
            <!-- User information displayed at the top right corner -->
            <div class="user-info">
                <span><?php echo htmlspecialchars($fullName); ?></span>
                <?php if (!empty($userImage)): ?>
                    <img src="<?php echo htmlspecialchars($userImage); ?>" alt="User Image">
                <?php endif; ?>
                <a href="logout.php" class="logout-link text-decoration-none text-white">Logout</a>
            </div>
        <?php endif; ?>
    </header>
</body>
