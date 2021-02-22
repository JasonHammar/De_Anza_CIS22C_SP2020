
public class GraphTest {

	public static void main(String[] args) {

		Graph g1 = new Graph(5);

		Graph g2 = new Graph(15);
		System.out.print("**Testing getNumEdges**\n");
		System.out.print("Should print 0: ");
		System.out.print(g1.getNumEdges());
		g2.addUndirectedEdge(1, 2);
		System.out.print("\nShould Print 1: " + g2.getNumEdges());

		System.out.print("\n\n**Testing getNumVertices**\n");
		System.out.print("Should Print 5: " + g1.getNumVertices());
		System.out.print("\nShould Print 15: " + g2.getNumVertices());

		System.out.print("\n\n**Testing isEmpty**");
		System.out.print("\nShould return false: " + g1.isEmpty());
		Graph g3 = new Graph(0);
		System.out.print("\nShould print true: " + g3.isEmpty());

		System.out.print("\n\n**Testing getDistance**");
		System.out.print("\nShould print Error message: ");
		try {
			System.out.print(g1.getDistance(0));
		} catch (IndexOutOfBoundsException e) {
			System.out.print(e.getMessage());
		}
		System.out.print("\nShould Print -1: ");
		System.out.print(g2.getDistance(2));

		System.out.print("\n\n**Testing getParent**");
		System.out.print("\nShould print error message: ");
		try {
			g1.getParent(0);
		} catch (IndexOutOfBoundsException e) {
			System.out.print(e.getMessage());
		}
		System.out.print("\nShould Print 0: ");
		System.out.print(g2.getParent(2));

		System.out.print("\n\n**Testing getColor**");
		System.out.print("\nShould print error message: ");
		try {
			g1.getColor(0);
		} catch (IndexOutOfBoundsException e) {
			System.out.print(e.getMessage());
		}
		System.out.print("\nShould Print W: ");
		System.out.print(g2.getColor(2));

		System.out.print("\n\n**Testing getAdjacencyList**");
		System.out.print("\nShould print error message: ");
		try {
			g1.getAdjacencyList(0);
		} catch (IndexOutOfBoundsException e) {
			System.out.print(e.getMessage());
		}
		System.out.print("\nShould Print 1: ");
		System.out.print(g2.getAdjacencyList(2));
		
		System.out.print("\n\n**Testing addDirectedEdge**");
		g1.addDirectedEdge(1,2);
		g1.addDirectedEdge(1,3);
		g1.addDirectedEdge(2,3);
		g1.addDirectedEdge(3,5);
		System.out.print("\nShould print 2 3: ");
		System.out.print(g1.getAdjacencyList(1));
		System.out.print("\nShould print 4: ");
		System.out.print(g1.getNumEdges());
		System.out.print("\nShould print error message: ");
		try {
			g1.addDirectedEdge(0, 6);
		}catch(IndexOutOfBoundsException e) {
			System.out.print(e.getMessage());
		}
		
		System.out.print("\n\n**Testing addUndirectedEdge**");
		g2.addUndirectedEdge(1,4);
		g2.addUndirectedEdge(2,3);
		g2.addUndirectedEdge(3,4);
		System.out.print("\nShould print 2 4: ");
		System.out.print(g2.getAdjacencyList(1));
		System.out.print("\nShould print 4: ");
		System.out.print(g1.getNumEdges());
		System.out.print("\nShould print error message: ");
		try {
			g2.addUndirectedEdge(0, 6);
		}catch(IndexOutOfBoundsException e) {
			System.out.print(e.getMessage());
		}

		System.out.print("\n\n**Testing Graph Constructor and toString**\nShould print nothing: ");
		try {
		System.out.print(g1);
		}catch(NullPointerException e) {
			System.out.print(e.getMessage());
		}
		
		g2.addUndirectedEdge(3, 6);
		g2.addUndirectedEdge(4, 7);
		g2.addUndirectedEdge(5, 4);
		g2.addUndirectedEdge(6, 7);
		g2.addUndirectedEdge(7, 10);
		g2.BFS(1);
		g2.printBFS();
		

	}

}
