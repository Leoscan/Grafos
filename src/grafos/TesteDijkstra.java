package grafos;

import java.util.Map;

public class TesteDijkstra {

	public static void main(String[] args) {
	    ListaAdjacencia grafo = new ListaAdjacencia(5, true);
	    grafo.adicionaAresta(0, 1, 1);
        grafo.adicionaAresta(0, 3, 3);
        grafo.adicionaAresta(0, 4, 10);
        grafo.adicionaAresta(1, 2, 5);
        grafo.adicionaAresta(2, 4, 1);
        grafo.adicionaAresta(3, 2, 2);
        grafo.adicionaAresta(3, 4, 6);

	    Dijkstra dijkstra = new Dijkstra(grafo);
	    Map<Integer, Integer> distancias = dijkstra.executarDijkstra(0);
	    
	    grafo.mostrarListaAdjacencias();
	    
	    // Exibir as distâncias mínimas a partir do vértice 0
	    for (Map.Entry<Integer, Integer> entry : distancias.entrySet()) {
	        System.out.println("Distância mínima de 0 para " + entry.getKey() + ": " + entry.getValue());
	    }
	}


}
