/**
  * EpuzzleState.java
  *
  * Run a BFS search for the 8 puzzle problem
  *
*/
import java.util.*;

public class EpuzzleState extends SearchState {
    private int[][] board;

    /**
    * Constructor
    * @param b Current Board Layout
    */
    public EpuzzleState(int[][] b){
        board = b;
    }

    /**
    * Gets the current board
    *@return Current Board Layout
    */
    public int[][] getBoard(){
        return board;
    }

    /**
    * Checks to see if the goal has been achived
    * @param searcher Current Searcher
    * @return if the presented board matches the goal board
    */
    public boolean goalPredicate(Search searcher){
        EpuzzleSearch Esearcher = (EpuzzleSearch) searcher;
        int[][] target = Esearcher.getTarget();

        //loops through loop and compares each element, if any don't match, match variable is set to false
        boolean match = true;
        for(int i = 0; i < target.length; i++){
            for(int j =0; j < target[i].length; j++){
                if(board[i][j] != target[i][j])
                    match = false;
            }
        }
        return match;
    }

    /**
    * Gets the successors for the current node
    * @param searcher Current Search
    * @return An array list of search states
    */
    public ArrayList<SearchState> getSuccessors(Search searcher){
        EpuzzleSearch Esearcher = (EpuzzleSearch) searcher;
        int row = 0;
        int column = 0;

        //Loops through the array to find the position of the blank space
        for(int i = 0; i < board.length; i++){
            for(int j =0; j < board[i].length; j++){
                if(board[i][j] == 0){
                    row = i;
                    column = j;
                }
            }
        }

        //Successor arrays are declared
        ArrayList<EpuzzleState> puzList = new ArrayList<EpuzzleState>();
        ArrayList<SearchState> statList = new ArrayList<SearchState>();

        //Depending on the position of the 0, there are moves that are able to be made. This if statement finds the available moves.
        if(row == 0 && column == 0){
            puzList.add(new EpuzzleState(moveBoardPiece(row,column,0,1)));
            puzList.add(new EpuzzleState(moveBoardPiece(row,column,1,0)));
        }
        else if(row == 0 && column == 1){
            puzList.add(new EpuzzleState(moveBoardPiece(row,column,0,0)));
            puzList.add(new EpuzzleState(moveBoardPiece(row,column,0,2)));
            puzList.add(new EpuzzleState(moveBoardPiece(row,column,1,1)));
        }
        else if(row == 0 && column == 2){
            puzList.add(new EpuzzleState(moveBoardPiece(row,column,0,1)));
            puzList.add(new EpuzzleState(moveBoardPiece(row,column,1,2)));
        }
        else if(row == 1 && column == 0){
            puzList.add(new EpuzzleState(moveBoardPiece(row,column,0,0)));
            puzList.add(new EpuzzleState(moveBoardPiece(row,column,1,1)));
            puzList.add(new EpuzzleState(moveBoardPiece(row,column,2,0)));
        }
        else if(row == 1 && column == 1){
            puzList.add(new EpuzzleState(moveBoardPiece(row,column,0,1)));
            puzList.add(new EpuzzleState(moveBoardPiece(row,column,1,0)));
            puzList.add(new EpuzzleState(moveBoardPiece(row,column,1,2)));
            puzList.add(new EpuzzleState(moveBoardPiece(row,column,2,1)));
        }
        else if(row == 1 && column == 2){
            puzList.add(new EpuzzleState(moveBoardPiece(row,column,0,2)));
            puzList.add(new EpuzzleState(moveBoardPiece(row,column,1,1)));
            puzList.add(new EpuzzleState(moveBoardPiece(row,column,2,2)));
        }
        else if(row == 2 && column == 0){
            puzList.add(new EpuzzleState(moveBoardPiece(row,column,1,0)));
            puzList.add(new EpuzzleState(moveBoardPiece(row,column,2,1)));
        }
        else if(row == 2 && column == 1){
            puzList.add(new EpuzzleState(moveBoardPiece(row,column,1,1)));
            puzList.add(new EpuzzleState(moveBoardPiece(row,column,2,0)));
            puzList.add(new EpuzzleState(moveBoardPiece(row,column,2,2)));
        }
        else if(row == 2 && column == 2){
            puzList.add(new EpuzzleState(moveBoardPiece(row,column,1,2)));
            puzList.add(new EpuzzleState(moveBoardPiece(row,column,2,1)));
        }

        //EpuzzleState is converted to searchstate in order to be returned
        for (EpuzzleState puz : puzList){
            statList.add((SearchState) puz);
        }

        //Successors are returned
        return statList;
    }

    /**
    * The creates a new array where the board piece is moved to
    @param blankRow The row coordinate of the blank space
    @param blankColumn The column parameter of the blank space
    @param valRow The row paramter of the value to be swapped
    @param valColumn The column paramter of the value to be swapped
    @return The new board with moved piece
    */
    private int[][] moveBoardPiece(int blankRow, int blankColumn, int valRow, int valColumn){
        //New board is deep copied from the old board
        int[][] newBoard = new int[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j =0; j < board[i].length; j++){
                newBoard[i][j] = board[i][j];
            }
        }

        //Piece is swapped
        newBoard[blankRow][blankColumn] = newBoard[valRow][valColumn];
        newBoard[valRow][valColumn] = 0;
        return newBoard;
    }

    /**
    *Compares the state provided with the current state to see if they are the same
    * @param state The comparison state
    * @return If they are the same
    */
    public boolean sameState(SearchState state2){
        EpuzzleState board2state = (EpuzzleState)state2;
        int[][] board2 = board2state.getBoard();

        //Loops through board and if any position is different, the match is set to false
        boolean match = true;
        for(int i = 0; i < board2.length; i++){
            for(int j =0; j < board2[i].length; j++){
                if(board[i][j] != board2[i][j])
                    match = false;
            }
        }
        return match;
    }

    /**
    *Converts the state to a string
    *@return the string value representation of the board.
    */
    public String toString(){
        String result = "\n";
        for(int i = 0; i < board.length; i++){
            for(int j =0; j < board[i].length; j++){
                result+= "" + board[i][j];
                if(j != board[i].length-1){
                    result+= " | ";
                }
            }
            result+= "\n";
        }
        
        return result;
    }

}