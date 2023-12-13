package grafos;

public class TesteListasAdjacencias {
    public static void main(String[] args) {
        ListaAdjacencia grafo = new ListaAdjacencia(5, true);

        // Adicionando arestas ao grafo
        grafo.adicionaAresta(0, 1);
        grafo.adicionaAresta(0, 3);
        grafo.adicionaAresta(0, 4);
        grafo.adicionaAresta(1, 2);
        grafo.adicionaAresta(2, 4);
        grafo.adicionaAresta(3, 2);
        grafo.adicionaAresta(3, 4);

        // Mostrando a lista de Adjacências
        System.out.println("Lista de Adjacências Inicial:");
        grafo.mostrarListaAdjacencias();
        System.out.println("É conexo: " + grafo.ehConexo());
        System.out.println("É Completo: " + grafo.ehCompleto());
        System.out.println("É Euleriano: "+grafo.verificaEuleriano());
      
        System.out.println("***************************");
        System.out.println("Teste Removendo Vertice 4");
        grafo.removerVertice(4);
        grafo.mostrarListaAdjacencias();
        
               

        System.out.println("***************************");
        ListaAdjacencia desconexografo = new ListaAdjacencia(5, true);

        // Adicionando arestas ao grafo
        desconexografo.adicionaAresta(0, 3);
        desconexografo.adicionaAresta(0, 4);
        desconexografo.adicionaAresta(2, 4);
        desconexografo.adicionaAresta(3, 2);
        desconexografo.adicionaAresta(3, 4);
        
        System.out.println("Teste Desconexo");
        desconexografo.mostrarListaAdjacencias();
        System.out.println("É Conexo: "+desconexografo.ehConexo());
        System.out.println("É Euleriano: "+desconexografo.verificaEuleriano());
        
        
        
        System.out.println("***************************");
        ListaAdjacencia completografo = new ListaAdjacencia(5, true);

        // Adicionando arestas ao grafo
        completografo.adicionaAresta(0, 1);
        completografo.adicionaAresta(0, 2);
        completografo.adicionaAresta(0, 3);
        completografo.adicionaAresta(0, 4);
        completografo.adicionaAresta(1, 2);
        completografo.adicionaAresta(1, 3);
        completografo.adicionaAresta(1, 4);
        completografo.adicionaAresta(2, 3);
        completografo.adicionaAresta(2, 4);
        completografo.adicionaAresta(3, 4);
        
        System.out.println("Teste Completo");
        completografo.mostrarListaAdjacencias();
        System.out.println("É Completo: "+completografo.ehCompleto());
        System.out.println("É Euleriano: "+completografo.verificaEuleriano());
        
        
        System.out.println("***************************");
        System.out.println("Hamiltoniano");
        // Exemplo 1: Grafo Hamiltoniano
        ListaAdjacencia grafo1 = new ListaAdjacencia(5, true);
        grafo1.adicionaAresta(0, 1);
        grafo1.adicionaAresta(0, 3);
        grafo1.adicionaAresta(0, 4);
        grafo1.adicionaAresta(1, 2);
        grafo1.adicionaAresta(2, 4);
        grafo1.adicionaAresta(3, 2);
        grafo1.adicionaAresta(3, 4);

        System.out.println("Exemplo 1 - Grafo Hamiltoniano:");
        grafo1.mostrarListaAdjacencias();
        System.out.println("É Hamiltoniano: " + grafo1.verificaHamiltonianismo());
        System.out.println("***************************");

        // Exemplo 2: Grafo Semi-Hamiltoniano
        ListaAdjacencia grafo2 = new ListaAdjacencia(5, true);
        grafo2.adicionaAresta(0, 1);
        grafo2.adicionaAresta(0, 3);
        grafo2.adicionaAresta(0, 4);
        grafo2.adicionaAresta(1, 2);
        grafo2.adicionaAresta(2, 4);
        grafo2.adicionaAresta(3, 2);

        System.out.println("Exemplo 2 - Grafo Semi-Hamiltoniano:");
        grafo2.mostrarListaAdjacencias();
        System.out.println("É Hamiltoniano: " + grafo2.verificaHamiltonianismo());
        System.out.println("***************************");

        // Exemplo 3: Grafo Não Hamiltoniano
        ListaAdjacencia grafo3 = new ListaAdjacencia(5, true);
        grafo3.adicionaAresta(0, 1);
        grafo3.adicionaAresta(0, 2);
        grafo3.adicionaAresta(0, 4);
        grafo3.adicionaAresta(1, 3);
        grafo3.adicionaAresta(2, 3);
        grafo3.adicionaAresta(2, 4);

        System.out.println("Exemplo 3 - Grafo Não Hamiltoniano:");
        grafo3.mostrarListaAdjacencias();
        System.out.println("É Hamiltoniano: " + grafo3.verificaHamiltonianismo());
        System.out.println("***************************");
   
        
        
    }
}
