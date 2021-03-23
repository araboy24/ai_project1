package ai_project1;

import java.util.List;
import java.util.ArrayList;


public class Node
{
	private String city;
	private int depthLevel = 0;
	private List<Node> adjacentNodes;
	
	public Node(String city) {
		this.city = city;
		this.adjacentNodes = new ArrayList<>();
	}
	
	public String toString() {
		return this.city;
	}
	
	public void addNeighbor(Node n) {
		this.adjacentNodes.add(n);
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public int getDepthLevel()
	{
		return depthLevel;
	}

	public void setDepthLevel(int depthLevel)
	{
		this.depthLevel = depthLevel;
	}

	public List<Node> getAdjacentNodes()
	{
		return adjacentNodes;
	}
	
	
	
}
