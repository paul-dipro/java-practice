import java.util.Scanner;

class SinkDotComGame {

    private int[] locationCells;
    private int numOfHits = 0;

    public void setLocationCells(int[] locs) {
        locationCells = locs;
    }

    public String checkYourself(String userGuess) {
      
        String result = "miss";
        int guess = Integer.parseInt(userGuess);

        for (int i = 0; i < locationCells.length; i++) {
          
            if (guess == locationCells[i] && locationCells[i] != -1) {
                result = "hit";
                numOfHits++;
                locationCells[i] = -1;
                break;
            }
        }

        if (numOfHits == locationCells.length) {
            result = "kill";
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleDotGame game = new SimpleDotGame();
        
        int numOfGuesses = 0;
        boolean isAlive = true;

        int randomNum = (int) (Math.random() * 5);
        int[] locations = {randomNum, randomNum + 1, randomNum + 2};
        game.setLocationCells(locations);

        System.out.println("--- Welcome to Simple Dot Game ---");

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
                sc.next(); 
            }
        }
        sc.close();
    }
}
