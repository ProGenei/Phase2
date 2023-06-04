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

import GraphFramework.Edge;
import GraphFramework.Vertex;
import GraphFramework.Graph;

//subclass of graph class
public class AFRouteMap extends Graph{
    
    //overriden methods to create route and vertex objects
    @Override
    public Edge createEdge(Vertex source, Vertex target, int weight) {
        Route route = new Route(source, target, weight);
        return route;
    }

    @Override
    public Vertex createVertex(String label, int verticesNo) {
        Location location = new Location(label, verticesNo);
        return location;
    }
    
}
