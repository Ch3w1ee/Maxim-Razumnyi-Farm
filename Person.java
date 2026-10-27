package farm;

public class Person {
    protected int id;
    protected String fullName;
    protected String phone;

    public Person(int id, String fullName, String phone) {
        setId(id);
        setFullName(fullName);
        setPhone(phone);
    }
    public int getId() { return id; }
    public final void setId(int id) {
        if (id <= 0) throw new IllegalArgumentException("id має бути додатним");
        this.id = id;
    }
    public String getFullName() { return fullName; }
    public final void setFullName(String fullName) {
        if (fullName == null || fullName.trim().isEmpty())
            throw new IllegalArgumentException("Ім'я не може бути порожнiм");
        this.fullName = fullName;
    }
    public String getPhone() { return phone; }
    public final void setPhone(String phone) { this.phone = phone; }
    public void showInfo() {
        System.out.println("Person.showInfo(): " + id + ", " + fullName + ", " + phone);
    }
    public void performWork() {
        System.out.println("Person.performWork(): " + fullName + " виконує загальну роботу");
    }
}
