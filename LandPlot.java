package farm;

public class LandPlot {
    protected int id;
    protected String name;
    protected double area;
    protected String location;

    public LandPlot(int id, String name, double area, String location) {
        setId(id);
        setName(name);
        setArea(area);
        setLocation(location);
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
    public double getArea() { return area; }
    public final void setArea(double area) {
        if (!Double.isFinite(area) || area <= 0)
            throw new IllegalArgumentException("Площа має бути скiнченною та додатною");
        this.area = area;
    }
    public String getLocation() { return location; }
    public final void setLocation(String location) { this.location = location; }
    public void showSowingHistory() {
        System.out.println("LandPlot.showSowingHistory(): iсторiя дiлянки " + name);
    }
    public void checkSowingArea(double sowingArea) {
        if (!Double.isFinite(sowingArea) || sowingArea <= 0 || sowingArea > area)
            throw new IllegalArgumentException("Посiвна площа має бути в межах дiлянки");
        System.out.println("LandPlot.checkSowingArea(): доступно " + area + " га");
    }
}
