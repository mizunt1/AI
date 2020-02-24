// notes:compile as javac npuzzle/Demo.java
// run as java npuzzle.Demo

/*Results:

Depth First Graph search
Performing graph search
states visited:34266
max frontier size:14480
time taken/ms:17411

Breadth First Graph search
Performing graph search
states visited:4359
max frontier size:1592
time taken/ms:131



Breadth First Tree search
Performing tree search
states visited:2298273
max frontier size:1473871
time taken/ms:1076



Best First Tree search
Performing tree search
states visited:963
max frontier size:613
time taken/ms:2



Best First Graph search
Performing graph search
states visited:189
max frontier size:82
time taken/ms:2

Comments:
Depth First graph search takes the longest time. Going down one branch till the end 
requires traversing many states. 17411 ms
Breadth First graph search takes less time of 131ms. 
Breadth First tree search takes longer, 1076 seconds. This is unsurprising, the graph search
version of any search will take less time than the tree search version as it does not look at
states which it has seen before

Best First tree search and graph search take approximately the same amount of time of 2ms.
However graph search is more efficient as it visits much fewer nodes.


*/








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
		//new NPuzzlePrinting().printSolution(solution);
		int maxfront = search.getMaxFrontier();
		
		System.out.println("states visited:" + states_visited); 
		System.out.println("max frontier size:" + maxfront); 
		System.out.println("time taken/ms:" + (endTime - startTime)/1000000); 
		System.out.print( "\n\n\n" );
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
		System.out.println("time taken/ms:" + (endTime2 - startTime2)/1000000); 
		System.out.print( "\n\n\n" );
		//new NPuzzlePrinting().printSolution(solution2);
		
		System.out.println("Breadth First Tree search");
		Bfrontier.clear();
		TreeSearch search3 = new TreeSearch(Bfrontier);
		long startTime3 = System.nanoTime();
		Node solution3 = search3.returnSolution(initialConfiguration, goalTest);
		long endTime3 = System.nanoTime();
		int states_visited3 = search3.getNumNodes();
		int maxfront3 = search3.getMaxFrontier();
		System.out.println("states visited:" + states_visited3); 
		System.out.println("max frontier size:" + maxfront3); 
		System.out.println("time taken/ms:" + (endTime3 - startTime3)/1000000); 
		System.out.print( "\n\n\n" );
		//new NPuzzlePrinting().printSolution(solution3);

		System.out.println("Best First Tree search");
		BestFirstFrontier BestFrontier = new BestFirstFrontier(new AStarFunction( new MisplacedTilesHeuristicFunction()));
		TreeSearch search4 = new TreeSearch(BestFrontier);
		long startTime4 = System.nanoTime();
		Node solution4 = search4.returnSolution(initialConfiguration, goalTest);
		long endTime4 = System.nanoTime();
		int states_visited4 = search4.getNumNodes();
		int maxfront4 = search4.getMaxFrontier();
		System.out.println("states visited:" + states_visited4); 
		System.out.println("max frontier size:" + maxfront4); 
		System.out.println("time taken/ms:" + (endTime4 - startTime4)/1000000); 
		System.out.print( "\n\n\n" );
		//new NPuzzlePrinting().printSolution(solution4);

		System.out.println("Best First Graph search");
		BestFrontier.clear();

		GraphSearch search5 = new GraphSearch(BestFrontier);
		long startTime5 = System.nanoTime();
		Node solution5 = search5.returnSolution(initialConfiguration, goalTest);
		long endTime5 = System.nanoTime();
		int states_visited5 = search5.getNumNodes();
		int maxfront5 = search5.getMaxFrontier();
		System.out.println("states visited:" + states_visited5); 
		System.out.println("max frontier size:" + maxfront5); 
		System.out.println("time taken/ms:" + (endTime5 - startTime4)/1000000); 
		System.out.print( "\n\n\n" );
		//new NPuzzlePrinting().printSolution(solution5);
		
		// findsol takes in inputs (initalConfiguration, goalTest)
		// goalTest is the condition for this game where goal is true.
		// its an abstract fn that gets applied in BreadthFTSearch

		// NPuzzlePrinting takes solution and prints it for each step
		// iterates from node to node using . parent
	}
}

