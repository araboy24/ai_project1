package ai_project1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class UnifCost
{	
	String startCityS;
	String goalCityS;
	CityUF startCity;
	CityUF goalCity;
	
	
     static CityUF jenin = new CityUF("Jenin");
     static CityUF toulkarem = new CityUF("Toulkarem");
     static CityUF qalqillia = new CityUF("Qalqillia");
     static CityUF salfeit = new CityUF("Salfeit");
     static CityUF ramallah = new CityUF("Ramallah");
     static CityUF jerusalem = new CityUF("Jerusalem");
     static CityUF bethlehem = new CityUF("Bethlehem");
     static CityUF hebron = new CityUF("Hebron");
     static CityUF jericho = new CityUF("Jericho");
     static CityUF nablus = new CityUF("Nablus");
     static CityUF tubas = new CityUF("Tubas");
     static CityUF haifa = new CityUF("Haifa");
     static CityUF jaffa = new CityUF("Jaffa");
     static CityUF gaza = new CityUF("Gaza");
     static CityUF rafah = new CityUF("Rafah");
     static CityUF nazareth = new CityUF("Nazareth");
     static CityUF deirAlbalah = new CityUF("Deir Al Balah"); 
     static CityUF safad = new CityUF("Safad");
     static CityUF ramla = new CityUF("Ramla");	
     static CityUF northGaza = new CityUF("North Gaza");
     static CityUF khanYunis = new CityUF("Khan Yunis");
     
     static CityUF[] cities = {jenin, toulkarem, qalqillia, salfeit, ramallah, jerusalem, bethlehem, 
 			hebron, jericho, nablus, tubas, haifa, jaffa, gaza, rafah, safad, deirAlbalah, northGaza, nazareth, ramla, khanYunis};
     
	
	public UnifCost(String startCityS, String goalCityS) {
		this.startCityS = startCityS;
		this.goalCityS = goalCityS;
		this.startCity = cityStringToObject(startCityS);
		this.goalCity = cityStringToObject(goalCityS);
		
		addAdjacencies();
		
		try {
		computePaths(this.startCity);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		System.out.println("The shortest Distance from " + startCityS + " to " + goalCityS + ": " + this.goalCity.minDistance + " km.");
	    List<CityUF> path = getShortestPathTo(goalCity);
        System.out.println("Path: " + path);
		
		
	}
	
	public CityUF cityStringToObject(String c) {
		for(CityUF city: cities) {
			if(c.equalsIgnoreCase(city.toString())) {
				return city;
			}
		}	
		return null;
	}
	
	public static void computePaths(CityUF source)
    {
        source.minDistance = 0.;
        PriorityQueue<CityUF> vertexQueue = new PriorityQueue<CityUF>();
        vertexQueue.add(source);

        while (!vertexQueue.isEmpty()) {
        	CityUF u = vertexQueue.poll();

            // Visit each edge exiting u
            for (Edge e : u.adjacencies)
            {
            	CityUF v = e.target;
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

    public static List<CityUF> getShortestPathTo(CityUF target)
    {
        List<CityUF> path = new ArrayList<CityUF>();
        for (CityUF vertex = target; vertex != null; vertex = vertex.previous)
            path.add(vertex);

        Collections.reverse(path);
        return path;
    }
	
    public void addAdjacencies() {
    	haifa.adjacencies = new Edge[]{ new Edge(nazareth, 30.39) };
    	nazareth.adjacencies = new Edge[]{ new Edge(jenin,27) };
    	jenin.adjacencies = new Edge[]{ new Edge( toulkarem,52) };
        toulkarem.adjacencies = new Edge[]{ new Edge(tubas, 32) };
      tubas.adjacencies = new Edge[]{};// new Edge(sabastia, 17) }
//        tubas.adjacencies = new Edge[]{ new Edge(sabastia, 17) };
//        sabastia.adjacencies = new Edge[]{ new Edge(nablus, 23) };
        nablus.adjacencies = new Edge[]{ new Edge(salfeit, 16) };
    	salfeit.adjacencies = new Edge[]{ new Edge(ramallah, 18) };
    	ramallah.adjacencies = new Edge[]{ new Edge(jericho, 20) };
    	jericho.adjacencies = new Edge[]{ new Edge(bethlehem, 29) };
//    	bethlehem.adjacencies = new Edge[]{ new Edge(halhoul, 17) };
//    	halhoul.adjacencies = new Edge[]{ new Edge(hebron, 5) };
//    	hebron.adjacencies = new Edge[]{ new Edge(dura, 7) };
//    	dura.adjacencies = new Edge[]{ new Edge(rafah, 48.2) };
    	rafah.adjacencies = new Edge[]{ new Edge(gaza, 33.5) };
    	gaza.adjacencies = new Edge[]{ new Edge(ramla, 76.2) };
    	ramla.adjacencies = new Edge[]{ new Edge(jaffa, 18.3) };
    	jaffa.adjacencies = new Edge[]{ new Edge(haifa, 85.26) };
    	
    }
    
}


class CityUF implements Comparable<CityUF>
{
	
    public final String name;
    public Edge[] adjacencies = {};
    public Edge1[] adjacencies1;
    public double minDistance = Double.POSITIVE_INFINITY;
    public CityUF previous;
    public CityUF(String argName) { name = argName; }
    public String toString() { return name; }
    public int compareTo(CityUF other)
    {
        return Double.compare(minDistance, other.minDistance);
    }

}

class Edge1
{
	
}

class Edge
{
   public final CityUF target;
   public final double weight;
   
   public Edge(CityUF argTarget, double argWeight)
   { 
	   target = argTarget; 
	   weight = argWeight; 
	   }
}