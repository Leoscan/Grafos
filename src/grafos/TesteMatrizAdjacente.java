package grafos;

public class TesteMatrizAdjacente {
	public static void main(String[] args) {
		/*int numVertices = 3;
		MatrizAdjacencia grafo = new MatrizAdjacencia(numVertices, false, true);
		
		
		grafo.inserirAresta(0,1);
		grafo.inserirAresta(0,2);
		grafo.inserirAresta(1,2);
	
		grafo.mostrarMatriz();
		
		System.out.print("");
		MatrizAdjacencia grafo2 = new MatrizAdjacencia(numVertices, true, true);
		
		grafo2.inserirAresta(0,1,3);
		grafo2.inserirAresta(1,2,5);
		grafo2.inserirAresta(2,0,5);
		
		grafo2.mostrarMatriz();*/
		
	
		        MatrizAdjacencia grafo = new MatrizAdjacencia(5, true, true);

		        // Inserir arestas com pesos
		        grafo.inserirAresta(0, 1, 2);
		        grafo.inserirAresta(1, 2, 1);
		        grafo.inserirAresta(2, 3, 3);
		        grafo.inserirAresta(3, 4, 4);
		        grafo.inserirAresta(4, 0, 5);

		        // Mostrar a matriz de adjacência
		        System.out.println("Matriz de Adjacência após inserção:");
		        grafo.mostrarMatriz();

		        // Remover a aresta entre o vértice 2 e o vértice 3
		        grafo.removerAresta(2, 3);

		        // Mostrar a matriz de adjacência após remoção
		        System.out.println("\nMatriz de Adjacência após remoção:");
		        grafo.mostrarMatriz();

		        // Verificar se os vértices 1 e 2 são adjacentes
		        int resultado = grafo.saoAdjacentes(1, 2);
		        System.out.println("\nVértices 1 e 2 são adjacentes? " + (resultado != 0 ? "Sim" : "Não"));
		 

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
