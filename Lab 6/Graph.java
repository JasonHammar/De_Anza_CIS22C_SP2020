
/**
 * Graph.java
 * @author
 * @author
 * CIS 22C, Lab 8
 */

import java.util.ArrayList;

public class Graph {
	private int vertices;
	private int edges;
	private ArrayList<List<Integer>> adj;
	private ArrayList<Character> color;
	private ArrayList<Integer> distance;
	private ArrayList<Integer> parent;

	/** Constructor */

	/**
	 * initializes an empty graph, with n vertices and 0 edges, and initializes all
	 * arraylists to contain default values from indices 1 to n
	 * 
	 * @param n the number of vertices in the graph
	 */
	public Graph(int n) {

		vertices = n;
		edges = 0;

		adj = new ArrayList<List<Integer>>(n);
		color = new ArrayList<Character>(n);
		distance = new ArrayList<Integer>(n);
		parent = new ArrayList<Integer>(n);

		for (int i = 0; i < n + 1; i++) {
			adj.add(new List<Integer>());
			color.add('w');
			distance.add(-1);
			parent.add(0);
		}

	}

	/*** Accessors ***/

	/**
	 * Returns the number of edges in the graph
	 * 
	 * @return the number of edges
	 */
	public int getNumEdges() {
		return edges;
	}

	/**
	 * Returns the number of vertices in the graph
	 * 
	 * @return the number of vertices
	 */
	public int getNumVertices() {
		return vertices;
	}

	/**
	 * returns whether the graph is empty (no vertices)
	 * 
	 * @return whether the graph is empty
	 */
	public boolean isEmpty() {
		return vertices == 0;
	}

	/**
	 * Returns the value of the distance[v]
	 * 
	 * @param v a vertex in the graph
	 * @precondition 0 < v <= vertices
	 * @return the distance of vertex v
	 * @throws IndexOutOfBoundsException when the precondition is violated
	 */
	public Integer getDistance(Integer v) throws IndexOutOfBoundsException {
		if (v <= 0 || v > vertices) {
			throw new IndexOutOfBoundsException("getDistance(): vertex is not on graph");
		}
		return distance.get(v);
	}

	/**
	 * Returns the value of the parent[v]
	 * 
	 * @param v a vertex in the graph
	 * @precondition 0 < v <= vertices
	 * @return the parent of vertex v
	 * @throws IndexOutOfBoundsException when the precondition is violated
	 */
	public Integer getParent(Integer v) throws IndexOutOfBoundsException {
		if (v <= 0 || v > vertices) {
			throw new IndexOutOfBoundsException("getParent(): vertex is not on graph");
		}
		return parent.get(v);
	}

	/**
	 * Returns the value of the color[v]
	 * 
	 * @param v a vertex in the graph
	 * @precondition 0 < v <= vertices
	 * @return the color of vertex v
	 * @throws IndexOutOfBoundsException when the precondition is violated
	 */
	public Character getColor(Integer v) throws IndexOutOfBoundsException {
		if (v <= 0 || v > vertices) {
			throw new IndexOutOfBoundsException("getColor(): vertex is not on graph");
		}
		return color.get(v);
	}

	/**
	 * Returns the List stored at index v
	 * 
	 * @param v a vertex in the graph
	 * @return the adjacency List a v
	 * @precondition 0 < v <= vertices
	 * @throws IndexOutOfBoundsException when the precondition is violated
	 */
	public List<Integer> getAdjacencyList(Integer v) throws IndexOutOfBoundsException {
		if (v <= 0 || v > vertices) {
			throw new IndexOutOfBoundsException("getAdjacencyList(): vertex is not on graph");
		}
		return adj.get(v);
	}

	/*** Manipulation Procedures ***/

	/**
	 * Inserts vertex v into the adjacency list of vertex u (i.e. inserts v into the
	 * list at index u)
	 * 
	 * @precondition 0 < u <= vertices, 0 < v <= vertices
	 * @throws IndexOutOfBounds exception when the precondition is violated
	 */
	public void addDirectedEdge(Integer u, Integer v) throws IndexOutOfBoundsException {
		if ((v <= 0 || v > vertices) && (u <= 0 || u > vertices)) {
			throw new IndexOutOfBoundsException("addDirectedEdge(): vertex is not on graph");
		}
		adj.get(u).addLast(v);
		edges++;
	}

	/**
	 * Inserts vertex v into the adjacency list of vertex u (i.e. inserts v into the
	 * list at index u) and inserts u into the adjacent vertex list of v
	 * 
	 * @precondition 0 < u <= vertices, 0 < v <= vertices
	 * @throws IndexOutOfBounds exception when the precondition is violated
	 */
	public void addUndirectedEdge(Integer u, Integer v) throws IndexOutOfBoundsException {
		if ((v <= 0 || v > vertices) && (u <= 0 || u > vertices)) {
			throw new IndexOutOfBoundsException("addUndirectedEdge(): vertex is not on graph");
		}
		adj.get(u).addLast(v);
		adj.get(v).addLast(u);
		edges++;
	}

	/*** Additional Operations ***/

	/**
	 * Creates a String representation of the Graph Prints the adjacency list of
	 * each vertex in the graph, vertex: <space separated list of adjacent vertices>
	 */
	@Override
	public String toString() {
		String result = "";
		for (int i = 0; i < vertices; i++) {
			result += i + ": " + adj.get(i) + " \n";

		}
		return result;

	}

	/**
	 * Prints the current values in the parallel ArrayLists after executing BFS.
	 * First prints the heading: v <tab> c <tab> p <tab> d Then, prints out this
	 * information for each vertex in the graph Note that this method is intended
	 * purely to help you debug your code
	 */
	public void printBFS() {

		System.out.println("v   c   p   d");
		for (int i = 1; i < 10; i++) {
			System.out.print(color.get(i) + " " + parent.get(i) + " " + distance.get(i));
			System.out.print("\n");
		}

	}

	/**
	 * Performs breath first search on this Graph given a source vertex
	 * 
	 * @param source the source vertex
	 * @precondition graph must not be empty
	 * @precondition source is a vertex in the graph
	 * @throws IllegalStateException     if the graph is empty
	 * @throws IndexOutOfBoundsException when vertex is outside the bounds of the
	 *                                   graph
	 */

	public void BFS(Integer source) throws IllegalStateException, IndexOutOfBoundsException {

		if (isEmpty()) {
			throw new IllegalStateException("BFS(): graph is empty");
		}
		if (source <= 0 || source > vertices) {
			throw new IndexOutOfBoundsException("BFS(): vertex is outside the bounds of the graph");
		}

		for (int i = 1; i <= vertices; i++) {
			color.add(i, 'w');
			distance.add(i, -1);
			parent.add(i, null);
		}

		List<Integer> Q = new List<>();
		color.add(source, 'g');
		distance.add(source, 0);
		Q.addLast(source);

		while (!Q.isEmpty()) {

			int x = Q.getFirst();
			
			Q.removeFirst();
			
			List<Integer> adjacent_vertices = adj.get(x);
			adjacent_vertices.placeIterator();
			while (!adjacent_vertices.offEnd()) {
				if (color.get(adjacent_vertices.getIterator()).equals('w')) {
					
					color.add(adjacent_vertices.getIterator(), 'g');
					distance.add(adjacent_vertices.getIterator(), getDistance(x) + 1);
					parent.add(adjacent_vertices.getIterator(), x);
					Q.addLast(adjacent_vertices.getIterator());
					adjacent_vertices.advanceIterator();
				}
			}

			
			color.add(x, 'b');

		}
	}

}
