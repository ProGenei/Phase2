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

//edge class of graph
public abstract class Edge {
    //attributes
    public Vertex source;
    public Vertex target;
    public Vertex parent;
    public int weight;

    //constructors
    public Edge(Vertex source, Vertex target, Vertex parent, int weight) {
        this.source = source;
        this.target = target;
        this.parent = parent;
        this.weight = weight;
    }
    
    public Edge(Vertex source, Vertex target, int weight) {
        this.source = source;
        this.target = target;
        this.weight = weight;
    }

    // method will be overriden by subclass
    public abstract void displayInfo();
    
}
