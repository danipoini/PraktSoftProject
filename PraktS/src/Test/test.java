package Test;

import java.util.ArrayList;

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
		for(int i = 0;i<5;i++) {
			test.addVertex();
		}
		test.addEdge(0,1);
		test.addEdge(0,2);
		test.addEdge(1,2);
		test.addEdge(0,4);
		test.addEdge(4,5);
		
		int[] x = test.algW(test.getvertices(),5);
		int[] y = test.algM(test.getvertices(),3);
		for(int i=0;i<y.length;i++) {
			System.out.println(y[i]);
		}
	}

}

