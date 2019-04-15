package exercicio;

import java.util.ArrayList;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

/**
 * 
 * Esta classe tem o objetivo de solucionar o problema dos astronautas, no qual dois astronautas de
 * mesma nacionalidade não podem ser cumprir a missão, devendo um par de astronautas de nacionalidades
 * diferentes cumprí-la. Foi-se utilizado conceitos de teoria dos grafos para solucionar o problema
 * proposto.
 * 
 * @author Guilherme de Melo Carneiro
 * @author Gildo Matos Macedo Neto
 * @author Tulio Araujo Cunha
 * @author Mirella Quintans Lyra
 * @author Jose Nilton Da Silva Lima Junior
 */

public class Questao1 {
	
	/**
	 * 
	 * Retorna um ArrayList de String contendo as duplas de astronautas aptas a fazer a missão. Obtem
	 * as duplas aptas à realizar missão a partir do grafo que explicita que as relações dos astronautas 
	 * com base na nacionalidade.
	 * 
	 * @param graph grafo que explicita as relações dos astronautas com base na nacionalidade
	 * @return ArrayList de String contendo as duplas aptas a realizar a missão
	 */
	
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
