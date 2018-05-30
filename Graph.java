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
		vertices.get(i).addEdges(j);
		vertices.get(j).addEdges(i);
	}
	
	public void addVertex() {
		vertices.add(new Vertex());
	}
	
	public void removeEdges(int i,int j){

	}
	
	public void removeVertex(int i){
		ArrayList<Integer> edges = vertices.get(i).getEdges();
		edges.forEach((j)->
			{vertices.get(j).removeEdges(i);
		});
		vertices.remove(i);
	}
	public void addColor(){
		
	}
	public void removeColor(){
		
	}
	public void setColor(){
		
	}
}
