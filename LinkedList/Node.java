public class Node {

    private Node mNext;
    private int mKey;
    private double mValue;

    public void setNext(Node node){
        mNext = node;
    }
    public void setKey(int key){
        mKey = key;
    }
    public void setValue(double value){
        mValue = value;
    }
    public Node getNext(){
        return mNext;
    }
    public int getKey(){
        return mKey;
    }
    public double getValue(){
        return mValue;
    }

}
