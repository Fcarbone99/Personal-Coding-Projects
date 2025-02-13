<?php
// Gym class schedule (Static data for each day of the week)
$gymClasses = [
    "Sunday" => [
        ["time" => "9:00 AM", "endTime" => "10:00 AM", "class" => "Yoga", "teacher" => "John"],
        ["time" => "11:00 AM", "endTime" => "12:00 PM", "class" => "Pilates", "teacher" => "John"],
        ["time" => "4:00 PM", "endTime" => "5:00 PM", "class" => "Zumba", "teacher" => "John"],
    ],
    "Monday" => [
        ["time" => "6:00 AM", "endTime" => "7:00 AM", "class" => "Spin Class", "teacher" => "John"],
        ["time" => "8:00 AM", "endTime" => "9:00 AM", "class" => "HIIT", "teacher" => "Jesse"],
        ["time" => "5:30 PM", "endTime" => "6:30 PM", "class" => "Strength Training", "teacher" => "Jesse"],
    ],
    "Tuesday" => [
        ["time" => "7:00 AM", "endTime" => "8:00 AM", "class" => "Bootcamp", "teacher" => "Jesse"],
        ["time" => "10:00 AM", "endTime" => "11:00 AM", "class" => "Pilates", "teacher" => "John"],
        ["time" => "6:00 PM", "endTime" => "7:00 PM", "class" => "Yoga", "teacher" => "John"],
    ],
    "Wednesday" => [
        ["time" => "6:30 AM", "endTime" => "7:30 AM", "class" => "Cardio Blast", "teacher" => "John"],
        ["time" => "12:00 PM", "endTime" => "1:00 PM", "class" => "Stretch & Core", "teacher" => "John"],
        ["time" => "7:00 PM", "endTime" => "8:00 PM", "class" => "Zumba", "teacher" => "John"],
    ],
    "Thursday" => [
        ["time" => "7:00 AM", "endTime" => "8:00 AM", "class" => "Strength Training", "teacher" => "Jesse"],
        ["time" => "10:00 AM", "endTime" => "11:00 AM", "class" => "Yoga", "teacher" => "John"],
        ["time" => "5:00 PM", "endTime" => "6:00 PM", "class" => "Spin Class", "teacher" => "John"],
    ],
    "Friday" => [
        ["time" => "6:00 AM", "endTime" => "7:00 AM", "class" => "HIIT", "teacher" => "Jesse"],
        ["time" => "8:30 AM", "endTime" => "9:30 AM", "class" => "Bootcamp", "teacher" => "Jesse"],
        ["time" => "6:30 PM", "endTime" => "7:30 PM", "class" => "Pilates", "teacher" => "John"],
    ],
    "Saturday" => [
        ["time" => "8:00 AM", "endTime" => "9:00 AM", "class" => "Spin Class", "teacher" => "John"],
        ["time" => "10:30 AM", "endTime" => "11:30 AM", "class" => "Zumba", "teacher" => "John"],
        ["time" => "4:00 PM", "endTime" => "5:00 PM", "class" => "Yoga", "teacher" => "John"],
    ],
];
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gym Class Calendar</title>
    <style>
        body {
            
            line-height: 1.6;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 1000px;
            margin: 0px auto;
            padding: 20px;
            border: 0px solid #ccc;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
            margin-bottom: 20px;
        }
        .day {
            margin-bottom: 60px;
        }
        .day h2 {
            margin-bottom: 10px;
            color: black;
        }
        .class {
            margin-left: 20px;
            margin-bottom: 5px;
        }
        .class span {
            font-weight: bold;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Gym Class Calendar</h1>
    <?php foreach ($gymClasses as $day => $classes): ?>
        <div class="day">
            <h2><?php echo $day; ?></h2>
            <?php foreach ($classes as $class): ?>
                <div class="class">
                    <span><?php echo $class['time']; ?> - <?php echo $class['endTime']; ?>:</span> 
                    <?php echo $class['class']; ?> (Instructor: <?php echo $class['teacher']; ?>)
                </div>
            <?php endforeach; ?>
        </div>
    <?php endforeach; ?>
</div>
</body>
</html>
