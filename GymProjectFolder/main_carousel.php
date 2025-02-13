<?php

include 'conn.php';

// Check if $conn is defined and available
if (isset($conn)) {
    // Database name
    $dbname = "myDBPDO";

    try {
        // Select the database
        $conn->exec("USE $dbname");
    } catch (PDOException $e) {
        echo "<p>Error selecting database: " . $e->getMessage() . '</p>';
    }

    // Fetch carousel data from the MySQL table
    $sql = "SELECT * FROM images";
    $stmt = $conn->prepare($sql);
    $stmt->execute();
    $result = $stmt->fetchAll(PDO::FETCH_ASSOC);

    // Initialize variables for carousel indicators and items
    $carouselIndicators = '';
    $carouselItems = '';

    if (count($result) > 0) {
        $i = 0;
        foreach ($result as $row) {
            // Create indicators
            $activeClass = $i === 0 ? 'active' : '';
            $carouselIndicators .= "<li data-bs-target='#carouselExampleIndicators' data-bs-slide-to='$i' class='$activeClass'></li>";

            // Create carousel items
            $carouselItems .= "
            <div class='carousel-item $activeClass'>
                <img src='{$row['image_path']}' class='d-block w-100' alt='...'>
                <div class='carousel-caption d-none d-md-block'>
                    <h5>{$row['title']}</h5>
                </div>
            </div>";
            $i++;
        }
    } else {

?>
        <div class="carousel-container mt-3">
            <h2>View Progress Photos</h2>
            <div class="card">
                <div class="card-body">

                </div>
            </div>
        </div>
    <?php
    }
} else {
    ?>

    <div class="carousel-container mt-3">
        <h2>Home Page</h2>
        <div class="card">
            <div class="card-body">

                "<p>Database connection failed.</p>";

            </div>
        </div>
    </div>

<?php


}
?>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
<style>
    /* Default carousel size for larger screens */
    .carousel-container {
    padding-top: 20px;
    width: 60% !important;
    margin: 0 auto;
    text-align: center;
    background: linear-gradient(135deg, #f06, #f90);
}

    /* Media query for smaller screens */
    @media (max-width: 768px) {
        .carousel-container {
            width: 100% !important;
            padding-bottom: 55px;
        }
    }
</style>


<div class="carousel-container">

    <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
        <ol class="carousel-indicators">
            <?php echo $carouselIndicators; ?>
        </ol>
        <div class="carousel-inner">
            <?php echo $carouselItems; ?>
        </div>
        <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </a>
    </div>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>