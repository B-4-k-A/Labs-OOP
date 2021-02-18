package Client;

import java.util.UUID;

public class Client {
    public String id;
    private String name;
    private String surname;
    private String address;
    private String passport;

    public Client(String name, String surname, String address, String passport) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.passport = passport;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public String getPassport() {
        return passport;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (!id.equals(client.id)) return false;
        if (!name.equals(client.name)) return false;
        if (!surname.equals(client.surname)) return false;
        if (address != null ? !address.equals(client.address) : client.address != null) return false;
        return passport != null ? passport.equals(client.passport) : client.passport == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (passport != null ? passport.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + surname;
    }
}
