package game;

public class TakePinsGame {

    //Main method, starting the game
    public static void main(String[] args) {
        
        //Create board
        Board b1 = new Board();
        //Set up how many pins on the board
        b1.setUp(10);
        
        //Human player created
        Player hp = new HumanPlayer("Player");
        
        //Creating computer player that picks a random number of pins [1, 2]
        //Player cp = new ComputerPlayer("Computer");
        
        //Creating computer player that picks number of pins depending on number of pins left modulo 2
        Player cp = new ComputerPlayerAlgorithm("Computer");

        //Loop, running game until somebody wins
        while(b1.getNoPins() > 0){
            //Prints out nbr of pins
            System.out.println("Antalet pinnar: " + b1.getNoPins());
            //Calls the human player to draw pins and removes from board
            b1.takePins(hp.takePins(b1));
            //Checks win condition, if win, breaks loop and prints winner
            if(b1.getNoPins() <= 0){
             System.out.println(hp.getUserId() + " har vunnit");
             break;   
            }
            System.out.println("Antalet pinnar: " + b1.getNoPins());
            b1.takePins(cp.takePins(b1));
            //Checks win condition, if win, breaks loop and prints winner
            if(b1.getNoPins() <= 0){
                System.out.println(cp.getUserId() + " har vunnit");
                break;
            }
        }
    }

}
