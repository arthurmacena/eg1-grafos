package exercicio;

import java.util.ArrayList;
import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.cycle.PatonCycleBase;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

public class Questao2 {

	public static ArrayList<GraphPath<String, DefaultEdge>> getQuarteiroesInseparaveis(Graph<String, DefaultEdge> graph){
		
		PatonCycleBase<String, DefaultEdge> c = new PatonCycleBase<String, DefaultEdge>(graph);
		ArrayList<GraphPath<String, DefaultEdge>> quarteiroesInseparaveis = new ArrayList<GraphPath<String, DefaultEdge>>();
		
		for(GraphPath<String, DefaultEdge> ciclo: c.getCycleBasis().getCyclesAsGraphPaths()) {
			if(ciclo.getLength() == 3) {
				quarteiroesInseparaveis.add(ciclo);
			}
		}
		return quarteiroesInseparaveis;
	}
	
	public static void main(String[] args) {
		
		Graph<String, DefaultEdge> graph = new SimpleGraph<String, DefaultEdge>(DefaultEdge.class);
		
		graph.addVertex("1");
		graph.addVertex("2");
		graph.addVertex("3");
		graph.addVertex("4");
		graph.addVertex("5");
		graph.addVertex("6");
		graph.addVertex("7");
		graph.addVertex("8");
		graph.addVertex("9");
		graph.addVertex("10");
		graph.addVertex("11");
		graph.addVertex("12");
		graph.addVertex("13");
		graph.addVertex("14");
		graph.addVertex("15");
		
		graph.addEdge("1", "5");
		graph.addEdge("1", "2");
		graph.addEdge("2", "5");
		graph.addEdge("2", "3");
		graph.addEdge("3", "10");
		graph.addEdge("3", "4");
		graph.addEdge("3", "7");
		graph.addEdge("4", "8");
		graph.addEdge("5", "9");
		graph.addEdge("7", "8");
		graph.addEdge("7", "11");
		graph.addEdge("8", "12");
		graph.addEdge("9", "10");
		graph.addEdge("9", "13");
		graph.addEdge("10", "14");
		graph.addEdge("10", "11");
		graph.addEdge("11", "15");
		graph.addEdge("11", "12");
		graph.addEdge("12", "15");
		graph.addEdge("13", "14");
		graph.addEdge("14", "15");
		
		for(GraphPath<String, DefaultEdge> ciclo: getQuarteiroesInseparaveis(graph)) {
			List<String> quarteiroes = ciclo.getVertexList();
			quarteiroes.remove(ciclo.getVertexList().size()-1);
			System.out.println("Quarteirões inseparáveis: " + quarteiroes);
		}
		
	}
}
