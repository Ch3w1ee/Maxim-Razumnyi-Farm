package farm;

public class Machinery extends Equipment {
    private String inventoryNumber;
    private String type;
    private String brand;
    private String model;
    private int manufactureYear;
    private String technicalCondition;
    private int responsibleEmployeeId;
    private int farmId;

    public Machinery(int id, String inventoryNumber, String name,
                     String type, String brand, String model,
                     int manufactureYear, String technicalCondition,
                     double operatingHours, int responsibleEmployeeId,
                     int farmId) {
        super(id, name, operatingHours);
        setInventoryNumber(inventoryNumber);
        setType(type);
        setBrand(brand);
        setModel(model);
        setManufactureYear(manufactureYear);
        setTechnicalCondition(technicalCondition);
        setResponsibleEmployeeId(responsibleEmployeeId);
        setFarmId(farmId);
    }

    public String getInventoryNumber() { return inventoryNumber; }

    public void setInventoryNumber(String inventoryNumber) { this.inventoryNumber = inventoryNumber; }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }

    public String getBrand() { return brand; }

    public void setBrand(String brand) { this.brand = brand; }

    public String getModel() { return model; }

    public void setModel(String model) { this.model = model; }

    public int getManufactureYear() { return manufactureYear; }

    public void setManufactureYear(int manufactureYear) {
        if (manufactureYear <= 0) {
            throw new IllegalArgumentException(
                    "manufactureYear має бути бiльше нуля"
            );
        }
        this.manufactureYear = manufactureYear;
    }

    public String getTechnicalCondition() { return technicalCondition; }

    public void setTechnicalCondition(String technicalCondition) { this.technicalCondition = technicalCondition; }

    public int getResponsibleEmployeeId() { return responsibleEmployeeId; }

    public void setResponsibleEmployeeId(int responsibleEmployeeId) {
        if (responsibleEmployeeId <= 0) {
            throw new IllegalArgumentException(
                    "responsibleEmployeeId має бути бiльше нуля"
            );
        }
        this.responsibleEmployeeId = responsibleEmployeeId;
    }

    public int getFarmId() { return farmId; }

    public void setFarmId(int farmId) {
        if (farmId <= 0) {
            throw new IllegalArgumentException(
                    "farmId має бути бiльше нуля"
            );
        }
        this.farmId = farmId;
    }

    @Override
    public void assignWork(int workId) {
        super.assignWork(workId);
        System.out.println("Machinery.assignWork(): " + brand + " " + model + ", вiдповiдальний №" + responsibleEmployeeId);
    }

    @Override
    public void checkAvailability() { System.out.println("Machinery.checkAvailability(): " + name + ", стан " + technicalCondition); }

    @Override
    public void recordOperatingHours(double hours) {
        super.recordOperatingHours(hours);
        System.out.println("Machinery.recordOperatingHours(): " + inventoryNumber + ", разом " + operatingHours);
    }

    @Override
    public String toString() {
        return "Machinery{" +
                "id=" + id +
                ", inventoryNumber='" + inventoryNumber + "'" +
                ", name='" + name + "'" +
                ", type='" + type + "'" +
                ", brand='" + brand + "'" +
                ", model='" + model + "'" +
                ", manufactureYear=" + manufactureYear +
                ", technicalCondition='" + technicalCondition + "'" +
                ", operatingHours=" + operatingHours +
                ", responsibleEmployeeId=" + responsibleEmployeeId +
                ", farmId=" + farmId +
                "}";
    }
}