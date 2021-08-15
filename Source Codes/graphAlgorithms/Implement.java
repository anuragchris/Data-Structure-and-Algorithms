package graphAlgorithms;

public class Implement {
	public static void main(String[] args) {
//		AdjacencyMatrix graph = new AdjacencyMatrix(10);
//		graph.addVertex('a');
//		graph.addVertex('b');
//		graph.addVertex('c');
//		graph.addVertex('d');
//		graph.addVertex('h');
//		graph.addVertex('e');
//		graph.addVertex('f');
//		graph.addVertex('g');
//		graph.addEdge(0, 1);
//		graph.addEdge(1, 2);
//		graph.addEdge(2, 3);
//		graph.addEdge(1, 4);
//		graph.addEdge(2, 5);
//		graph.addEdge(5, 7);
//		graph.addEdge(5, 6);
//		graph.printRecursiveDFS();
//		graph.printIterativeDFS();
//		graph.BFSTraversal();
//		System.out.println(graph.isCyclic());
//		Dijkstra dj = new Dijkstra(6);
//		dj.addVertex('0');/
//		dj.addVertex('1');
//		dj.addVertex('2');
//		dj.addVertex('3');
//		dj.addVertex('4');
//		dj.addVertex('5');
//		dj.addWeight(0, 1, 2);
//		dj.addWeight(0, 3, 4);
//		dj.addWeight(1, 3, 1);
//		dj.addWeight(1, 2, 3);
//		dj.addWeight(3, 4, 2);
//		dj.addWeight(2, 5, 4);
//		dj.addWeight(4, 5, 1);
//		dj.shortestPathUsingDijkstra(0);
//		AdjacencyMatrix graph = new AdjacencyMatrix(10);
//		graph.addVertex('0');
//		graph.addVertex('1');
//		graph.addVertex('2');
//		graph.addVertex('3');
//		graph.addVertex('4');
//		graph.addVertex('5');
//		graph.addVertex('6');
//		graph.addEdge(0, 1);
//		graph.addEdge(1, 2);
//		graph.addEdge(2, 3);
//		graph.addEdge(3, 4);
//		graph.addEdge(6, 1);
//		graph.addEdge(6, 5);
//		graph.addEdge(5, 3);
//		graph.topologicalSort();
//		KruskalsAlgorithm ka = new KruskalsAlgorithm(4, 5);
//		ka.addVerticesWithEdgeAndWeight(1, 3, 15);
//		ka.addVerticesWithEdgeAndWeight(0, 1, 10);
//		ka.addVerticesWithEdgeAndWeight(0, 2, 6);
//		ka.addVerticesWithEdgeAndWeight(2, 3, 4);
//		ka.addVerticesWithEdgeAndWeight(0, 3, 5);
//		ka.kruskalMST();
//		PrimsAlgorithm pa = new PrimsAlgorithm(6);
//		pa.addWeight(0, 1, 2);
//		pa.addWeight(0, 3, 4);
//		pa.addWeight(1, 2, 3);
//		pa.addWeight(1, 3, 1);
//		pa.addWeight(3, 4, 2);
//		pa.addWeight(2, 5, 4);
//		pa.addWeight(4, 5, 1);
//		pa.prim();
//		BellmanFord bf = new BellmanFord(5, 10);
//		bf.addVerticesWithEdgeAndWeight(0, 1, 6);
//		bf.addVerticesWithEdgeAndWeight(0, 2, 7);
//		bf.addVerticesWithEdgeAndWeight(1, 2, 8);
//		bf.addVerticesWithEdgeAndWeight(1, 3, -4);
//		bf.addVerticesWithEdgeAndWeight(1, 4, 5);
//		bf.addVerticesWithEdgeAndWeight(2, 3, 9);
//		bf.addVerticesWithEdgeAndWeight(2, 4, -3);
//		bf.addVerticesWithEdgeAndWeight(3, 0, 2);
//		bf.addVerticesWithEdgeAndWeight(3, 4, 7);
//		bf.addVerticesWithEdgeAndWeight(4, 1, -2);
//		bf.bellmanFord();
//		AdjacencyMatrix am = new AdjacencyMatrix(5);
//		am.addVertex('0');
//		am.addVertex('1');
//		am.addVertex('2');
//		am.addVertex('3');
//		am.addVertex('4');
//		am.addEdge(0, 1);
//		am.addEdge(1, 3);
//		am.addEdge(3, 4);
//		am.addEdge(4, 2);
//		System.out.println(am.checkPath(0, 2));
//		TarjansAlgorithm ta = new TarjansAlgorithm(5);
//		ta.addEdge(0, 1);
//		ta.addEdge(1, 2);
//		ta.addEdge(1, 3);
//		ta.addEdge(3, 4);
//		ta.addEdge(4, 5);
//		ta.addEdge(4, 0);
//		ta.addEdge(4, 6);
//		ta.addEdge(5, 2);
//		ta.addEdge(5, 6);
//		ta.addEdge(6, 5);
//		ta.tarjanUsingDFS();
//		ta.addEdge(0, 1);
//		ta.addEdge(2, 0);
//		ta.addEdge(0, 3);
//		ta.addEdge(1, 2);
//		ta.addEdge(3, 4);
//		ta.addEdge(3, 5);
//		ta.articulatePoints();
//		ta.addEdge(0, 1);
//		ta.addEdge(1, 2);
//		ta.addEdge(2, 0);
//		ta.addEdge(0, 3);
//		ta.addEdge(3, 4);
//		ta.findBridgesUsingDfs();
//		EulerGraph eg = new EulerGraph(4);
//		eg.addEdge(1, 2);
//		eg.addEdge(2, 1);
//		eg.addEdge(2, 3);
//		eg.addEdge(3, 2);
//		eg.addEdge(3, 1);
//		eg.addEdge(1, 3);
//		eg.findEulerPathCycle();
//		EulerGraph eg1 = new EulerGraph(5);
//		eg1.addEdge(0, 1);
//		eg1.addEdge(1, 0);
//		eg1.addEdge(1, 2);
//		eg1.addEdge(2, 1);
//		eg1.addEdge(2, 0);
//		eg1.addEdge(0, 2);
//		eg1.addEdge(3, 4);
//		eg1.addEdge(4, 3);
//		eg1.findEulerPathCycle();
		DirectedGraph dg = new DirectedGraph(5);
		dg.addEdge(0, 1);
		dg.addEdge(1, 2);
		dg.addEdge(2, 3);
		dg.addEdge(3, 4);
		dg.addEdge(4, 1);
		System.out.println(dg.isCyclic());
	}
}
