/**
  * RunEPuzzleAstar.java
  *
  * Run a AStar search for the 8 puzzle problem
  *
*/

import java.util.*;

public class RunEpuzzleAstar{

    public static void main(String[] arg){
        //Adapt to specification
        Scanner myInput = new Scanner( System.in );
        System.out.print("Enter Seed: ");
        int seed = myInput.nextInt();

        //Puzzle is generated from presented seed
        EpuzzGen generatePuzzle = new EpuzzGen(seed);
        int[][] start = generatePuzzle.puzzGen(8);
        int[][] goal = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};

        //A* search algorithm using hamming search (boolean value is set to true)
        EpuzzleSearch searcherHam = new EpuzzleSearch(goal);
        SearchState initStateHam = (SearchState) new EpuzzleState(start, 100, true);

        //A* search algorithm using manhattan search (boolean value is set to false)
        EpuzzleSearch searcherManhat = new EpuzzleSearch(goal);
        SearchState initStateManhat = (SearchState) new EpuzzleState(start, 100, false);

        //Hamming method is ran 
        System.out.println("Ham Method:");
        String resdHam = searcherHam.runSearch(initStateHam, "AStar");

        //Manhattan method is ran
        System.out.println("\nManhattan Method:");
        String resdManhat = searcherManhat.runSearch(initStateManhat, "AStar");
        System.out.println("Starting map is: ");

        //The board is printed into the console
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