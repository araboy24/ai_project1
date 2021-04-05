package ai_project1;

import java.util.*;

class LinkedListPractice {

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
	
	
	City jenin = new City("Jenin");
	City toulkarem = new City("Toulkarem");
	City qalqillia = new City("Qalqillia");
	City salfeit = new City("Salfeit");
	City ramallah = new City("Ramallah");
	City jerusalem = new City("Jerusalem");
	City bethlehem = new City("Bethlehem");
	City hebron = new City("Hebron");
	City jericho = new City("Jericho");
	City nablus = new City("Nablus");
	City tubas = new City("Tubas");
//	City jenin = new City("Jenin");
	
	public LinkedListPractice(){
		
		populateLists();
		assignListsToCities();
		System.out.println(ramallah.getAdjacentCities());
		ItDeepCity idc = new ItDeepCity(salfeit);
		idc.runDeepeningSearch(jerusalem);
	
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
	}
	
	public void assignJenin() {
		jeninList.add(toulkarem);
		jeninList.add(tubas);
		jeninList.add(nablus);
	}

	public void assignToulkarem() {
		toulkaremList.add(jenin);
		toulkaremList.add(qalqillia);
		toulkaremList.add(nablus);
	}
	
	public void assignQalqillia() {
		qalqilliaList.add(toulkarem);
		qalqilliaList.add(salfeit);
		qalqilliaList.add(nablus);
	}
	
	public void assignSalfeit() {
		salfeitList.add(qalqillia);
		salfeitList.add(nablus);
		salfeitList.add(ramallah);
	}
	
	public void assignRamallah() {
		ramallahList.add(salfeit);
		ramallahList.add(nablus);
		ramallahList.add(jericho);
		ramallahList.add(jerusalem);
	}
	
	public void assignJerusalem() {
		jerusalemList.add(ramallah);
		jerusalemList.add(jericho);
		jerusalemList.add(bethlehem);
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
	

}
