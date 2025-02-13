- 👋 Hello, my name is Frankie Carbone
- 👀 I've always been intrigued by computers, tech, and coding
- 🌱 I am currently a senior Computer Science Honors Major at Central Connecticut State University
- 📫 I’m looking to collaborate on anything written in Java, C, or Python at the moment
- ⚡ Fun fact: Most definitely a car guy

# --------------------------------------------------------------------

# Password Manager created Spring 2024
# Author: Frankie Carbone

 My application is a password manager, created in Java, that is capable of adding passwords of your favorite websites and retrieve those passwords as well. I use AES to encrypt and decrypt user passwords. AES is very secure because it uses confusion and diffusion. Diffusion when it shifts rows of data and confusion while mixing columns. This creates doubly layered protection for encryption, and when you want to decrypt you would just do the opposite of the encryption techniques. For AES to work you need a shared symmetric key (for encryption and decryption as well to take place). If the shared key is lost then all the data inside the AES is easy to come by since they are reverses of each other. This is why I protected the shared symmetric key with a one-time pad. The one-time pad is generated randomly and is the same length as the secret key so when its encrypted and decrypted that random key can do both. The OTP works by XOR the plaintext with the random OTP key to create the ciphertext or encrypted symmetric key. This protection is needed because if the symmetric key was public information or not protected, Trudy (any unwanted user) can have it and use it to decrypt any AES encryption that was done before, therefore getting any password they want. 

Ways I can work to improve my project:
-My AES key is not purely randomly generated but it is at least hidden in a variable​
-OTP use the same random key for encryption and decryption and it needs to be the same length as the AES key so this can become a huge storage problem in the long run​
-Could add an option to generate a random password for the website you want to save a password too​
-AES operates on a fixed block size of 128 bits so all data must be changed to fit this size​

# ------------------------------------------------------------------------------

# Snake Game created Spring 2024
# Authors: Frankie Carbone, Edmond Cani, Abel Kloter

For our application we were tasked to create the classic Snake Game in C. My groupmates and I had restrictions and specifics tasks we were mandated to create (as shown at the top of our code in the comments)

# ------------------------------------------------------------------------------

# Gym Project Website created Fall 2024
# Authors: Frankie Carbone, Filip Gorczyca, and Omar Abouelgheit

We want to develop a responsive and visually appealing website for a gym, aimed at enhancing user engagement and ease of management. The website will include features for both admin and worker roles, enabling efficient management of gym operations. Key functionalities will include storing gym membership data and fitness class information. 
Steps for Completion:
1.	HTML (Structure):
o	Create pages for gym information, membership sign-up, fitness class schedules, and admin/worker portals.
o	Use forms for user inputs like membership details, class registrations, etc.
2.	CSS (Design):
o	Ensure responsive design using media queries to make the website accessible on multiple devices.
o	Apply modern, clean styles to make the site visually attractive and user-friendly.
3.	PHP (Back-End Logic):
o	Implement a system to manage gym memberships and fitness class data in a database.
o	Create admin and worker roles, allowing different access levels for viewing, adding, or modifying data.
o	Develop a secure login system for admins and workers.
4.	Database Integration:
o	Use MySQL to store gym member data, class schedules, and user roles.
o	Connect the database to the website using PHP for dynamic content management and updates.
5.	Testing & Deployment:
o	Test the website for functionality, responsiveness, and security.
o	Deploy on a hosting platform with database support.


# ------------------------------------------------------------------------------

# HMI Data Visualization Acquisition Project Fall 2024
# Authors: Frankie Carbone, Khosro Pourkavoos, Rajani Bhat, Omar Abouelgheit

The system's overall functionality will include automatically and periodically capturing images of a
human-machine interface (HMI) and then comparing these images to the ones before it. With the
goal of isolating relevant indicators, alarms, gauges, and bar charts, and detecting significant
changes in the monitored parameters. These comparisons will be used, when needed, to alert floor
managers (via email) to significant changes and human intervention with the machine. In addition,
machine operators and floor managers will be able to view the data based on the alerts and
information collected, tracking changes in gauges and operation metrics over time. The work for this 
project for CCSU Robotics Lab so all the code is in their private GitHub Repo.

# ------------------------------------------------------------------------------

# Animal Project Fall 2024
# Authors: Frankie Carbone, Lauren Cedrone, Robert Fanzutti, Kameron Dear

This project involves the development of a simulation game featuring three creatures—Fire, Water, and Grass—interacting on a 50x50 grid. The creatures move randomly and interact with randomly placed objects, evolving based on a point system. The game employs multiple design patterns, such as Singleton, Template, Decorator, Factory, Strategy, Composite, Visitor, and Observer, to manage and streamline the complexity of the simulation. In summary, the project integrates various design patterns to simulate a dynamic and interactive environment where creatures evolve, interact with obstacles, and plants, and experience random events. The game runs in the terminal, with supplementary graphics showing the simulation's story.

