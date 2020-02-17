package search;
import java.util.Stack;
public class DepthFirstFrontier implements Frontier{
    private Stack<Node> stack = new Stack<Node>();
	public Node remove(){
		return stack.pop();
	}
	public void add(Node addedNode){
	    stack.push(addedNode);
	}
	public boolean isEmpty(){
		return stack.isEmpty();
	}
	public void clear(){
		stack.clear();
	    }

    }
