package Test;

import static org.junit.jupiter.api.Assumptions.assumingThat;

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

		test.addVertex();
		System.out.println(test.algI(test.getVertex(),1));
	}

}

