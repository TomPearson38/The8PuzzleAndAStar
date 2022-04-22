/**
  * RunEPuzzleBFS.java
  *
  * run a BFS search for the 8 puzzle problem
  *
*/

import java.util.*;

public class RunEpuzzleBFS{

    public static void main(String[] arg){
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