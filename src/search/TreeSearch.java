package search;
import search.Node;


public class TreeSearch implements Search{
        // delcaring a field of the class
    public static Frontier frontier;
    int num_visited = 0;
    int max_len_front = 0;
    // constructor assigns 
    public TreeSearch(Frontier newFrontier){
	this.frontier = newFrontier;
	}
    public Node returnSolution(State initialConfig, GoalTest goalTest){
	System.out.println("Performing tree search");
	int num_nodes = 0;
	    // create a Queue of type Node 
	    // we call this fifoQueue
	        frontier.add(new Node(null, null, initialConfig));
		while (!frontier.isEmpty()) {
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
				    num_visited += 1;
				    if(frontier.returnLen()>max_len_front){
					    max_len_front = frontier.returnLen();
				    }
								
				    // Node(parent, action, state)
				    // add these nodes to the queue
				}
			}
		}
		return null;
		}
    public int getNumNodes(){
	return num_visited;}
    public int getMaxFrontier(){
	return max_len_front;
    }
}
