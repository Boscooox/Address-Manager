public class Contact {
    String name;
    String phone;
    String address;

    public Contact(String name, String phone, String address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public String toString() {
        return "Name: " + name + ", Phone: " + phone + ", Address: " + address;
    }
}

