// notes but compile as javac npuzzle/DFTS_Demo.java
// run as java npuzzle.BFTS_Demo 
package npuzzle;

import search.BreadthFirstFrontier;
import search.GoalTest;
import search.Node;

public class BFTS_frontier_demo {
	public static void main(String[] args) {
		System.out.println("This is a demonstration of breadth-first tree search on 8-puzzle");
		System.out.println();
		// specify initial configuration
		Tiles initialConfiguration = new Tiles(new int[][] {
			{ 7, 4, 2 },
			{ 8, 1, 3 },
			{ 5, 0, 6 }
		});
		
		GoalTest goalTest = new TilesGoalTest();
		// 
		Node solution = BreadthFirstFrontier.findSolution(initialConfiguration, goalTest);
		// findsol takes in inputs (initalConfiguration, goalTest)
		// goalTest is the condition for this game where goal is true.
		// its an abstract fn that gets applied in BreadthFTSearch

		new NPuzzlePrinting().printSolution(solution);
		// NPuzzlePrinting takes solution and prints it for each step
		// iterates from node to node using . parent
	}
}
