
import java.util.ArrayList;


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
		test.addEdges(0, 2);

		test.exhaustive(test.vertices, 3);
		test.algXcolors(test.vertices);
	}

}

