import command.CommandExecuter;
import command.Operation;
import exeption.InterruptOperationException;

import java.io.IOException;


public class main {
    public static void main(String[] args) {
        try {
            Operation requiredOperation = null;
            do {
                ConsoleHelper.printMenu();
                requiredOperation = ConsoleHelper.getOperation();
                CommandExecuter.execute(requiredOperation);
            } while (requiredOperation != Operation.EXIT);
        }catch (IOException ignore){} catch (InterruptOperationException e) {
            e.printStackTrace();
        }

    }
}
