package game;
import java.util.Scanner;

public class HumanPlayer extends Player {
    //Scanner obj, to read data from user
    Scanner scan = new Scanner(System.in);
    //Constructor
    public HumanPlayer(String userId){
        //Calls superclass constructor
        super(userId);
    }

    //Takes and returns specified number of pins
    public int takePins(Board b){
        return scan.nextInt();
    }


}
