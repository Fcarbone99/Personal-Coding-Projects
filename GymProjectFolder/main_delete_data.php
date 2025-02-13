                    <div class="container mt-3">
                        <h2>Delete Data</h2>
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

                                        // Try to delete the record
                                        try {

                                            $id = 7;
                                            // SQL to delete a record
                                            $sql = "DELETE FROM MyGuests WHERE id=$id";

                                            // Prepare and execute the statement
                                            $stmt = $conn->prepare($sql);
                                            $stmt->execute();

                                            // Check if any rows were affected
                                            if ($stmt->rowCount() > 0) {
                                                echo "<p>Record $id deleted successfully.</p>";
                                            } else {
                                                echo "<p>No record found with id=$id.</p>";
                                            }
                                        } catch (PDOException $e) {
                                            // Handle SQL errors
                                            echo "<p>Error deleting record: " . $e->getMessage() . '</p>';
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