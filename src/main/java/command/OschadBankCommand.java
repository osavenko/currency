package command;

import model.OschadBank;

public class OschadBankCommand implements Command{
    public void execute() {
        Bank ob = new Bank(new OschadBank(), "Ощадбанк");
        ob.execute();
    }
}
