import java.io.File;
import java.util.*;

public class Graph {
    private int vertexCt;  // Number of vertices in the graph.
    private int[][] capacity;  // Adjacency  matrix
    private int[][] residual; // residual matrix
    private int[][] edgeCost; // cost of edges in the matrix
    private String graphName;  //The file from which the graph was created.
    private int totalFlow; // total achieved flow
    private int source = 0; // start of all paths
    private int sink; // end of all paths

    public Graph(String fileName) {
        this.vertexCt = 0;
        source = 0;
        this.graphName = "";
        makeGraph(fileName);

    }

    /**
     * Method to add an edge
     *
     * @param source      start of edge
     * @param destination end of edge
     * @param cap         capacity of edge
     * @param weight      weight of edge, if any
     * @return edge created
     */
    private boolean addEdge(int source, int destination, int cap, int weight) {
        if (source < 0 || source >= vertexCt) return false;
        if (destination < 0 || destination >= vertexCt) return false;
        capacity[source][destination] = cap;
        residual[source][destination] = cap;
        edgeCost[source][destination] = weight;
        edgeCost[destination][source] = -weight;
        return true;
    }

    /**
     * Method to get a visual of the graph
     *
     * @return the visual
     */
    public String printMatrix(String label, int[][] m) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n " + label + " \n     ");
        for (int i = 0; i < vertexCt; i++)
            sb.append(String.format("%5d", i));
        sb.append("\n");
        for (int i = 0; i < vertexCt; i++) {
            sb.append(String.format("%5d", i));
            for (int j = 0; j < vertexCt; j++) {
                sb.append(String.format("%5d", m[i][j]));
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * Method to make the graph
     *
     * @param filename of file containing data
     */
    private void makeGraph(String filename) {
        try {
            graphName = filename;
            System.out.println("\n****Find Flow " + filename);
            Scanner reader = new Scanner(new File(filename));
            vertexCt = reader.nextInt();
            capacity = new int[vertexCt][vertexCt];
            residual = new int[vertexCt][vertexCt];
            edgeCost = new int[vertexCt][vertexCt];
            for (int i = 0; i < vertexCt; i++) {
                for (int j = 0; j < vertexCt; j++) {
                    capacity[i][j] = 0;
                    residual[i][j] = 0;
                    edgeCost[i][j] = 0;
                }
            }

            // If weights, need to grab them from file
            while (reader.hasNextInt()) {
                int v1 = reader.nextInt();
                int v2 = reader.nextInt();
                int cap = reader.nextInt();
                int weight = reader.nextInt();
                if (!addEdge(v1, v2, cap, weight))
                    throw new Exception();
            }

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        sink = vertexCt - 1;
        System.out.println(printMatrix("Edge Cost", edgeCost));
    }


    public void findWeightedFlow() {
        //finds each path through the graph and costs
        if (bellman(source, sink)) {
            System.out.println("Path found!");
        }else{
            System.out.println("No path found");
        }

    }

    /**
     * @param cost the list of costs to get to nodes
     * @param v1 x coordinate for the array
     * @param v2 y coordinate for the array
     * @return if the new edge cost is cheaper than the current recorded cost
     */
    public boolean isCheaper(int[] cost, int v1, int v2) {
        if (residual[v1][v2] > 0) {
            int newCost = cost[v1] + edgeCost[v1][v2];
            return newCost < cost[v2];
        }
        return false;
    }

    /**
     * condenses the parents array into a list of nodes visited from source to sink
     * @param parents the array of predecessors
     * @return a list of nodes
     */
    public ArrayList writePath(int[] parents){
        ArrayList path = new ArrayList();
        for (int i=0; i<parents.length; i++){
            if (!path.contains(parents[i])){
                path.add(parents[i]);
            }
        }
        path.add(sink);
        for (int j=0; j<path.size(); j++){
            System.out.print(path.get(j)+" ");
        }
        return path;
    }

    /**
     * calculates the flow of the path by finding the shortest capacity on any edge
     * adds the flow to the total flow of the graph
     * @param path the series of nodes from source to sink
     */
    public void addFlow(ArrayList path){
        int flow = 10000;
        for (int i=1; i<path.size()-1; i++){
            int coor1 = (int) path.get(i);
            int coor2 = (int) path.get(i+1);
            if (residual[coor1][coor2] < flow){
                flow = residual[coor1][coor2];
            }
        }
        System.out.print("("+flow+") ");
        totalFlow+=flow;
    }

    /**
     * checks if a shortest augmenting path exists, prints the path if true
     * @param start the first node of the graph
     * @param sink the last node of the graph
     * @return whether or not a path exists
     */
    public boolean bellman(int start, int sink) {
        int cost[] = new int[vertexCt];
        cost[0] = 0;
        for (int n = 1; n < vertexCt; n++) {
            cost[n] = Integer.MAX_VALUE;
        }
        int parents[] = new int[vertexCt];
        for (int n = 1; n < vertexCt; n++) {
            parents[n] = 1000;
        }
        for (int i = 0; i < vertexCt; i++) {
            for (int u = 0; u < vertexCt; u++) {
                for (int v = 0; v < vertexCt; v++) {
                    if (isCheaper(cost, u, v)) {
                        cost[v] = cost[u] + edgeCost[u][v];
                        parents[v] = u;
                    }
                }
            }
        }
            if (parents[sink] != 1000) {
                ArrayList path = writePath(parents);
                addFlow(path);
                System.out.println("$"+cost[cost.length-1]+" ");
                return true;
            } else {
                return false;
            }
        }


    public void finalEdgeFlow(){
        System.out.println(totalFlow);
    }


    public void minCostMaxFlow(){
        System.out.println( printMatrix("Capacity", capacity));
        System.out.println(printMatrix("Residual", residual));
        findWeightedFlow();
        finalEdgeFlow();
    }

    public static void main(String[] args) {
        String[] files = {"transport/transport0.txt", "transport/transport1.txt", "transport/transport2.txt", "transport/transport3.txt", "transport/Flow10.txt"};
        for (String fileName : files) {
            Graph graph = new Graph(fileName);
            graph.minCostMaxFlow();
        }
    }
}