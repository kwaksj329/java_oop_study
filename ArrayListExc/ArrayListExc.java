package practice07;

import java.util.ArrayList;

public class ArrayListExc extends ArrayList<String> {
    public String setExc(int index, String elem) throws ArrayListOutOfBoundException{
        if (index < 0 || index > this.size()-1)
            throw new ArrayListOutOfBoundException(index);
        return this.set(index, elem);
    }
    public String getExc(int index) throws ArrayListOutOfBoundException{
        if (index < 0 || index > this.size()-1)
            throw new ArrayListOutOfBoundException(index);
        return this.get(index);
    }
    public String removeExc(int index) throws ArrayListOutOfBoundException{
        if (index < 0 || index > this.size()-1)
            throw new ArrayListOutOfBoundException(index);
        return this.remove(index);
    }
    public int indexOfExc(String str) throws ArrayListStringNotFoundException{
        int idx = this.indexOf(str);
        if (idx < 0)
            throw new ArrayListStringNotFoundException(str);
        return idx;
    }
    public boolean removeExc(String str) throws ArrayListStringNotFoundException{
        boolean b = this.remove(str);
        if (!b)
            throw new ArrayListStringNotFoundException(str);
        return b;
    }
}
