//package ai_project1;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class UniformCost
//{
//	String startCityS;
//	String goalCityS;
//	City startCityC;
//	City goalCityC;
//
//	// City jenin = new City("Jenin");
//	// City toulkarem = new City("Toulkarem");
//	// City qalqillia = new City("Qalqillia");
//	// City salfeit = new City("Salfeit");
//	// City ramallah = new City("Ramallah");
//	// City jerusalem = new City("Jerusalem");
//	// City bethlehem = new City("Bethlehem");
//	// City hebron = new City("Hebron");
//	// City jericho = new City("Jericho");
//	// City nablus = new City("Nablus");
//	// City tubas = new City("Tubas");
//	// City haifa = new City("Haifa");
//	// City yafa = new City("Jaffa");
//	// City gaza = new City("Gaza");
//	// City rafah = new City("Rafah");
//	// City nazareth = new City("Nazareth");
//	// City halhoul = new City("Halhoul"); // MAYBE SWAP?
//	// City dura = new City("Dura");	//MAYBE SWAP?
//	// City ramla = new City("ramla");	
//	// City sabastia = new City("Sabastia"); //SWAP
//
//	public UniformCost(String startCityS, String goalCityS){
//		addAdjacencies();
//		this.startCityS = startCityS;
//	}
//
//    public static void computePaths(City source)
//    {
//        source.minDistance = 0.;
//        PriorityQueue<City> vertexQueue = new PriorityQueue<City>();
//        vertexQueue.add(source);
//
//        while (!vertexQueue.isEmpty()) {
//            City u = vertexQueue.poll();
//
//            // Visit each edge exiting u
//            for (Edge e : u.adjacencies)
//            {
//                City v = e.target;
//                double weight = e.weight;
//                double distanceThroughU = u.minDistance + weight;
//                if (distanceThroughU < v.minDistance) {
//                    vertexQueue.remove(v);
//
//                    v.minDistance = distanceThroughU ;
//                    v.previous = u;
//                    vertexQueue.add(v);
//                }
//            }
//        }
//    }
//
//    public static List<City> getShortestPathTo(City target)
//    {
//        List<City> path = new ArrayList<City>();
//        for (City vertex = target; vertex != null; vertex = vertex.previous)
//            path.add(vertex);
//
//        Collections.reverse(path);
//        return path;
//    }
//
//	public static void addAdjacencies(){
//		LinkedListPractice.haifa.adjacencies = new Edge[]{ new Edge(nazareth, 30.39) };
//    	nazareth.adjacencies = new Edge[]{ new Edge(jenin,27) };
//    	jenin.adjacencies = new Edge[]{ new Edge( toulkarem,52) };
//        toulkarem.adjacencies = new Edge[]{ new Edge(tubas, 32) };
//        tubas.adjacencies = new Edge[]{ new Edge(sabastia, 17) };
//        sabastia.adjacencies = new Edge[]{ new Edge(nablus, 23) };
//        nablus.adjacencies = new Edge[]{ new Edge(salfeit, 16) };
//    	salfeit.adjacencies = new Edge[]{ new Edge(ramallah, 18) };
//    	ramallah.adjacencies = new Edge[]{ new Edge(jericho, 20) };
//    	jericho.adjacencies = new Edge[]{ new Edge(bethlehem, 29) };
//    	bethlehem.adjacencies = new Edge[]{ new Edge(halhoul, 17) };
//    	halhoul.adjacencies = new Edge[]{ new Edge(hebron, 5) };
//    	hebron.adjacencies = new Edge[]{ new Edge(dura, 7) };
//    	dura.adjacencies = new Edge[]{ new Edge(rafah, 48.2) };
//    	rafah.adjacencies = new Edge[]{ new Edge(gaza, 33.5) };
//    	gaza.adjacencies = new Edge[]{ new Edge(ramla, 76.2) };
//    	ramla.adjacencies = new Edge[]{ new Edge(yafa, 18.3) };
//    	yafa.adjacencies = new Edge[]{ new Edge(haifa, 85.26) };
//	}
//
//    public static void main(String[] args)
//    {
//        addAdjacencies();
//
//    	// City jenin = new City("Jenin");
//    	// City toulkarem = new City("Toulkarem");
//    	// City qalqillia = new City("Qalqillia");
//    	// City salfeit = new City("Salfeit");
//    	// City ramallah = new City("Ramallah");
//    	// City jerusalem = new City("Jerusalem");
//    	// City bethlehem = new City("Bethlehem");
//    	// City hebron = new City("Hebron");
//    	// City jericho = new City("Jericho");
//    	// City nablus = new City("Nablus");
//    	// City tubas = new City("Tubas");
//    	// City haifa = new City("Haifa");
//    	// City yafa = new City("Jaffa");
//    	// City gaza = new City("Gaza");
//    	// City rafah = new City("Rafah");
//    	// City nazareth = new City("Nazareth");
//    	// City halhoul = new City("Halhoul"); // MAYBE SWAP?
//    	// City dura = new City("Dura");	//MAYBE SWAP?
//    	// City ramla = new City("ramla");	
//    	// City sabastia = new City("Sabastia"); //SWAP
//
//		
//    	
//    	
//
//        // set 
//    	
//    	
//
//
//        computePaths(yafa); // run to see the algorthim 
//        System.out.println(" shortest Distance to " + nablus + ": " + nablus.minDistance);
//        List<City> path = getShortestPathTo(nablus);
//        System.out.println("Path: " + path);
//    }	
//}
//
//
//
//// class City implements Comparable<City>
//// {
//	
////     public final String name;
////     public Edge[] adjacencies;
////     public Edge1[] adjacencies1;
////     public double minDistance = Double.POSITIVE_INFINITY;
////     public City previous;
////     public City(String argName) { name = argName; }
////     public String toString() { return name; }
////     public int compareTo(City other)
////     {
////         return Double.compare(minDistance, other.minDistance);
////     }
//
//// }
//
//
//class Edge
//{
//    public final City target;
//    public final double weight;
//    public Edge(City argTarget, double argWeight)
//    { target = argTarget; weight = argWeight; }
//}
//
