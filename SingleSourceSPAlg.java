/*
CPCS 324 : Algorithms & Data Structures 2 : Group Project Phase2
Air Freight App (Usage of Djikstra Algorithm)
---------------
Ayatun Ara - 2110295 - B0B
Rayana Bander Aljuaid - 2105972 - B0A
Samaher Ismael Fattani - 1905374 - B0A
Ghadeer Mohammed Nooh - 2006705 - B0A
---------------
 */
package GraphFramework;

//uses priority queue
import java.util.PriorityQueue;

//class which use Dijkstra algorithm to compute the shortest path of single source
public class SingleSourceSPAlg extends ShortestPathAlgorithm {

    //constructors
    public SingleSourceSPAlg(Graph graph) {
        super(graph);
    }

    //method to compute djikstra alg
    public void computeDijkstraAlg(Vertex source, boolean flag) {
        //initialise variables
        int infinity = Integer.MAX_VALUE;
        int distance[] = new int[this.graph.verticesNo];
        int parent[] = new int[this.graph.verticesNo];

        //assign infinity to all distances at first
        for (int i = 0; i < distance.length; i++) {
            distance[i] = infinity;
        }

        //source distance is 0
        distance[source.getLabel() - 'A'] = 0;
        
        //priority queue initialised with pair of distances and nodes 
        PriorityQueue<int[]> q = new PriorityQueue<>((value, node) -> Integer.compare(value[0], node[0]));
        
        //add first pair to queue
        int firstPair[] = {0, (source.getLabel() - 'A')};
        q.add(firstPair);

        //while q is not empty, continue
        while (!q.isEmpty()) {
            //assign to array
            int array[] = q.poll();
            int value = array[0], node = array[1];

            //continue if node's distance is less than value
            if (distance[node] < value) {
                continue;
            }

            for (int i = 0; i < graph.vertices[node].adjList.size(); i++) {
                //assign edge from graph
                Edge edge = graph.vertices[node].adjList.get(i);
                int target = edge.target.getLabel() - 'A';
                int weight = edge.weight;

                if (distance[target] > value + weight) {
                    distance[target] = value + weight;
                    int pair[] = {distance[target], target};
                    //add the pair to queue
                    q.add(pair);
                    parent[target] = node;
                }
            }
        }

        //if requirement1 is called then print this otherwise no need to print it
        if (flag) {
            for (int i = 0; i < graph.verticesNo; i++) {
                //if there are no path from one vertex to another
                if (distance[i] == infinity) {
                    System.out.println("");
                    System.out.println("There is no path from " + source.getLabel()
                            + " to " + graph.vertices[i].getLabel());
                    continue;
                }

                if (i != source.getLabel() - 'A') {
                    System.out.println("");
                    getPath(source, i, parent);
                    System.out.println(" --- route length: " + distance[i]);
                }
            }
        }

    }

    //method to get the path needed to make up the shortest path
    public void getPath(Vertex source, int node, int[] parent) {
        if (graph.vertices[parent[node]].label.equals(source.label)) {
            System.out.print("loc. ");
            source.displayInfo();
            System.out.print(" - ");
            System.out.print("loc. ");
            graph.vertices[node].displayInfo();
        } else {
            getPath(source, parent[node], parent);
            System.out.print(" - ");
            System.out.print("loc. ");
            graph.vertices[node].displayInfo();
            
            
        }

    }

}
