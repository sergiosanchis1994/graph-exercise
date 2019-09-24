package Graph;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Node {

    private static final Logger LOGGER = LogManager.getLogger(Node.class);

    private char value;

    /**
     * Constructor
     * @param value which will have the node
     */
    public Node(char value) {
        LOGGER.debug("Creating new Node with value '{}'", value);
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
