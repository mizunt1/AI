package search;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BreadthFirstFrontier {
    // creating a method findSolution which returns type Node
    // takes input unitialConfiguration which is of type State and input goalTest, which is of type GoalTest
	public static Node findSolution(State initialConfiguration, GoalTest goalTest) {
	    // create a Queue of type Node 
	    // we call this fifoQueue
	    Frontier fifoQueue = new Frontier("queue");
		fifoQueue.add(new Node(null, null, initialConfiguration));
		while (!fifoQueue.isEmpty()) {
		    // remove the item from queue and if its goal, return the node
		    // returns goal node
		    // node has pointer to previous node, accessible by . parent
			Node node = fifoQueue.remove();
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
				    fifoQueue.add(new Node(node, action, newState));
				    // Node(parent, action, state)
				    // add these nodes to the queue
				}
			}
		}
		return null;
	}
}