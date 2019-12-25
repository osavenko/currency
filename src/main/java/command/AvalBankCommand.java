package command;

import model.AvalBank;

public class AvalBankCommand implements Command{
    public void execute() {
        Bank ab = new Bank(new AvalBank(),"Аваль");
        ab.execute();
    }
}
