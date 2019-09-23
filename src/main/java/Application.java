import Utils.IOUtils;

import java.io.IOException;

import static Utils.IOUtils.getUserInput;
import static Utils.IOUtils.printErrorOption;
import static Utils.IOUtils.printIOException;
import static Utils.IOUtils.printMain;
import static Utils.IOUtils.printNumberFormatException;
import static Utils.IOUtils.printUsage;

public class Application {

    public static void main(String[] args) {
        runMain();
    }

    private static void runMain(){
        try {
            printMain();
            int userOption = Integer.parseInt(getUserInput());
            switch (userOption){
                case 1:
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
        } finally {
           runMain();
        }
    }
}
