package filesystem;

import java.util.ArrayList;

public class Folder extends Node {
    private ArrayList<Node> nodelist = new ArrayList<>();

    public Folder(String n) {
        setName(n);
    }

    public boolean add(Node n) {
        if (n == null) return false;
        nodelist.add(n);
        return true;
    }

    public void print(String tab) {
        System.out.println(tab + getName());
        for (Node n : nodelist) {
            n.print(tab + "  ");
        }
    }

    public Node search(String n) {

        if (this.getName().equals(n)){
            return this;
        }
        for (Node node : nodelist) {
            Node found = node.search(n);
            if (found != null)
                return found;
        }
        return null;
    }
}

