package Checkers;

// NEW CLASS (Grade C, Point 1): Defines the contents of a cell on the Checkers board.
public class Cell {

    // (Grade C, Point 1.ii): All possible things that can occupy a cell
    public static final int EMPTY = 0;
    public static final int RED = 1;          // 1. a red piece
    public static final int BLACK = 2;        // 2. a black piece
    public static final int RED_KING = 3;     // 3. a red king
    public static final int BLACK_KING = 4;   // 4. a black king
    public static final int RED_STACK = 5;    // 5. a red stack
    public static final int BLACK_STACK = 6;  // 6. a black stack

    // (Grade C, Point 1.i): Whether this cell is available for play
    private boolean available;
    private int occupant;       // What is on this cell
    private int stackSize;      // How many pieces are stacked here
    private int row;
    private int col;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.available = (row + col) % 2 == 1; // Dark squares are playable
        this.occupant = EMPTY;
        this.stackSize = 0;
    }

    public boolean isAvailable() {
        return available;
    }

    public int getOccupant() {
        return occupant;
    }

    public void setOccupant(int occupant) {
        this.occupant = occupant;
        if (occupant == EMPTY) {
            stackSize = 0;
        } else {
            stackSize = 1;
        }
    }

    public boolean isOccupied() {
        return occupant != EMPTY;
    }

    public int getStackSize() {
        return stackSize;
    }

    // (Grade C, Point 5): Add a piece to the stack when it reaches the last row
    public void addToStack() {
        stackSize++;
        if (occupant == RED || occupant == RED_STACK) {
            occupant = RED_STACK;
        } else if (occupant == BLACK || occupant == BLACK_STACK) {
            occupant = BLACK_STACK;
        }
    }

    // (Grade C, Point 5): Remove a piece from the stack (penalty: opponent selects a piece to remove)
    public void removeFromStack() {
        if (stackSize > 0) {
            stackSize--;
        }
        if (stackSize == 0) {
            occupant = EMPTY;
        } else if (stackSize == 1) {
            if (occupant == RED_STACK) {
                occupant = RED;
            } else if (occupant == BLACK_STACK) {
                occupant = BLACK;
            }
        }
    }

    public void clear() {
        occupant = EMPTY;
        stackSize = 0;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    // (Grade C, Point 2): Text display for text-based view
    public String toString() {
        if (occupant == RED) return " r ";
        if (occupant == BLACK) return " b ";
        if (occupant == RED_KING) return " R ";
        if (occupant == BLACK_KING) return " B ";
        if (occupant == RED_STACK) return "r" + stackSize + " ";
        if (occupant == BLACK_STACK) return "b" + stackSize + " ";
        if (available) return " . ";
        return "   ";
    }
}
