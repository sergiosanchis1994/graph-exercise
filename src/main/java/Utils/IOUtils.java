package Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOUtils {

    private static final String MAIN_TEXT = "Please, select option desired:\n 1. Introduce Graph\n 2. Show usage\n 0. Exit";
    private static final String USAGE_TITLE = "\n## USAGE ##";
    private static final String WONDER = "Given a non-directed graph, all connected components will be printed line by line.";
    private static final String INPUT_INSTRUCTIONS = "To enter a graph, you only have to enter the numbers in pairs that will form an edge. Empty values are not allowed. For example:\n011234";
    private static final String OUTPUT_INSTRUCTIONS = "In the output, all related nodes will be shown in separate rows. For example:\n012\n34";
    private static final String ERROR_OPTION = "This is not a valid option.";
    private static final String NUMBER_FORMAT_EXCEPTION = "Input must be a number.";
    private static final String IO_EXCEPTION = "Input throws an unexpected error.";
    private static final String INTRODUCE_GRAPH = "Please, introduce a graph";


    /**
     * Print main text
     */
    public static void printMain(){
        System.out.println(MAIN_TEXT);
    }

    /**
     * Print insert graph instructions
     */
    public static void printInsertGraph(){
        System.out.println(INTRODUCE_GRAPH);
        System.out.println(INPUT_INSTRUCTIONS);
    }

    /**
     * Print usage instructions
     */
    public static void printUsage(){
        System.out.println(USAGE_TITLE);
        System.out.println(WONDER);
        System.out.println(INPUT_INSTRUCTIONS);
        System.out.println(OUTPUT_INSTRUCTIONS);
    }

    /**
     * Print any message in red indicating that this is an error message
     * @param message which will be printed
     */
    public static void printErrorMessage(String message){
        System.out.println("ERROR: " + message);
    }

    /**
     * Print error option
     */
    public static void printErrorOption(){
        printErrorMessage(ERROR_OPTION);
    }

    /**
     * Print number format exception
     */
    public static void printNumberFormatException(){
        printErrorMessage(NUMBER_FORMAT_EXCEPTION);
    }

    /**
     * Print IO Error message exception
     */
    public static void printIOException(){
        printErrorMessage(IO_EXCEPTION);
    }

    /**
     * Receives user input
     * @return user input
     * @throws IOException if exists any problem receiving the input data
     */
    public static String getUserInput() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }
}
