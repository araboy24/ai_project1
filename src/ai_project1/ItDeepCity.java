package ai_project1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ItDeepCity
{
	
	private City targetCity;
	private boolean isTargetFound = false;
	int depth = 0;
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
		}
	}
	
	
	private void depthSearch(City startCity, int depth) {
		Stack<City> stack = new Stack<>();
		startCity.setDepthLevel(0);
		startCity.setIsVisited(true);
		stack.push(startCity);

		
		while(!stack.isEmpty()) {
			City actualCity = stack.pop();
			System.out.print(actualCity + " ");
			
			
			if(actualCity.getCity().equals(this.targetCity.getCity())) {
				System.out.println("\nCity has been found");
				System.out.println("Depth reached: "+ depth);
				this.isTargetFound = true;
				return;
			}
			
			if(actualCity.getDepthLevel() >= depth) {
				continue;
			}
			
			for(City city : actualCity.getAdjacentCities()) {
				if(!city.getIsVisited()) {
					city.setDepthLevel(actualCity.getDepthLevel()+1);
					city.setIsVisited(true);
					stack.push(city);
				}
			}
		}
	}
	
}
