<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>The Movement Collective Gym</title>
    <link rel="icon" type="image/x-icon" href="./images/mvmtpic.png">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/styles.css">

    <style>
        body {
            background: linear-gradient(135deg, #f06, #f90);
            color: white;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }
    </style>
</head>

<body>
    <div class="container mt-5">
        <h2 class="text-center"><i class="fas fa-user-plus"></i> User Registration</h2>
        <form action="./includes/process_registration.php" method="POST" enctype="multipart/form-data"
            class="needs-validation" novalidate>

            <!-- Username -->
            <div class="mb-3">
                <label for="username" class="form-label"><i class="fas fa-user"></i> Username</label>
                <input type="text" class="form-control" id="username" name="username" pattern="^[a-zA-Z0-9_]{5,50}$"
                    required>
                <div class="invalid-feedback">
                    Username must be alphanumeric and 5-50 characters long.
                </div>
            </div>

            <!-- Email -->
            <div class="mb-3">
                <label for="email" class="form-label"><i class="fas fa-envelope"></i> Email address</label>
                <input type="email" class="form-control" id="email" name="email"
                    pattern="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$" required>
                <div class="invalid-feedback">
                    Please provide a valid email address.
                </div>
            </div>

            <!-- Password -->
            <div class="mb-3">
                <label for="password" class="form-label"><i class="fas fa-lock"></i> Password</label>
                <input type="password" class="form-control" id="password" name="password"
                    pattern="^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,}$" required>
                <div class="invalid-feedback">
                    Password must be at least 8 characters long, contain at least one letter, one number, and one
                    special character (!@#$%^&*).
                </div>
            </div>

            <!-- Full Name -->
            <div class="mb-3">
                <label for="full_name" class="form-label"><i class="fas fa-id-card"></i> Full Name</label>
                <input type="text" class="form-control" id="full_name" name="full_name" required>
                <div class="invalid-feedback">
                    Please provide your full name.
                </div>
            </div>

            <!-- File Upload -->
            <div class="mb-3">
                <label for="file" class="form-label"><i class="fas fa-file-upload"></i> Upload File</label>
                <input type="file" class="form-control" id="file" name="file" accept=".jpg,.jpeg,.png,.pdf" required>
                <div class="invalid-feedback">
                    Please upload a valid file (jpg, jpeg, png, pdf).
                </div>
            </div>

            

            <button type="submit" class="btn btn-primary"><i class="fas fa-user-check"></i> Register</button>
        </form>
    </div>

    <script>
        // Bootstrap form validation
        (function() {
            'use strict';
            const forms = document.querySelectorAll('.needs-validation');

            Array.prototype.slice.call(forms)
                .forEach(function(form) {
                    form.addEventListener('submit', function(event) {
                        if (!form.checkValidity()) {
                            event.preventDefault();
                            event.stopPropagation();
                        }
                        form.classList.add('was-validated');
                    }, false);
                });
        })();
    </script>
</body>

</html>
