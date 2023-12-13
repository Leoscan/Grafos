package grafos;
import java.util.*;


class Aresta {
    int origem;
    int destino;
    int peso;

    public Aresta(int origem, int destino, int peso) {
        this.origem = origem;
        this.destino = destino;
        this.peso = peso;
    }
}

public class ListaAdjacencia {
    private int nVertices;
    private List<List<Aresta>> adjacencias;
    private boolean direcionado;

    public ListaAdjacencia(int nVertices, boolean direcionado) {
        this.nVertices = nVertices;
        this.direcionado = direcionado;
        this.adjacencias = new ArrayList<>(nVertices);

        for (int i = 0; i < nVertices; i++) {
            adjacencias.add(new ArrayList<Aresta>());
        }
    }
    public List<Aresta> getAdjacencias(int vertice) {
        return adjacencias.get(vertice);
    }

    public int getNumVertices() {
        return nVertices;
    }
    
    public void adicionaAresta(int u, int v, int peso) {
        Aresta aresta = new Aresta(u, v, peso);
        adjacencias.get(u).add(aresta);
        if (direcionado) {
            Aresta arestaInvertida = new Aresta(v, u, peso);
            adjacencias.get(v).add(arestaInvertida);
        }
    }

    public void adicionaAresta(int u, int v) {
        adicionaAresta(u, v, 1);
    }

    public boolean saoAdjacentes(int u, int v) {
        for (Aresta aresta : adjacencias.get(u)) {
            if (aresta.destino == v) {
                return true;
            }
        }
        return false;
    }

    public void mostrarListaAdjacenteDoVertice(int vertice) {
        System.out.print("Vértice " + vertice + ": ");
        for (Aresta aresta : adjacencias.get(vertice)) {
            System.out.print("(" + aresta.destino + ", Peso: " + aresta.peso + ") ");
        }
        System.out.println();
    }

    public void mostrarListaAdjacencias() {
        for (int i = 0; i < nVertices; i++) {
            System.out.print("Vértice " + i + ": ");
            for (Aresta aresta : adjacencias.get(i)) {
                System.out.print("(" + aresta.destino + ", Peso: " + aresta.peso + ") ");
            }
            System.out.println();
        }
    }

    public void removeAresta(int u, int v) {
        List<Aresta> arestasU = adjacencias.get(u);
        for (Aresta aresta : new ArrayList<>(arestasU)) {
            if (aresta.destino == v) {
                arestasU.remove(aresta);
                break;
            }
        }
        if (!direcionado) {
            List<Aresta> arestasV = adjacencias.get(v);
            for (Aresta aresta : new ArrayList<>(arestasV)) {
                if (aresta.destino == u) {
                    arestasV.remove(aresta);
                    break;
                }
            }
        }
    }
    
    public void removerVertice(int vertice) {
        // Remover arestas incidentes ao vértice
        adjacencias.get(vertice).clear();

        // Remover referências ao vértice em outras listas
        for (List<Aresta> lista : adjacencias) {
            lista.removeIf(aresta -> aresta.destino == vertice);
        }

        // Remover a lista de adjacência do vértice
        adjacencias.remove(vertice);
        nVertices--;
    }

    
    
    public boolean ehConexo() {
        boolean[] visitados = new boolean[nVertices];
        dfs(0, visitados);

        for (boolean visitado : visitados) {
            if (!visitado) {
                return false;
            }
        }
        return true;
    }

    private void dfs(int vertice, boolean[] visitados) {
        visitados[vertice] = true;
        for (Aresta aresta : adjacencias.get(vertice)) {
            if (!visitados[aresta.destino]) {
                dfs(aresta.destino, visitados);
            }
        }
    }

    public boolean ehCompleto() {
        for (int i = 0; i < nVertices; i++) {
            for (int j = 0; j < nVertices; j++) {
                if (i != j && !saoAdjacentes(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    
    public String verificaEuleriano() {
        int impares = 0;

        for (List<Aresta> lista : adjacencias) {
            if (lista.size() % 2 != 0) {
                impares++;
            }
        }

        if (impares == 0) {
            return "Grafo Euleriano";
        } else if (impares == 2) {
            return "Grafo Semi-Euleriano";
        } else {
            return "Grafo Não Euleriano";
        }
    }
    
    public String verificaHamiltonianismo() {
        if (ehConexo()) {
            if (verificaCicloHamiltoniano()) {
                return "Grafo Hamiltoniano";
            } else if (verificaCaminhoHamiltoniano()) {
                return "Grafo Semi-Hamiltoniano";
            } else {
                return "Grafo Não Hamiltoniano";
            }
        } else {
            return "Grafo Não Conexo";
        }
    }

    private boolean verificaCicloHamiltoniano() {
        for (int i = 0; i < nVertices; i++) {
            boolean[] visitados = new boolean[nVertices];
            if (dfsCicloHamiltoniano(i, i, visitados, 1)) {
                return true;
            }
        }
        return false;
    }

    private boolean dfsCicloHamiltoniano(int verticeAtual, int verticeInicial, boolean[] visitados, int visitadosCount) {
        visitados[verticeAtual] = true;

        if (visitadosCount == nVertices && saoAdjacentes(verticeAtual, verticeInicial)) {
            return true;  // Encontrou um ciclo Hamiltoniano
        }

        for (Aresta aresta : adjacencias.get(verticeAtual)) {
            if (!visitados[aresta.destino]) {
                if (dfsCicloHamiltoniano(aresta.destino, verticeInicial, visitados, visitadosCount + 1)) {
                    return true;
                }
            }
        }

        visitados[verticeAtual] = false;  // Backtrack
        return false;
    }

    private boolean verificaCaminhoHamiltoniano() {
        for (int i = 0; i < nVertices; i++) {
            boolean[] visitados = new boolean[nVertices];
            if (dfsCaminhoHamiltoniano(i, visitados, 1)) {
                return true;
            }
        }
        return false;
    }

    private boolean dfsCaminhoHamiltoniano(int verticeAtual, boolean[] visitados, int visitadosCount) {
        visitados[verticeAtual] = true;

        if (visitadosCount == nVertices) {
            return true;  // Encontrou um caminho Hamiltoniano
        }

        for (Aresta aresta : adjacencias.get(verticeAtual)) {
            if (!visitados[aresta.destino]) {
                if (dfsCaminhoHamiltoniano(aresta.destino, visitados, visitadosCount + 1)) {
                    return true;
                }
            }
        }

        visitados[verticeAtual] = false;  // Backtrack
        return false;
    }

}