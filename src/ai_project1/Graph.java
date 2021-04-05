package ai_project1;

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class Graph
{

	private Map<City, List<City>> adjVertices;

	public Graph()
	{
		this.adjVertices = new HashMap<City, List<City>>();
	}
	
	public Graph(Map<City, List<City>> adjVertices)
	{
		this.adjVertices = adjVertices;
	}

	public Map<City, List<City>> getAdjVertices()
	{
		return adjVertices;
	}

	public void setAdjVertices(Map<City, List<City>> adjVertices)
	{
		this.adjVertices = adjVertices;
	}

	void addVertex(String label)
	{
		adjVertices.putIfAbsent(new City(label), new ArrayList<>());
	}

	void removeVertex(String label) 
	{
		City c = new City(label);
		adjVertices.values().stream().forEach(e -> e.remove(c));
		adjVertices.remove(new City(label));
	}

	void addEdge(String label1, String label2)
	{
		City c1 = new City(label1);
		City c2 = new City(label2);
		adjVertices.get(c1).add(c2);
		adjVertices.get(c2).add(c1);
	}
	
	void removeEdge(String label1, String label2) {
		City c1 = new City(label1);
		City c2 = new City(label2);
	    List<City> eC1 = adjVertices.get(c1);
	    List<City> eC2 = adjVertices.get(c2);
	    if (eC1 != null)
	        eC1.remove(c2);
	    if (eC2 != null)
	        eC2.remove(c1);
	}
	
	Graph createGraph() {
	    Graph graph = new Graph();
	    graph.addVertex("Bob");
	    graph.addVertex("Alice");
	    graph.addVertex("Mark");
	    graph.addVertex("Rob");
	    graph.addVertex("Maria");
	    graph.addEdge("Bob", "Alice");
	    graph.addEdge("Bob", "Rob");
	    graph.addEdge("Alice", "Mark");
	    graph.addEdge("Rob", "Mark");
	    graph.addEdge("Alice", "Maria");
	    graph.addEdge("Rob", "Maria");
	    return graph;
	}
	
	List<City> getAdjVertices(String label) {
	    return adjVertices.get(new City(label));
	}
	
}
