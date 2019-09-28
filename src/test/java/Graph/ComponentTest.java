package Graph;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(JUnit4.class)
public class ComponentTest {

    private final static char NODE_VALUE = '1';

    @Mock
    private Node nodeMock;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        when(nodeMock.getValue()).thenReturn(NODE_VALUE);
    }

    @Test
    public void verify_addNode_addNewNodeWhenItNotExists() {
        Component component = new Component();
        assertTrue(component.getNodes().isEmpty());
        component.addNode(nodeMock);
        assertFalse(component.getNodes().isEmpty());
        assertTrue(component.getNodes().contains(nodeMock));
    }

    @Test
    public void verify_addNode_noAddNewNodeWhenItExists() {
        Component component = new Component();
        component.addNode(nodeMock);
        assertFalse(component.getNodes().isEmpty());
        assertEquals(1, component.getNodes().size());
        component.addNode(nodeMock);
        assertFalse(component.getNodes().isEmpty());
        assertEquals(1, component.getNodes().size());
    }

    @Test
    public void verify_mergeComponent_mergeTwoComponentsWithoutRepetitions() {
        Node node1 = generateNode('1');
        Node node2 = generateNode('2');
        Node node3 = generateNode('3');
        Component component1 = generateComponent(node1, node2);
        Component component2 = generateComponent(node1, node3);
        assertEquals(2, component1.getNodes().size());
        assertEquals(2, component2.getNodes().size());
        component1.mergeComponent(component2);
        assertEquals(3, component1.getNodes().size());
    }

    private Node generateNode(char value) {
        return new Node(value);
    }

    private Component generateComponent(Node... nodes) {
        Component component = new Component();
        for (Node node : nodes) {
            component.addNode(node);
        }
        return component;
    }
}
