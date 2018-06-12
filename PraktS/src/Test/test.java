package Test;

import Figures.*;

public class test {

	public static void main(String[] args) {
/*
		Graph test = new Graph();
		test.addVertex();
		test.addVertex();
		test.addVertex();
		test.addVertex();
		test.addEdges(0,1);
		test.addEdges(1,2);
		test.addEdges(0,3);

		//test.exhaustive(test.getvertices(), 3);
		//test.algXcolors(test.getvertices());
		int[]i=new int[4];
		i=test.algGcolors(test.getvertices());
		System.out.println(i[0]);
		System.out.println(i[1]);
		System.out.println(i[2]);
		System.out.println(i[3]);
*/		
		Graph test = new Graph();
		test.addVertex();
		test.addVertex();
		test.addVertex();
		test.addVertex();
		test.addVertex();
		test.addVertex();
		test.addVertex();
		test.addEdge(0,3);
		test.addEdge(0,2);
		test.addEdge(1,3);
		test.addEdge(4,5);
		test.addEdge(6,5);
		test.addEdge(4,2);
		
		int[]i=new int[7];
		i=test.algBcolors_not_connected(test.getvertices());
		System.out.print(i[0]);
		System.out.print(i[1]);
		System.out.print(i[2]);
		System.out.print(i[3]); 
		System.out.print(i[4]);
		System.out.print(i[5]);
		System.out.print(i[6]);  
		
		


	}

}

