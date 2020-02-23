package search;

public class AStarFunction implements NodeFunction{
    private NodeFunction heuristicFunction;
    public AStarFunction(NodeFunction heuristicFunction){
	this.heuristicFunction = heuristicFunction;
	    }
    @Override
    public int returnValue(Node node){
	return node.totalCost + this.heuristicFunction.returnValue(node);
	}
}
