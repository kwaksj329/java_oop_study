package extdotcomgame2;

import java.io.*;
import java.util.*;

public class GameHelper {
    private static final String alphabet = "adcdefg";
    private int gridLength = 7;
    private int gridSize = 49;
    private int [] grid = new int[gridSize];

    private int comCount = 0;

    public String getUserInput(String prompt) {
        String inputLine = null;
        System.out.print(prompt + " ");
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() == 0)
                return null;
        } catch(IOException e) {
            System.out.println("IOException: " + e);
        }
        return inputLine.toLowerCase();
    }

    private Random generator = new Random(10);
    public String getUserInputRandom(String prompt) {
        String inputLine = null;
        int row = (int)(generator.nextDouble()*gridLength);
        int col = (int)(generator.nextDouble()*gridLength);

        String temp = String.valueOf(alphabet.charAt(col));
        temp = temp.concat(Integer.toString(row));
        return temp;
    }

    public ArrayList<String> placeDotCom(int comSize) {
        ArrayList<String> alphaCells = new ArrayList<String>();

        int [] coords = new int[comSize];
        int attempts = 0;
        boolean success = false;
        int location = 0;

        comCount++;
        int incr = ((comCount % 2) == 1) ? gridLength : 1;

        while(!success && attempts++ <200) {
            location = (int)(Math.random()*gridSize);
            int x = 0;
            success = true;
            while(success && x < comSize) {
                if(grid[location] == 0) {
                    coords[x++] = location;
                    location += incr;
                    if(location >= gridSize || (x > 0 && (location % gridLength == 0))) {
                        success = false;
                    }
                } else {
                    success = false;
                }
            }
        }

        int x = 0;
        while(x < comSize) {
            grid[coords[x]] = 1;
            int row = coords[x] / gridLength;
            int colum = coords[x] % gridLength;
            String temp = String.valueOf(alphabet.charAt(row));

            alphaCells.add(temp.concat(Integer.toString(colum)));
            x++;
        }
        return alphaCells;
    }
}