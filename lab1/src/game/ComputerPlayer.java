package game;

public class ComputerPlayer extends Player {
    //Constructor
    public ComputerPlayer(String userId){
        //Calls superclass constructor
        super(userId);
    }

    //using Math.random to take either 1 or 2 pins
    public int takePins(Board b){
        double rand = Math.random();
        if(rand <= 0.5){
            return 1;
        }
        else{
            return 2;
        } 
    }
}
