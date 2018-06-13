package Figures;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;
import static java.lang.Math.sqrt;

public class Graph {
	private static ArrayList<Color[]> colors;
	private static ArrayList<Vertex> vertices;
	
	/**
	 * This is the standard constructor for the class Graph
	 */
	public Graph() {
		vertices = new ArrayList<Vertex>();
		colors= new ArrayList<Color[]>();
	}
	
	/**
	 * This is another constructor which adds a certain number of vertices
	 * @param i is the number of vertices which are added
	 */
	public Graph(int i) {
		vertices = new ArrayList<Vertex>();
		for (int j=0;j<i;j++) {
			addVertex();
		}
		colors= new ArrayList<Color[]>();
	}
	
	/**
	 * returns field vertices of this class
	 * @return vertices
	 */
	public ArrayList<Vertex> getvertices(){
		return vertices;
	}
	
	/**
	 * 
	 * @param colors
	 */
	public void displaygraph (int[] colors) {
		
	}
	
	/**
	 * adds an edge between two different vertices if they exist otherwise it does nothing
	 * @param i is one Vertex
	 * @param j is the other Vertex
	 */
	public void addEdge(int i, int j) {
		if((i<vertices.size()) && (j<vertices.size())) {
			if(i!=j) {
				vertices.get(i).addEdge(j);
				vertices.get(j).addEdge(i);
			}
		}
	}
	
	/**
	 * It adds one Vertex at the end of vertices
	 */
	public void addVertex() {
		vertices.add(new Vertex());
	}
	
	/**
	 * it removes an edge between two different vertices if one exist. otherwise it does nothing
	 * @param i is the first Vertex
	 * @param j is the other Vertex
	 */
	public void removeEdge(int i,int j){
		if((i<vertices.size()) && (j<vertices.size())) {
			if((vertices.get(i).getEdges().contains(j))  && (vertices.get(j).getEdges().contains(i))) {
				vertices.get(i).removeEdge(j);
				vertices.get(j).removeEdge(i);
			}
		}
	}
	
	/**
	 * remove Vertex on desired position
	 * @param i is the desired position
	 */
	public void removeVertex(int j){
		if(j<vertices.size()) {
			vertices.remove(j);
			for(int i=0;i<vertices.size();i++) {
				if(vertices.get(i).getEdges().contains(j)) {
					vertices.get(i).removeEdge(j);;
				}
			}
			for(int i=0;i<vertices.size();i++) {
				vertices.get(i).decreaseEdgeElements(j);
			}
		}
	}
	
	/**
	 * it returns the vertices
	 * @return an arrayList with the vertices
	 */
	public ArrayList<Vertex> getVertex() {
		return vertices;
	}
	
	/**
	 * 
	 */
	public void addColor(){
		
	}
	
	/**
	 * 
	 */
	public void removeColor(){
		
	}
	/**
	 * 
	 */
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
			z[j]=1;                               
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
	
	/**
	 * this function is named greedy vertex coloring. It finds a possibility that no vertices with the same color are connected.
	 * @param vertices are all vertices of the desired graph
	 * @return is an int array which contains the color of each vertex
	 */
	public  int[] algGcolors(ArrayList<Vertex> vertices) {
		int j=0;
		int[] out=new int[vertices.size()];
		Vector <Integer>z=new Vector();
		for (int i=0;i<vertices.size();i++) {
			find_smaller_neighbours(vertices,z, i);
			j=find_smallest_color(z,out);
			out[i]=j;
			z.clear();
		}
		return out;
	}
	
	/**
	 * It finds the smallest color which no connected neighbor has
	 * @param z are the connected neighbours
	 * @param out is the colorarray
	 * @return value of the smallest color
	 */
	public int find_smallest_color(Vector<Integer> z, int[] out) {
		boolean a =true;
		if(z.isEmpty()==true) {
			return 1;
		}
		for(int j=1;;j++) {
			for(int i=0;i<z.size();i++) {
				if(out[z.elementAt(i)]==j) {
					a=false;
				}				
			}
			if(a==true) {
				return j;
			}
			a=true;
		}		
	}

	/**
	 * It stores the set of connected neighbors which are already colored
	 * @param vertices are all vertices of the desired graph
	 * @param z is where it stores this neighbors
	 * @param i is the i-th vertex in vertices from we look for neighbors
	 * @return is the filled parameter z
	 */
	public void find_smaller_neighbours(ArrayList<Vertex> vertices,Vector <Integer> z, int i) {
		for(int j=0;j<vertices.get(i).getEdges().size();j++) {
			if(vertices.get(i).getEdge(j)<i) {
				z.add(vertices.get(i).getEdge(j));
			}
		}
	}
	
	/**
	 * It finds a 2-coloring if it exists otherwise it returns null.
	 * Input must be a connected graph!
	 * @param vertices are all vertices of the desired graph
	 * @return is an int array which contains the color of each vertex if it exists or null if not
	 */
	public  int[] algBcolors(ArrayList<Vertex> vertices) {
		int dyn;
		int[]colors =new int[vertices.size()];
		colors[0]=1;
		Vector <Integer>Q =new Vector();
		int[]parent= new int[vertices.size()];
		parent=add_parents_and_queue(parent,vertices,0,Q,colors);
		
		while(Q.size()!=0) {
			dyn= Q.elementAt(0);
			Q.remove(0);
			colors=bipart_coloring(dyn,colors,parent);
			parent=add_parents_and_queue(parent,vertices,dyn,Q,colors);	
		}
		return verifycoloring(vertices,colors);
	}
	
	/**
	 * It finds a 2-coloring if it exists otherwise it returns null.
	 * Input must not be a connected graph! but could be
	 * @param vertices are all vertices of the desired graph
	 * @return is an int array which contains the color of each vertex if it exists or null if not
	 */
	public  int[] algBcolors_not_connected(ArrayList<Vertex> vertices) {
		int dyn;
		int[]colors =new int[vertices.size()];
		Vector <Integer>Q = new Vector();
		int[]parent= new int[vertices.size()];
		int i=0;

		while(i!=-1) {
			colors[i]=1;
			parent=add_parents_and_queue(parent,vertices,i,Q,colors);
		
			while(Q.size()!=0) {
				dyn= Q.elementAt(0);
				Q.remove(0);
				colors=bipart_coloring(dyn,colors,parent);
				parent=add_parents_and_queue(parent,vertices,dyn,Q,colors);	
			}
			i=find_first_not_colored(colors);
		}
		return verifycoloring(vertices,colors);
	}
	
	/**
	 * Given a 3- chromatic graph G, finds a vertex-
	 * coloring with O(sqrt(n)) colors.
	 * @param vertices
	 * @param n
	 * @return
	 */
	public int[] algW(ArrayList<Vertex> v, int n) {
		int c = 0;
		int sqn = (int) Math.ceil(sqrt(n));
		
		ArrayList<Integer> neil = new ArrayList<Integer>();
		ArrayList<Integer> left = createList(v.size());
		ArrayList<Integer> check = new ArrayList<Integer>();
		ArrayList<Vertex> neiv = new ArrayList<Vertex>();
		
		int[] col = new int[v.size()];
		int i = findVertex(v,left,check,sqn);
		while(i>=0) {
			check.add(i);
			neil = v.get(i).getEdges();
			for(int j:neil) {
				if(left.contains(j)) {
					left.remove(left.indexOf(j));
				}
			}
			neiv = createGraph(v,neil);
			int [] newcol = this.algBcolors_not_connected(neiv);
			col = addColors(col,newcol,neil,c);
			c = c + getMax(newcol);
			neiv.clear();
			i = findVertex(v,left,check,sqn);
		}
		neiv = createGraph(v,left);
		int [] newcol = this.algGcolors(neiv);
		col = addColors(col,newcol,left,c);
		return col;
	}
	
	/**
	 * Algorithm who finds a q coloring for vertices v under the condition that q > 4* x;
	 * x beeing the maximal degree of v
	 * 
	 * slight modification if q < 4*x then it tries to find one using 100000 iterations.
	 * @param v vertices
	 * @param q colors
	 * @return
	 */
	public int[] algM(ArrayList<Vertex> v, int q) {
		int maxDeg = getMaxDegree(v);
		int T = (int) (q*v.size() * (Math.log(2*v.size())/(q- 4* maxDeg)));
		if(T< 0) {
			T = 100000;
		}
		int[] col = new int[v.size()];
		ArrayList<Integer> neib = new ArrayList<Integer>();
		ArrayList<Integer> left = createList(v.size());
		int j; int i = 0;
		int cucol;
		while(left.size() > 0 && i <T) {
			j = (int)(Math.random()*left.size());
			cucol = (int)(Math.random()*q);
			neib = v.get(left.get(j)).getEdges();
			Boolean isused = true;
			for(int u:neib) {
				if(col[u] == cucol) {
					isused = false;
				}
			}
			if(isused) {
				col[left.get(j)] = cucol;
				left.remove(j);
			}
			i++;
		}
		if(left.size()==0) {
			return col;
		}
		else return null;
	}
	
	/**
	 * Determines whether a graph can be q colored
	 * @return
	 */
	public Boolean algI(ArrayList<Vertex> v, int q) {
		return false;
	}
	
	public int getMaxDegree(ArrayList<Vertex> v) {
		int max = v.get(0).getEdges().size();
		for(int i = 1; i<v.size();i++ ) {
			if(v.get(0).getEdges().size()>max) {
				max = v.get(0).getEdges().size();
			}
		}
		return max;
	}
	
	
	/**
	 * creates a graph out of the vertices v and the list n
	 * @param v
	 * @param n
	 * @return
	 */
	public ArrayList<Vertex> createGraph(ArrayList<Vertex> v, ArrayList<Integer> n){
		Vertex[] newver = new Vertex[n.size()];
		ArrayList<Integer> edges = new ArrayList<Integer>();
		int u = 0;
		for(int i:n) {
			newver[u] = new Vertex();
			edges = v.get(i).getEdges();
			Integer[] ed = edges.toArray(new Integer[0]);
			for(int j:ed) {
				int x = n.indexOf(j);
				if(x >= 0) {
					newver[u].addEdge(x);
				}
			}
			u++;
		}
		ArrayList<Vertex> r = new ArrayList<Vertex>(Arrays.asList(newver));
		return r;
	}
	
	/**
	 * retruns the maximum of an list
	 * @param a
	 * @return
	 */
	public int getMax(int[] a) {
		int max = a[0];
		for(int i= 1;i< a.length;i++) {
			if(a[i]>max) {
				max=a[i];
			}
		}
		return max;
	}
	
	public int[] addColors(int[] col,int [] newcol, ArrayList<Integer> neil,int c) {
		int j = 0;
		for(int i:neil) {
			col[i] = newcol[j] + c;
			j++;
		}
		return col;
	}
	
	public ArrayList<Integer> createList(int n){
		ArrayList<Integer> l = new ArrayList<Integer>();
		for(int i= 0;i< n;i++) {
			l.add(i);
		}
		return l;
	}
	
	public int findVertex(ArrayList<Vertex> v,ArrayList<Integer> leaft ,ArrayList<Integer> c,int sqn) {
		for(int i:leaft) {
			if(v.get(i).getEdges().size()>=sqn && !c.contains(i)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * it looks for the first vertex in an array which is not colored
	 * @param colors are the colors of the vertices
	 * @return value is the position in the array. or -1 if all vertices are already colored
	 */
	public int find_first_not_colored(int[] colors) {
		for(int i=0;i<colors.length;i++) {
			if(colors[i]==0) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * it checks whether connected vertices does not have the same color
	 * @param vertices are all vertices of the desired graph
	 * @param colors are the colors of the vertices
	 * @return is parameter colors if the coloring is correct. otherwise it is null
	 */
	public int[] verifycoloring(ArrayList<Vertex> vertices, int[] colors) {
		for(int i=0;i<vertices.size();i++) {
			for(int j=0;j<vertices.get(i).getEdges().size();j++) {
				if(colors[i]==colors[vertices.get(i).getEdge(j)]) {
					return null;
				}
			}
		}
		return colors;
	}

	/**
	 * Calculation to get a vertex at one position colored for algB
	 * @param dyn is the position of the vertex we want to color
	 * @param colors are the colors of the vertices
	 * @param parent is an array of vertices which are connected with the vertex at position dyn,
	 * are not colored yet and are not on a queue which is used in algB
	 * @return value is the array with the colored vertices
	 */
	public int[] bipart_coloring(int dyn, int[] colors, int[] parent) {
		colors[dyn]=3-colors[parent[dyn]];
		return colors;
	}

	/**
	 * this function calculates parent relations and may add something to queue
	 * @param parent is an array of vertices which are connected with the vertex at position dyn,
	 * are not colored yet and are not on a queue which is used in algB
	 * @param vertices are all vertices of the desired graph
	 * @param dyn is the position of the vertex we need the connected neighbors
	 * @param Q is a specific queue which contains int values
	 * @param colors are the colors of the vertices
	 * @return value is the changed parent array
	 */
	public int[] add_parents_and_queue(int[] parent, ArrayList<Vertex> vertices, int dyn, Vector<Integer> Q, int[] colors) {
		for(int i=0;i<vertices.get(dyn).getEdges().size();i++) {
			if(colors[vertices.get(dyn).getEdge(i)]==0) {
				if(Q.contains(vertices.get(dyn).getEdge(i))!=true) {
					parent[vertices.get(dyn).getEdge(i)]=dyn;
					Q.add(vertices.get(dyn).getEdge(i));
				}
			}
		}
		return parent;
	}
	
}

