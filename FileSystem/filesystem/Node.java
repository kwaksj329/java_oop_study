package filesystem;

public class Node {

    private String name;

    public boolean setName(String n) {
        if (n == null) return false;
        name = n;
        return true;
    }

    public String getName() {
        return name;
    }

    public void print(String tab){

    }
    public Node search (String n){
        return null;
    }
}
