import java.util.*;

public class EpuzzleState extends SearchState {
    private int[][] board;
    private boolean hamming;

    public EpuzzleState(int[][] b, int lc, boolean h){
        board = b;
        localCost = lc;
        hamming = h;
    }

    public int[][] getBoard(){
        return board;
    }

    public boolean goalPredicate(Search searcher){
        EpuzzleSearch Esearcher = (EpuzzleSearch) searcher;
        int[][] target = Esearcher.getTarget();
        boolean match = true;
        for(int i = 0; i < target.length; i++){
            for(int j =0; j < target[i].length; j++){
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
            for(int j =0; j < board[i].length; j++){
                if(board[i][j] == 0){
                    row = i;
                    column = j;
                }
            }
        }

        ArrayList<EpuzzleState> puzList = new ArrayList<EpuzzleState>();
        ArrayList<SearchState> statList = new ArrayList<SearchState>();


        if(row == 0 && column == 0){
            puzList.add(new EpuzzleState(moveBoardPiece(row,column,0,1), estRemCost(moveBoardPiece(row,column,0,1), Esearcher.getTarget()), hamming));
            puzList.add(new EpuzzleState(moveBoardPiece(row,column,1,0), estRemCost(moveBoardPiece(row,column,1,0), Esearcher.getTarget()), hamming));
        }
        else if(row == 0 && column == 1){
            puzList.add(new EpuzzleState(moveBoardPiece(row,column,0,0), estRemCost(moveBoardPiece(row,column,0,0), Esearcher.getTarget()), hamming));
            puzList.add(new EpuzzleState(moveBoardPiece(row,column,0,2), estRemCost(moveBoardPiece(row,column,0,2), Esearcher.getTarget()), hamming));
            puzList.add(new EpuzzleState(moveBoardPiece(row,column,1,1), estRemCost(moveBoardPiece(row,column,1,1), Esearcher.getTarget()), hamming));
        }
        else if(row == 0 && column == 2){
            puzList.add(new EpuzzleState(moveBoardPiece(row,column,0,1), estRemCost(moveBoardPiece(row,column,0,1), Esearcher.getTarget()), hamming));
            puzList.add(new EpuzzleState(moveBoardPiece(row,column,1,2), estRemCost(moveBoardPiece(row,column,1,2), Esearcher.getTarget()), hamming));

        }
        else if(row == 1 && column == 0){
            puzList.add(new EpuzzleState(moveBoardPiece(row,column,0,0), estRemCost(moveBoardPiece(row,column,0,0), Esearcher.getTarget()), hamming));
            puzList.add(new EpuzzleState(moveBoardPiece(row,column,1,1), estRemCost(moveBoardPiece(row,column,1,1), Esearcher.getTarget()), hamming));
            puzList.add(new EpuzzleState(moveBoardPiece(row,column,2,0), estRemCost(moveBoardPiece(row,column,2,0), Esearcher.getTarget()), hamming));

        }
        else if(row == 1 && column == 1){
            puzList.add(new EpuzzleState(moveBoardPiece(row,column,0,1), estRemCost(moveBoardPiece(row,column,0,1), Esearcher.getTarget()), hamming));
            puzList.add(new EpuzzleState(moveBoardPiece(row,column,1,0), estRemCost(moveBoardPiece(row,column,1,0), Esearcher.getTarget()), hamming));
            puzList.add(new EpuzzleState(moveBoardPiece(row,column,1,2), estRemCost(moveBoardPiece(row,column,1,2), Esearcher.getTarget()), hamming));
            puzList.add(new EpuzzleState(moveBoardPiece(row,column,2,1), estRemCost(moveBoardPiece(row,column,2,1), Esearcher.getTarget()), hamming));

        }
        else if(row == 1 && column == 2){
            puzList.add(new EpuzzleState(moveBoardPiece(row,column,0,2), estRemCost(moveBoardPiece(row,column,0,2), Esearcher.getTarget()), hamming));
            puzList.add(new EpuzzleState(moveBoardPiece(row,column,1,1), estRemCost(moveBoardPiece(row,column,1,1), Esearcher.getTarget()), hamming));
            puzList.add(new EpuzzleState(moveBoardPiece(row,column,2,2), estRemCost(moveBoardPiece(row,column,2,2), Esearcher.getTarget()), hamming));

        }
        else if(row == 2 && column == 0){
            puzList.add(new EpuzzleState(moveBoardPiece(row,column,1,0), estRemCost(moveBoardPiece(row,column,1,0), Esearcher.getTarget()), hamming));
            puzList.add(new EpuzzleState(moveBoardPiece(row,column,2,1), estRemCost(moveBoardPiece(row,column,2,1), Esearcher.getTarget()), hamming));

        }
        else if(row == 2 && column == 1){
            puzList.add(new EpuzzleState(moveBoardPiece(row,column,1,1), estRemCost(moveBoardPiece(row,column,1,1), Esearcher.getTarget()), hamming));
            puzList.add(new EpuzzleState(moveBoardPiece(row,column,2,0), estRemCost(moveBoardPiece(row,column,2,0), Esearcher.getTarget()), hamming));
            puzList.add(new EpuzzleState(moveBoardPiece(row,column,2,2), estRemCost(moveBoardPiece(row,column,2,2), Esearcher.getTarget()), hamming));

        }
        else if(row == 2 && column == 2){
            puzList.add(new EpuzzleState(moveBoardPiece(row,column,1,2), estRemCost(moveBoardPiece(row,column,1,2), Esearcher.getTarget()), hamming));
            puzList.add(new EpuzzleState(moveBoardPiece(row,column,2,1), estRemCost(moveBoardPiece(row,column,2,1), Esearcher.getTarget()), hamming));

        }

    for (EpuzzleState puz : puzList){
        statList.add((SearchState) puz);
    }

    return statList;
    }

    private int[][] moveBoardPiece(int blankRow, int blankColumn, int valRow, int valColumn){
        int[][] newBoard = new int[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j =0; j < board[i].length; j++){
                newBoard[i][j] = board[i][j];
            }
        }

        newBoard[blankRow][blankColumn] = newBoard[valRow][valColumn];
        newBoard[valRow][valColumn] = 0;
        return newBoard;
    }

    public boolean sameState(SearchState state2){
        EpuzzleState board2state = (EpuzzleState)state2;
        int[][] board2 = board2state.getBoard();
        boolean match = true;
        for(int i = 0; i < board2.length; i++){
            for(int j =0; j < board2[i].length; j++){
                if(board[i][j] != board2[i][j])
                    match = false;
            }
        }
        return match;
    }

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

    private int estRemCost(int[][] newBoard, int[][] target){
        if(hamming = true){
            int hamCount = 0;
            for(int i = 0; i < target.length; i++){
                for(int j =0; j < target[i].length; j++){
                    if(board[i][j] != target[i][j])
                        hamCount++;
                }
            }
            return hamCount;
        }
        else{
            int manCount = 0;
            for(int i = 0; i < target.length; i++){
                for(int j =0; j < target[i].length; j++){
                    if(board[i][j] != target[i][j])
                    {
                        int[] correctPos = findCorrectPos(board[i][j], target);
                        if(i > correctPos[0]){
                            manCount += (i - correctPos[0]);
                        }
                        else{
                            manCount += (correctPos[0] - i);
                        }

                        if(j > correctPos[1]){
                            manCount += (j - correctPos[1]);
                        }
                        else{
                            manCount += (correctPos[1] - j);
                        }
                    }
                }
            }
            return manCount;
        }
    }

    private int[] findCorrectPos(int val, int[][] target){
        for(int i = 0; i < target.length; i++){
            for(int j =0; j < target[i].length; j++){
                if(val == target[i][j])
                {
                    int[] correctPos = {i, j};
                    return correctPos;
                }
            }
        }
        return null;
    }

}