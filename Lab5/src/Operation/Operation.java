package Operation;

import Account.*;

import java.util.Calendar;
import java.util.UUID;

public abstract class Operation {
    public final String id;
    public final Calendar date;
    protected Account owner;

    public Operation(Account owner, Calendar date) {
        this.id = UUID.randomUUID().toString();
        this.date = date;
        this.owner = owner;
    }

    public abstract void doOperation();

    public abstract void undoOperation();
}
