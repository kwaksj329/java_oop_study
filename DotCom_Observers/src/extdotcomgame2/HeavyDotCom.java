package extdotcomgame2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class HeavyDotCom extends DotCom {
    public int size() {
        return 3;
    }
    public void setLocationCells(ArrayList<String> locs) {
        if (locs == null)
            return;
        locationCells = (ArrayList<String>)locs.clone();
        locationCells.addAll(locs);
    }

    public ArrayList<String> getState (){

        ArrayList<String> heavydot = (ArrayList<String>)locationCells.clone();
        ArrayList<String> resultList = new ArrayList<String>();

        for (String s : heavydot) {
            if (!resultList.contains(s)){
                resultList.add(s);
            }
        }
        //HeavyDotCom의 남은 cell을 순서대로 sorting 해줌.
        Collections.sort(resultList);
        return resultList;
    }
}