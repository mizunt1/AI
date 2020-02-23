package search;
import npuzzle.Tiles;

public class MisplacedTilesHeuristicFunction implements NodeFunction{
@Override
	public int returnValue(Node node) {
		State st = node.state;
		Tiles t = (Tiles)st;
		int n=t.getWidth();
		int misplaced = 0;
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				if (i==n-1 && j==n-1) {
					if (t.getTile(i,j)==0) {
						continue;
					}
				}
				else if (t.getTile(i,j)!=i*n+j+1) {
					misplaced++;
				}
			}
		}
		return misplaced;
	}
}
