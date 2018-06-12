package Figures;

import java.util.ArrayList;

public class Vertex {
	private ArrayList<Integer> edges;
	
	/**
	 * This is the standard constructor for the class Vertex
	 */
	public Vertex() {
		edges = new ArrayList<Integer>();
	}
	
	/**
	 * adds an edge to the Vertex
	 * @param i is the number of the connected Vertex
	 */
	public void addEdge(int i) {
		edges.add(i);
	}
	
	/**
	 * removes a desired edge of this Vertex
	 * @param i is the number which is removed from edges
	 */
	public void removeEdge(int i) {	
		if(edges.contains(i)) {
			edges.remove(edges.indexOf(i));
		}
	}
	
	/**
	 * returns the field edges from this class
	 * @return edges
	 */
	public ArrayList<Integer> getEdges(){
		return edges;
	}
	
	/**
	 * returns an edge at a chosen position if it exists otherwise it returns -1
	 * @param i is the desired position
	 * @return value is the edge at position i or -1 if position does not exist
	 */
	public int getEdge(int i){	
		if(i>edges.size()) {
			return -1;
		}
		return edges.get(i);
	}
	
	/**
	 * decreases every edge by one which is greater than a desired number
	 * @param i is this desired number
	 */
	public void decreaseEdgeElements(int i) {
		for(int j=0;j<edges.size();j++) {
			if(edges.get(j)>i) {
				edges.set(j, edges.get(j)-1);
			}
		}
	}
}
