package command;


import java.util.HashMap;
import java.util.Map;

public class CommandExecuter {
    public static final Map<Operation, Command> allCommand = new HashMap<Operation, Command>();
    static {
        allCommand.put(Operation.KURS_PRIVATEBANK, new PrivateBankCommand());
        allCommand.put(Operation.KURS_OSCHADBANK, new OschadBankCommand());
        allCommand.put(Operation.KURS_AVALBANK, new AvalBankCommand());
        allCommand.put(Operation.EXIT, new ExitCommand());
        allCommand.put(Operation.KURS_OTHERBANK, new OtherBankCommand());
    }
    private CommandExecuter(){}
    public static void execute(Operation operation){
        allCommand.get(operation).execute();
    }
}
