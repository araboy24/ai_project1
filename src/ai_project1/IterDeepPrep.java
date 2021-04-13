package ai_project1;

import java.util.*;

public class IterDeepPrep {

	City a = new City("Ramallah");
	LinkedList<LinkedList<City>> allCities = new LinkedList<LinkedList<City>>();
	LinkedList<City> jeninList = new LinkedList<City>(); 
	LinkedList<City> toulkaremList = new LinkedList<City>();
	LinkedList<City> qalqilliaList = new LinkedList<City>();
	LinkedList<City> salfeitList = new LinkedList<City>();
	LinkedList<City> ramallahList = new LinkedList<City>();
	LinkedList<City> jerusalemList = new LinkedList<City>();
	LinkedList<City> bethlehemList = new LinkedList<City>();
	LinkedList<City> hebronList = new LinkedList<City>();
	LinkedList<City> jerichoList = new LinkedList<City>();
	LinkedList<City> nablusList = new LinkedList<City>();
	LinkedList<City> tubasList = new LinkedList<City>();
	
	//New Cities from Noor
	LinkedList<City> haifaList = new LinkedList<City>();
	LinkedList<City> jaffaList = new LinkedList<City>();
	LinkedList<City> gazaList = new LinkedList<City>();
	LinkedList<City> rafahList = new LinkedList<City>();
	
	//More new cities
	LinkedList<City> safadList = new LinkedList<City>();
	LinkedList<City> deirAlbalahList = new LinkedList<City>();
	LinkedList<City> northGazaList = new LinkedList<City>();
	LinkedList<City> nazarethList = new LinkedList<City>();
	LinkedList<City> ramlaList = new LinkedList<City>();
	LinkedList<City> khanYunisList = new LinkedList<City>();
	
	
	static City jenin = new City("Jenin");
	static City toulkarem = new City("Toulkarem");
	static City qalqillia = new City("Qalqillia");
	static City salfeit = new City("Salfeit");
	static City ramallah = new City("Ramallah");
	static City jerusalem = new City("Jerusalem");
	static City bethlehem = new City("Bethlehem");
	static City hebron = new City("Hebron");
	static City jericho = new City("Jericho");
	static City nablus = new City("Nablus");
	static City tubas = new City("Tubas");
	
	//New Cities N
	static City haifa = new City("Haifa");
	static City jaffa = new City("Jaffa");
	static City gaza = new City("Gaza");
	static City rafah = new City("Rafah");
	
	//New Cities M
	static City safad = new City("Safad");
	static City deirAlbalah = new City("Deir Al Balah");
	static City northGaza = new City("North Gaza");
	static City nazareth = new City("Nazareth");
	static City ramla = new City("Ramla");
	static City khanYunis = new City("Khan Yunis");
	
	static City[] cities = {jenin, toulkarem, qalqillia, salfeit, ramallah, jerusalem, bethlehem, 
			hebron, jericho, nablus, tubas, haifa, jaffa, gaza, rafah, safad, deirAlbalah, northGaza, nazareth, ramla, khanYunis};
	
	String start, end;
	
	public IterDeepPrep(String start, String end){
		this.start = start;
		this.end = end;
		populateLists();
		assignListsToCities();
	}
	
	public void runIterativeDeepening() {
		ItDeepCity idc = new ItDeepCity(cityStringToObject(end));
		idc.runDeepeningSearch(cityStringToObject(start));
	}
	
	public City cityStringToObject(String c) {
		for(City city: cities) {
			if(c.equalsIgnoreCase(city.getCity())) {
				return city;
			}
		}
		return null;
	}
	
	public static City[] getCities() {
		return cities;
	}
	
	public void assignListsToCities() {
		jenin.setAdjacentCities(jeninList);
		toulkarem.setAdjacentCities(toulkaremList);
		qalqillia.setAdjacentCities(qalqilliaList);
		salfeit.setAdjacentCities(salfeitList);
		ramallah.setAdjacentCities(ramallahList);
		jerusalem.setAdjacentCities(jerusalemList);
		bethlehem.setAdjacentCities(bethlehemList);
		hebron.setAdjacentCities(hebronList);
		jericho.setAdjacentCities(jerichoList);
		nablus.setAdjacentCities(nablusList);
		tubas.setAdjacentCities(tubasList);
		
		//Added
		haifa.setAdjacentCities(haifaList);
		jaffa.setAdjacentCities(jaffaList);
		gaza.setAdjacentCities(gazaList);
		rafah.setAdjacentCities(rafahList);
		safad.setAdjacentCities(safadList);
		deirAlbalah.setAdjacentCities(deirAlbalahList);
		northGaza.setAdjacentCities(northGazaList);
		nazareth.setAdjacentCities(nazarethList);
		ramla.setAdjacentCities(ramlaList);
		khanYunis.setAdjacentCities(khanYunisList);
	}
	
	public void populateLists() {
		assignJenin();
		assignToulkarem();
		assignQalqillia();
		assignSalfeit();
		assignRamallah();
		assignJerusalem();
		assignBethlehem();
		assignHebron();
		assignJericho();
		assignNablus();
		assignTubas();
		allCities.add(jeninList);
		allCities.add(toulkaremList);
		allCities.add(qalqilliaList);
		allCities.add(salfeitList);
		allCities.add(ramallahList);
		allCities.add(bethlehemList);
		allCities.add(hebronList);
		allCities.add(jerichoList);
		allCities.add(nablusList);
		allCities.add(hebronList);
		
		//Additions
		assignHaifa();
		assignJaffa();
		assignGaza();
		assignRafah();
		assignSafad();
		assignDeirAlbalah();
		assignNorthGaza();
		assignNazareth();
		assignRamla();
		
	}
	
	public void assignJenin() {
		jeninList.add(toulkarem);
		jeninList.add(tubas);
		jeninList.add(nablus);
		
		//New
		jeninList.add(nazareth);
		jeninList.add(haifa);
	}

	public void assignToulkarem() {
		toulkaremList.add(jenin);
		toulkaremList.add(qalqillia);
		toulkaremList.add(nablus);
		
		//NEW
		jeninList.add(haifa);
		qalqilliaList.add(ramla);
	}
	
	public void assignQalqillia() {
		qalqilliaList.add(toulkarem);
		qalqilliaList.add(salfeit);
		qalqilliaList.add(nablus);
		
		//New
//		qalqilliaList.add(jaffa);
		qalqilliaList.add(ramla);
	}
	
	public void assignSalfeit() {
		salfeitList.add(qalqillia);
		salfeitList.add(nablus);
		salfeitList.add(ramallah);
		
		//NEW
//		salfeitList.add(jaffa);
		salfeitList.add(ramla);
	}
	
	public void assignRamallah() {
		ramallahList.add(salfeit);
		ramallahList.add(nablus);
		ramallahList.add(jericho);
		ramallahList.add(jerusalem);
		
		//New
		ramallahList.add(ramla);
	}
	
	public void assignJerusalem() {
		jerusalemList.add(ramallah);
		jerusalemList.add(jericho);
		jerusalemList.add(bethlehem);
		
		//new
		jerusalemList.add(ramla);
	}
	
	public void assignBethlehem() {
		bethlehemList.add(jerusalem);
		bethlehemList.add(hebron);
	}
	
	public void assignHebron() {
		hebronList.add(bethlehem);
	}
	
	public void assignJericho() {
		jerichoList.add(jerusalem);
		jerichoList.add(nablus);
		jerichoList.add(tubas);
		jerichoList.add(ramallah);
	}
	
	public void assignNablus() {
		nablusList.add(jenin);
		nablusList.add(jericho);
		nablusList.add(tubas);
		nablusList.add(ramallah);
		nablusList.add(salfeit);
		nablusList.add(qalqillia);
		nablusList.add(toulkarem);
	}
	
	public void assignTubas() {
		tubasList.add(jenin);
		tubasList.add(jericho);
		tubasList.add(nablus);	
	} 
	
	
	
	//new functions
	
	public void assignHaifa() {
		haifaList.add(nazareth);
		haifaList.add(toulkarem);
		haifaList.add(jenin);
	}

    public void assignJaffa() {
    	jaffaList.add(nazareth);
    	jaffaList.add(qalqillia);
    	jaffaList.add(salfeit);
    	jaffaList.add(ramla);
    }
    
    public void assignGaza() {
    	gazaList.add(northGaza);
    	gazaList.add(deirAlbalah);
    }
    
    public void assignRafah() {
    	rafahList.add(khanYunis);
    }
    
    public void assignKhanYunis() {
    	khanYunisList.add(rafah);
    	khanYunisList.add(deirAlbalah);
    }
    
    public void assignSafad() {
    	safadList.add(nazareth);
    }
    
    public void assignDeirAlbalah() {
        	deirAlbalahList.add(gaza);
        	deirAlbalahList.add(khanYunis);
    }
    
    public void assignNorthGaza() {
    	northGazaList.add(gaza);
    	northGazaList.add(ramla);
    }
    
	
	public void assignNazareth() {
		nazarethList.add(jaffa);
		nazarethList.add(jenin);
		nazarethList.add(haifa);
		nazarethList.add(safad);
	}
	
	public void assignRamla() {
		ramlaList.add(jerusalem);
		ramlaList.add(jaffa);
		ramlaList.add(ramallah);
		ramlaList.add(toulkarem);
		ramlaList.add(qalqillia);
		ramlaList.add(salfeit);
		ramlaList.add(northGaza);
	}

	
	public static void resetVisited() {
		for (City c : cities) {
			c.setIsVisited(false);
		}
	}
	

}
