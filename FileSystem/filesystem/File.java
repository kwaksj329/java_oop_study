package filesystem;

public class File extends Node{
    private int size;

    public File(String n , int s){
        setName(n);
        setSize(s);
    }

    public boolean setSize(int s){
        if ( s < 0) return false;
        size = s;
        return true;
    }
    public int getSize(){
        return size;
    }
    public void print (String tab){
        System.out.println(tab+getName() + "  size = " + size);
    }
    public Node search (String n){

        if (this.getName().equals(n)){
            return this;
        }
        return null;
    }
}
