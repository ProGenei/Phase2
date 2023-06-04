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

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

//graph class
public abstract class Graph {

    // attributes
    int verticesNo;
    int edgeNo;
    boolean isDigraph;
    Vertex vertices[];

    //method to make randomized graph based on its parameters
    public void makeGraph(int vertexNum, int edgeNum, boolean isDigraph) {
        //save in attributes
        this.isDigraph = isDigraph;
        this.vertices = new Vertex[vertexNum];

        //create vertex object for all vertices in the graph
        for (int i = 0; i < vertexNum; i++) {
            //increment no. of vertices
            this.verticesNo++;
            vertices[i] = createVertex(((char) (i + 65)) + "", verticesNo);
        }

        //choices array of vertices
        int c[] = new int[vertexNum];

        for (int i = 0; i < edgeNum; i++) {
            //assign random weights
            int weight = 1 + (int) (Math.random() * 100);
            
            //first and second vertex
            int vertex1, vertex2;
            if (i < vertexNum - 1) {
                do {
                    vertex1 = (int) (Math.random() * vertexNum);
                } while (c[vertex1] == 2);
                c[vertex1]++; //increment for vertex1
                
                do {
                    vertex2 = (int) (Math.random() * vertexNum);
                } while (c[vertex2] == 2);
                c[vertex2]++; //increment for vertex2
                
            } else {
                //assign random integers
                vertex1 = (int) (Math.random() * (vertexNum));
                vertex2 = (int) (Math.random() * (vertexNum));

                boolean check;
                do {
                    check = true;
                    vertex1 = (int) (Math.random() * (vertexNum));
                    vertex2 = (int) (Math.random() * (vertexNum));
                    if (vertex2 != vertex1) {
                        check = false;
                        continue;
                    }
                    for (int j = 0; j < vertices[vertex1].adjList.size(); j++) {
                        if (vertices[vertex1].adjList.get(j).target.label != (vertices[vertex2].label)) {
                            check = false;
                            break;
                        }
                    }
                } while (check);
            }
            //increment once
            this.edgeNo ++;
            
            //if it is a digraph add one edge
            addEdge(vertices[vertex1], vertices[vertex2], weight);
            //if it is not a digraph then add both edges in opposite direction
            if (!isDigraph) {
                addEdge(vertices[vertex2], vertices[vertex1], weight);
                this.edgeNo ++; //got incremented twice
            }
        }

    }

    //method to read graph from input file 
    public void readGraphFromFile(File InputFile) throws FileNotFoundException {
        Scanner input = new Scanner(InputFile);
        if ("digraph 1".equals(input.nextLine())) {
            this.isDigraph = true;
        }

        // read num of vertices
        int vertexNum = input.nextInt();
        // read num of edges
        int edgeNum = input.nextInt();

        //assign vertices array
        this.vertices = new Vertex[vertexNum];
        
        //read vertices and weights for each edge
        for (int i = 0; i < edgeNum; i++) {
            String s1 = input.next();
            String s2 = input.next();
            int w = input.nextInt();

            // add vertices
            if (vertices[(s1.charAt(0)) - 'A'] == null) {
                this.verticesNo++;
                vertices[(s1.charAt(0)) - 'A'] = createVertex(s1, verticesNo);
            }
            if (vertices[(s2.charAt(0)) - 'A'] == null) {
                this.verticesNo++;
                vertices[(s2.charAt(0)) - 'A'] = createVertex(s2, verticesNo);
            }

            // add edges
            this.edgeNo++;
            addEdge(vertices[(s1.charAt(0)) - 'A'], vertices[(s2.charAt(0)) - 'A'], w);
            if (!isDigraph) {
                this.edgeNo++;
                addEdge(vertices[(s2.charAt(0)) - 'A'], vertices[(s1.charAt(0)) - 'A'], w);
            }
        }
    }

    //method to add edge in adj list
    public Edge addEdge(Vertex v, Vertex u, int w) {
        v.adjList.add(createEdge(v, u, w));
        return createEdge(v, u, w);
    }

    //abstract methods will be overridden in subclass
    public abstract Edge createEdge(Vertex source, Vertex target, int weight);

    public abstract Vertex createVertex(String label, int verticesNo);

}
