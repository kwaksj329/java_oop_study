package extdotcomgame2;

public class Submarine extends DotCom{

    private boolean underwater = false;
    public int size() {return 3;}

    public String checkYourSelf(String userInput) {

        String result = "miss";
        int index = locationCells.indexOf(userInput);

        if(!underwater){
            if(index >= 0) {
                locationCells.remove(index);
                underwater = true;
                if(locationCells.isEmpty()) {
                    result = "kill";
                    System.out.println("You sunk " + name);
                } else {
                    result = "hit";
                }
            }
        }else if(underwater){
            if(index == -1){
                underwater = false;}
        }
        return result;
    }
}
