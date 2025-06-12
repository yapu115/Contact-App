public class Contact {
    private final String name;
    private String email;
    private String phoneNumber;

    public Contact(String name){
        this.name = name;
    }
    public Contact(String name, String email){
        this(name);
        this.email = email;
    }
    public Contact(String name, String email, String phoneNumber){
        this(name, email);
        this.phoneNumber = phoneNumber;
    }

    public String getName(){
        return this.name;
    }

    public String showInfo(){
        return String.format("Name: %s - Email: %s - Phone number: %s", this.name, this.email, this.phoneNumber);
    }

}
