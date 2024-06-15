package game;

//Defines subclass extending superclass Player
public class ComputerPlayerAlgorithm extends Player {
    
    public ComputerPlayerAlgorithm(String userId){
        //Calls superclass constructor
        super(userId);
    }

    //Uses modulo to pick either 1 or 2 pins
    public int takePins(Board b){
        if(b.getNoPins() % 2 == 0){
            return 2;
        }
        else{
            return 1;
        }
        
    }

}
