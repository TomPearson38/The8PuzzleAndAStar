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
        Scanner myInput = new Scanner( System.in );
        System.out.print("Enter Seed: ");
        int seed = myInput.nextInt();
        EpuzzGen generatePuzzle = new EpuzzGen(seed);
        int[][] start = generatePuzzle.puzzGen(8);
        int[][] goal = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};

        EpuzzleSearch searcherHam = new EpuzzleSearch(goal);
        SearchState initStateHam = (SearchState) new EpuzzleState(start, 100, true);
        EpuzzleSearch searcherManhat = new EpuzzleSearch(goal);
        SearchState initStateManhat = (SearchState) new EpuzzleState(start, 100, false);

        System.out.println("Ham Method:");
        String resdHam = searcherHam.runSearch(initStateHam, "AStar");
        System.out.println("\nManhattan Method:");
        String resdManhat = searcherManhat.runSearch(initStateManhat, "AStar");
        System.out.println("Starting map is: ");

        String result = "";
        for(int i = 0; i < start.length; i++){
            for(int j =0; j < start[i].length; j++){
                result+= "" + start[i][j];
                if(j != start[i].length-1){
                    result+= " | ";
                }
            }
            result+= "\n";
        }
        System.out.print(result);
      
    }
}