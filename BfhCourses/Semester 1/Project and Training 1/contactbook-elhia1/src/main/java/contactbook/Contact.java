package contactbook;

public class Contact {
    private String name;
    private String email;
    private String phoneNumber;

    public Contact (String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    public String getName() {
        return name;
    }
}
