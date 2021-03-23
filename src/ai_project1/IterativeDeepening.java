package ai_project1;

import java.util.Stack;

public class IterativeDeepening
{
	private Node targetNode;
	private boolean isTargetFound = false;
	public IterativeDeepening(Node targetNode)
	{
		this.targetNode = targetNode;
		
	}
	
	public void runDeepeningSearch(Node startNode) {
		
		int depth = 0;
		
		while(!isTargetFound) {
			System.out.println();
			dfs(startNode, depth);
			depth++;
		}
	}
	
	private void dfs(Node startNode, int depth) {
		Stack<Node> stack = new Stack<>();
		startNode.setDepthLevel(0);
		stack.push(startNode);
		
		while(!stack.isEmpty()) {
			Node actualNode = stack.pop();
			System.out.println(actualNode + " ");
			
			if(actualNode.getCity().equals(this.targetNode.getCity())) {
				System.out.println("\nNode has been found");
				this.isTargetFound = true;
				return;
			}
			
			if(actualNode.getDepthLevel() >= depth) {
				continue;
			}
			
			for(Node node : actualNode.getAdjacentNodes()) {
				node.setDepthLevel(actualNode.getDepthLevel()+1);
				stack.push(node);
			}
		}
	}
	
	
}
