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
	
	 CityUF jenin = new CityUF("Jenin");
	 CityUF toulkarem = new CityUF("Toulkarem");
	 CityUF qalqillia = new CityUF("Qalqillia");
	 CityUF salfeit = new CityUF("Salfeit");
	 CityUF ramallah = new CityUF("Ramallah");
	 CityUF jerusalem = new CityUF("Jerusalem");
	 CityUF bethlehem = new CityUF("Bethlehem");
	 CityUF hebron = new CityUF("Hebron");
	 CityUF jericho = new CityUF("Jericho");
	 CityUF nablus = new CityUF("Nablus");
	 CityUF tubas = new CityUF("Tubas");
	 CityUF haifa = new CityUF("Haifa");
	 CityUF jaffa = new CityUF("Jaffa");
	 CityUF gaza = new CityUF("Gaza");
	 CityUF rafah = new CityUF("Rafah");
	 CityUF nazareth = new CityUF("Nazareth");
	 CityUF deirAlbalah = new CityUF("Deir Al Balah"); 
	 CityUF safad = new CityUF("Safad");
	 CityUF ramla = new CityUF("Ramla");	
	 CityUF northGaza = new CityUF("North Gaza");
	 CityUF khanYunis = new CityUF("Khan Yunis");
	     
	 CityUF[] cities = {jenin, toulkarem, qalqillia, salfeit, ramallah, jerusalem, bethlehem, 
	 			hebron, jericho, nablus, tubas, haifa, jaffa, gaza, rafah, safad, deirAlbalah, northGaza, nazareth, ramla, khanYunis};
	     
	
	public UnifCost(String startCityS, String goalCityS, boolean isDriving) {
		this.startCityS = startCityS;
		this.goalCityS = goalCityS;
		this.startCity = cityStringToObject(startCityS);
		this.goalCity = cityStringToObject(goalCityS);
		
		if(isDriving) {
		addDrivingAdjacencies();
    	} else {
    		addAdjacencies();
    	}
		
		try {
		computePaths(this.startCity);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		System.out.printf("The shortest Distance from " + startCityS + " to " + goalCityS + ": %.2f km.\n", this.goalCity.minDistance);
	    List<CityUF> path = getShortestPathTo(goalCity);
        System.out.println("Path: " + path + "\n");
		
		
	}
	public void initCities() {
		 jenin = new CityUF("Jenin");
		 toulkarem = new CityUF("Toulkarem");
		 qalqillia = new CityUF("Qalqillia");
		 salfeit = new CityUF("Salfeit");
		 ramallah = new CityUF("Ramallah");
		 jerusalem = new CityUF("Jerusalem"); 
		 bethlehem = new CityUF("Bethlehem");
		 hebron = new CityUF("Hebron");
		 jericho = new CityUF("Jericho");
		 nablus = new CityUF("Nablus");
		 tubas = new CityUF("Tubas");
		 haifa = new CityUF("Haifa");
		 jaffa = new CityUF("Jaffa");
		 gaza = new CityUF("Gaza");
		 rafah = new CityUF("Rafah");
		 nazareth = new CityUF("Nazareth");
		 deirAlbalah = new CityUF("Deir Al Balah"); 
		 safad = new CityUF("Safad");
		 ramla = new CityUF("Ramla");	
		 northGaza = new CityUF("North Gaza");
		 khanYunis = new CityUF("Khan Yunis");
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
//    	haifa.adjacencies = new Edge[]{ new Edge(nazareth, 30.39) };
//    	nazareth.adjacencies = new Edge[]{ new Edge(jenin,27) };
//    	jenin.adjacencies = new Edge[]{ new Edge( toulkarem,52) };
//        toulkarem.adjacencies = new Edge[]{ new Edge(tubas, 32) };
//      tubas.adjacencies = new Edge[]{};// new Edge(sabastia, 17) }
////        tubas.adjacencies = new Edge[]{ new Edge(sabastia, 17) };
////        sabastia.adjacencies = new Edge[]{ new Edge(nablus, 23) };
//        nablus.adjacencies = new Edge[]{ new Edge(salfeit, 16) };
//    	salfeit.adjacencies = new Edge[]{ new Edge(ramallah, 18) };
//    	ramallah.adjacencies = new Edge[]{ new Edge(jericho, 20) };
//    	jericho.adjacencies = new Edge[]{ new Edge(bethlehem, 29) };
////    	bethlehem.adjacencies = new Edge[]{ new Edge(halhoul, 17) };
////    	halhoul.adjacencies = new Edge[]{ new Edge(hebron, 5) };
////    	hebron.adjacencies = new Edge[]{ new Edge(dura, 7) };
////    	dura.adjacencies = new Edge[]{ new Edge(rafah, 48.2) };
//    	rafah.adjacencies = new Edge[]{ new Edge(gaza, 33.5) };
//    	gaza.adjacencies = new Edge[]{ new Edge(ramla, 76.2) };
//    	ramla.adjacencies = new Edge[]{ new Edge(jaffa, 18.3) };
//    	jaffa.adjacencies = new Edge[]{ new Edge(haifa, 85.26) };
    	
    	rafah.adjacencies = new Edge[]{ new Edge(khanYunis, 7.71),  new Edge(gaza, 30.79) ,
    			new Edge(deirAlbalah, 17.88) ,  new Edge(northGaza, 35.4) };
    	khanYunis.adjacencies = new Edge[]{ new Edge( deirAlbalah,9.26),  new Edge(northGaza, 27.75) 
    			,new Edge(ramla, 83.89) ,  new Edge(jaffa, 93.42)  };
    	deirAlbalah.adjacencies = new Edge[]{ new Edge( gaza,14.48) , new Edge(northGaza, 27.75),
    			 new Edge(rafah, 30.78)	};
        gaza.adjacencies = new Edge[]{ new Edge(northGaza, 20.05),new Edge(khanYunis, 26.89)
        		,new Edge(jaffa, 85.11) , new Edge(rafah, 30.79) };
        northGaza.adjacencies = new Edge[]{ new Edge(ramla, 56.26) ,new Edge( rafah,37.4)
        		,new Edge(deirAlbalah, 27.75) };
        ramla.adjacencies = new Edge[]{ new Edge(jaffa, 17.20) , new Edge(deirAlbalah,74.87)
        		, new Edge(rafah, 91.62) , new Edge(hebron, 49.38)};
        jaffa.adjacencies = new Edge[]{ new Edge(haifa, 89.21), new Edge( gaza,85.11) 
        		,new Edge(deirAlbalah, 80.28) ,  new Edge(ramla, 17.89) };
        haifa.adjacencies = new Edge[]{ new Edge(safad, 50.29) , new Edge(nazareth, 31.72)
        		,new Edge(jaffa, 89.21) };
        safad.adjacencies = new Edge[]{ new Edge(nazareth, 34.84) ,new Edge(haifa, 48.82)
        		,new Edge(jenin, 58.91) };
        nazareth.adjacencies = new Edge[]{ new Edge(jenin, 26.53) ,new Edge(safad, 34.84) 
        		,new Edge(haifa, 31.72) };
        jenin.adjacencies = new Edge[]{ new Edge(toulkarem, 42.13), new Edge(tubas, 19.72), new Edge(nablus, 72.92),
      			 new Edge(haifa, 62.95)};
        tubas.adjacencies = new Edge[]{ new Edge(toulkarem, 32.10) , new Edge(nablus, 33.72)
        		, new Edge(nazareth, 42.48) ,new Edge(qalqillia, 40.31)  };
    	toulkarem.adjacencies = new Edge[]{ new Edge(qalqillia, 14.78) , new Edge(nablus,40.17)
    			, new Edge(jaffa, 42.83) };
    	qalqillia.adjacencies = new Edge[]{ new Edge(nablus, 35.22) ,new Edge(salfeit, 23.16)
    			,new Edge(haifa, 70.11) , new Edge(jaffa, 25.44)};
    	nablus.adjacencies = new Edge[]{ new Edge(salfeit, 12.02) , new Edge(ramallah,18.84)
    			,new Edge(tubas, 33.72) };
    	salfeit.adjacencies = new Edge[]{ new Edge(jericho, 36.5) ,  new Edge(ramallah, 17.56)
    			, new Edge(toulkarem, 29.11)};
    	jericho.adjacencies = new Edge[]{ new Edge(ramallah, 25.5) ,  new Edge(nablus, 24.81)
    			, new Edge(toulkarem,64.76) , new Edge(jerusalem, 24.96) };
    	ramallah.adjacencies = new Edge[]{ new Edge(jerusalem, 15.04),new Edge(bethlehem, 27.72)
    			,new Edge(ramla,38.95) };
    	jerusalem.adjacencies = new Edge[]{ new Edge(bethlehem, 7.72) , new Edge(ramla,37.61)
    			, new Edge(hebron,28.94)};
    	bethlehem.adjacencies = new Edge[]{ new Edge(hebron, 21.96),  new Edge(rafah, 100.85)
    			,  new Edge(ramla, 40.56),new Edge(ramallah, 27.72) };
    	hebron.adjacencies = new Edge[]{ new Edge(rafah, 83.75) ,new Edge(ramla, 49.83)
    			,  new Edge(jaffa, 68.05)};
    	
    }
    
    public void addDrivingAdjacencies() {
    	jenin.adjacencies = new Edge[]{ 
    			new Edge(toulkarem, 42.13), 
    			new Edge(tubas, 19.72), 
    			new Edge(nablus, 72.92),
    			new Edge(nazareth, 41.12), 
    			new Edge(haifa, 62.95)};
    	
    	toulkarem.adjacencies = new Edge[]{ 
    			new Edge(jenin, 42.13), 
    			new Edge(qalqillia, 16.56), 
    			new Edge(nablus, 72.63),  
    			new Edge(haifa, 73.81), 
    			new Edge(ramla, 58.71) };
    	
    	qalqillia.adjacencies = new Edge[]{ 
    			new Edge(toulkarem, 16.56), 
    			new Edge(salfeit, 42.02), 
    			new Edge(nablus, 60.77),
    			new Edge(ramla, 46.85)   };
    	
    	salfeit.adjacencies = new Edge[]{ 
    			new Edge(qalqillia, 42.02), 
    			new Edge(nablus, 16.06), 
    			new Edge(ramallah, 28.42),
    			new Edge(ramla, 61.25),
    			new Edge(jaffa, 47.43)
    	};
    	
    	ramallah.adjacencies = new Edge[]{ 
    			new Edge(salfeit, 28.42), 
    			new Edge(nablus, 15.29), 
    			new Edge(jericho, 32.12),
    			new Edge(jerusalem, 30.25),
    			new Edge(ramla, 63.59)
    			
    	};

    	jerusalem.adjacencies = new Edge[]{ 
    			new Edge(ramallah, 30.25), 
    			new Edge(jericho, 36.82), 
    			new Edge(bethlehem, 6.97),
    			new Edge(ramla, 46.13),
    	};
    	
    	
    	bethlehem.adjacencies = new Edge[]{ 
    			new Edge(jerusalem, 6.97), 
    			new Edge(hebron, 31.87), 
    			
    	};
    	
    	hebron.adjacencies = new Edge[]{ 
    			new Edge(bethlehem, 31.87), 
    	};
    	

    	
    	jericho.adjacencies = new Edge[] {
    			new Edge(jerusalem, 36.22),
    			new Edge(nablus, 35.12),
    			new Edge(ramallah, 32.2),
    			new Edge(tubas, 82.81),
    	};
    	
    	
    	ramla.adjacencies = new Edge[] {
    			new Edge(jerusalem, 46.13),
    			new Edge(jaffa, 21.69),
    			new Edge(ramallah, 63.59),
    			new Edge(toulkarem, 58.71),
    			new Edge(qalqillia, 46.85),
    			new Edge(salfeit, 61.25),
    			new Edge(northGaza, 65.80),		
    	};
    	
    	nablus.adjacencies = new Edge[] {
    			new Edge(jenin, 72.92),
    			new Edge(jericho, 35.12),
    			new Edge(ramallah, 15.29),
    			new Edge(toulkarem, 72.63),
    			new Edge(qalqillia, 60.77),
    			new Edge(salfeit, 16.06),
    			new Edge(tubas, 62.06),		
    	};
    	
    	tubas.adjacencies = new Edge[] {
    			new Edge(jenin, 19.72),
    			new Edge(jericho, 82.81),
    			new Edge(nablus, 62.06),
    	};
    	
    	haifa.adjacencies = new Edge[] {
    			new Edge(nazareth, 79.26),
    			new Edge(toulkarem, 73.81),
    			new Edge(jenin, 62.95),
    	};
    	
    	jaffa.adjacencies = new Edge[] {
    			new Edge(nazareth, 62.12),
    			new Edge(qalqillia, 22.22),
    			new Edge(salfeit, 47.43),
    			new Edge(ramla, 21.69)
    	};
    	
    	
    	gaza.adjacencies = new Edge[] {
    			new Edge(northGaza, 24.14),
    			new Edge(deirAlbalah, 2.73),
    	};
    	
    	rafah.adjacencies = new Edge[] {
    			new Edge(khanYunis, 11.78),
    	};
    	
    	khanYunis.adjacencies = new Edge[] {
    			new Edge(rafah, 11.78),
    			new Edge(deirAlbalah, 13.14),
    	};
    	
    	safad.adjacencies = new Edge[] {
    			new Edge(nazareth, 62.40),
    	};
    	
    	deirAlbalah.adjacencies = new Edge[] {
    			new Edge(gaza, 2.73),
    			new Edge(khanYunis, 13.14),
    	};
    	
    	northGaza.adjacencies = new Edge[] {
    			new Edge(gaza, 24.14),
    			new Edge(ramla, 65.80),
    	};

    	
    	nazareth.adjacencies = new Edge[] {
    			new Edge(jaffa, 62.12),
    			new Edge(jenin, 41.12),
    			new Edge(haifa, 79.26),
    			new Edge(safad, 62.40),
    	};
    }
    
}


class CityUF implements Comparable<CityUF>
{
	
    public final String name;
    public Edge[] adjacencies = {};
    public double minDistance = Double.POSITIVE_INFINITY;
    public CityUF previous;
    
    public CityUF(String argName) {
    	name = argName; 
    }
    
    public String toString() { 
    	return name; 
    }
    
    public int compareTo(CityUF other)
    {
        return Double.compare(minDistance, other.minDistance);
    }

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