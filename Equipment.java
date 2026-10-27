package farm;

public class Equipment {
    protected int id;
    protected String name;
    protected double operatingHours;
    String internalCode = "FARM-INTERNAL";

    public Equipment(int id, String name, double operatingHours) {
        setId(id);
        setName(name);
        setOperatingHours(operatingHours);
    }
    public int getId() { return id; }
    public final void setId(int id) {
        if (id <= 0) throw new IllegalArgumentException("id має бути додатним");
        this.id = id;
    }
    public String getName() { return name; }
    public final void setName(String name) {
        if (name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("Назва не може бути порожньою");
        this.name = name;
    }
    public double getOperatingHours() { return operatingHours; }
    public final void setOperatingHours(double operatingHours) {
        if (!Double.isFinite(operatingHours) || operatingHours < 0)
            throw new IllegalArgumentException("Напрацювання має бути скiнченним i невiд'ємним");
        this.operatingHours = operatingHours;
    }
    public void assignWork(int workId) {
        if (workId <= 0) throw new IllegalArgumentException("workId має бути додатним");
        System.out.println("Equipment.assignWork(): " + name + ", робота №" + workId);
    }
    public void checkAvailability() {
        System.out.println("Equipment.checkAvailability(): загальна перевiрка " + name);
    }
    public void recordOperatingHours(double hours) {
        if (!Double.isFinite(hours) || hours < 0)
            throw new IllegalArgumentException("Додатковi години мають бути невiд'ємними");
        setOperatingHours(operatingHours + hours);
        System.out.println("Equipment.recordOperatingHours(): " + operatingHours);
    }
    void showInternalCode() {
        System.out.println("Equipment.showInternalCode(): " + internalCode);
    }
}
