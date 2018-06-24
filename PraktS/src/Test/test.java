package Test;

import java.util.ArrayList;

import Figures.*;
import UI.MainGUI;

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
		
		ArrayList<Vertex> v = test.createGraph(test.getVertex(), test.getVertex().get(0).getEdges());
		ArrayList<Integer> ed0 = new ArrayList<Integer>();
		ed0.add(1);
		ed0.add(2);
		ed0.add(3);
		
		MainGUI gui =  new MainGUI(test);
		gui.setVisible(true);
		
	}

}

