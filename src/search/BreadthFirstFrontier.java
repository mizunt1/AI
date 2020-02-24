package search;
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;
public class BreadthFirstFrontier implements Frontier{
    private Queue<Node> fifoQueue = new LinkedList<Node>();
	public Node remove(){
	    return fifoQueue.remove();
	}
	public void add(Node addedNode){
	    fifoQueue.add(addedNode);
	}
	public boolean isEmpty(){
	    return fifoQueue.isEmpty();
	}
	public void clear(){
		fifoQueue.clear();
		}
	public int returnLen(){
	    return fifoQueue.size();
	    
	    }	
	}


