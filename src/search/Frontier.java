package search;
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

public class Frontier{
    private String frontierType = null;
    private Stack<Node> stack = new Stack<Node>();
    private Queue<Node> fifoQueue = new LinkedList<Node>();
    public Frontier(String frontierTypeIn){
	this.frontierType = frontierTypeIn;

	}
	public Node remove(){
	    if(this.frontierType == "stack"){
		return stack.pop();
	    }
	    else{
		return fifoQueue.remove();
	    }	    	    
	}
	public void add(Node addedNode){
	if(frontierType == "stack"){
	    stack.push(addedNode);
	}
	else{
	    fifoQueue.add(addedNode);
	}	    		
	}
	public boolean isEmpty(){
	    if(frontierType == "stack"){
		return stack.isEmpty();
	    }
	    else{
		return fifoQueue.isEmpty();
	    }	    		
	}
	public void clear(){
	    if(frontierType == "stack"){
		stack.clear();
	    }
	    else{
		fifoQueue.clear();
	    }	    		
	}
    }
