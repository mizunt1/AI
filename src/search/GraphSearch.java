package search;
import search.Node;
import java.util.LinkedList; 
import java.io.*; 
public class GraphSearch implements Search{
    // delcaring a field of the class
    private Frontier frontier;
    int num_visited = 0;
    LinkedList<State> state_list = new LinkedList<State>(); 
    // constructor assigns 
    public GraphSearch(Frontier frontier){
	this.frontier = frontier;
	}
    public Node returnSolution(State initialConfig, GoalTest goalTest){
	System.out.println("Performing graph search");

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
				    if(!state_list.contains(newState)){
					state_list.add(newState);
					frontier.add(new Node(node, action, newState));
					num_visited += 1;
					}
				    // add these nodes to the queue
				}
			}
		}
		return null;
		}
    public int getNumNodes(){
	return num_visited;}
	
}
