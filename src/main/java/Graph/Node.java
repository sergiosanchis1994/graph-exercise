package Graph;

public class Node {

    private char value;

    /**
     * Constructor
     * @param value which will have the node
     */
    public Node(char value) {
        this.value = value;
    }

    /**
     * Get value
     * @return value
     */
    public char getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Node) return ((Node) obj).getValue() == this.value;
        return super.equals(obj);
    }
}
