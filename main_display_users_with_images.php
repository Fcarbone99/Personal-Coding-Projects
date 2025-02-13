<?php
include './includes/conn.php';

// Check if the database connection is available
if (isset($conn)) {
    $dbname = "myDBPDO";

    try {
        // Select the database
        $conn->exec("USE $dbname");

        // Fetch all users from the 'users' table
        // We will also fetch the 'FileData' (image) from the database
        $stmt = $conn->query("SELECT id, username, email, full_name, FileData FROM users");
        $users = $stmt->fetchAll(PDO::FETCH_ASSOC);
    } catch (PDOException $e) {
        echo "<p>Error fetching users: " . $e->getMessage() . "</p>";
    }
} else {
    echo "<p>Error: Database connection not available.</p>";
}
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User List</title>
    <!-- Include DataTables CSS and jQuery -->
    <link rel="stylesheet" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/responsive/2.2.9/css/responsive.dataTables.min.css">
    <style>
        /* Basic table styling */
        table.dataTable {
            width: 100%;
            margin: 20px 0;
            border-collapse: collapse;
        }

        table.dataTable th,
        table.dataTable td {
            padding: 10px;
            border: 1px solid #ddd;
        }

        table.dataTable th {
            background-color: linear-gradient(135deg, #f06, #f90);
        }

        /* Image column styling */
        img {
            width: 50px;
            /* Adjust image size */
            height: 50px;
            object-fit: cover;
            border-radius: 50%;
        }
    </style>
</head>

<body>
    <div class="container">
        <h1>User List</h1>

        <table id="userTable" class="display responsive nowrap" style="width:100%">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Username</th>
                    <th>Email</th>
                    <th>Full Name</th>
                    <th>Image</th> <!-- New column for images -->
                </tr>
            </thead>
            <tbody>
                <?php if (!empty($users)): ?>
                    <?php foreach ($users as $user): ?>
                        <tr>
                            <td><?php echo htmlspecialchars($user['id']); ?></td>
                            <td><?php echo htmlspecialchars($user['username']); ?></td>
                            <td><?php echo htmlspecialchars($user['email']); ?></td>
                            <td><?php echo htmlspecialchars($user['full_name']); ?></td>
                            <td>
                                <?php if (!empty($user['FileData'])): ?>
                                    <img src="data:image/jpeg;base64,<?php echo base64_encode($user['FileData']); ?>"
                                        alt="User Image" />
                                <?php else: ?>
                                    <p>No Image</p>
                                <?php endif; ?>
                            </td>
                        </tr>
                    <?php endforeach; ?>
                <?php else: ?>
                    <tr>
                        <td colspan="5">No users found.</td>
                    </tr>
                <?php endif; ?>
            </tbody>
        </table>
    </div>

    <!-- Include jQuery and DataTables JS -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/responsive/2.2.9/js/dataTables.responsive.min.js"></script>

    <script>
        $(document).ready(function() {
            // Initialize DataTables with search, pagination, and responsiveness
            $('#userTable').DataTable({
                responsive: true,
                pageLength: 5 // Default number of rows per page
            });
        });
    </script>
</body>

</html>
<!-- https://generated.photos/faces 
https://www.shutterstock.com/search/ai-people-mountain-sea?image_type=photo&irclickid=wXDWd%3AUIjxyKRDS0FET782njUkCRmvRWlRsiU40&irgwc=1&pl=5159507-1906897&utm_campaign=Freepik%20Company&utm_content=1906897&utm_medium=Affiliate&utm_source=5159507&utm_term=www.freepik.com&page=2
-->