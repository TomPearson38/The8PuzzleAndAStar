/**
  * RunEPuzzleBFS.java
  *
  *
  * 
  *   run a BFS search for the 8 puzzle problem
  *
*/

import java.util.*;

public class RunEpuzzleBFS{

    public static void main(String[] arg){
        Scanner myInput = new Scanner( System.in );
        System.out.print("Enter Seed: ");
        int seed = myInput.nextInt();
        EpuzzGen generatePuzzle = new EpuzzGen(seed);
        int[][] start = generatePuzzle.puzzGen(8);
        int[][] goal = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};

        EpuzzleSearch searcher = new EpuzzleSearch(goal);
        SearchState initState = (SearchState) new EpuzzleState(start);

        String resd = searcher.runSearch(initState, "breadthFirst");
        System.out.println(resd);
    }
}