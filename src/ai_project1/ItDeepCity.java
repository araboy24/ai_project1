package ai_project1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ItDeepCity
{
	
	private City targetCity;
	private boolean isTargetFound = false;
	int depth = 0;
	private List<City> alreadyCheckedCities = new ArrayList<City>();
	public ItDeepCity(City targetCity) {
		this.targetCity = targetCity;
	}
	
	
	public void runDeepeningSearch(City startCity) {
		depth = 0;
		while(!isTargetFound) {
			System.out.println();
			depthSearch(startCity, depth);
			depth++;
		}
	}
	
	private void depthSearch(City startCity, int depth) {
		Stack<City> stack = new Stack<>();
		startCity.setDepthLevel(0);
		stack.push(startCity);
		
		alreadyCheckedCities.clear();
		
		while(!stack.isEmpty()) {
			City actualCity = stack.pop();
			alreadyCheckedCities.add(actualCity);
			System.out.print(actualCity + " ");
			
			
			if(actualCity.getCity().equals(this.targetCity.getCity())) {
				System.out.println("\nNode has been found");
				System.out.println("Depth reached: "+ depth);
				this.isTargetFound = true;
				return;
			}
			
			if(actualCity.getDepthLevel() >= depth) {
				continue;
			}
			
//			System.out.println("For loop incoming");
			for(City city : actualCity.getAdjacentCities()) {
//				if(!alreadyCheckedCities.contains(city)) {
					city.setDepthLevel(actualCity.getDepthLevel()+1);
					stack.push(city);
//				}
			}
//			System.out.println("For loop Done");
		}
	}
	
}
