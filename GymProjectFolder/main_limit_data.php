<script>
    $(document).ready(function() {
        $('#example').DataTable({
            "responsive": true
        });
    });
</script>

<div class="container mt-3">
    <center>
        <h2>Select Data</h2>
        <table id="example" class="display" style="width:100%">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                </tr>
            </thead>
            <tbody>

                <?php
                // Check if $conn is defined and available
                if (isset($conn)) {
                    // Database name
                    $dbname = "myDBPDO";

                    try {
                        // Select the database
                        $conn->exec("USE $dbname");

                        // Execute the query and display results
                        try {
                            $sql = "SELECT id, firstname, lastname FROM MyGuests Limit 3";
                            $result = $conn->query($sql);

                            // Check if there are rows returned
                            if ($result->rowCount() > 0) {
                                // Output data of each row
                                while ($row = $result->fetch(PDO::FETCH_ASSOC)) {
                                    echo "<tr><td>" . $row["id"] . "</td><td>" . $row["firstname"] . " " . $row["lastname"] . "</td></tr>";
                                }
                                echo "</tbody></table>";
                            } else {
                                echo "<p>No results found.</p>";
                            }
                        } catch (PDOException $e) {
                            // Handle SQL errors
                            echo "<p>Error fetching data: " . $e->getMessage() . '</p>';
                        }
                    } catch (PDOException $e) {
                        // Handle database selection errors
                        echo "<p>Error selecting database: " . $e->getMessage() . '</p>';
                    }
                } else {
                    echo "<p>Database connection not established.</p>";
                }
                ?>



                <?php
                // This second block is unnecessary because the query has already been run above
                // You can remove it unless you need it for a different context


                ?>

    </center>
</div>