package ai_project1;

import java.util.*;
import java.util.List;

public class City //implements Comparable<City>
{

	private String cityName;
	private int depthLevel = 0;
	private List<City> adjacentCities;
	private boolean isVisited = false;
//	public Edge[] adjacencies;
//	public double minDistance = Double.POSITIVE_INFINITY;
//	public City previous;
//    public City(String argName) { cityName = argName; }
//	public int compareTo(City other)
//    {
//        return Double.compare(minDistance, other.minDistance);
//    }
//	
	public City(String cityName) {
		this.cityName = cityName;
		this.adjacentCities = new ArrayList<>();
	}
	
	public boolean getIsVisited() {
		return this.isVisited;
	}
	
	public void setIsVisited(boolean isVisited) {
		this.isVisited = isVisited;
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
