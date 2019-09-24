package Graph;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Component {

    private static final Logger LOGGER = LogManager.getLogger(Component.class);

    private List<Node> nodes = new ArrayList<Node>();

    /**
     * Add node to component if it not exists
     * @param node to add
     */
    public void addNode(Node node){
        LOGGER.debug("Adding new node to component");
        if(!containsNode(node)) {
            this.nodes.add(node);
        }
    }

    /**
     * Get nodes in component
     * @return nodes in component
     */
    public List<Node> getNodes() {
        return nodes;
    }

    /**
     * Merge new component in the present component
     * @param newComponent will be merged
     */
    public void mergeComponent(Component newComponent){
        LOGGER.debug("Merging component '{}' with component '{}'", this, newComponent);
        this.nodes = Stream.concat(nodes.stream(), newComponent.getNodes().stream())
                .distinct()
                .collect(Collectors.toList());
    }

    /**
     * Check if a node is present in this component
     * @param node to be checked
     * @return if a node is present in this component
     */
    public boolean containsNode(Node node){
        return containsNode(node.getValue());
    }

    /**
     * Check if a node is present in this component
     * @param nodeValue to be checked
     * @return if a node is present in this component
     */
    public boolean containsNode(char nodeValue){
        return nodes.stream().anyMatch(node -> node.getValue() == nodeValue);
    }

    /**
     * Print this component
     */
    public void printComponent(){
        nodes.forEach(node -> System.out.print(node.getValue()));
        System.out.println();
    }
}
