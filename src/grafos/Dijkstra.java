package grafos;

import java.util.*;

public class Dijkstra {
    private ListaAdjacencia grafo;
    
    public Dijkstra(ListaAdjacencia grafo) {
        this.grafo = grafo;
    }

    public Map<Integer, Integer> executarDijkstra(int origem) {
        Map<Integer, Integer> distancias = new HashMap<>();
        PriorityQueue<VerticeDistancia> filaPrioridade = new PriorityQueue<>(Comparator.comparingInt(vd -> vd.distancia));

        for (int i = 0; i < grafo.getNumVertices(); i++) {
            if (i == origem) {
                distancias.put(i, 0);
            } else {
                distancias.put(i, Integer.MAX_VALUE);
            }
            filaPrioridade.offer(new VerticeDistancia(i, distancias.get(i)));
        }

        while (!filaPrioridade.isEmpty()) {
            int verticeAtual = filaPrioridade.poll().vertice;

            for (Aresta aresta : grafo.getAdjacencias(verticeAtual)) {
                int distanciaNova = distancias.get(verticeAtual) + aresta.peso;
                if (distanciaNova < distancias.get(aresta.destino)) {
                    distancias.put(aresta.destino, distanciaNova);
                    filaPrioridade.offer(new VerticeDistancia(aresta.destino, distanciaNova));
                }
            }
        }

        return distancias;
    }

    private static class VerticeDistancia {
        int vertice;
        int distancia;

        public VerticeDistancia(int vertice, int distancia) {
            this.vertice = vertice;
            this.distancia = distancia;
        }
    }
}
