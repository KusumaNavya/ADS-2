import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Class for adj matrix graph.
 */
public class AdjMatrixGraph {
    /**
     * { var_description }
     */
    private static final String NEWLINE = System.getProperty("line.separator");
    /**
     * { var_description }
     */
    private final int V;
    /**
     * { var_description }
     */
    private int E;
    /**
     * { var_description }
     */
    private boolean[][] adj;
    //
    // empty graph with V vertices
    //
    // @param      V     { parameter_description }
    //
    public AdjMatrixGraph(int V) {
        if (V < 0) throw new IllegalArgumentException("Too few vertices");
        this.V = V;
        this.E = 0;
        this.adj = new boolean[V][V];
    }
    /**
     * { function_description }
     *    // number of vertices and edges
     * @return     { description_of_the_return_value }
     */
    public int V() { return V; }
    public int E() { return E; }
    /**
     * Adds an edge.
     *    // add undirected edge v-w
     * @param      v     { parameter_description }
     * @param      w     { parameter_description }
     */
    public void addEdge(int v, int w) {
        if (!adj[v][w]) E++;
        adj[v][w] = true;
        adj[w][v] = true;
    }
    /**
     * Determines if it has edge.
     *    // does the graph contain the edge v-w?
     * @param      v     { parameter_description }
     * @param      w     { parameter_description }
     *
     * @return     True if has edge, False otherwise.
     */
    public boolean hasEdge(int v, int w) {
        return adj[v][w];
    }
    /**
     * { function_description }
     *
     * @param      v     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public Iterable<Integer> adj(int v) {
        return new AdjIterator(v);
    }
    /**
     * Class for adj iterator.
     */
    private class AdjIterator implements Iterator<Integer>, Iterable<Integer> {
        private int v;
        private int w = 0;
        /**
         * Constructs the object.
         *
         * @param      v     { parameter_description }
         */
        AdjIterator(int v) {
            this.v = v;
        }
        /**
         * { function_description }
         *
         * @return     { description_of_the_return_value }
         */
        public Iterator<Integer> iterator() {
            return this;
        }
        /**
         * Determines if it has next.
         *
         * @return     True if has next, False otherwise.
         */
        public boolean hasNext() {
            while (w < V) {
                if (adj[v][w]) return true;
                w++;
            }
            return false;
        }
        /**
         * { function_description }
         *
         * @return     { description_of_the_return_value }
         */
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return w++;
        }
        /**
         * { function_description }
         */
        public void remove()  {
            throw new UnsupportedOperationException();
        }
    }
    /**
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
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
