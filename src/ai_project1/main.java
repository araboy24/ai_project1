package ai_project1;

public class main
{

	public static void main(String[] args)
	{
		Node node1 = new Node("A");
		Node node2 = new Node("B");
		Node node3 = new Node("C");
		
		node1.addNeighbor(node2);
		node2.addNeighbor(node3);
		
		IterativeDeepening itDeep = new IterativeDeepening(node1);
		itDeep.runDeepeningSearch(node2);
	}

}
