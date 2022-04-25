/**
  * RunEPuzzleBFS.java
  *
  * Run a BFS search for the 8 puzzle problem
  *
*/

import java.util.*;

public class RunEpuzzleBFS{

    public static void main(String[] arg){
      //User choses if they would like to chose predfined puzzles or would like to generate a random puzzle
      Scanner myInput =new Scanner(System.in);  
      System.out.println("Please enter the number of an option:");
      System.out.println("[1] Pre-defined Puzzles");
      System.out.println("[2] Random Puzzles");
      int choice = myInput.nextInt();

      if(choice == 1)
        preDef();
      else if (choice == 2)
        randGen();
      else
        System.out.println("Invalid Input");
    }

    /**
    * Generates a random puzzle to solve based on a seed
    */
    private static void randGen(){
        //Puzzle is created
        Scanner myInput = new Scanner( System.in );
        System.out.print("Enter Seed (5 Digit Number): ");
        int seed = myInput.nextInt();
        EpuzzGen generatePuzzle = new EpuzzGen(seed);
        int[][] start = generatePuzzle.puzzGen(8);
        int[][] goal = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};

        //Puzzle searcher is delcared
        EpuzzleSearch searcher = new EpuzzleSearch(goal);
        SearchState initState = (SearchState) new EpuzzleState(start);

        //Puzzle is ran
        String resd = searcher.runSearch(initState, "breadthFirst");
        System.out.println(resd);

        //The board is printed into the console
        String result = "";
        for(int i = 0; i < start.length; i++){
            for(int j =0; j < start[i].length; j++){
        }
      }
    }

    /**
    * Calculates the pre-defined puzzles presented
    */
    private static void preDef(){
        int[][] startP1 = {{1, 0, 3}, {4, 2, 6}, {7, 5, 8}};
        int[][] startP2 = {{4, 1, 3}, {7, 2, 5}, {0, 8, 6}};
        int[][] startP3 = {{2, 3, 6}, {1, 5, 8}, {4, 7, 0}};

        int[][] target = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};

        //BFS search algorithm P1
        EpuzzleSearch searcherP1 = new EpuzzleSearch(target);
        SearchState initStateP1 = (SearchState) new EpuzzleState(startP1);

        //BFS search algorithm P2
        EpuzzleSearch searcherP2 = new EpuzzleSearch(target);
        SearchState initStateP2 = (SearchState) new EpuzzleState(startP2);

        //BFS search algorithm P3
        EpuzzleSearch searcherP3 = new EpuzzleSearch(target);
        SearchState initStateP3 = (SearchState) new EpuzzleState(startP3);

        //Search algorithm is ran for each P
        String resultP1 = searcherP1.runSearch(initStateP1, "breadthFirst");
        System.out.println(resultP1);
        String resultP2 = searcherP2.runSearch(initStateP2, "breadthFirst");
        System.out.println(resultP2);
        String resultP3 = searcherP3.runSearch(initStateP3, "breadthFirst");
        System.out.println(resultP3);
    }
}