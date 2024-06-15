package game;

public abstract class Player {
    //Protected, reachable from subclasses and class
    protected String userId;

    //Constructor
    protected Player(String userId){
        this.userId = userId;
    }

    //Returns the userId of the player
    public String getUserId(){
        return this.userId;
    }

    //Abstract class for taking pins, needs to be implemented in subclasses
    public abstract int takePins(Board b);

}
