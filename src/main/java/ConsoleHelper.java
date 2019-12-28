import command.Operation;
import exeption.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    public static void printMenu(){
        System.out.println("Доступные команды:");
        System.out.println("1 - Курсы валют Приватбанка.");
        System.out.println("2 - Курсы валют Ощадбанка.");
        System.out.println("3 - Курсы валют Аваль.");
        System.out.println("4 - Курсы другого бвнка.");
        System.out.println("exit - ДЛЯ ВЫХОДА.");
        System.out.print("[]->");
    }
    public static Operation getOperation() throws IOException, InterruptOperationException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        while(true) {
            input = reader.readLine();
            if (input.toLowerCase().equals("exit")) {
                return Operation.EXIT;
            }
            if (input.matches("[1-4]")){
                break;
            }
        }
        return Operation.getOperationByOrdinal(Integer.parseInt(input));
    }
}
