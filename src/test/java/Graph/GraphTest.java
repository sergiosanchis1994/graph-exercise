package Graph;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

@RunWith(JUnit4.class)
public class GraphTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void verify_constructor_createGraphWithNodes() throws Exception {
        Graph graph = new Graph("1224");
        assertTrue(graph.getComponents().get(0).getNodes().contains(new Node('1')));
        assertTrue(graph.getComponents().get(0).getNodes().contains(new Node('2')));
        assertTrue(graph.getComponents().get(0).getNodes().contains(new Node('4')));
        assertEquals(3, graph.getComponents().get(0).getNodes().size());
    }

    @Test
    public void verify_checkInputGraph_throwsAnException_whenInputGraphHasNotPairLength() throws Exception {
        expectedException.expect(Exception.class);
        expectedException.expectMessage("Input graph has not been introduced correctly.");
        new Graph("123");
    }

    @Test
    public void verify_checkInputGraph_throwsAnException_whenInputGraphHasInvalidChars() throws Exception {
        expectedException.expect(Exception.class);
        expectedException.expectMessage("Input graph has not been introduced correctly.");
        new Graph("12w3");
    }

    @Test
    public void verify_addNodes_mergeComponents_whenNodesExistingInTwoComponents() throws Exception {
        Graph graph = new Graph("1234");
        assertEquals(2, graph.getComponents().size());
        graph.addNodes('2','3');
        assertEquals(1, graph.getComponents().size());
    }

    @Test
    public void verify_addNodes_addComponent_whenNodesNoExistsInAnyComponents() throws Exception {
        Graph graph = new Graph("1234");
        assertEquals(2, graph.getComponents().size());
        graph.addNodes('5','6');
        assertEquals(3, graph.getComponents().size());
    }

    @Test
    public void verify_addNodes_updateComponent_whenNodesExistingInTwoComponents() throws Exception {
        Graph graph = new Graph("122345");
        assertEquals(2, graph.getComponents().size());
        assertEquals(3, graph.getComponents().get(0).getNodes().size());
        graph.addNodes('1','8');
        assertEquals(2, graph.getComponents().size());
        assertEquals(4, graph.getComponents().get(0).getNodes().size());
    }
}
