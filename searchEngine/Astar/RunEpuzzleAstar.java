/**
  * RunEPuzzleAstar.java
  *
  * Run a AStar search for the 8 puzzle problem
  *
*/

import java.util.*;

public class RunEpuzzleAstar{

    public static void main(String[] arg){
      //User choses if they would like to chose predefined puzzles or would like to generate a new puzzle
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
    *Solves a pre-defined puzzle
    */
    private static void preDef()
    {
        int[][] startP1 = {{1, 0, 3}, {4, 2, 6}, {7, 5, 8}};
        int[][] startP2 = {{4, 1, 3}, {7, 2, 5}, {0, 8, 6}};
        int[][] startP3 = {{2, 3, 6}, {1, 5, 8}, {4, 7, 0}};

        int[][] target = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};

        System.out.println("Please chose a local cost algorithm:");
        System.out.println("[1]Hamming");
        System.out.println("[2]Manhattan");

        Scanner myInput =new Scanner(System.in);  
        int input = myInput.nextInt();
        boolean hamming = true;

        if(input == 2)
          hamming = false;

        //search algorithm P1 
        EpuzzleSearch searcherP1 = new EpuzzleSearch(target);
        SearchState initStateP1 = (SearchState) new EpuzzleState(startP1, 100, hamming, 1);

        //search algorithm P2 
        EpuzzleSearch searcherP2 = new EpuzzleSearch(target);
        SearchState initStateP2 = (SearchState) new EpuzzleState(startP2, 100, hamming, 1);

        //search algorithm P3 
        EpuzzleSearch searcherP3 = new EpuzzleSearch(target);
        SearchState initStateP3 = (SearchState) new EpuzzleState(startP3, 100, hamming, 1);

        //algorithm is ran for each P 
        String resultP1 = searcherP1.runSearch(initStateP1, "AStar");
        System.out.println(resultP1);
        String resultP2 = searcherP2.runSearch(initStateP2, "AStar");
        System.out.println(resultP2);
        String resultP3 = searcherP3.runSearch(initStateP3, "AStar");
        System.out.println(resultP3);
    }

    /**
    * Generates a random puzzle to solve based on a seed
    */
    private static void randGen(){
        Scanner myInput = new Scanner( System.in );
        System.out.print("Enter Seed: ");
        int seed = myInput.nextInt();

        //Puzzle is generated from presented seed
        EpuzzGen generatePuzzle = new EpuzzGen(seed);
        int[][] start = generatePuzzle.puzzGen(8);
        int[][] goal = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};

        //A* search algorithm using hamming search (boolean value is set to true)
        EpuzzleSearch searcherHam = new EpuzzleSearch(goal);
        SearchState initStateHam = (SearchState) new EpuzzleState(start, 100, true, 1);

        //A* search algorithm using manhattan search (boolean value is set to false)
        EpuzzleSearch searcherManhat = new EpuzzleSearch(goal);
        SearchState initStateManhat = (SearchState) new EpuzzleState(start, 100, false, 1);

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
        }
      }
    }
}