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
package AirFreightApp;

import GraphFramework.Vertex;
import GraphFramework.Edge;

//subclass of edge class
public class Route extends Edge{
    //constructors
    public Route(Vertex source, Vertex target, Vertex parent, int weight) {
        super(source, target, parent, weight);
    }
    
    public Route(Vertex source, Vertex target, int weight) {
        super(source, target, weight);
    }
    
    @Override
    public void displayInfo(){
        System.out.println("--- route length: ");
    }
    
}
