<!DOCTYPE html>
<html lang="en">

<!-- hi frankie -->

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>The Movement Collective Gym</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome CSS -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
    <link rel="icon" type="image/x-icon" href="./images/mvmtpic.png">
    <!-- Custom CSS for background and styling -->
    <style>
        body {
            background: linear-gradient(135deg, #f06, #f90);
            color: white;
            height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center; /* Center horizontally */
        }

        h2 {
            font-size: 3.5rem; /* Increased font size for title */
            font-weight: bold; /* Added boldness */
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5); /* Added shadow for more striking effect */
            animation: fadeInDown 2s ease;
            margin-bottom: 20px; /* Decreased space below the title */
        }

        .form-control,
        .input-group-text {
            background-color: rgba(255, 255, 255, 0.8);
            color: #333;
            font-size: 0.8rem; /* Increased font size for readability */
        }

        /* Increase the size of input fields */
        .form-control {
            height: calc(2.75rem); /* Adjusted height for better readability */
        }

        .btn {
            padding: 20px 30px;
            font-size: 1.0rem;
        }

        .btn-primary {
            background-color: white !important; /* White background */
            color: #333 !important;  /* Dark text color for contrast */
            border: 1px solid #333;  /* Optional: add a border */
        }

        .btn-primary:hover {
            background-color: #333 !important;  /* Darken background on hover */
            color: white !important;  /* White text on hover */
        }

        .carousel-item img {
            height: 60vh; /* Set a fixed height */
            width: 100%;  /* Set width to full carousel width */
            object-fit: cover; /* Ensures images cover the area without distortion */
            margin: 0 auto;
            border: 5px solid white;
        }

        .carousel {
            width: 100%;
            max-width: 300px; /* Set a smaller maximum width for the carousel */
        }

        .carousel-container {
            display: flex; /* Use flexbox for alignment */
            justify-content: space-between; /* Space between the carousels and form */
            align-items: center; /* Center align vertically */
        }

        @keyframes fadeInDown {
            from {
                opacity: 0;
                transform: translateY(-30px);
            }

            to {
                opacity: 1;
                transform: translateY(0);
            }
        }
    </style>
</head>

<body>
    <div class="container-fluid">
        <div class="carousel-container">
            <!-- Left Carousel -->
            <div id="leftCarousel" class="carousel slide carousel-fade" data-bs-ride="carousel">
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img src="images/gym1.jpg" class="d-block w-100" alt="Gym Image 1">
                    </div>
                    <div class="carousel-item">
                        <img src="images/gym2.jpg" class="d-block w-100" alt="Gym Image 2">
                    </div>
                    <div class="carousel-item">
                        <img src="images/gym3.jpg" class="d-block w-100" alt="Gym Image 3">
                    </div>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#leftCarousel" data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#leftCarousel" data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Next</span>
                </button>
            </div>

            <div class="container mt-5 mx-3">
                <h2 class="text-center">The Movement Collective Gym</h2>
                <div class="row justify-content-center">
                    <div class="col-md-4">
                        <form action="process_login.php" method="POST">
                            <div class="mb-3">
                                <label for="username" class="form-label">Username</label>
                                <div class="input-group">
                                    <span class="input-group-text"><i class="fas fa-user"></i></span>
                                    <input type="text" class="form-control" id="username" name="username" placeholder="Enter your username" required>
                                </div>
                            </div>
                            <div class="mb-3">
                                <label for="password" class="form-label">Password</label>
                                <div class="input-group">
                                    <span class="input-group-text"><i class="fas fa-lock"></i></span>
                                    <input type="password" class="form-control" id="password" name="password" placeholder="Enter your password" required>
                                </div>
                            </div>
                            <button type="submit" class="btn btn-primary w-100">
                                <i class="fas fa-sign-in-alt"></i> Login
                            </button>
                        </form>
                        <div class="text-center mt-3">
                            <p>Don't have an account? <a href="register.php" class="text-white"><i class="fas fa-user-plus"></i> Register</a></p>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Right Carousel -->
            <div id="rightCarousel" class="carousel slide carousel-fade" data-bs-ride="carousel">
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img src="images/gym4.jpg" class="d-block w-100" alt="Gym Image 4">
                    </div>
                    <div class="carousel-item">
                        <img src="images/gym5.jpg" class="d-block w-100" alt="Gym Image 5">
                    </div>
                    <div class="carousel-item">
                        <img src="images/gym6.jpg" class="d-block w-100" alt="Gym Image 6">
                    </div>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#rightCarousel" data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#rightCarousel" data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Next</span>
                </button>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>
