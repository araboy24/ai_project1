import java.util.PriorityQueue;

import javax.swing.JComboBox;

import java.util.List;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Collections;

class city implements Comparable<city>
{
	
    public final String name;
    public Edge[] adjacencies;
    public Edge1[] adjacencies1;
    public double minDistance = Double.POSITIVE_INFINITY;
    public city previous;
    public city(String argName) { name = argName; }
    public String toString() { return name; }
    public int compareTo(city other)
    {
        return Double.compare(minDistance, other.minDistance);
    }

}


class Edge
{
    public final city target;
    public final double weight;
    public Edge(city argTarget, double argWeight)
    { target = argTarget; weight = argWeight; }
}

class Edge1
{
	
}

public class seh
{
    public static void computePaths(city source)
    {
        source.minDistance = 0.;
        PriorityQueue<city> vertexQueue = new PriorityQueue<city>();
        vertexQueue.add(source);

        while (!vertexQueue.isEmpty()) {
            city u = vertexQueue.poll();

            // Visit each edge exiting u
            for (Edge e : u.adjacencies)
            {
                city v = e.target;
                double weight = e.weight;
                double distanceThroughU = u.minDistance + weight;
                if (distanceThroughU < v.minDistance) {
                    vertexQueue.remove(v);

                    v.minDistance = distanceThroughU ;
                    v.previous = u;
                    vertexQueue.add(v);
                }
            }
        }
    }

    public static List<city> getShortestPathTo(city target)
    {
        List<city> path = new ArrayList<city>();
        for (city vertex = target; vertex != null; vertex = vertex.previous)
            path.add(vertex);

        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args)
    {
        

    	city jenin = new city("Jenin");
    	city toulkarem = new city("Toulkarem");
    	city qalqillia = new city("Qalqillia");
    	city salfeit = new city("Salfeit");
    	city ramallah = new city("Ramallah");
    	city jerusalem = new city("Jerusalem");
    	city bethlehem = new city("Bethlehem");
    	city hebron = new city("Hebron");
    	city jericho = new city("Jericho");
    	city nablus = new city("Nablus");
    	city tubas = new city("Tubas");
    	city haifa = new city("Haifa");
    	city yafa = new city("Yafa");
    	city gaza = new city("Gaza");
    	city rafah = new city("Rafah");
    	city nazareth = new city("Nazareth");
    	city halhoul = new city("Halhoul");
    	city dura = new city("Dura");
    	city ramleh = new city("Ramleh");
    	city sabastia = new city("Sabastia");
    	
    	

        // set 
    	haifa.adjacencies = new Edge[]{ new Edge(nazareth, 30.39) };
    	nazareth.adjacencies = new Edge[]{ new Edge(jenin,27) };
    	jenin.adjacencies = new Edge[]{ new Edge( toulkarem,52) };
        toulkarem.adjacencies = new Edge[]{ new Edge(tubas, 32) };
        tubas.adjacencies = new Edge[]{ new Edge(sabastia, 17) };
        sabastia.adjacencies = new Edge[]{ new Edge(nablus, 23) };
        nablus.adjacencies = new Edge[]{ new Edge(salfeit, 16) };
    	salfeit.adjacencies = new Edge[]{ new Edge(ramallah, 18) };
    	ramallah.adjacencies = new Edge[]{ new Edge(jericho, 20) };
    	jericho.adjacencies = new Edge[]{ new Edge(bethlehem, 29) };
    	bethlehem.adjacencies = new Edge[]{ new Edge(halhoul, 17) };
    	halhoul.adjacencies = new Edge[]{ new Edge(hebron, 5) };
    	hebron.adjacencies = new Edge[]{ new Edge(dura, 7) };
    	dura.adjacencies = new Edge[]{ new Edge(rafah, 48.2) };
    	rafah.adjacencies = new Edge[]{ new Edge(gaza, 33.5) };
    	gaza.adjacencies = new Edge[]{ new Edge(ramleh, 76.2) };
    	ramleh.adjacencies = new Edge[]{ new Edge(yafa, 18.3) };
    	yafa.adjacencies = new Edge[]{ new Edge(haifa, 85.26) };
    	


        computePaths(yafa); // run to see the algorthim 
        System.out.println(" shortest Distance to " + nablus + ": " + nablus.minDistance);
        List<city> path = getShortestPathTo(nablus);
        System.out.println("Path: " + path);
    }
   
    
  
   
    	
   
	
}