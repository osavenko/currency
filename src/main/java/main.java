import command.CommandExecuter;
import command.Operation;
import command.OschadBankCommand;
import model.AvalBank;
import model.CurrencyPair;
import model.OschadBank;
import model.PrivateBank;

import java.util.List;

public class main {
    public static void main(String[] args) {
        CommandExecuter.execute(Operation.KURS_OSCHADBANK);
    }
}
