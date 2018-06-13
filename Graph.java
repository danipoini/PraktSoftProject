import java.awt.Color;
import java.util.ArrayList;

import sun.security.provider.certpath.Vertex;

public class Graph {
	private static ArrayList<Color[]> colors;
	ArrayList<Vertex> vertices;
	
	public Graph() {
		vertices = new ArrayList<Vertex>();
	}
	
	public void displaygraph (int[] colors) {
		
	}
	
	public void addEdges(int i, int j) {
		vertices.get(i).addEdges(j);
		vertices.get(j).addEdges(i);
	}
	
	public void addVertex() {
		vertices.add(new Vertex());
	}
	
	public void removeEdges(int i,int j){
		vertices.get(i).removeEdge(j);
		veritces.get(j).removeEdge(i);
	}
	
	/*
	 * remuve last Vertex
	 */
	public void removeVertex(){
		if(!vertices.isEmpty()) {
			ArrayList<Integer> edges = vertices.get(vertices.size()-1).getEdges();
			edges.forEach((j)->
				{vertices.get(j).removeEdges(i);
			});
		vertices.remove(vertices.size()-1);
		}
	}
	public void addColor(){
		
	}
	public void removeColor(){
		
	}
	public void setColor(){
		
	}
}
