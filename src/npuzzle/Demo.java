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
		
		System.out.println("Depth First Graph search");
		
		DepthFirstFrontier frontier = new DepthFirstFrontier();
		GraphSearch search = new GraphSearch(frontier);
		long startTime = System.nanoTime();
		Node solution = search.returnSolution(initialConfiguration, goalTest);
		long endTime = System.nanoTime();
		int states_visited = search.getNumNodes();
		new NPuzzlePrinting().printSolution(solution);
		int maxfront = search.getMaxFrontier();
		
		System.out.println("states visited:" + states_visited); 
		System.out.println("max frontier size:" + maxfront); 
		System.out.println("time taken/s:" + (endTime - startTime)/1000000000); 
		

		System.out.println("Depth First Tree search will loop for ever, not tested");
		//frontier.clear();
		//TreeSearch search = new TreeSearch(frontier);
		//Node solution = search.returnSolution(initialConfiguration, goalTest);
		
		System.out.println("Breadth First Graph search");
		BreadthFirstFrontier Bfrontier = new BreadthFirstFrontier();
		long startTime2 = System.nanoTime();
		GraphSearch search2 = new GraphSearch(Bfrontier);
		Node solution2 = search2.returnSolution(initialConfiguration, goalTest);
		long endTime2 = System.nanoTime();
		int states_visited2 = search2.getNumNodes();
		int maxfront2 = search2.getMaxFrontier();
		System.out.println("states visited:" + states_visited2); 
		System.out.println("max frontier size:" + maxfront2); 
		System.out.println("time taken/s:" + (endTime2 - startTime2)/1000000000); 

		//new NPuzzlePrinting().printSolution(solution);
		
		System.out.println("Breadth First Tree search");
		Bfrontier.clear();
		TreeSearch search3 = new TreeSearch(Bfrontier);
		
		Node solution3 = search3.returnSolution(initialConfiguration, goalTest);
		int states_visited3 = search3.getNumNodes();
		System.out.println(states_visited3); 
		//new NPuzzlePrinting().printSolution(solution);

		System.out.println("Best First Tree search");
		BestFirstFrontier BestFrontier = new BestFirstFrontier(new AStarFunction( new MisplacedTilesHeuristicFunction()));
		TreeSearch search4 = new TreeSearch(BestFrontier);
		
		Node solution4 = search4.returnSolution(initialConfiguration, goalTest);
		int states_visited4 = search4.getNumNodes();
		System.out.println(states_visited4); 
		//new NPuzzlePrinting().printSolution(solution);

		System.out.println("Best First Graph search");
		BestFrontier.clear();

		GraphSearch search5 = new GraphSearch(BestFrontier);
		Node solution5 = search5.returnSolution(initialConfiguration, goalTest);
		int states_visited5 = search5.getNumNodes();
		System.out.println(states_visited5); 
		//new NPuzzlePrinting().printSolution(solution);
		





		// findsol takes in inputs (initalConfiguration, goalTest)
		// goalTest is the condition for this game where goal is true.
		// its an abstract fn that gets applied in BreadthFTSearch

		// NPuzzlePrinting takes solution and prints it for each step
		// iterates from node to node using . parent
	}
}
