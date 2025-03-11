import java.util.Arrays;

public class GameOfLife implements Board {

    // Integers: 0 or 1 for alive or dead
    private int[][] board;
    private int [][] board2;

    public GameOfLife(int x, int y)
    {
        board = new int [x][y];
        board2 = new int [x][y];
    }

    // Set values on the board
    public void set(int x, int y, int[][] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                board[(i + x) % board.length][(j + y) % board[0].length] = data[i][j];
            }
        }
    }
    // Run the simulation for a number of turns
    public void run(int turns) {
        for (int i = 0; i<turns; i++){
            step();
        }
    }

    // Step the simulation forward one turn.
    public void step() {
    int[][] newBoard = new int[board.length][board[0].length];
    for (int x = 0; x<board.length; x++){
        for (int y = 0; y<board[x].length;y++){
            int neighbors = countNeighbors(x,y);
        if (board[x][y]==1){
            newBoard[x][y] = (neighbors == 2 || neighbors == 3) ? 1 : 0;
        }
        else {
            newBoard[x][y]= (neighbors ==3) ? 1 :0;
        }
        }
    }
        // Update the game board, store a 1 if the cell is alive and a 0 otherwise.
    }


    public int countNeighbors(int x, int y) {
        int count = 0;
        for (int AA = -1; AA <=1;AA++){
            for (int AB = -1; AB <=1;AB++) {
                if (AA==0 && AB==0) continue;
                count +=get(x + AA, y+ AB);

            }
        }
        // count the number of neighbors the cell has
        // use the get(x,y) method to read any board state you need.
        return count;
    }

    // Get a value from the board with "wrap around"
    // Locations outside the board will loop back into the board.
    // Ex: -1 will read board.length-1
    public int get(int x, int y) {
        int xLimit = board.length;
        int yLimit= board[0].length;
        return board[(x+xLimit)%xLimit][(y+yLimit)%yLimit];
    }

    // Test helper to get the whole board state
    public int[][] get()
    {
        return board;
    }

    // Test helper to print the current state
    public void print(){
        // Print the header
        System.out.print("\n ");
        for (int y = 0; y < board[0].length; y++) {
            System.out.print(y%10 + " ");
        }

        for (int x = 0; x < board.length; x++) {
            System.out.print("\n" + x%10);
            for (int y=0; y<board[x].length; y++)
            {
                if (board[x][y] == 1)
                {
                    System.out.print("⬛");
                }
                else
                {
                    System.out.print("⬜");
                }
            }
        }
        System.out.println();
    }
}
