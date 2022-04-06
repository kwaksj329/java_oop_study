public class LinkedList {

    private Node mData;
    private int mSize;

    public boolean insert(int key, double value){
        Node newnode = new Node();
        newnode.setKey(key);
        newnode.setValue(value);
        if (mData != null){
            Node lastnode = mData;
            for ( ; lastnode.getNext() != null ; lastnode = lastnode.getNext()){
                if (key == lastnode.getKey())
                    return false;
            }
            if (key == lastnode.getKey())
                return false;
            lastnode.setNext(newnode);
        }else{
            mData = newnode;
        }
        mSize++;
        return true;
    }

    public boolean delete(int key){
        Node preNode = mData;
        Node nextNode = mData.getNext();

            while (nextNode != null) {
                if (preNode.getKey() == key) {
                    mData = mData.getNext();
                    mSize--;
                    return true;
                }
                if (nextNode.getKey() == key) {
                    preNode.setNext(nextNode.getNext());
                    mSize--;
                    return true;
                }
                preNode = nextNode;
                nextNode = preNode.getNext();
            }
        return false;
    }

    public void print(){
        System.out.println("List: "+ mSize  + "elements");
        for(Node node = mData ; node != null ; node = node.getNext()){
            System.out.println("    (" + node.getKey() + ", " + node.getValue() + ")    ");
        }
    }
}
