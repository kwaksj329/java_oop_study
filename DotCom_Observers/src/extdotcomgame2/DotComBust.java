package extdotcomgame2;

import dotcomobservers.DamageRate;
import dotcomobservers.SurvivingCells;

import java.util.*;

public class DotComBust {
    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
    private int numOfGuesses = 0;

    public static void main(String[] args) {
        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPlaying();
    }

    public void setUpGame() {
        ShortDotCom one = new ShortDotCom();  one.setName("Pets.com");
        LongDotCom two = new LongDotCom();  two.setName("eToys.com");
        HeavyDotCom three = new HeavyDotCom();  three.setName("Go2.com");

        one.attach(new SurvivingCells(one));
        two.attach(new SurvivingCells(two));
        three.attach(new SurvivingCells(three));
        one.attach(new DamageRate(one));
        two.attach(new DamageRate(two));
        three.attach(new DamageRate(three));

        dotComsList.add(one);
        dotComsList.add(two);
        dotComsList.add(three);

        ArrayList<String>   newLocation;
        newLocation = helper.placeDotCom(one.size());
        one.setLocationCells(newLocation);
        newLocation = helper.placeDotCom(two.size());
        two.setLocationCells(newLocation);
        newLocation = helper.placeDotCom(three.size());
        three.setLocationCells(newLocation);
    }

    public void startPlaying() {
        while(!dotComsList.isEmpty()) {
            String userGuess = helper.getUserInputRandom("Enter a guess");
            checkUserGuess(userGuess);
        }
        this.finishGame();
    }

    private void checkUserGuess(String userGuess) {
        numOfGuesses++;
        String result = " ";
        for (int x = 0; x < dotComsList.size(); x++) {
            result = dotComsList.get(x).checkYourSelf(userGuess);
            if (result.equals("hit")) {
                result += " " + dotComsList.get(x).getName();
                break;
            } else if (result.equals("kill")) {
                result += " " + dotComsList.get(x).getName();
                dotComsList.remove(x);
                break;
            }
        }
        if(!result.equals("miss"))
            System.out.println(result);
    }

    private void finishGame() {
        System.out.println("All Dot Coms are dead!");
        if (numOfGuesses <= 18) {
            System.out.println("It only took you " + numOfGuesses + " guesses.");
        } else {
            System.out.println("Took you long enough. " + numOfGuesses + " guesses.");
        }
    }
}