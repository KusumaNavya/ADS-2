import java.util.Scanner;
/**.
 * Class for solution.
 */
public final class Solution {
    /**.
     * epmty constructor.
     */
    private Solution() {
        //empty constructor
    }
    /**.
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // Self loops are not allowed...
        // Parallel Edges are allowed...
        // Take the Graph input here...
        Scanner scan = new Scanner(System.in);
        int cities = Integer.parseInt(scan.nextLine());
        int road = Integer.parseInt(scan.nextLine());
        EdgeWeightedGraph list = new EdgeWeightedGraph(cities);
        for (int i = 0; i < road; i++) {
            String[] tokens = scan.nextLine().split(" ");
            if (!tokens[0].equals(tokens[1])) {
                Edge obj = new Edge(Integer.parseInt(tokens[0]),
                    Integer.parseInt(tokens[1]),
                             Integer.parseInt(tokens[2]));
                list.addEdge(obj);
            }
        }
        String caseToGo = scan.nextLine();
        switch (caseToGo) {
        case "Graph":
            //Print the Graph Object.
            System.out.println(list);
            break;

        case "DirectedPaths":
            // Handle the case of DirectedPaths,
            // where two integers are given.
            // First is the source and second is the destination.
            // If the path exists print the distance between them.
            // Other wise print "No Path Found."
            while (scan.hasNextLine()) {
                String[] tokens = scan.nextLine().split(" ");
                DijkstraUndirectedSP path = new DijkstraUndirectedSP(list,
                 Integer.parseInt(tokens[0]));
                if (path.hasPathTo(Integer.parseInt(tokens[1]))) {
                        System.out.println(path.distTo(Integer.parseInt(
                                                         tokens[1])));
                } else {
                        System.out.println("No Path Found.");
                }
            }
            break;
        case "ViaPaths":
            // Handle the case of ViaPaths, where
            // three integers are given.
            // First is the source and second is
            // the via is the one where path should pass throuh.
            // third is the destination.
            // If the path exists print the distance between them.
            // Other wise print "No Path Found."
            while (scan.hasNextLine()) {
                String[] tokens = scan.nextLine().split(" ");
                System.out.println("No Path Found.");
            }
            break;
        default:
            break;
        }
    }
}
