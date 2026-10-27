package farm;

public class Sowing {
    private int id;
    private int fieldId;
    private int cropId;
    private int season;
    private String sowingDate;
    private double sowingArea;
    private double harvestedArea;
    private double plannedHarvest;
    private String status;
    private String endDate;

    public Sowing(int id, int fieldId, int cropId, int season,
                  String sowingDate, double sowingArea,
                  double harvestedArea, double plannedHarvest,
                  String status, String endDate) {
        setId(id);
        setFieldId(fieldId);
        setCropId(cropId);
        setSeason(season);
        setSowingDate(sowingDate);
        setSowingArea(sowingArea);
        setHarvestedArea(harvestedArea);
        setPlannedHarvest(plannedHarvest);
        setStatus(status);
        setEndDate(endDate);
    }

    public int getId() { return id; }

    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("id має бути бiльше нуля");
        }
        this.id = id;
    }

    public int getFieldId() { return fieldId; }

    public void setFieldId(int fieldId) {
        if (fieldId <= 0) {
            throw new IllegalArgumentException(
                    "fieldId має бути бiльше нуля"
            );
        }
        this.fieldId = fieldId;
    }

    public int getCropId() { return cropId; }

    public void setCropId(int cropId) {
        if (cropId <= 0) {
            throw new IllegalArgumentException(
                    "cropId має бути бiльше нуля"
            );
        }
        this.cropId = cropId;
    }

    public int getSeason() { return season; }

    public void setSeason(int season) {
        if (season <= 0) {
            throw new IllegalArgumentException(
                    "season має бути бiльше нуля"
            );
        }
        this.season = season;
    }

    public String getSowingDate() { return sowingDate; }

    public void setSowingDate(String sowingDate) { this.sowingDate = sowingDate; }

    public double getSowingArea() { return sowingArea; }

    public void setSowingArea(double sowingArea) {
        if (!Double.isFinite(sowingArea) || sowingArea <= 0) {
            throw new IllegalArgumentException(
                    "Некоректне значення sowingArea"
            );
        }
        if (sowingArea < harvestedArea) {
            throw new IllegalArgumentException(
                    "Посiвна площа менша за зiбрану"
            );
        }
        this.sowingArea = sowingArea;
    }

    public double getHarvestedArea() { return harvestedArea; }

    public void setHarvestedArea(double harvestedArea) {
        if (!Double.isFinite(harvestedArea) || harvestedArea < 0) {
            throw new IllegalArgumentException(
                    "Некоректне значення harvestedArea"
            );
        }
        if (harvestedArea > sowingArea) {
            throw new IllegalArgumentException(
                    "Зiбрана площа перевищує посiвну"
            );
        }
        this.harvestedArea = harvestedArea;
    }

    public double getPlannedHarvest() { return plannedHarvest; }

    public void setPlannedHarvest(double plannedHarvest) {
        if (!Double.isFinite(plannedHarvest) || plannedHarvest < 0) {
            throw new IllegalArgumentException(
                    "Некоректне значення plannedHarvest"
            );
        }
        this.plannedHarvest = plannedHarvest;
    }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public String getEndDate() { return endDate; }

    public void setEndDate(String endDate) { this.endDate = endDate; }

    public void showGrowingHistory() { System.out.println("Sowing.showGrowingHistory(): сезон " + season + ", стан " + status); }

    public void compareResults() { System.out.println("Sowing.compareResults(): зiбрано " + harvestedArea + " iз " + sowingArea + " га"); }

    public void calculateYield() { System.out.println("Sowing.calculateYield(): планова врожайнiсть " + (plannedHarvest / sowingArea) + " т/га"); }

    @Override
    public String toString() {
        return "Sowing{" +
                "id=" + id +
                ", fieldId=" + fieldId +
                ", cropId=" + cropId +
                ", season=" + season +
                ", sowingDate='" + sowingDate + "'" +
                ", sowingArea=" + sowingArea +
                ", harvestedArea=" + harvestedArea +
                ", plannedHarvest=" + plannedHarvest +
                ", status='" + status + "'" +
                ", endDate=" + endDate +
                "}";
    }
}