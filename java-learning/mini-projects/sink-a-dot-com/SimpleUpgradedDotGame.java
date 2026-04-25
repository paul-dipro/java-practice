import java.util.Scanner;
import java.util.ArrayList;

class SimpleUpgradedDotGame {
    private ArrayList<String> locationCells;
    
    public void setLocationCells(ArrayList<String> locs) {
       locationCells = locs;
    }

    public String checkYourself(String userGuess) {
        String result = "miss";
        // ArrayList.indexOf returns the position, or -1 if not found
        int index = locationCells.indexOf(userGuess);
          
        if (index > -1) {
            locationCells.remove(index); // it's remove the hit location
            if (locationCells.isEmpty()) {
                result = "kill";
            } else {
                result = "hit";
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleUpgradedDotGame game = new SimpleUpgradedDotGame();
        
        boolean isAlive = true;
        int numOfGuesses = 0;

        int randomNum = (int) (Math.random() * 5);
        ArrayList<String> locations = new ArrayList<String>();
        
        locations.add(Integer.toString(randomNum));
        locations.add(Integer.toString(randomNum + 1));
        locations.add(Integer.toString(randomNum + 2));
        
        game.setLocationCells(locations);

        System.out.println("--- Welcome to Simple Dot Game (ArrayList Edition) ---");

        while (isAlive) {
            System.out.print("Enter a guess: ");
            
            if (sc.hasNextInt()) {
                String userGuess = sc.next(); 
                numOfGuesses++;
                String result = game.checkYourself(userGuess);
                System.out.println(result);

                if (result.equals("kill")) {
                    isAlive = false;
                    System.out.println("You took " + numOfGuesses + " guesses.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                sc.next(); //it's for clearing buffer
            }
        }
        sc.close();
    }
}
