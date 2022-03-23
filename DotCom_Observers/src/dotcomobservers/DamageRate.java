package dotcomobservers;

import extdotcomgame2.DotCom;

import java.util.ArrayList;

public class DamageRate implements Observer{

    private DotCom subject;

    public DamageRate(DotCom s){
        subject = s;
    }

    public void update(){
        int num = 0;
        double rate = 0;
        ArrayList<String> state = subject.getState();
        double s = subject.size();
        for(String a : state){
            num++;
        }
        rate = 100*(s - num)/s;
        System.out.printf("Damage rate of %s : %.2f%%", subject.getName(), rate);
        System.out.println("");
    }
}
