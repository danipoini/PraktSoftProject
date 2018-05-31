package Test;
import java.util.ArrayList;
import Figures.*;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph test = new Graph();
		test.addVertex();
		test.addVertex();
		test.addVertex();
		test.addVertex();
		test.addEdges(0 , 1);
		test.addEdges(1 , 2);
		test.addEdges(1, 3);
		test.removeEdges(1,2);
		ArrayList<Vertex> v = test.getVertex();
		System.out.println(v.get(0).getEdges());
		System.out.println(v.get(1).getEdges());
		System.out.println(v.get(2).getEdges());
		test.removeVertex();
		System.out.println(v.get(1).getEdges());
	}

}
