package src.Types;

import java.util.UUID;

public class Identification {
    protected String name;
    protected String id;

    protected Identification(String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
    }

    public String getName() {
        return this.name;
    }

    public String getId() {
        return this.id;
    }
}
