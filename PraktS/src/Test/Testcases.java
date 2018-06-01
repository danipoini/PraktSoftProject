import static org.junit.jupiter.api.Assertions.*;

import java.util.Vector;

import org.junit.jupiter.api.Test;

class Testcases {

	@Test
	void test_check_vertices_true() {
		Graph test = new Graph();
		
		Vector <Integer>z= new Vector();
		z.add(0);
		z.add(1);
		z.add(7);
		z.add(4);

		
		assertEquals(true,test.checkvertices(z));

	}
	
	@Test
	void test_check_vertices_false() {
		Graph test = new Graph();
		
		Vector <Integer> y= new Vector();
		y.add(0);
		y.add(2);
		y.add(1);
		y.add(0);
				
		assertEquals(false,test.checkvertices(y));
	}
	
	@Test
	void test_check_vertices_one_entry() {
		Graph test = new Graph();
		
		Vector <Integer> x= new Vector();
		x.add(1);

		assertEquals(true,test.checkvertices(x));
	}
	
	@Test
	void test_check_increase_only_last() {
		Graph test = new Graph();
		
		int[] v= new int[4];
		v[0]=1;
		v[1]=2;
		v[2]=2;
		v[3]=1;
		test.increase(v, 2);
		assertEquals(1,v[0]);
		assertEquals(2,v[1]);
		assertEquals(2,v[2]);
		assertEquals(2,v[3]);
	}
	
	@Test
	void test_check_increase_more_then_one() {
		Graph test = new Graph();
		
		int[] v= new int[4];
		v[0]=1;
		v[1]=1;
		v[2]=2;
		v[3]=2;
		test.increase(v, 2);
		assertEquals(1,v[0]);
		assertEquals(2,v[1]);
		assertEquals(1,v[2]);
		assertEquals(1,v[3]);
	}
	
	@Test
	void test_check_increase_first() {
		Graph test = new Graph();
		
		int[] v= new int[4];
		v[0]=1;
		v[1]=2;
		v[2]=2;
		v[3]=2;
		test.increase(v, 2);
		assertEquals(2,v[0]);
		assertEquals(1,v[1]);
		assertEquals(1,v[2]);
		assertEquals(1,v[3]);
	}
	
	@Test
	void test_check_checkincrease_false() {
		Graph test = new Graph();
		
		int[] v= new int[4];
		v[0]=1;
		v[1]=2;
		v[2]=1;
		v[3]=2;
		assertEquals(false,test.checkincrease(v, 2));
	}
	
	@Test
	void test_check_checkincrease_true() {
		Graph test = new Graph();
		
		int[] v= new int[4];
		v[0]=2;
		v[1]=2;
		v[2]=2;
		v[3]=2;
		assertEquals(true,test.checkincrease(v, 2));
	}
	
	@Test
	void test_check_exhaustive_less_colors() {
		Graph test = new Graph();
		test.addVertex();
		test.addVertex();
		test.addVertex();
		test.addVertex();
		test.addEdges(0 , 1);
		test.addEdges(1 , 2);
		test.addEdges(0, 2);
		assertEquals(null,test.exhaustive(test.vertices, 2));
	}

	@Test
	void test_check_exhaustive_enough_colors() {
		Graph test = new Graph();
		test.addVertex();
		test.addVertex();
		test.addVertex();
		test.addVertex();
		test.addEdges(0 , 1);
		test.addEdges(1 , 2);
		test.addEdges(0, 2);
		
		int[] i= new int[4];
		i=test.exhaustive(test.vertices, 3);
		assertEquals(1,i[0]);
		assertEquals(2,i[1]);
		assertEquals(3,i[2]);
		assertEquals(1,i[3]);
	}
	
	@Test
	void test_check_exhaustive_one_color() {
		Graph test = new Graph();
		test.addVertex();
		test.addVertex();
		test.addVertex();
		test.addVertex();

		
		int[] i= new int[4];
		i=test.exhaustive(test.vertices, 1);
		assertEquals(1,i[0]);
		assertEquals(1,i[1]);
		assertEquals(1,i[2]);
		assertEquals(1,i[3]);
	}
	
	@Test
	void test_check_algXcolors() {
		Graph test = new Graph();
		test.addVertex();
		test.addVertex();
		test.addVertex();
		test.addVertex();
		test.addEdges(0 , 1);
		test.addEdges(1 , 2);
		test.addEdges(0, 2);
		
		int[] i= new int[4];
		i=test.algXcolors(test.vertices);
		assertEquals(1,i[0]);
		assertEquals(2,i[1]);
		assertEquals(3,i[2]);
		assertEquals(1,i[3]);
	}
	
	@Test
	void test_find_smaller_neighbours_non_neighbour() {
		Graph test = new Graph();
		test.addVertex();
		test.addVertex();
		test.addVertex();
		test.addVertex();
		test.addEdges(0 , 1);
		test.addEdges(1 , 2);
		test.addEdges(0, 2);
		Vector <Integer>z=new Vector();
		assertEquals(0,test.find_smaller_neighbours(test.vertices, z, 3).size());
	}
	
	@Test
	void test_find_smaller_neighbours_normal_behaviour() {
		Graph test = new Graph();
		test.addVertex();
		test.addVertex();
		test.addVertex();
		test.addVertex();
		test.addEdges(0 , 1);
		test.addEdges(1 , 2);
		test.addEdges(0, 2);
		Vector <Integer>z=new Vector();
		assertEquals(1,test.find_smaller_neighbours(test.vertices, z, 1).size());
		z.clear();
		assertEquals(0,(int)test.find_smaller_neighbours(test.vertices, z, 1).elementAt(0));
	}
	
	@Test
	void test_find_smallest_color_not_first() {
		Graph test = new Graph();
		
		Vector<Integer> z=new Vector();
		z.add(2);
		z.add(4);
		int[] out= new int[5];
		out[2]=2;
		out[4]=1;
		
		assertEquals(3,test.find_smallest_color(z, out));
	}
	
	@Test
	void test_find_smallest_color_in_the_middle() {
		Graph test = new Graph();
		
		Vector<Integer> z=new Vector();
		z.add(2);
		z.add(4);
		int[] out= new int[5];
		out[2]=3;
		out[4]=1;
		
		assertEquals(2,test.find_smallest_color(z, out));
	}
	
	@Test
	void test_find_smallest_color_first() {
		Graph test = new Graph();
		
		Vector<Integer> z=new Vector();
		z.add(2);
		z.add(4);
		int[] out= new int[5];
		out[2]=3;
		out[4]=2;
		
		assertEquals(1,test.find_smallest_color(z, out));
	}
	
	@Test
	void test_find_smallest_color_empty_vector() {
		Graph test = new Graph();
		
		Vector<Integer> z=new Vector();
		int[] out= new int[5];
		
		assertEquals(1,test.find_smallest_color(z, out));
	}
	
	@Test
	void test_algGcolors_normal_behaviour() {
		Graph test = new Graph();
		test.addVertex();
		test.addVertex();
		test.addVertex();
		test.addVertex();
		test.addEdges(0 , 1);
		test.addEdges(1 , 2);
		test.addEdges(0, 3);

		int[]i=new int[4];
		i=test.algGcolors(test.vertices);
		
		assertEquals(1,i[0]);
		assertEquals(2,i[1]);
		assertEquals(1,i[2]);
		assertEquals(2,i[3]);
	}
	
	@Test
	void test_algGcolors_no_edges() {
		Graph test = new Graph();
		test.addVertex();
		test.addVertex();
		test.addVertex();
		test.addVertex();


		int[]i=new int[4];
		i=test.algGcolors(test.vertices);
		
		assertEquals(1,i[0]);
		assertEquals(1,i[1]);
		assertEquals(1,i[2]);
		assertEquals(1,i[3]);
	}
	
	@Test
	void test_algGcolors_all_vertices_connected() {
		Graph test = new Graph();
		test.addVertex();
		test.addVertex();
		test.addVertex();
		test.addVertex();
		test.addEdges(0,1);
		test.addEdges(0,2);
		test.addEdges(0,3);
		test.addEdges(1,2);
		test.addEdges(1,3);
		test.addEdges(2,3);

		int[]i=new int[4];
		i=test.algGcolors(test.vertices);
		
		assertEquals(1,i[0]);
		assertEquals(2,i[1]);
		assertEquals(3,i[2]);
		assertEquals(4,i[3]);
	}

}
