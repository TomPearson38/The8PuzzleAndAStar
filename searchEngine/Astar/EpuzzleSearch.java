/**
*	EpuzzleSearch.java
*
*	search for 8-puzzle problem assignment for BFS
*/


import java.util.*;

public class EpuzzleSearch extends Search {
    private int[][] board; //Layout of board
    private int[][] target; //Layout of the target board

    //constructor creates the board
    /**
    *constructor create the board
    *@param b the initial board layout
    *@param t the target board layout
     */
    public EpuzzleSearch(int[][] b, int[][] t)
    {
        board = b;
        target = t;
    }

    public int[][] getBoard(){
        return board;
    }

    public int[][] getTarget(){
        return target;
    }

}