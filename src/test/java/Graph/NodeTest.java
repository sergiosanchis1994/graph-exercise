package Graph;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(JUnit4.class)
public class NodeTest {

    private static final char NODE_VALUE = '1';

    @Test
    public void verify_nodeConstructor_createNewNodeWithInputValue(){
        Node node = new Node(NODE_VALUE);
        assertEquals(NODE_VALUE, node.getValue());
    }

    @Test
    public void verify_twoNodesWithSameValues_areDetectedAsEquals(){
        Node node1 = new Node(NODE_VALUE);
        Node node2 = new Node(NODE_VALUE);
        assertEquals(node1, node2);
    }
}
