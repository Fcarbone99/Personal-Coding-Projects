<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Meet Our Trainers</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
    <link rel="icon" type="image/x-icon" href="./images/mvmtpic.png">
    <link rel="stylesheet" href="styles.css">
    <style>
        /* Additional styles specific to trainers page */
        .trainer-container {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            gap: 2rem;
            padding: 20px;
            max-width: 1200px;
            margin: 0 auto;
        }

        .trainer-card {
            background: linear-gradient(135deg, rgba(255, 102, 0, 0.9), rgba(255, 0, 102, 0.9));
            border-radius: 10px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            overflow: hidden;
            width: 300px;
            text-align: center;
            padding: 1rem;
            margin-bottom: 20px;
        }

        .trainer-card img {
            width: 200px;
            height: 200px;
            border-radius: 50%;
            margin-bottom: 1rem;
            border: 3px solid white;
            object-fit: cover;
        }

        .trainer-card h2 {
            margin: 0.5rem 0;
            font-size: 1.5rem;
            color: white;
        }

        .trainer-card p {
            line-height: 1.6;
            color: white;
            font-size: 0.9rem;
            padding: 0 1rem;
        }

        #main {
            background-color: white;
            padding: 20px;
            /*border-radius: 10px; */
            min-height: calc(100vh - 130px); /* Adjusted for single header */
        }

        .trainers-title {
            color: white;
            text-align: center;
            margin-bottom: 30px;
            padding: 20px;
            background: linear-gradient(135deg, #f06, #f90);
            border-radius: 10px;
        }
    </style>
</head>
<body>

            <div id="main">
                <h1 class="trainers-title">Meet Our Personal Trainers</h1>
                <div class="trainer-container">
                    <?php
                    $trainers = [
                        [
                            "name" => "John Thorpe",
                            "bio" => "Hey everyone! I'm John, and I'm here to help you become the strongest version of you. My own passion for health and wellness has empowered me to be able to do the things I love and enjoy. I have tons of fun exciting hobbies like rock climbing, hiking, acrobatics, yoga, and a bit of carpentry lately! I can't wait to learn more about you and what motivates you to taking care of your body through exercise and nutrition. As a guide on your journey, I will give you the necessary tools to be successful.",
                            "image" => "images/JohnThorpe.jpg"
                        ],
                        [
                            "name" => "Sam McCue",
                            "bio" => "Sam specializes in yoga and Pilates, offering personalized programs for flexibility and stress relief.",
                            "image" => "images/SamMcCue.jpg"
                        ],
                        [
                            "name" => "Jesse Torres",
                            "bio" => "Jesse focuses on high-intensity interval training (HIIT) and has a background in sports performance.",
                            "image" => "images/Jesse Torres.jpg"
                        ],
                        [
                            "name" => "Brandon Ross",
                            "bio" => "Jesse focuses on high-intensity interval training (HIIT) and has a background in sports performance.",
                            "image" => "images/Brandon Ross.jpg"
                        ],
                        [
                            "name" => "Abigail Bowersox",
                            "bio" => "Jesse focuses on high-intensity interval training (HIIT) and has a background in sports performance.",
                            "image" => "images/GnereicPfp.png"
                        ],
                        [
                            "name" => "Devin Scanlon",
                            "bio" => "Jesse focuses on high-intensity interval training (HIIT) and has a background in sports performance.",
                            "image" => "images/GnereicPfp.png"
                        ]
                    ];

                    foreach ($trainers as $trainer) {
                        echo "
                        <div class='trainer-card'>
                            <img src='{$trainer['image']}' alt='{$trainer['name']}'>
                            <h2>{$trainer['name']}</h2>
                            <p>{$trainer['bio']}</p>
                        </div>
                        ";
                    }
                    ?>
                </div>
            </div>
</body>
</html>