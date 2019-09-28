package Graph;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Graph {

    private static final Logger LOGGER = LogManager.getLogger(Graph.class);

    private static final String INVALID_INPUT_EXCEPTION = "Input graph has not been introduced correctly.";
    private static final String OUTPUT_GRAPH_TITLE = "\n## CONNECTED COMPONENTS ##";
    private static final String NUMBER_REGEX = "[0-9]+";

    private List<Component> components = new ArrayList<Component>();

    /**
     * Constructor
     * @param nodes introduced by user
     * @throws Exception throws if input nodes not has correct value
     */
    public Graph(String nodes) throws Exception {
        LOGGER.debug("Creating new Graph");
        checkInputGraph(nodes);

        for(int i = 0; i+1 < nodes.length(); i+=2){
            addNodes(nodes.charAt(i), nodes.charAt(i+1));
        }
    }

    /**
     * Add two char as nodes in graph, both connected between them
     * @param node1 first node to add
     * @param node2 second node to add
     */
    public void addNodes(char node1, char node2) {
        LOGGER.debug("Adding nodes '{}' and '{}'", node1, node2);
        List<Component> componentsContainers = components.stream()
                .filter(component -> component.containsNode(node1) || component.containsNode(node2))
                .collect(Collectors.toList());

        if (componentsContainers.size() == 2) {
            componentsContainers.get(0).mergeComponent(componentsContainers.get(1));
            this.components.remove(componentsContainers.get(1));
        } else {
            Component component = componentsContainers.isEmpty() ? new Component() : componentsContainers.get(0);
            component.addNode(new Node(node1));
            component.addNode(new Node(node2));
            if(componentsContainers.isEmpty()){
                this.components.add(component);
            }
        }
    }

    /**
     * Print the Graph
     */
    public void printGraph(){
        System.out.println(OUTPUT_GRAPH_TITLE);
        components.forEach(component -> component.printComponent());
        System.out.println();
    }

    /**
     * Check if input graph introduced has valid values (pair length and all numeric values)
     * @param inputGraph to check
     * @throws Exception if not has correct length or not match pattern
     */
    private void checkInputGraph(String inputGraph) throws Exception {
        if(inputGraph.length()%2 != 0 || !Pattern.matches(NUMBER_REGEX, inputGraph)) {
            LOGGER.error(inputGraph.length()%2 != 0 ? "Invalid length" : "Input does not match regex");
            throw new Exception(INVALID_INPUT_EXCEPTION);
        }
    }

    public List<Component> getComponents() {
        return components;
    }
}
