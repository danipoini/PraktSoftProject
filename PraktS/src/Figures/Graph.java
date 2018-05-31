

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

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
	/**
	 * exhaustive is a function which trys all possibilities with a fixed number of colors to find a possibility that 
	 * no vertices with the same color are connected 
	 * @param vertices are all vertices of the desired graph
	 * @param i is the maximum number of colours
	 * @return is an int array which contains the color of each vertex
	 */
	public int[] exhaustive(ArrayList<Vertex> vertices,int i) {
		boolean b=false;
		boolean b2=false;
		Vector <Integer> dyn = new Vector();
		int[] z=new int[vertices.size()];
		for(int j=0;j<vertices.size();j++) {
			z[j]=1;                               //ineffizient
		}
		while(b==false && b2==false) {
			b=true;
			for(int l=1;l<=i;l++) {
				for(int m=0;m<vertices.size();m++) {
					if(l==z[m]) {
						for(int k=0;k<vertices.get(m).getEdges().size();k++) {
							dyn.add(vertices.get(m).getEdge(k));
						}
					}					
				}
				if(b==true) {
					b=checkvertices(dyn);
				}
				dyn.clear();
			}
			if(b==true) {
				return z;
			}			
			z=increase(z,i);
			b2=checkincrease(z,i);
		}
		return null;
	}

	/**
	 * it checks whether all possibilities of colors are tried
	 * @param z is the colorarray 
	 * @param i is the maximum number of colors
	 * @return
	 */
	public boolean checkincrease(int[] z, int i) {
		for (int j=0;j<z.length;j++) {
			if(z[j]!=i) {
				return false;
			}
		}
		return true;
	}

	/**
	 * it increases the number which is given as the order of colored graphs
	 * @param z is the actual coloring
	 * @param i is the maximum number of colors
	 * @return is an int array with the next coloring
	 */
	public int[] increase(int[] z, int i) {
		for(int j=1;j<=z.length;j++) {
			if(z[z.length-j]==i) {
				z[z.length-j]=1;
			}
			else {
				z[z.length-j]=z[z.length-j]+1;
				j=z.length;
			}
		}
		return z;
	}

	/**
	 * it checks whether choosen vertices has a connection among this choosen vertices
	 * @param dyn are the choosen vertices
	 * @return is a bool variable which is true if there is no such a connection. otherwise it is false
	 */
	public boolean checkvertices(Vector<Integer> dyn) {
		int[] j= new int[dyn.size()];
		for(int i=0;i<dyn.size();i++) {
			j[i]=dyn.elementAt(i);
		}
		Arrays.sort(j);
		for(int i=0;i<j.length-1;i++) {
			if(j[i]==j[i+1]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * this is a function which trys all possibilities with beginning with one color to find a possibility that 
	 * no vertices with the same color are connected. if it is not possible it increases the number of colors until it finds a solution
	 * @param vertices are all vertices of the desired graph
	 * @return is an int array which contains the color of each vertex
	 */
	public  int[] algXcolors(ArrayList<Vertex> vertices) {
		int i=1;
		while(1>0) {
			if(exhaustive(vertices, i)!=null) {
				return exhaustive(vertices, i);
			}
			i++;
		}
	}
	
	
}

