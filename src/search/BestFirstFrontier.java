package search;
import search.*;
import java.util.PriorityQueue;
import java.util.Comparator;
//import java.search.FunctionComparator;

public class BestFirstFrontier implements Frontier{
    private Comparator<Node> comparator = new FunctionComparator();
    private PriorityQueue<Node> pQueue = new PriorityQueue<Node>(comparator);

    private NodeFunction function;
        public BestFirstFrontier(NodeFunction function){
	    this.function = function;
	    }
	public Node remove(){
	    return pQueue.remove();
	}
	public void add(Node addedNode){
	    int eval = this.function.returnValue(addedNode);
	    addedNode.setValue(eval);
	    pQueue.add(addedNode);
	}
	public boolean isEmpty(){
	    return pQueue.isEmpty();
	}
	public void clear(){
		pQueue.clear();
	    }	
	}

