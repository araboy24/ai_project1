package ai_project1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ItDeepCity
{
	
	private City targetCity;
	private boolean isTargetFound = false;
	int depth = 0;
//	private List<City> citiesToReset = new ArrayList<City>();
	public ItDeepCity(City targetCity) {
		this.targetCity = targetCity;
	}
	
	
	public void runDeepeningSearch(City startCity) {
		depth = 0;
		while(!isTargetFound) {
			System.out.println();
			LinkedListPractice.resetVisited();
			depthSearch(startCity, depth);
			depth++;
//			resetVisited();
		}
	}
	
	private void resetVisited() {
//		for(City c : citiesToReset) {
//			c.setIsVisited(false);
//		}
		
	}
	
	private void depthSearch(City startCity, int depth) {
		Stack<City> stack = new Stack<>();
		startCity.setDepthLevel(0);
		startCity.setIsVisited(true);
		stack.push(startCity);
//		citiesToReset.add(startCity);
//		alreadyCheckedCities.clear();
		
		while(!stack.isEmpty()) {
			City actualCity = stack.pop();
//			alreadyCheckedCities.add(actualCity);
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
				if(!city.getIsVisited()) {
					city.setDepthLevel(actualCity.getDepthLevel()+1);
					city.setIsVisited(true);
//					citiesToReset.add(startCity);
					stack.push(city);
				}
//				}
			}
//			System.out.println("For loop Done");
		}
	}
	
}
