package search;
import search.Node;
import search.State;

public interface Search {
    Node returnSolution(State initialConfig, GoalTest goalConfig);
    int getNumNodes();
	   
}
