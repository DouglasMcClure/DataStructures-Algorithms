package backtrack;

/**
 * A Position is a row and column number on
 * a chess board.
 * Row and column numbers begin at 0
 * @author (Douglas McClure)
 */
public class Position {
    int row, col;

    public Position(int r, int c){
        row = r;
        col = c;
    }

    public boolean equals(Object obj){
        Position other = (Position) obj;
        return row == other.row && col == other.col;
    }

    /**
     * @retyrn true iff a queen on this Position
     * is attaching a queen on the other Position
     */
    public boolean isAttacking(Position other){
        return row == other.row ||
                col == other.col ||
                row+col == other.row + other.col || // Major
                row-col == other.row - other.col; // Minor
    }
}
