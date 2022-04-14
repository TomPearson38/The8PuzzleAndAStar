import java.util.*;

public class EpuzzleState extends SearchState {
    private int[][] board;

    public EpuzzleState(int[][] b){
        board = b;
    }

    public int[][] getBoard(){
        return board;
    }

    public boolean goalPredicate(Search searcher){
        EpuzzleSearch Esearcher = (EpuzzleSearch) searcher;
        int[][] target = Esearcher.getTarget();
        boolean match = true;
        for(int i = 0; i < target.length; i++){
            for(int j =0; j < target[i].length; i++){
                if(board[i][j] != target[i][j])
                    match = false;
            }
        }
        return match;
    }

    public ArrayList<SearchState> getSuccessors(Search searcher){
        EpuzzleSearch Esearcher = (EpuzzleSearch) searcher;
        int row = 0;
        int column = 0;

        for(int i = 0; i < board.length; i++){
            for(int j =0; j < board[i].length; i++){
                if(board[i][j] == 0){
                    row = i;
                    column = j;
                }
            }
        }

        ArrayList<EpuzzleState> puzList = new ArrayList<EpuzzleState>();
        ArrayList<SearchState> statList = new ArrayList<SearchState>();


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

    for (EpuzzleState puz : puzList){
        statList.add((SearchState) puz);
    }

    return statList;
    }

    private int[][] moveBoardPiece(int blankRow, int blankColumn, int valRow, int valColumn){
        int[][] newBoard = board;
        newBoard[blankRow][blankColumn] = newBoard[valRow][valColumn];
        newBoard[valRow][valColumn] = 0;
        return newBoard;
    }

    public boolean sameState(SearchState state2){
        EpuzzleState board2state = (EpuzzleState)state2;
        int[][] board2 = board2state.getBoard();
        boolean match = true;
        for(int i = 0; i < board2.length; i++){
            for(int j =0; j < board2[i].length; i++){
                if(board[i][j] != board2[i][j])
                    match = false;
            }
        }
        return match;
    }

    public String toString(){
        String result = "";
        for(int i = 0; i < board.length; i++){
            for(int j =0; j < board[i].length; i++){
                result+= "" + board[i][j];
                if(j != board.length-2){
                    result+= " | ";
                }
            }
            result+= "\n";
        }
        
        return result;
    }

}