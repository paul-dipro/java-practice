import java.util.Scanner;
import java.util.ArrayList;

class DotComBust {
    private int numOfGuesses;
    private ArrayList<DotCom> dotComsList;
    
    public void setUpGame() {
        dotComsList = new ArrayList<DotCom>();

        DotCom one = new DotCom();
        one.setName("Pets.com");
        dotComsList.add(one);

        DotCom two = new DotCom();
        two.setName("eToys.com");
        dotComsList.add(two);

        DotCom three = new DotCom();
        three.setName("Go2.com");
        dotComsList.add(three);

        ArrayList<String> locationsOne = new ArrayList<String>(); 
        locationsOne.add("1");
        locationsOne.add("2");
        locationsOne.add("3");
        one.setLocation(locationsOne);

        ArrayList<String> locationsTwo = new ArrayList<String>();
        locationsTwo.add("7");
        locationsTwo.add("3");
        locationsTwo.add("5");
        two.setLocation(locationsTwo);

        ArrayList<String> locationsThree = new ArrayList<String>();
        locationsThree.add("7");
        locationsThree.add("9");
        locationsThree.add("2");
        three.setLocation(locationsThree);
    }

    public void checkUserGuess(String userGuess) {
    numOfGuesses++;
    String result = "miss";
    DotCom killedDotCom = null;

    for (DotCom dotComToTest : dotComsList) {
        result = dotComToTest.checkYourself(userGuess);

        if (result.equals("hit")) {
            break;
        }

        if (result.equals("kill")) {
            killedDotCom = dotComToTest;
            break;
        }
    }

    if (killedDotCom != null) {
        dotComsList.remove(killedDotCom);
    }

    System.out.println(result);
}

    public void finishGame() {
        if (dotComsList.isEmpty()) {
            System.out.println("All Dot Coms are dead!");
            System.out.println("You Took: " + numOfGuesses + " Guesses!");
        }
    }

    public static void main(String[] args) {
        DotComBust game = new DotComBust();
        game.setUpGame();

        Scanner scanner = new Scanner(System.in);

        while (!game.dotComsList.isEmpty()) {
            System.out.print("Enter a guess: ");
            String userGuess = scanner.nextLine();
            game.checkUserGuess(userGuess);
        }

        game.finishGame();
        scanner.close();
    }
}