package Client;

public interface Builder {

    Builder setName(String name);
    Builder setSurname(String surname);
    Builder setAddress(String address);
    Builder setPassport(String passport);
    Client build();
}
