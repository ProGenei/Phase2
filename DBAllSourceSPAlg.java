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


//class which uses single source class by passing a different vertices 
public class DBAllSourceSPAlg extends ShortestPathAlgorithm{
    
    //constructor
    public DBAllSourceSPAlg(Graph graph){
        super(graph);
    }
    
    //method to compute djikstra algorithm for all sources by using single source class
    public void computeDijkstraBasedSPAlg(boolean flag){
        int verticesNo = graph.verticesNo;
        SingleSourceSPAlg Single = new SingleSourceSPAlg(graph);
        for (int sourceVertex = 0; sourceVertex < verticesNo; sourceVertex++) {
            if (flag) {
                System.out.println("\nThe starting point location is " + graph.vertices[sourceVertex].getLabel());
                System.out.println("The routes from location " + graph.vertices[sourceVertex].getLabel()
                        + " to the rest of the locations are:");
            }
            Single.computeDijkstraAlg(graph.vertices[sourceVertex], flag);
            if (flag) {
                System.out.println("_________________________________________________________\n");
            }

        }
    }
    
}
