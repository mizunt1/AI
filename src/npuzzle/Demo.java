// notes but compile as javac npuzzle/DFTS_Demo.java
// run as java npuzzle.BFTS_Demo 
package npuzzle;

import search.BreadthFirstFrontier;
import search.DepthFirstFrontier;
import search.GoalTest;
import search.BestFirstFrontier;
import search.Node;
import search.GraphSearch;
import search.TreeSearch;
import search.AStarFunction;
import search.MisplacedTilesHeuristicFunction;
import java.io.*; 

public class Demo {
	public static void main(String[] args) {
		System.out.println();
		// specify initial configuration
		Tiles initialConfiguration = new Tiles(new int[][] {
			{ 7, 4, 2 },
			{ 8, 1, 3 },
			{ 5, 0, 6 }
		});
		
		GoalTest goalTest = new TilesGoalTest();
		// 
//		DepthFirstFrontier frontier = new DepthFirstFrontier();
//		BreadthFirstFrontier frontier = new BreadthFirstFrontier();
		BestFirstFrontier frontier = new BestFirstFrontier(new AStarFunction( new MisplacedTilesHeuristicFunction()));

//		TreeSearch search = new TreeSearch(frontier);
		GraphSearch search = new GraphSearch(frontier);
		Node solution = search.returnSolution(initialConfiguration, goalTest);
		int states_visited = search.getNumNodes();
		// findsol takes in inputs (initalConfiguration, goalTest)
		// goalTest is the condition for this game where goal is true.
		// its an abstract fn that gets applied in BreadthFTSearch

		new NPuzzlePrinting().printSolution(solution);
		System.out.println(states_visited); 
		// NPuzzlePrinting takes solution and prints it for each step
		// iterates from node to node using . parent
	}
}
