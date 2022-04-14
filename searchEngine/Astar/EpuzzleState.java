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
        int[][] target = Esearcher.getTarget;
        boolean match = true;
        for(int i = 0; i < target.count; i++){
            for(int j =0; j < target[i].count; i++){
                if(board[i][j] != target[i][j])
                    match = false;
            }
        }
    }

}