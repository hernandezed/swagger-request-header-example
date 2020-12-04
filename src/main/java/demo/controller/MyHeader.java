package demo.controller;

public class MyHeader {

    private String name;
    private String surname;

    public MyHeader(String header) {
        name = header.split(" ")[0];
        surname = header.split(" ")[1];
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
