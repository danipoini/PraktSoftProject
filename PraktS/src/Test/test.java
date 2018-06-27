package Test;

import java.util.ArrayList;

import Figures.*;

public class test {

	public static void main(String[] args) {
		Graph test = new Graph();
		for(int i = 0; i< 6;i++) {
			test.addVertex();
		}
		test.addEdge(0, 1);
		test.addEdge(0, 2);
		test.addEdge(0, 3);
		test.addEdge(0, 4);
		test.addEdge(2, 3);

		
		int [] col = test.algM(test.getVertex(), 3);
		int [] col2 = test.algM(test.getVertex(), 2);
		
		for(int i = 0; i< col.length;i++) {
			System.out.println(col[i]);
		}
		System.out.println("-------------");
		for(int i = 0; i < col.length;i++) {
			System.out.println(col2[i]);
		}
	}

}

