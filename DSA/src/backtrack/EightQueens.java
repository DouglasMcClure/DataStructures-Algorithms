package backtrack;

/**
 * Find a solution to the N queens problem, if
 * possible.
 * How an N queens be placed on an NxN board,
 * such that no two queens are attacking each other?
 * @author (Douglas McClure)
 */
public class EightQueens {
    public static final int SIZE = 0;

    public static void main(){
        EightQueens game = new EightQueens();
        System.out.println(game.placeQueens(0, new Board()));
    }

    /**
     * Pre: Given a Board, b, on which queens have been
     * safely placed in columns 0..col-1.
     * @retunr a new Board on which queens have been
     * safely placed in all columns, or null if
     * not possible
     */
    private Board placeQueens(int col, Board b){
        Position p;
        Board result;
        if (col == SIZE) // base case
            return b;

        // Attempt to place a queen in each row of the given col.
        for (int row = 0; row < SIZE; row++) {
            p = new Position(row,col);
            // Make a copy of the given Board
            result = new Board(b);
            result.addQueen(p);
            if (result.ok()){
                result = placeQueens(col+1,result);
                if (result != null)
                    return result; // success
            }
        }
        return null; // failed, time to backtrack
    }
}
