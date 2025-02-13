<div class="container mt-3">
  <h2>Prepared Statements</h2>
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
          // prepare sql and bind parameters
          $stmt = $conn->prepare("INSERT INTO MyGuests (firstname, lastname, email)
  VALUES (:firstname, :lastname, :email)");
          $stmt->bindParam(':firstname', $firstname);
          $stmt->bindParam(':lastname', $lastname);
          $stmt->bindParam(':email', $email);

          // insert a row
          $firstname = "Tom";
          $lastname = "Doe";
          $email = "john@example.com";
          $stmt->execute();

          // insert another row
          $firstname = "Mary";
          $lastname = "Moe";
          $email = "mary@example.com";
          $stmt->execute();

          // insert another row
          $firstname = "Julie";
          $lastname = "Dooley";
          $email = "julie@example.com";
          $stmt->execute();

          echo "New records created successfully";
        } catch (PDOException $e) {
          echo "Error: " . $e->getMessage();
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