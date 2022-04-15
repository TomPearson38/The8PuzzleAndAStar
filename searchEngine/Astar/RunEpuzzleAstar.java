/**
  * RunEPuzzleBFS.java
  *
  *
  * 
  *   run a BFS search for the 8 puzzle problem
  *
*/

import java.util.*;

public class RunEpuzzleAstar{

    public static void main(String[] arg){
        int[][] start = {{1, 0, 3},{4, 2, 6},{7, 5, 8}};
        int[][] goal = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};

        EpuzzleSearch searcher = new EpuzzleSearch(goal);
        SearchState initState = (SearchState) new EpuzzleState(start);

        String resd = searcher.runSearch(initState, "breadthFirst");
        System.out.println(resd);
    }
}