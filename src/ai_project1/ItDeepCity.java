package ai_project1;

import java.util.Stack;

public class ItDeepCity
{
	
	private City targetCity;
	private boolean isTargetFound = false;
	public ItDeepCity(City targetCity) {
		this.targetCity = targetCity;
	}
	
	
	public void runDeepeningSearch(City startCity) {
		int depth = 0;
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
		
		while(!stack.isEmpty()) {
			City actualCity = stack.pop();
			System.out.print(actualCity + " ");
			
			if(actualCity.getCity().equals(this.targetCity.getCity())) {
				System.out.println("\nNode has been found");
				this.isTargetFound = true;
				return;
			}
			
			if(actualCity.getDepthLevel() >= depth) {
				continue;
			}
			
//			System.out.println("For loop incoming");
			for(City city : actualCity.getAdjacentCities()) {
				city.setDepthLevel(actualCity.getDepthLevel()+1);
				stack.push(city);
			}
//			System.out.println("For loop Done");
		}
	}
	
}
