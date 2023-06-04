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

//subclass of Vertex class
public class Location extends Vertex{
    //attribute
    private String city;
            
    //constructors
    public Location(String label, int verticesNo) {
        super(label);
        this.setLabel(label);
        city = "city " + verticesNo;
    }
    
    //set label method with including a unique number
    @Override
    public void setLabel(String label){
        //set the label as a unique number added to loc. 
        this.label = "loc. " + (label.charAt(0)-65);
    }

    //getter method
    @Override
    public char getLabel() {
        return (char) (Integer.parseInt(label.substring(5)) + 65);
    } 
    
    @Override
    public void displayInfo(){
        System.out.print(this.getLabel() + ": " + city);
    }
    
}
