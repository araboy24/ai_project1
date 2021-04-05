package ai_project1;

import java.util.*;
import java.util.List;

public class City
{

	private String cityName;
	private int depthLevel = 0;
//	private List<Node> adjacentNodes;
	private List<City> adjacentCities;
	
	
	
	public City(String cityName) {
		this.cityName = cityName;
		this.adjacentCities = new ArrayList<>();
	}
	
	public String toString() {
		return this.cityName;
	}
	
	public void setAdjacentCities(LinkedList<City> cities){
		adjacentCities = cities;
	}
	
	public List<City> getAdjacentCities(){
		return this.adjacentCities;
	}
	
	public String getCity() {
		return this.cityName;
	}
	
	public int getDepthLevel()
	{
		return depthLevel;
	}

	public void setDepthLevel(int depthLevel)
	{
		this.depthLevel = depthLevel;
	}

	
}
