package search;
import java.util.Comparator;

public class FunctionComparator implements Comparator<Node> {
    @Override
    public int compare(Node node1, Node node2) {
	if (node1.getValue() < node2.getValue())
	    {
		return -1; 
	    }  
        else if (node1.getValue() > node2.getValue()) {
	    return 1; 
        }
	
	return 0; 
    }
}
