/**
*	EpuzzleSearch.java
*
*	search for 8-puzzle problem assignment for BFS
*/


import java.util.*;

public class EpuzzleSearch extends Search {
    private int[][] target; //Layout of the target board

    /**
    *constructor create the board
    *@param t the target board layout
    */
    public EpuzzleSearch(int[][] t)
    {
        target = t;
    }

    /**
    * Returns the target
    * @return The target board
    */
    public int[][] getTarget(){
        return target;
    }

}