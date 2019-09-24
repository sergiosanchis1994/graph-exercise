import Graph.Graph;

import java.io.IOException;

import static Utils.IOUtils.getUserInput;
import static Utils.IOUtils.printErrorMessage;
import static Utils.IOUtils.printErrorOption;
import static Utils.IOUtils.printIOException;
import static Utils.IOUtils.printInsertGraph;
import static Utils.IOUtils.printMain;
import static Utils.IOUtils.printNumberFormatException;
import static Utils.IOUtils.printUsage;

public class Application {

    public static void main(String[] args) {
        runMain();
    }

    private static void runMain() {
        try {
            printMain();
            int userOption = Integer.parseInt(getUserInput());
            switch (userOption) {
                case 1:
                    printInsertGraph();
                    String inputGraph = getUserInput();
                    Graph graph = new Graph(inputGraph);
                    graph.printGraph();
                    break;
                case 2:
                    printUsage();
                    break;
                case 0:
                    System.exit(0);
                default:
                    printErrorOption();
            }
        } catch (IOException e) {
            printIOException();
        } catch (NumberFormatException e) {
            printNumberFormatException();
        } catch (Exception e) {
            printErrorMessage(e.getMessage());
        } finally {
            runMain();
        }
    }
}
