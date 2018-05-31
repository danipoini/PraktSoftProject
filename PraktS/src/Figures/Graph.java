package Figures;

import java.awt.Color;
import java.util.ArrayList;

public class Graph {
	private static ArrayList<Color[]> colors;
	ArrayList<Vertex> vertices;
	
	public Graph() {
		vertices = new ArrayList<Vertex>();
	}
	
	public void displaygraph (int[] colors) {
		
	}
	
	public void addEdges(int i, int j) {
		vertices.get(i).addEdge(j);
		vertices.get(j).addEdge(i);
	}
	
	public void addVertex() {
		vertices.add(new Vertex());
	}
	
	public void removeEdges(int i,int j){
		vertices.get(i).removeEdge(j);
		vertices.get(j).removeEdge(i);
	}
	
	/*
	 * remove last Vertex
	 */
	public void removeVertex(){
		if(!vertices.isEmpty()) {
			ArrayList<Integer> edges = vertices.get(vertices.size()-1).getEdges();
			edges.forEach((j)->
				{vertices.get(j).removeEdge(vertices.size()-1);
			});
		vertices.remove(vertices.size()-1);
		}
	}
	
	public ArrayList<Vertex> getVertex() {
		return vertices;
	}
	
	public void addColor(){
		
	}
	public void removeColor(){
		
	}
	public void setColor(){
		
	}
}

