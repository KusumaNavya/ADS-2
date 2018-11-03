import java.util.Scanner;
/**
 * Class for page rank.
 */
class PageRank {
	private double[] pr;
	private Digraph graph;
	PageRank() {
		//empty constructor
	}
	/**
	 * Constructs the object.
	 *
	 * @param      graphh  The graphh
	 */
	PageRank(final Digraph graphh) {
		this.graph = graphh;
	}
	public double getPR(int v) {
    	return pr[v];
    }
    public String toString() {
    	String s = "";
    	for (int i = 0; i < pr.length; i++) {
     		s += i + " - " + getPR(i) + "\n";
    	}
    	return s;
    }
}
class WebSearch {
	private PageRank rank;
	WebSearch() {
		//empty constructor;
	}
	WebSearch(final PageRank rankk, final String filename) {
		this.rank = rankk;
	}
}
public class Solution {
	public static void main(String[] args) {
		// read the first line of the input to get the number of vertices
		Scanner scan = new Scanner(System.in);
		int vertices = Integer.parseInt(scan.nextLine());
		while (vertices > 0) {
			String[] tokens = scan.nextLine().split(" ");
			Digraph graph = new Digraph(vertices);
			int web = Integer.parseInt(tokens[0]);
			for (int i= 1; i <= tokens.length; i++) {
				graph.addEdge(web, Integer.parseInt(tokens[i]));
			}
			vertices--;
		}

		
		// iterate count of vertices times 
		// to read the adjacency list from std input
		// and build the graph
		
		
		// Create page rank object and pass the graph object to the constructor
		
		// print the page rank object
		
		// This part is only for the final test case
		
		// File path to the web content
		String file = "WebContent.txt";
		
		// instantiate web search object
		// and pass the page rank object and the file path to the constructor
		
		// read the search queries from std in
		// remove the q= prefix and extract the search word
		// pass the word to iAmFeelingLucky method of web search
		// print the return value of iAmFeelingLucky
		
	}
}
