    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>The Movement Collective Gym</title>
        <link rel="icon" type="image/x-icon" href="./images/mvmtpic.png">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        <link rel="stylesheet" href="css/styles.css">
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </head>

    <body>
        <?php include './includes/conn.php'; ?>
        <?php include './includes/header.php'; ?>
        <div class="container-fluid content-wrapper d-flex flex-column flex-grow-1">
            <div class="row flex-grow-1">
                <?php include './includes/nav.php'; ?>
                <?php include './includes/main_insert_multiple_records.php'; ?>
                <?php include './includes/aside.php'; ?>
            </div>
        </div>
        <?php include './includes/footer.php'; ?>

    </body>

    </html>