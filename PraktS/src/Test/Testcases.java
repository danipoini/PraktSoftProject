package Test;

import Figures.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Vector;

import org.junit.jupiter.api.Test;

class Testcases {
	
	@Test
	void test_constructor() {
		Graph test = new Graph(3);
		
		assertEquals(3,test.getvertices().size());
		assertEquals(0,test.getvertices().get(0).getEdges().size());
		assertEquals(0,test.getvertices().get(1).getEdges().size());
		assertEquals(0,test.getvertices().get(2).getEdges().size());
	}
	
	@Test
	void test_getvertices() {
		Graph test = new Graph();
		test.addVertex();
		test.addVertex();		
		assertEquals(2,(int)test.getvertices().size());
	}
	
	@Test
	void test_getvertices_zero() {
		Graph test = new Graph();		
		assertEquals(0,(int)test.getvertices().size());
	}
	
	@Test
	void test_addEdge_correct_input() {
		Graph test = new Graph();
		test.addVertex();
		test.addVertex();

		test.addEdge(0 , 1);

		assertEquals(1,test.getvertices().get(0).getEdges().size());
		assertEquals(1,test.getvertices().get(0).getEdge(0));
		assertEquals(1,test.getvertices().get(1).getEdges().size());
		assertEquals(0,test.getvertices().get(1).getEdge(0));
	}
	
	@Test
	void test_addEdge_incorrect_input_vertex_not_existent() {
		Graph test = new Graph();
		test.addVertex();
		test.addVertex();

		test.addEdge(0 , 4);

		assertEquals(0,test.getvertices().get(0).getEdges().size());
		assertEquals(0,test.getvertices().get(1).getEdges().size());
	}
	
	@Test
	void test_addEdge_incorrect_input_edge_to_itself() {
		Graph test = new Graph();
		test.addVertex();
		test.addVertex();

		test.addEdge(0,0);

		assertEquals(0,test.getvertices().get(0).getEdges().size());
		assertEquals(0,test.getvertices().get(1).getEdges().size());
	}
	
	@Test
	void test_addVertex() {
		Graph test = new Graph();
		test.addVertex();
		
		assertEquals(0,test.getvertices().get(0).getEdges().size());
		assertEquals(1,test.getvertices().size());
	}
	
	@Test
	void test_removeEdge_korrect_input() {
		Graph test = new Graph();
		test.addVertex();
		test.addVertex();
		test.addVertex();

		test.addEdge(0,1);
		test.addEdge(0,2);
		
		test.removeEdge(0, 1);
		
		assertEquals(1,test.getvertices().get(0).getEdges().size());
		assertEquals(2,test.getvertices().get(0).getEdge(0));
		assertEquals(0,test.getvertices().get(1).getEdges().size());
		assertEquals(1,test.getvertices().get(2).getEdges().size());
		assertEquals(0,test.getvertices().get(2).getEdge(0));
	}
	
	@Test
	void test_removeEdge_edge_does_not_exist() {
		Graph test = new Graph();
		test.addVertex();
		test.addVertex();

		test.removeEdge(0,1);
		
		assertEquals(0,test.getvertices().get(0).getEdges().size());
		assertEquals(0,test.getvertices().get(1).getEdges().size());
	}
	
	@Test
	void test_removeEdge_same_edge() {
		Graph test = new Graph();
		test.addVertex();
		test.addVertex();
		test.addVertex();
		
		test.addEdge(0,1);
		test.addEdge(0,2);

		test.removeEdge(0, 0);
		
		assertEquals(2,test.getvertices().get(0).getEdges().size());
		assertTrue(test.getvertices().get(0).getEdges().contains(1));
		assertTrue(test.getvertices().get(0).getEdges().contains(2));
		assertEquals(1,test.getvertices().get(1).getEdges().size());
		assertEquals(0,test.getvertices().get(1).getEdge(0));
		assertEquals(1,test.getvertices().get(2).getEdges().size());
		assertEquals(0,test.getvertices().get(2).getEdge(0));
	}
	
	@Test
	void test_removeEdge_Vertex_correct_input() {
		Graph test = new Graph();
		test.addVertex();
		test.addVertex();
		test.addVertex();
		test.addVertex();
		
		test.addEdge(0,1);
		test.addEdge(0,2);
		test.addEdge(1,2);
		test.addEdge(3,0);
		test.addEdge(3,1);


		test.removeVertex(1);
		
		assertEquals(2,test.getvertices().get(0).getEdges().size());
		assertEquals(1,test.getvertices().get(1).getEdges().size());
		assertEquals(1,test.getvertices().get(2).getEdges().size());
		assertTrue(test.getvertices().get(0).getEdges().contains(2));
		assertTrue(test.getvertices().get(0).getEdges().contains(1));
		assertTrue(test.getvertices().get(1).getEdges().contains(0));
		assertTrue(test.getvertices().get(2).getEdges().contains(0));
	}
	
	@Test
	void test_removeEdge_Vertex_incorrect_input_vertex_not_existent() {
		Graph test = new Graph();
		test.addVertex();
		test.addVertex();
		test.addVertex();
		test.addVertex();
		
		test.addEdge(0,1);
		test.addEdge(0,2);
		test.addEdge(1,2);
		test.addEdge(3,0);
		test.addEdge(3,1);


		test.removeVertex(5);
		
		assertEquals(3,test.getvertices().get(0).getEdges().size());
		assertEquals(3,test.getvertices().get(1).getEdges().size());
		assertEquals(2,test.getvertices().get(2).getEdges().size());
		assertEquals(2,test.getvertices().get(3).getEdges().size());
		assertTrue(test.getvertices().get(0).getEdges().contains(3));
		assertTrue(test.getvertices().get(0).getEdges().contains(2));
		assertTrue(test.getvertices().get(0).getEdges().contains(1));
		assertTrue(test.getvertices().get(1).getEdges().contains(0));
		assertTrue(test.getvertices().get(1).getEdges().contains(2));
		assertTrue(test.getvertices().get(1).getEdges().contains(3));
		assertTrue(test.getvertices().get(2).getEdges().contains(0));
		assertTrue(test.getvertices().get(2).getEdges().contains(1));
		assertTrue(test.getvertices().get(3).getEdges().contains(0));
		assertTrue(test.getvertices().get(3).getEdges().contains(1));
	}
	
	@Test
	void test_check_getvertices_true() {
		Graph test = new Graph();
		
		Vector <Integer>z= new Vector();
		z.add(0);
		z.add(1);
		z.add(7);
		z.add(4);
		
		assertEquals(true,test.checkvertices(z));
	}
	
	@Test
	void test_check_getvertices_false() {
		Graph test = new Graph();
		
		Vector <Integer> y= new Vector();
		y.add(0);
		y.add(2);
		y.add(1);
		y.add(0);
				
		assertEquals(false,test.checkvertices(y));
	}
	
	@Test
	void test_check_getvertices_one_entry() {
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
		test.addEdge(0,1);
		test.addEdge(1,2);
		test.addEdge(0,2);
		assertEquals(null,test.exhaustive(test.getvertices(), 2));
	}

	@Test
	void test_check_exhaustive_enough_colors() {
		Graph test = new Graph();
		test.addVertex();
		test.addVertex();
		test.addVertex();
		test.addVertex();
		test.addEdge(0 , 1);
		test.addEdge(1 , 2);
		test.addEdge(0, 2);
		
		int[] i= new int[4];
		i=test.exhaustive(test.getvertices(), 3);
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
		i=test.exhaustive(test.getvertices(), 1);
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
		test.addEdge(0 , 1);
		test.addEdge(1 , 2);
		test.addEdge(0, 2);
		
		int[] i= new int[4];
		i=test.algXcolors(test.getvertices());
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
		test.addEdge(0 , 1);
		test.addEdge(1 , 2);
		test.addEdge(0, 2);
		Vector <Integer>z=new Vector();
		test.find_smaller_neighbours(test.getvertices(), z, 3);
		assertEquals(0,z.size());
	}
	
	@Test
	void test_find_smaller_neighbours_normal_behaviour() {
		Graph test = new Graph();
		test.addVertex();
		test.addVertex();
		test.addVertex();
		test.addVertex();
		test.addEdge(0 , 1);
		test.addEdge(1 , 2);
		test.addEdge(0, 2);
		Vector <Integer>z=new Vector();
		test.find_smaller_neighbours(test.getvertices(), z, 1);
		assertEquals(1,z.size());
		assertEquals(0,(int)z.elementAt(0));
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
		test.addEdge(0 , 1);
		test.addEdge(1 , 2);
		test.addEdge(0, 3);

		int[]i=new int[4];
		i=test.algGcolors(test.getvertices());
		
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
		i=test.algGcolors(test.getvertices());
		
		assertEquals(1,i[0]);
		assertEquals(1,i[1]);
		assertEquals(1,i[2]);
		assertEquals(1,i[3]);
	}
	
	@Test
	void test_algGcolors_all_getvertices_connected() {
		Graph test = new Graph();
		test.addVertex();
		test.addVertex();
		test.addVertex();
		test.addVertex();
		test.addEdge(0,1);
		test.addEdge(0,2);
		test.addEdge(0,3);
		test.addEdge(1,2);
		test.addEdge(1,3);
		test.addEdge(2,3);

		int[]i=new int[4];
		i=test.algGcolors(test.getvertices());
		
		assertEquals(1,i[0]);
		assertEquals(2,i[1]);
		assertEquals(3,i[2]);
		assertEquals(4,i[3]);
	}
	
	@Test
	void test_find_first_not_colored_pos_0() {
		Graph test = new Graph();
		int [] colors= {0,0,4,6,2,0,0};
		assertEquals(0,test.find_first_not_colored(colors));
	}
	
	@Test
	void test_find_first_not_colored_middle_pos() {
		Graph test = new Graph();
		int [] colors= {1,6,4,0,2,0,1};
		assertEquals(3,test.find_first_not_colored(colors));
	}
	
	@Test
	void test_find_first_not_colored_last_pos() {
		Graph test = new Graph();
		int [] colors= {1,6,4,2,2,3,0};
		assertEquals(6,test.find_first_not_colored(colors));
	}
	
	@Test
	void test_find_first_not_colored_none() {
		Graph test = new Graph();
		int [] colors= {1,6,4,2,2,3,5};
		assertEquals(-1,test.find_first_not_colored(colors));
	}
	
	@Test
	void test_verify_two_coloring_corr_input() {
		Graph test = new Graph();
		test.addVertex();
		test.addVertex();
		test.addVertex();
		test.addVertex();
		test.addEdge(0,1);
		test.addEdge(0,2);
		test.addEdge(0,3);
		test.addEdge(1,2);
		test.addEdge(1,3);
		int [] colors= {1,2,3,3};
		assertEquals(colors,test.verifycoloring(test.getvertices(), colors));
	}
	
	@Test
	void test_verify_two_coloring_false_input() {
		Graph test = new Graph();
		test.addVertex();
		test.addVertex();
		test.addVertex();
		test.addVertex();
		test.addEdge(0,1);
		test.addEdge(0,2);
		test.addEdge(0,3);
		test.addEdge(1,2);
		test.addEdge(1,3);
		int [] colors= {1,2,1,3};
		assertEquals(null,test.verifycoloring(test.getvertices(), colors));
	}
	
	@Test
	void test_bipart_coloring() {
		Graph test = new Graph();
		int[] parent = {1,1,0,1,2};
		int[] colors = {1,0,0,2,1};
		colors=test.bipart_coloring(2, colors, parent);
		assertEquals(1,colors[0]);
		assertEquals(0,colors[1]);
		assertEquals(2,colors[2]);
		assertEquals(2,colors[3]);
		assertEquals(1,colors[4]);
	}
	
	@Test
	void test_add_parents_and_queue_not_colored_not_queue() {
		Graph test = new Graph();
		test.addVertex();
		test.addVertex();
		test.addVertex();
		test.addEdge(0,1);
		test.addEdge(1,2);
		int [] colors= {1,0,2};
		int [] parent= {1,0,1};
		Vector<Integer> Q= new Vector();
		Q.add(2);
		parent=test.add_parents_and_queue(parent, test.getvertices(), 2, Q, colors);
		assertEquals(1,parent[0]);
		assertEquals(2,parent[1]);
		assertEquals(1,parent[2]);
		assertEquals(2,Q.size());
		assertEquals(2,(int)Q.elementAt(0));
		assertEquals(1,(int)Q.elementAt(1));
	}
	
	@Test
	void test_add_parents_and_queue_not_colored_but_on_queue() {
		Graph test = new Graph();
		test.addVertex();
		test.addVertex();
		test.addVertex();
		test.addEdge(0,1);
		test.addEdge(1,2);
		int [] colors= {1,0,2};
		int [] parent= {1,0,1};
		Vector<Integer> Q= new Vector();
		Q.add(1);
		parent=test.add_parents_and_queue(parent, test.getvertices(), 2, Q, colors);
		assertEquals(1,parent[0]);
		assertEquals(0,parent[1]);
		assertEquals(1,parent[2]);
		assertEquals(1,Q.size());
		assertEquals(1,(int)Q.elementAt(0));
	}
	
	@Test
	void test_add_parents_and_queue_colored_not_on_queue() {
		Graph test = new Graph();
		test.addVertex();
		test.addVertex();
		test.addVertex();
		test.addEdge(0,1);
		test.addEdge(1,2);
		int [] colors= {0,1,2};
		int [] parent= {1,0,1};
		Vector<Integer> Q= new Vector();
		Q.add(2);
		parent=test.add_parents_and_queue(parent, test.getvertices(), 2, Q, colors);
		assertEquals(1,parent[0]);
		assertEquals(0,parent[1]);
		assertEquals(1,parent[2]);
		assertEquals(1,Q.size());
		assertEquals(2,(int)Q.elementAt(0));
	}
	
	@Test
	void test_add_parents_and_queue_no_neighbors() {
		Graph test = new Graph();
		test.addVertex();
		test.addVertex();
		test.addVertex();
		test.addVertex();
		test.addEdge(0,1);
		test.addEdge(1,3);
		int [] colors= {0,1,2,0};
		int [] parent= {1,0,1,0};
		Vector<Integer> Q= new Vector();
		Q.add(2);
		parent=test.add_parents_and_queue(parent, test.getvertices(), 2, Q, colors);
		assertEquals(1,parent[0]);
		assertEquals(0,parent[1]);
		assertEquals(1,parent[2]);
		assertEquals(0,parent[3]);
		assertEquals(1,Q.size());
		assertEquals(2,(int)Q.elementAt(0));
	}
	
	@Test
	void test_algBcolors_existing_2_coloring() {
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
		i=test.algBcolors(test.getvertices());
		assertEquals(1,i[0]);
		assertEquals(1,i[1]);
		assertEquals(2,i[2]);
		assertEquals(2,i[3]);
		assertEquals(1,i[4]);
		assertEquals(2,i[5]);
		assertEquals(1,i[6]);
	}
	
	@Test
	void test_algBcolors_non_existing_2_coloring() {
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
		test.addEdge(1,4);
		test.addEdge(1,5);
		test.addEdge(4,5);
		test.addEdge(6,5);
		test.addEdge(4,2);
		
		int[]i=new int[7];
		i=test.algBcolors(test.getvertices());
		assertEquals(null,i);
	}
	
	@Test
	void test_algBcolors_not_connected_existing_2_coloring() {
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
		assertEquals(1,i[0]);
		assertEquals(1,i[1]);
		assertEquals(2,i[2]);
		assertEquals(2,i[3]);
		assertEquals(1,i[4]);
		assertEquals(2,i[5]);
		assertEquals(1,i[6]);
	}
	
	@Test
	void test_algBcolors_not_connected_non_existing_2_coloring() {
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
		test.addEdge(1,4);
		test.addEdge(1,5);
		test.addEdge(4,5);
		test.addEdge(6,5);
		test.addEdge(4,2);
		
		int[]i=new int[7];
		i=test.algBcolors_not_connected(test.getvertices());
		assertEquals(null,i);
	}
	
	@Test
	void test_algBcolors_not_connected_existing_2_coloring_real_not_connected() {
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
		
		int[]i=new int[7];
		i=test.algBcolors_not_connected(test.getvertices());
		assertEquals(1,i[0]);
		assertEquals(1,i[1]);
		assertEquals(2,i[2]);
		assertEquals(2,i[3]);
		assertEquals(1,i[4]);
		assertEquals(2,i[5]);
		assertEquals(1,i[6]);
	}
	
	@Test
	void test_addEdge() {
		Vertex test = new Vertex();
		test.addEdge(3);
		assertEquals(3,(int)test.getEdges().get(0));
		assertEquals(1,(int)test.getEdges().size());
	}
	
	@Test
	void test_removeEdge_edge_exists() {
		Vertex test = new Vertex();
		test.addEdge(3);
		test.addEdge(7);
		test.addEdge(2);
		test.removeEdge(7);
		assertEquals(3,(int)test.getEdges().get(0));
		assertEquals(2,(int)test.getEdges().get(1));
		assertEquals(2,(int)test.getEdges().size());
	}
	
	@Test
	void test_removeEdge_edge_not_exists() {
		Vertex test = new Vertex();
		test.addEdge(3);
		test.addEdge(7);
		test.addEdge(2);
		test.removeEdge(6);
		assertEquals(3,(int)test.getEdges().get(0));
		assertEquals(7,(int)test.getEdges().get(1));
		assertEquals(2,(int)test.getEdges().get(2));
		assertEquals(3,(int)test.getEdges().size());
	}
	
	@Test
	void test_getEdges() {
		Vertex test = new Vertex();
		test.addEdge(3);
		test.addEdge(7);
		test.addEdge(2);
		assertEquals(3,(int)test.getEdges().size());
		assertEquals(3,(int)test.getEdges().get(0));
		assertEquals(7,(int)test.getEdges().get(1));
		assertEquals(2,(int)test.getEdges().get(2));
	}
	
	@Test
	void test_getEdges_zero() {
		Vertex test = new Vertex();
		assertEquals(0,(int)test.getEdges().size());
	}
	
	@Test
	void test_getEdge() {
		Vertex test = new Vertex();
		test.addEdge(3);
		test.addEdge(7);
		test.addEdge(2);
		assertEquals(7,(int)test.getEdge(1));
	}
	
	@Test
	void test_getEdge_not_existent() {
		Vertex test = new Vertex();
		test.addEdge(3);
		test.addEdge(7);
		test.addEdge(2);
		assertEquals(-1,(int)test.getEdge(4));
	}
	
	@Test
	void test_decreaseEdgeElements() {
		Vertex test = new Vertex();
		test.addEdge(3);
		test.addEdge(7);
		test.addEdge(2);
		test.decreaseEdgeElements(4);
		assertEquals(3,(int)test.getEdge(0));
		assertEquals(6,(int)test.getEdge(1));
		assertEquals(2,(int)test.getEdge(2));
	}
	
	@Test
	void test_decreaseEdgeElements_no_elements() {
		Vertex test = new Vertex();
		test.decreaseEdgeElements(4);
		assertEquals(0,(int)test.getEdges().size());
	}
}

