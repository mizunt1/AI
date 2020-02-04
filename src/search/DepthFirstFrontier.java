package search;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class DepthFirstFrontier {
    // creating a method findSolution which returns type Node
    // takes input unitialConfiguration which is of type State and input goalTest, which is of type GoalTest
	public static Node findSolution(State initialConfiguration, GoalTest goalTest) {
	    // create a Queue of type Node 
	    // we call this fifoQueue
	    Frontier lifoStack = new Frontier("stack"); 
		lifoStack.add(new Node(null, null, initialConfiguration));
		while (!lifoStack.isEmpty()) {
		    // remove the item from queue and if its goal, return the node
		    // returns goal node
		    // node has pointer to previous node, accessible by . parent
			Node node = lifoStack.remove();
			if (goalTest.isGoal(node.state))
				return node;
			else {
				for (Action action : node.state.getApplicableActions()) {
				    // see where we can go from that node
					State newState = node.state.getActionResult(action);
					// set up nodes.
					lifoStack.add(new Node(node, action, newState));
					// Node(parent, action, state)
					// add these nodes to the queue
				}
			}
		}
		return null;
	}
}
