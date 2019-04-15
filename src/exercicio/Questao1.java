package exercicio;

import java.util.ArrayList;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

public class Questao1 {
	
	public ArrayList<String> retornaDuplas(Graph<String, DefaultEdge> graph){
		
		ArrayList<String> duplas = new ArrayList<String>();
		
		for(String astronauta1: graph.vertexSet()) {
			for(String astronauta2: graph.vertexSet()) {
				if(!astronauta1.equals(astronauta2)) {
					if(!graph.containsEdge(astronauta1, astronauta2)) {
						if(!duplas.contains(astronauta2 + " - " + astronauta1)) {
							duplas.add(astronauta1 + " - " + astronauta2);
						}
					}
				}
			}
		}
		return duplas;
	}
	
	public static void main(String args[]) {
		
		Graph<String, DefaultEdge> graph = new SimpleGraph<String, DefaultEdge>(DefaultEdge.class);
	
		graph.addVertex("Mario");
		graph.addVertex("Ben");
		graph.addVertex("Chris");
		graph.addVertex("Jay");
		graph.addVertex("Uri");
		graph.addVertex("Mia");
		graph.addVertex("Sue");
		
		graph.addEdge("Chris", "Ben");
		graph.addEdge("Jay", "Ben");
		graph.addEdge("Chris", "Jay");
		graph.addEdge("Mario", "Mia");
		graph.addEdge("Uri", "Sue");
		
		ArrayList<String> duplas = new ArrayList<String>();
		
		System.out.println("Duplas de nacionalidades diferentes: ");
		for(String dupla: duplas) {
			System.out.println(dupla);
		}
	}
}
