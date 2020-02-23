package search;

public class Node {
	public final Node parent;
	public final Action action;
	public final State state;
        public int value;
        public int totalCost;

	public Node(Node parent, Action action, State state) {
		this.parent = parent;
		this.action = action;
		// action is what action was applied to get to this node
		this.state = state;
		if(parent == null){
		    totalCost = 0;
			}
		else {totalCost += parent.totalCost + action.cost();}
	}
        public int getValue(){
	    return this.value;
	    }
        public void setValue(int setValue){
        value = setValue;
	}
}
