package Utils;

public class IOUtils {

    private static final String USAGE_TITLE = "## USAGE ##";
    private static final String WONDER = "Given a non-directed graph, all connected components will be printed line by line.";
    private static final String INPUT_INSTRUCTIONS = "To enter a graph, you only have to enter the numbers in pairs that will form an edge. For example, 011234";
    private static final String OUTPUT_INSTRUCTIONS = "In the output, all related nodes will be shown in separate rows. For example:\n012\n34";

    public static void printUsage(){
        System.out.println(USAGE_TITLE);
        System.out.println(WONDER);
        System.out.println(INPUT_INSTRUCTIONS);
        System.out.println(OUTPUT_INSTRUCTIONS);
    }
}
