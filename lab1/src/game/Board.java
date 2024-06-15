package game;

public class Board {
    
    //Attribute, holding the integer value of ammount of pins on the board
    private int pins;

    //Constructor, creating the board obj
    public Board(){
    }

    //Set up the board by choosing the ammount of pins on the board
    public void setUp(int pins){
        this.pins = pins;
    }

    //Remove x pins from board, check if win, if there are x pins to remove etc.
    public void takePins(int x){
        this.pins -= x;

        //Add functionality to check who won, is it zero, below zero, etc?
    }

    //Returning current ammount of pins on the board
    public int getNoPins(){
        return this.pins; 
    }


}
