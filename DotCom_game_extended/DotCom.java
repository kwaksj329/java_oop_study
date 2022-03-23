package extdotcomgame2;

import java.util.*;

public class DotCom {
    protected ArrayList<String> locationCells;
    protected String name;

    public void setLocationCells(ArrayList<String> loc) {
        locationCells = (ArrayList<String>)loc.clone();
    }

    public void setName(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    public String checkYourSelf(String userInput) {
        String result = "miss";

        int index = locationCells.indexOf(userInput);
        if(index >= 0) {
            locationCells.remove(index);
            if(locationCells.isEmpty()) {
                result = "kill";
                System.out.println("You sunk " + name);
            } else {
                result = "hit";
            }
        }
        return result;
    }
}