import java.util.Scanner;

public class Maze {
    static int ROWS = 5;
    static int COLS = 5;


    static int[][] maze = {
            {1, 0, 1, 1, 1},
            {1, 0, 1, 0, 1},
            {1, 1, 1, 0, 1},
            {0, 1, 0, 0, 1},
            {1, 1, 1, 1, 1}
    };

    // Player's starting position
    static int playerRow = 0;
    static int playerCol = 0;

    // End goal position
    static int goalRow = 4;
    static int goalCol = 4;

    public static void displayMaze() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (i == playerRow && j == playerCol) {
                    System.out.print("P ");  // Display player
                } else if (i == goalRow && j == goalCol) {
                    System.out.print("E ");  // Display end goal
                } else {
                    System.out.print((maze[i][j] == 1 ? ". " : "# "));  // Display path or wall
                }
            }
            System.out.println();
        }
    }

    public static boolean isValidMove(int newRow, int newCol) {
        return (newRow >= 0 && newRow < ROWS && newCol >= 0 && newCol < COLS && maze[newRow][newCol] == 1);
    }

    public static void movePlayer(char direction) {
        int newRow = playerRow;
        int newCol = playerCol;

        switch (direction) {
            case 'W':  // Move up
                newRow = playerRow - 1;
                break;
            case 'S':  // Move down
                newRow = playerRow + 1;
                break;
            case 'A':  // Move left
                newCol = playerCol - 1;
                break;
            case 'D':  // Move right
                newCol = playerCol + 1;
                break;
            default:
                System.out.println("Invalid move! Use W (up), A (left), S (down), D (right).");
                return;
        }

        // Check if the move is valid
        if (isValidMove(newRow, newCol)) {
            playerRow = newRow;
            playerCol = newCol;
        } else {
            System.out.println("Invalid move! You hit a wall or boundary.");
        }
    }

    public static boolean isGameWon() {
        return playerRow == goalRow && playerCol == goalCol;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Maze Game!");
        System.out.println("Use W (up), A (left), S (down), D (right) to move the player.");
        System.out.println("Your goal is to reach the end 'E'. Good luck!\n");

        // Game loop
        while (!isGameWon()) {
            displayMaze();
            System.out.print("\nEnter your move: ");
            char move = scanner.next().toUpperCase().charAt(0);  // Get the player's move
            movePlayer(move);  // Move player
            System.out.println();
        }

        System.out.println("Congratulations! You've reached the end.");
        scanner.close();
    }
}


