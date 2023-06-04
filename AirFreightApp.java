
/*
CPCS 324 : Algorithms & Data Structures 2 : Group Project Phase2
Air Freight App (Usage of Djikstra Algorithm)
---------------
Ayatun Ara - 2110295 - B0B
Rayana Bander Aljuaid - 2105972 - B0A
Samaher Ismael Fattani - 1905374 - B0A
Ghadeer Mohammed Nooh - 2006705 - B0A
---------------
*///
package AirFreightApp;

import GraphFramework.DBAllSourceSPAlg;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AirFreightApp {
    //static AFRouteMap type for requiremnt 1 or 2
    static AFRouteMap map;
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) throws FileNotFoundException {
        //object AFRoute for requiremnt 1 or 2
        map = new AFRouteMap();
        int input;
        boolean flag = true;
        
        while (flag) {
            printReqMenu();
            input = sc.nextInt();

            switch (input) {
                //requirment1
                case 1:
                    req1();
                    flag = false;
                    break;
                    
                //requirement2
                case 2:
                    req2();
                    flag = false;
                    break;
                default:
                    System.out.print("This was a wrong input, please enter again.");
                    break;
            }
        }
    }

    //-------------------------------------------------------------------------------
    //print requirment menu
    //-------------------------------------------------------------------------------
    public static void printReqMenu() {
        System.out.println("Choose Requirements to compute shortest path:\n"
                + "With Dijkstra algorithm\n\n"
                + "Requirement 1: Read Graph from file\n"
                + "Requirement 2: Randomly generate Graph");
        System.out.print("Enter Requirement: ");

    }

    //-------------------------------------------------------------------------------
    //print second requirement cases menu
    //-------------------------------------------------------------------------------
    public static void printCases() {
        System.out.println("\nCases (n = no. of Locations, m = no. of Routes):\n");
        System.out.println("1:  n =  2000, m = 10000");
        System.out.println("2:  n =  3000, m = 15000");
        System.out.println("3:  n =  4000, m = 20000");
        System.out.println("4:  n =  5000, m = 25000");
        System.out.println("5:  n =  6000, m = 30000");
        System.out.print("\nEnter case: ");

    }

    //-------------------------------------------------------------------------------
    //the method for requirment 1 which is reading the graph from the file
    //-------------------------------------------------------------------------------
    public static void req1() throws FileNotFoundException {
        File InputFile = new File("CPCS324.txt");
        if (!InputFile.exists()) {
            System.out.println("The input file does not exist");
        } else {
            //read graph from file in map object
            map.readGraphFromFile(InputFile);
            //create all sources object, compute all sources and print them
            DBAllSourceSPAlg allSource = new DBAllSourceSPAlg(map);
            allSource.computeDijkstraBasedSPAlg(true);

        }
    }
    
    //-------------------------------------------------------------------------------
    //the method for requirment 2 which is generating a new graph out of 5 cases
    //-------------------------------------------------------------------------------
    public static void req2() {
        //intialize variables
        int vertex = 0;
        int edge = 0;
        int caseNum;

        //loop till correct case input
        boolean flag = true;
        while (flag) {
            //print the cases that ask for all the necessary inputs
            printCases();
            caseNum = sc.nextInt();
            switch (caseNum) {
                case 1:
                    vertex = 2000;
                    edge = 10000;
                    flag = false;
                    break;
                case 2:
                    vertex = 3000;
                    edge = 15000;
                    flag = false;
                    break;
                case 3:
                    vertex = 4000;
                    edge = 20000;
                    flag = false;
                    break;
                case 4:
                    vertex = 5000;
                    edge = 25000;
                    flag = false;
                    break;
                case 5:
                    vertex = 6000;
                    edge = 30000;
                    flag = false;
                    break;
                default:
                    System.out.println("This was a wrong input, please enter again.");
            }
        }
        
             
        System.out.print("Enter 'yes' if map is directed, or else 'no': ");
        
        //initialise diagraph boolean 
        boolean digraphBool = false;
        String digraph = sc.next();
        //diagraph is true if user enter yes or else no
        if (digraph.equalsIgnoreCase("yes")) {
            digraphBool = true;
        }

        //make random graph of map object
        map.makeGraph(vertex, edge, digraphBool); 

        //make all sources object and invoke method to compute
        DBAllSourceSPAlg allSourcesObj = new DBAllSourceSPAlg(map);
        long startTime = System.currentTimeMillis();
        allSourcesObj.computeDijkstraBasedSPAlg(false);
        long endTime = System.currentTimeMillis();
        
        //save time required for the all sources method to compute
        long elapsedTime = endTime - startTime;
        System.out.println("\nThe total runtime of Djikstra Algorithm for All Sources is: " + elapsedTime + " ms");

    }
}
