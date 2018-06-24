/**
 * 
 */
package UI;

/**
 * @author Gordon Vidal
 *
 */
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Figures.Graph;
import Figures.Vertex;

import java.util.*;

public class MainGUI extends JFrame {
    private static JPanel mainPanel;
    private static JPanel rightPanel;
    private static JPanel centerPanel;
    private static  JPanel leftPanel;
    private static JPanel bottomPanel;
    
    //default sizes
    final int offsetx = 200, 
    		offsety = 200, 
    		width = 1200,
    		height = 720;
    
    
    public static ArrayList<Color> colors = getContrastingColors(30);
	private static ArrayList<Vertex> vertices;
	
	private static JList vertexList;
	private static JList edgeList;
	
	private static JScrollPane edgeScrollPane;
	private static JScrollPane vertexScrollPane;
	

    public MainGUI(Graph graph) {
    	
   	    
    	vertices = graph.getvertices();
    	vertexList = new JList(vertices.toArray());
    	if(vertices.size() > 0)
    		edgeList = new JList(vertices.get(0).getEdges().toArray());
    	else
    		edgeList = new JList();
        colors = getContrastingColors(Math.max(10, vertices.size()));

    	
    	//main
        mainPanel = new JPanel();
        mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        mainPanel.setLayout(new BorderLayout(0, 0));
        setContentPane(mainPanel);
        setTitle("Graph Plotter and Editor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(offsetx, offsetx, width, height);
        
        
        //center 
        centerPanel = new GraphGUI();
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        centerPanel.setLayout(null);

        //right
        rightPanel = new JPanel();
        rightPanel.setPreferredSize(new Dimension(200,0)); 
        	// BorderLayout Ignores the height dimension of preferredSize for East and West components.
        mainPanel.add(rightPanel, BorderLayout.EAST);
        rightPanel.setBorder(BorderFactory.createTitledBorder("Edge Configurator"));
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

        
        edgeScrollPane = new JScrollPane(edgeList);
        
        edgeScrollPane.setVerticalScrollBarPolicy(
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        edgeScrollPane.setHorizontalScrollBarPolicy(
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        
        rightPanel.add(edgeScrollPane);
        
	        //addEdgeButton
	        JButton btnAddEdge = new JButton("Add Edge");
	        btnAddEdge.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	                // GUI gui = new GUI();
	            	int selectVertex = vertexList.getSelectedIndex();
	            	int edgeChoice = Integer.parseInt(JOptionPane.showInputDialog("Enter vertex to be connected to"));	            	
	            	
	                vertices.get(selectVertex).addEdge(edgeChoice);
	                vertices.get(edgeChoice).addEdge(selectVertex);
	            	
	            	updateEdges(selectVertex);
	            }
	        });
	        rightPanel.add(btnAddEdge);
	        
	      //removeEdgeButton
	        JButton btnDelEdge = new JButton("Remove Edge");
	        btnDelEdge.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	            	
	            if(edgeList.getSelectedValue() == null)	
	            {
	            	JOptionPane.showMessageDialog(mainPanel,
	            		    "Please select an edge to remove.",
	            		    "Removal Error",
	            		    JOptionPane.ERROR_MESSAGE);
	            }else {
	            	int selectVertex = vertexList.getSelectedIndex(),
   	            		selectEdge = (int) edgeList.getSelectedValue();
   	            		
   	                vertices.get(selectVertex).removeEdge(selectEdge);
   	                vertices.get(selectEdge).removeEdge(selectVertex);
   	                
   	                updateEdges(selectVertex);
	            }
	        }});
	        rightPanel.add(btnDelEdge);

        //left
        leftPanel = new JPanel();
        leftPanel.setPreferredSize(new Dimension(200,0)); 
        mainPanel.add(leftPanel, BorderLayout.WEST);
        leftPanel.setBorder(BorderFactory.createTitledBorder("Vertices"));
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

        
        vertexScrollPane = new JScrollPane(vertexList);
        
        vertexScrollPane.setVerticalScrollBarPolicy(
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        vertexScrollPane.setHorizontalScrollBarPolicy(
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        ListSelectionListener vertexSelector = new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
            updateEdges(vertexList.getSelectedIndex()); 
            }
        };
        
        vertexList.setSelectedIndex(0);
        vertexList.addListSelectionListener(vertexSelector);
        vertexList.setCellRenderer(new VertexListRenderer());
        leftPanel.add(vertexScrollPane);

        
    		//Add Vertex Button
	        JButton btnAddVert = new JButton("Add Vertex");
	        btnAddVert.addActionListener(new ActionListener()
	        {
	            @Override
	            public void actionPerformed(ActionEvent evt)
	            {
	            	graph.addVertex();
	            	updateVertices();
	            }
	            
	        });
	        leftPanel.add(btnAddVert);
	        
	        //Remove Vertex Button
	        JButton btnDelVert  = new JButton("Remove Vertex");
	        btnDelVert.addActionListener(new ActionListener()
	        {
	            @Override
	            public void actionPerformed(ActionEvent evt)
	            {
	            	
	            	
	            	int i =  vertexList.getSelectedIndex() ; 
	            	if(i >= 0)
	            	{
	            		graph.removeVertex(i);
		            	updateVertices();
		            	vertexList.setSelectedIndex(i-1);
	            		
	            	}
	            	else{
    	            	JOptionPane.showMessageDialog(mainPanel,
    	            		    "There are no more vertices left to remove.",
    	            		    "Removal Error",
    	            		    JOptionPane.ERROR_MESSAGE);
    	            }
	            }
	        });
	        leftPanel.add(btnDelVert);
	        
      //bottom
        bottomPanel = new JPanel();
        bottomPanel.setBorder(BorderFactory.createTitledBorder("Buttons... hell yeah"));
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        
	        //clearGraphButton
	        JButton btnClrGrph = new JButton("Clear Graph");
	        btnClrGrph.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	            	
	            	clearCenterPanel();
	                
	                
	            }
	        });
	        bottomPanel.add(btnClrGrph);
	        
	        //displayGraphButton
	        JButton btnDsplGrph = new JButton("No color");
	        btnDsplGrph.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	            	updateCenterPanel(new GraphGUI(vertices));
	            	
	            }
	        });
	        bottomPanel.add(btnDsplGrph, BorderLayout.SOUTH);
	        
	        //algGbtn
		    JButton algGbtn = new JButton("Use Alg G");
		    algGbtn.addMouseListener(new MouseAdapter() {
		        @Override
		        public void mouseClicked(MouseEvent e) {
		        	updateCenterPanel(new GraphGUI(vertices, graph.algGcolors(vertices)));
		        	
		        }
		    });
		    bottomPanel.add(algGbtn, BorderLayout.SOUTH);
		    
		  //algXbtn
		    JButton algXbtn = new JButton("Use Alg X");
		    algXbtn.addMouseListener(new MouseAdapter() {
		        @Override
		        public void mouseClicked(MouseEvent e) {
		        	updateCenterPanel(new GraphGUI(vertices, graph.algXcolors(vertices)));
		        	
		        }
		    });
		    bottomPanel.add(algXbtn, BorderLayout.SOUTH);
		    
		  //algMbtn
		    JButton algMbtn = new JButton("Use Alg M with q=10");
		    algMbtn.addMouseListener(new MouseAdapter() {
		        @Override
		        public void mouseClicked(MouseEvent e) {
		        	updateCenterPanel(new GraphGUI(vertices, graph.algM(vertices, 20)));
		        	
		        }
		    });
		    bottomPanel.add(algMbtn, BorderLayout.SOUTH);
	    		
	    }
    
    
	  


	static void updateEdges(int vertexIndex) 
	{
		edgeList = new JList(vertices.get(vertexIndex).getEdges().toArray());;
		edgeList.setSelectedIndex(vertices.get(vertexIndex).getEdges().size()-1);
		edgeScrollPane.setViewportView(edgeList);
	}
	
	static void updateVertices() 
	{
		vertexList = new JList(vertices.toArray());;
        vertexList.setCellRenderer(new VertexListRenderer());
        
        ListSelectionListener vertexSelector = new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
            updateEdges(vertexList.getSelectedIndex()); 
            }
        };
        vertexList.addListSelectionListener(vertexSelector);
        vertexList.setSelectedIndex(vertices.size()-1);
        
        colors = getContrastingColors(Math.max(10, vertices.size()));
        
		vertexScrollPane.setViewportView(vertexList);
	}
	void clearCenterPanel() {
		centerPanel.removeAll();

        mainPanel.remove(centerPanel);
        mainPanel.revalidate();
        mainPanel.repaint();
	}
	void updateCenterPanel(GraphGUI graph){
       
		clearCenterPanel();
		
       centerPanel = graph;
       mainPanel.add(centerPanel, BorderLayout.CENTER);
       
       mainPanel.validate();
       mainPanel.repaint();
        
	}
	
	static ArrayList<Color> getContrastingColors(int amount) {
	    int min = 0x101010,
	    		max = 0xD0D0D0,
	    		step = (max-min)/amount;

	    ArrayList<Color> colors = new ArrayList<Color>(amount);
	    for (int i=0;i<amount;i++) {
	        int colorInt = min+step*i;
	        colors.add(Color.decode("#" + Integer.toHexString(colorInt))); // make color from hex
	    }
	    
	    return colors;
	}
}	
	class VertexListRenderer extends DefaultListCellRenderer 
	{	@Override
		public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
		    String name = "Vertex " + "(" + (index) + ")";
		    return super.getListCellRendererComponent(list, name, index, isSelected, cellHasFocus);
		}
	}
	
	

