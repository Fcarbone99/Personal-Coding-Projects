                    <div class="container mt-3">
                        <?php
                        if (isset($_GET['type'])) {

                            $type = $_GET['type'];
                            echo "<h2>$type</h2>";
                        }
                        ?>
                        <div class="card">
                            <div class="card-body">
                                <!-- =========================Start Content================================== -->
                                <?php
                                // Check if the 'message' parameter exists in the URL
                                if (isset($_GET['message'])) {
                                    // Retrieve the value from the 'key' parameter in the URL
                                    $value = $_GET['message'];

                                    // Output the value
                                    echo "<p>$value" . "</p>";;
                                } else {
                                    echo  "<p>No 'message' parameter found in the URL." . "</p>";;
                                }
                                ?>

                                <!-- ===========================End Content================================== -->
                            </div>
                        </div>
                    </div>