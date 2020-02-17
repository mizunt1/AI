package search;
import search.Node;

public class TreeSearch implements Search{
        // delcaring a field of the class
    private Frontier frontier;
    // constructor assigns 
    public TreeSearch(Frontier frontier){
	this.frontier = frontier;
	}
    public static Node returnSolution(State initialConfig, GoalTest goalConfig){
	int num_nodes = 0
	    // create a Queue of type Node 
	    // we call this fifoQueue
		frontier.add(new Node(null, null, initialConfiguration));
		while (!fifoQueue.isEmpty()) {
		    // remove the item from queue and if its goal, return the node
		    // returns goal node
		    // node has pointer to previous node, accessible by . parent
		    Node node = frontier.remove();
			if (goalTest.isGoal(node.state))
				return node;
			else {
			    // if its not goal, see where we can go
				for (Action action : node.state.getApplicableActions()) {
				    // see where we can go from that node
				    // get applicable actions is under Tiles.java
				    // Tiles implements state
				    State newState = node.state.getActionResult(action);
				    // get actionResult also in Tiles.java
				    // add those accessible nodes to queue.
				    // ready for expansion
				    // goes around in loop

				    frontier.add(new Node(node, action, newState));
				    num_nodes += 1;
				    // Node(parent, action, state)
				    // add these nodes to the queue
				}
			}
		}
		return null;
		}
    public static int getNumNodes(){
	}
	
}

    public static Node returnSolution(State initialConfiguration, GoalTest goalTest){	
	BreadthFirstFrontier search = new BreadthFirstFrontier();
	Node solution = search.findSolution(initialConfiguration, goalTest);
	return solution;
    }
    
    public static int getNumNodes(){
	return search.num_nodes
	
	}
}
