package farm;

public class Field extends LandPlot {
    private String soilType;
    private String usageStatus;
    private int farmId;
    private String cadastralNumber;

    public Field(int id, String name, double area,
                 String location, String soilType,
                 String usageStatus, int farmId,
                 String cadastralNumber) {
        super(id, name, area, location);
        setSoilType(soilType);
        setUsageStatus(usageStatus);
        setFarmId(farmId);
        setCadastralNumber(cadastralNumber);
    }

    public String getSoilType() { return soilType; }

    public void setSoilType(String soilType) { this.soilType = soilType; }

    public String getUsageStatus() { return usageStatus; }

    public void setUsageStatus(String usageStatus) { this.usageStatus = usageStatus; }

    public int getFarmId() { return farmId; }

    public void setFarmId(int farmId) {
        if (farmId <= 0) {
            throw new IllegalArgumentException(
                    "farmId має бути бiльше нуля"
            );
        }
        this.farmId = farmId;
    }

    public String getCadastralNumber() { return cadastralNumber; }

    public void setCadastralNumber(String cadastralNumber) { this.cadastralNumber = cadastralNumber; }

    @Override
    public void showSowingHistory() { System.out.println("Field.showSowingHistory(): поле " + name + ", ґрунт " + soilType); }

    @Override
    public void checkSowingArea(double sowingArea) {
        super.checkSowingArea(sowingArea);
        System.out.println("Field.checkSowingArea(): залишок " + (area - sowingArea) + " га");
    }

    @Override
    public String toString() {
        return "Field{" +
                "id=" + id +
                ", name='" + name + "'" +
                ", area=" + area +
                ", location='" + location + "'" +
                ", soilType='" + soilType + "'" +
                ", usageStatus='" + usageStatus + "'" +
                ", farmId=" + farmId +
                ", cadastralNumber='" + cadastralNumber + "'" +
                "}";
    }
}