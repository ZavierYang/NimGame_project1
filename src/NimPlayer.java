import java.util.Scanner;

//Create players.
public class NimPlayer {
    private String player;
    
    public NimPlayer(String name){
        this.player = name;
    }
    
    //Return player's name.
    public String getPlayer(){
        return this.player;
    }

    //Return how many stones do player want to reduce.
    public int removeStone(Scanner input){
        return input.nextInt();
    }

    //Overload equals function to compare with current player.
    public boolean equals(Object player) {
        return this == player;
    }
}