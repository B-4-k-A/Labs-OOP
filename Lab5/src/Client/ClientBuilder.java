package Client;

public class ClientBuilder implements Builder{
    private String name;
    private String surname;
    private String address;
    private String passport;

    @Override
    public Builder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public Builder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    @Override
    public Builder setAddress(String address) {
        this.address = address;
        return this;
    }

    @Override
    public Builder setPassport(String passport) {
        this.passport = passport;
        return this;
    }

    @Override
    public Client build() {
        return new Client(name, surname, address, passport);
    }
}
