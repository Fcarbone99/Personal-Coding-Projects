/* THINGS TO DO:::::::::::::::::::::::::::::::::::::::::::::::::::::::
THE SNAKE PIT=
The snake pit is the area where the snake can move. (DONE)
The snake pit must utilize all available space of the current terminal window. (DONE)
There must be a visible border delineating the snake pit. (DONE)
THE SNAKE=
The initial length of the snake is five characters (DONE)
Initial direction of the snake's movement is chosen randomly. (DONE)
The user can press one of the four arrow keys to change the direction of the snake's movement. (DONE)
The snake's speed is proportional to its length. (DONE)
THE TROPHIES=
Trophies are represented by a digit randomly chosen from 1 to 9. (DONE)
There's always exactly one trophy in the snake pit at any given moment. (DONE)
When the snake eats the trophy, its length is increased by the corresponding number of characters. (DONE)
A trophy expires after a random interval from 1 to 9 seconds. (DONE)
A new trophy is shown at a random location on the 
screen after the previous one has either expired or is eaten by the snake. (DONE)
THE GAMEPLAY=
The snake dies and the game ends if:
It runs into the border; or (DONE)
It runs into itself; or (DONE)
The user attempts to reverse the snake's direction. (DONE)
The user wins the game if the snake's length grows to the length (DONE)
equal to half the perimeter of the border. (DONE)
Need to comment who wrote each part (DONE)
ADDED THINGS=
multicolor snake (DONE)
//Created by Frankie Carbone, Edmond Cani, and Abel Kloter

*/

#include <ncurses.h>
#include <stdlib.h>
#include <time.h>

#define WIDTH 160
#define HEIGHT 27
#define INIT_SNAKE_SIZE 5
#define OPPOSITE_UP    KEY_DOWN
#define OPPOSITE_DOWN  KEY_UP
#define OPPOSITE_LEFT  KEY_RIGHT
#define OPPOSITE_RIGHT KEY_LEFT

//Francesco

typedef struct {
    int columns, rows;
} Position;

Position snake[WIDTH * HEIGHT];
int snake_size;
int game_over;
int trophy_columns, trophy_rows;
int trophy_value;
int trophy_active;
time_t trophy_timer;
int win_condition;
//Francesco and Abel
void init_game() {
    initscr();
    cbreak();
    noecho();
    curs_set(0);
    keypad(stdscr, TRUE);
    timeout(100); //to start game
    //Edmond

    if (has_colors()) {
        start_color();
        use_default_colors();
        //makes all the colors for the snake!
        init_pair(1, COLOR_RED, -1);
        init_pair(2, COLOR_GREEN, -1);
        init_pair(3, COLOR_YELLOW, -1);
        init_pair(4, COLOR_BLUE, -1);
        init_pair(5, COLOR_MAGENTA, -1);
        init_pair(6, COLOR_CYAN, -1);
    }   //Francesco

    //calculates the starting column for the snake
    //centers the snake
    int init_columns = WIDTH / 2 - INIT_SNAKE_SIZE / 2;

    //sets the starting row for the snake. 
    //centers the snake
    int init_rows = HEIGHT / 2;

    //initialize the snake's body segments 
    //starting from the position above^^^^
    for (int i = 0; i < INIT_SNAKE_SIZE; i++) {
        snake[i].columns = init_columns + i; 
        //set each snake part segment's column, moving right from the initial position.
        snake[i].rows = init_rows;           
        //set each snake parts segment's row to the middle row, always happens
        }   
        //Abel
        
    snake_size = INIT_SNAKE_SIZE;
    trophy_active = 0; //initializes trophy as not on
    
    int total_area = (WIDTH - 1) * (HEIGHT - 1);
    //total area= WIDTH (160-1)*(27-1)=4134 and half of that is 2067
    win_condition = total_area / 2; //needed for win condition, half of area 
    //game termination
    game_over = 0;
    //Francesco
}

void draw_borders() {
    for (int i = 0; i <= WIDTH; i++) {
        mvprintw(0, i, "-");
        mvprintw(HEIGHT, i, "-");
        //print outside border ACROSS the top and bottom
        //can change to whatever we want, picked "-"
    }   //Edmond
    for (int i = 0; i <= HEIGHT; i++) {
        mvprintw(i, 0, "|");
        mvprintw(i, WIDTH, "|");
        //print outside border ALONG the left and right edges
        //can change to whatever we want, picked "|"
    }   //Edmond
}

void generate_trophy() {
    trophy_columns = rand() % (WIDTH - 2) + 1; //random column within borders
    trophy_rows = rand() % (HEIGHT - 2) + 1;    //random row within borders
    trophy_value = rand() % 9 + 1;              //random trophy value from 1 to 9
    trophy_active = 1; //turn on trophy
    time(&trophy_timer); //start a time for how long trophy lasts
}   //Francesco

void draw_trophy() {
    mvprintw(trophy_rows, trophy_columns, "%d", trophy_value);
}   //Francesco

void update_snake(int d_columns, int d_rows) {
    Position new_head = {snake[0].columns + d_columns, snake[0].rows + d_rows};
    //controls movement of snake (lets name him Gerald)
//Abel
    //check to see if snake crashed into border
    if (new_head.columns == 0 || new_head.columns == WIDTH || new_head.rows == 0 
        || new_head.rows == HEIGHT) {
        game_over = 1;
        return;
    }   //Abel

    //checks if the snake runs into itself
    for (int i = 1; i < snake_size; i++) { //start from 1 to avoid checking head, cause it hitting its 
                                           //own head is legit not possible
        if (snake[i].columns == new_head.columns && snake[i].rows == new_head.rows) {
            game_over = 1; //it hit itself, rip
            return;
        }   //Francesco
    }

    //shifts snake body
    for (int i = snake_size - 1; i > 0; i--) {
        snake[i] = snake[i - 1];
    } 
    snake[0] = new_head;
    //Abel
    
     //check if snake eats the trophy
    if (new_head.columns == trophy_columns && new_head.rows == trophy_rows) {
        snake_size += trophy_value; //increase snake size
        trophy_active = 0;          //turn off trophy
    }
    
    //checks if win condition is met
        if (snake_size >= win_condition) {
            game_over = 2; //is win condition
            return;
        }
    //Francesco
}

void draw_snake() {
    for (int i = 0; i < snake_size; i++) {
        int color_pair = (i % 6) + 1; //goes through all possible colors
        attron(COLOR_PAIR(color_pair));
        mvprintw(snake[i].rows, snake[i].columns, "o"); //prints snake with "o"
        attroff(COLOR_PAIR(color_pair));
    }   //Edmond and Francesco
}

int main() {
    srand(time(NULL)); //random time intialization

    int random_start_direction = rand() % 4; //generates a number 0-3
    int d_columns = 0, d_rows = 0;
    //Francesco

    switch (random_start_direction) {
        case 0:
            d_columns = 1; //moves right
            break;
        case 1:
            d_columns = -1; //moves left
            break;
        case 2:
            d_rows = 1; //moves down
            break;
        case 3:
            d_rows = -1; //moves up
            break;
    } //Abel

    init_game();

    while (!game_over) {
        int ch = getch(); //user input

        switch (ch) {
        case KEY_UP:
            if (d_rows == 0) { d_rows = -1; d_columns = 0; }
            break;
        case KEY_DOWN:
            if (d_rows == 0) { d_rows = 1; d_columns = 0; }
            break;
        case KEY_LEFT:
            if (d_columns == 0) { d_columns = -1; d_rows = 0; }
            break;
        case KEY_RIGHT:
            if (d_columns == 0) { d_columns = 1; d_rows = 0; }
            break;
        } //Edmond 

    while (!game_over) {
    int ch = getch(); //user input

    switch (ch) { //opposite of CH above^^^^
        case KEY_UP:
            if (d_rows == 1) { //moving down, cannot go up
                game_over = 1; //ends game
            } else if (d_rows == 0) { // Valid move
                d_rows = -1; d_columns = 0;
            }
            break;

        case KEY_DOWN:
            if (d_rows == -1) { //moving up so can't get down
                game_over = 1;//ends game
            } else if (d_rows == 0) { 
                d_rows = 1; d_columns = 0;
            }
            break;

        case KEY_LEFT:
            if (d_columns == 1) { //moves right so can't go left
                game_over = 1;//ends game
            } else if (d_columns == 0) { 
                d_columns = -1; d_rows = 0;
            }
            break;

        case KEY_RIGHT:
            if (d_columns == -1) { //moves left so can't go right
                game_over = 1;//ends game
            } else if (d_columns == 0) { 
                d_columns = 1; d_rows = 0;
            }
            break;
    }   //Edmond

        clear();
        draw_borders();

        //adjusts speed based on snake size
        //I kept it this low cause any other multiplier made the snake wayyyyyy to fast
        timeout(130 - (snake_size * 1.08)); 
        //Francesco

        if (!trophy_active) {
            generate_trophy(); //if there is not trophy, put one
        }
        draw_trophy();
        update_snake(d_columns, d_rows);
        draw_snake();
        refresh();
        //Edmond


         if (game_over == 2) { //if win condition is met
            mvprintw(HEIGHT / 2, WIDTH / 2 - 6, "You Win!");
            refresh();
            napms(5000); //displays the message for 5 seconds
            getch(); //end user input
            break;
            //Francesco
        }

        if (game_over == 1) { //user lost
            mvprintw(HEIGHT / 2, WIDTH / 2 - 6, "Game Over!");
            refresh();
            napms(5000); //displays the message for 5 seconds
            getch(); //end user input
            break;
            //Francesco
        }

        //check if trophy time has run out for 
        //the trophy length of time on screen
        time_t current_time;
        time(&current_time);
        double diff = difftime(current_time, trophy_timer);
        if (trophy_active && diff >= trophy_value) {
            trophy_active = 0;
        }
        //Edmond
    
    }

    endwin(); //close the game
  return 0;
    }
}