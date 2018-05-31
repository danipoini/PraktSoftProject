

import java.util.ArrayList;

public class Vertex {
	ArrayList<Integer> edges;
	
	public Vertex() {
		edges = new ArrayList<Integer>();
	}
	
	public void addEdge(int i) {
		edges.add(i);
	}
	
	public void removeEdge(int i) {	
		edges.remove(edges.indexOf(i));
	}
	
	public ArrayList<Integer> getEdges(){
		return edges;
	}
	public int getEdge(int i){
		
		return edges.get(i);
	}
}
