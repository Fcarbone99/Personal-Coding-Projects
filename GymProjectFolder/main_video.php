<div class="container mt-3">
    <h2>Play Videos</h2>
    <div class="card">
        <div class="card-body">
            <!-- Video Container 1 -->
            <div class="video-container mb-4">
                <iframe 
                    src="https://www.youtube.com/embed/J5OOz1hkXwA?si=zyDF0FSFY02DEmlK" 
                    title="YouTube video player" 
                    frameborder="0" 
                    allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" 
                    referrerpolicy="strict-origin-when-cross-origin" 
                    allowfullscreen>
                </iframe>
            </div>

            <!-- Video Container 2 -->
            <div class="video-container">
                <iframe 
                    src="https://www.youtube.com/embed/OOmtbQjmmro?si=QZgqrRMwssDQGlZ2" 
                    title="YouTube video player" 
                    frameborder="0" 
                    allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" 
                    referrerpolicy="strict-origin-when-cross-origin" 
                    allowfullscreen>
                </iframe>
            </div>
        </div>
    </div>
</div>

<style>
    .card-body {
        padding: 80px;
    }

    .video-container {
        width: 100%;
        max-width: 1200px; /* Increased max-width for larger screens */
        margin: 0 auto;
        position: relative;
        padding-top: 56.25%; /* 16:9 Aspect Ratio */
        background: #000; /* Black background for letterboxing */
    }

    .video-container iframe {
        position: absolute;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        border: none;
    }

    /* Responsive adjustments */
    @media (min-width: 992px) {
        .video-container {
            padding-top: 42.85%; /* Adjusted ratio for larger screens */
        }
    }

    @media (max-width: 768px) {
        .video-container {
            padding-top: 56.25%; /* Standard 16:9 for mobile */
        }
    }

    /* Add margin between videos */
    .mb-4 {
        margin-bottom: 1.5rem;
    }
</style>