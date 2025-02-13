<div class="container mt-3">
    <h2>Update Data</h2>
    <div class="card">
        <div class="card-body">
            <?php
            // Check if $conn is defined and available
            if (isset($conn)) {
                // Database name
                $dbname = "myDBPDO";

                try {
                    // Select the database
                    $conn->exec("USE $dbname");

                    try {
                        $conn = new PDO("mysql:host=$servername;dbname=$dbname", $username, $password);
                        // set the PDO error mode to exception
                        $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

                        $sql = "UPDATE MyGuests SET lastname='Smith' WHERE id=5";

                        // Prepare statement
                        $stmt = $conn->prepare($sql);

                        // execute the query
                        $stmt->execute();

                        // echo a message to say the UPDATE succeeded
                        echo $stmt->rowCount() . " Records UPDATED Successfully";
                    } catch (PDOException $e) {
                        echo $sql . "<br>" . $e->getMessage();
                    }
                } catch (PDOException $e) {
                    // Handle database selection errors
                    echo "<p>Error selecting database: " . $e->getMessage() . '</p>';
                }

                // Close the connection
                $conn = null;
            } else {
                echo "<p>Database connection not established.</p>";
            }
            ?>
        </div>
    </div>
</div>