import java.util.Iterator;
import java.util.NoSuchElementException;


public class AdjMatrixGraph {
    private static final String NEWLINE = System.getProperty("line.separator");

    private final int V;
    private int E;
    private boolean[][] adj;

    // empty graph with V vertices
    public AdjMatrixGraph(int V) {
        if (V < 0) throw new IllegalArgumentException("Too few vertices");
        this.V = V;
        this.E = 0;
        this.adj = new boolean[V][V];
    }

    // number of vertices and edges
    public int V() { return V; }
    public int E() { return E; }


    // add undirected edge v-w
    public void addEdge(int v, int w) {
        if (!adj[v][w]) E++;
        adj[v][w] = true;
        adj[w][v] = true;
    }

    // does the graph contain the edge v-w?
    public boolean hasEdge(int v, int w) {
        return adj[v][w];
    }

    // return list of neighbors of v
    public Iterable<Integer> adj(int v) {
        return new AdjIterator(v);
    }

    // support iteration over graph vertices
    private class AdjIterator implements Iterator<Integer>, Iterable<Integer> {
        private int v;
        private int w = 0;

        AdjIterator(int v) {
            this.v = v;
        }

        public Iterator<Integer> iterator() {
            return this;
        }

        public boolean hasNext() {
            while (w < V) {
                if (adj[v][w]) return true;
                w++;
            }
            return false;
        }

        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return w++;
        }

        public void remove()  {
            throw new UnsupportedOperationException();
        }
    }


    // string representation of Graph - takes quadratic time
    public String display() {
        String s = "";
        s += V + " vertices, " + E + " edges" + NEWLINE;
        if(E() > 0) {
            for(int i = 0; i < V(); i++) {
                for(int j = 0; j < V(); j++) {
                    if (adj[i][j]) {
                        s += "1" + " ";
                    } else {
                        s += "0" + " ";
                    }
                } s += NEWLINE;
            }
        } else {
            s += "No edges";
        }
        return s.substring(0, s.length());
    }
}