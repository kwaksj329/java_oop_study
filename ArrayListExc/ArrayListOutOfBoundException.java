package practice07;

public class ArrayListOutOfBoundException extends Exception{

    int idx = 0;

    public ArrayListOutOfBoundException(int i){
        this.idx = i;
    }
    public int getIndex(){
        return idx;
    }
}
