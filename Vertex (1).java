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

import java.util.LinkedList;

//vertex class of graph
public abstract class Vertex {
    
    // attributes 
    public String label;
    boolean isVisited;
    LinkedList<Edge> adjList;

    //constructors
    public Vertex(String label) {
        this.label = label;
        this.isVisited = false;
        this.adjList = new LinkedList<Edge>();
    }

    //abstract set and get methods overriden by subclass
    public abstract void setLabel(String label);

    public abstract char getLabel();
    
    //display will be overriden by subclass
    public abstract void displayInfo();
    
}
