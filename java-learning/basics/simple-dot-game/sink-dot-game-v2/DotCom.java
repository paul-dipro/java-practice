import java.util.Scanner;
import java.util.ArrayList;

class DotCom {
    private String shipName;
    private ArrayList<String> locationCells;

    public void setName(String shipN) {
        shipName = shipN;
    }

    public void setLocation(ArrayList<String> locs) {
        locationCells = locs;
    }

    public String checkYourself(String userInput) {
        String result = "miss";
        int index = locationCells.indexOf(userInput);

        if (index > -1) {
            locationCells.remove(index);
            if (locationCells.isEmpty()) {
                result = "kill";
                System.out.println("Ouch! You sunk " + shipName);
            } else {
                result = "hit";
            }
        }
        return result;
    }
}
