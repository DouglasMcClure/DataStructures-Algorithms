package backtrack;

import list.ArrayList;
import list.List;

/**
 * A Board has a List of Positions, on which there
 * are queens
 * @author (Douglas McClure)
 */
public class Board {
    // Positions on which there are queens
    List<Position> queens;

    // Default constructor
    public Board(){
        queens = new ArrayList<Position>();
    }

    // Copy constructor
    public Board(Board b){
        queens = new ArrayList<Position>(b.queens);
    }

    /**
     * Place a queen on position p of this Board
     */
    public void addQueen(Position p){
        queens.add(p);
    }

    /**
     * @return true iff no two queens on this Board
     * are attacking each other.
     */
    public boolean ok(){
        Position p, other;
        for (int i = 0; i < queens.size()-1; i++) {
            p = queens.get(i);
            for (int j = i+1; j < queens.size(); j++) {
                other = queens.get(j);
                if (p.isAttacking(other))
                    return false;
            }
        }
        return true;
    }

    public String toString(){
        String result = "";
        for (int row = 0; row < EightQueens.SIZE; row++) {
            for (int col = 0; col < EightQueens.SIZE; col++) {
                if (queens.contains(new Position(row,col)))
                    result += "Q ";
                else
                    result += ". ";
                result += "\n"; // newline
            }
        }
        return result;
    }
}
