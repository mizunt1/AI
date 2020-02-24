package search;
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

public interface Frontier{
	public Node remove();
	public void add(Node addedNode);
	public boolean isEmpty();
	public void clear();
        public int returnLen();
	}
    
