package command;

import model.PrivateBank;

public class PrivateBankCommand implements Command{
    public void execute() {
        Bank pb = new Bank(new PrivateBank(), "Приватбанк");
        pb.execute();
    }
}
