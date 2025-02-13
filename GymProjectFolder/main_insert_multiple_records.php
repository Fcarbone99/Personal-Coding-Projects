<div class="container mt-3">
  <h2>Insert Multiple Records into Table</h2>
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
            // Begin the transaction
            $conn->beginTransaction();

            // Our SQL statements
            $conn->exec("INSERT INTO MyGuests (firstname, lastname, email)
                         VALUES ('John', 'Doe', 'john@example.com')");
            $conn->exec("INSERT INTO MyGuests (firstname, lastname, email)
                         VALUES ('Mary', 'Moe', 'mary@example.com')");
            $conn->exec("INSERT INTO MyGuests (firstname, lastname, email)
                         VALUES ('Julie', 'Dooley', 'julie@example.com')");

            // Commit the transaction
            $conn->commit();
            echo "<p>New records created successfully</p>";
          } catch (PDOException $e) {
            // Roll back the transaction if something failed
            $conn->rollback();
            echo "<p>Error inserting records: " . $e->getMessage() . '</p>';
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