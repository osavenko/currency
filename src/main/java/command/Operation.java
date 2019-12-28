package command;

import exeption.InterruptOperationException;

public enum Operation {
    EXIT,
    KURS_PRIVATEBANK,
    KURS_AVALBANK,
    KURS_OSCHADBANK,
    KURS_OTHERBANK    ;
    public static Operation getOperationByOrdinal(int i) throws InterruptOperationException {
        switch (i){
            case 0:
                return Operation.EXIT;
            case 1:
                return Operation.KURS_PRIVATEBANK;
            case 2:
                return Operation.KURS_OSCHADBANK;
            case 3:
                return Operation.KURS_AVALBANK;
            case 4:
                return Operation.KURS_OTHERBANK;

        }
        throw new InterruptOperationException();
    }
}
