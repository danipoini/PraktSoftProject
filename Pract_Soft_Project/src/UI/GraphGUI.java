/**
 * 
 */
package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.*;

import Figures.Vertex;

/**
 * @author Gordon Vidal
 *
 */
public class GraphGUI extends JPanel
{
	//default values, they are meaningless!
	private static int SIZE = 720;
    private int width = SIZE / 2;
    private int height = width;
    private int circleRadius = 4 * SIZE / 5;
    private int n = 0 ;
    
    //initializing the lists
    ArrayList<Integer> edges = new ArrayList<Integer>() ;
    ArrayList<Color> AllColors = MainGUI.colors; 
    List<Integer> colorList= new ArrayList<Integer>() ;
    
    public GraphGUI() {}
    
    public GraphGUI(ArrayList<Vertex> vertices) 
    {
    	n =  vertices.size();
    	edges = new ArrayList<Integer>();
    	colorList = new ArrayList<Integer>();
    	
    	for(int i = 0; i < n; i++)
    	{
    		colorList.add(0);
    		for(int j = 0; j < vertices.get(i).getEdges().size();j++)
    		{
    			edges.add(i);
    			edges.add(vertices.get(i).getEdges().get(j));
    		}
    	}
    	
    }
    
    public GraphGUI(ArrayList<Vertex> vertices, int[] colors) 
    {
    	if(colors == null){
    		JOptionPane.showMessageDialog(this,
        		    "Could not compute the coloring. The graph will be black.",
        		    "Coloring Error",
        		    JOptionPane.ERROR_MESSAGE);
    	}
    		n =  vertices.size();
        	edges = new ArrayList<Integer>();
        	
        	colorList = new ArrayList<Integer>();
        	
        	for(int i = 0; i < n; i++)
        	{
        		if(colors == null){
        			colorList.add(0);
        		}
            	else{
            		colorList.add(colors[i]);
            	}
        		for(int j = 0; j < vertices.get(i).getEdges().size();j++)
        		{
        			edges.add(i);
        			edges.add(vertices.get(i).getEdges().get(j));
        		}
        	}
    	
    	
    }
    
    @Override
    public void paintComponent(Graphics g)
    {    
        super.paintComponent(g);
        width = getWidth() / 2;
        height = getHeight() / 2;
        int min = Math.min(width, height);
        circleRadius = 4 * min / 5;
        int vertexRadius = (int)(Math.abs(min - circleRadius) / 3.25);
        
        //draw vertices
        for (int i = 0; i < n; i++) {

	        g.setColor(AllColors.get(colorList.get(i)));
            double posInCircle = 2 * Math.PI * i / n;
            int x = (int) Math.round(width + circleRadius * Math.cos(posInCircle));
            int y = (int) Math.round(height + circleRadius * Math.sin(posInCircle));
            
            g.fillOval(x - vertexRadius, y - vertexRadius, 2 * vertexRadius, 2 * vertexRadius);
            g.drawString(Integer.toString(i), x-3, y-(int)(vertexRadius*1.4));
        }
        
        //draw edges
        for (int i = 0; i < edges.size(); i=i+2) {
	        g.setColor(Color.BLACK);
	        
            double t1 = 2 * Math.PI * edges.get(i) / n;
            int x1 = (int) Math.round(width + circleRadius * Math.cos(t1));
            int y1 = (int) Math.round(height + circleRadius * Math.sin(t1));
            
            double t2 = 2 * Math.PI * edges.get(i+1) / n;
            int x2 = (int) Math.round(width + circleRadius * Math.cos(t2));
            int y2 = (int) Math.round(height + circleRadius * Math.sin(t2));

            g.drawLine(x1, y1, x2, y2);
        } 
	        
	}
}
