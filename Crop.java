package farm;

public class Crop {
    private int id;
    private String name;
    private String variety;
    private String cropGroup;
    private int productItemId;
    private String description;

    public Crop(int id, String name, String variety,
                String cropGroup, int productItemId,
                String description) {
        setId(id);
        setName(name);
        setVariety(variety);
        setCropGroup(cropGroup);
        setProductItemId(productItemId);
        setDescription(description);
    }

    public int getId() { return id; }

    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("id має бути бiльше нуля");
        }
        this.id = id;
    }

    public String getName() { return name; }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "name не може бути порожнiм"
            );
        }
        this.name = name;
    }

    public String getVariety() { return variety; }

    public void setVariety(String variety) { this.variety = variety; }

    public String getCropGroup() { return cropGroup; }

    public void setCropGroup(String cropGroup) { this.cropGroup = cropGroup; }

    public int getProductItemId() { return productItemId; }

    public void setProductItemId(int productItemId) {
        if (productItemId <= 0) {
            throw new IllegalArgumentException(
                    "productItemId має бути бiльше нуля"
            );
        }
        this.productItemId = productItemId;
    }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public void selectForSowing() { System.out.println("Crop.selectForSowing(): " + name + ", сорт " + variety); }

    public void showProductItem() { System.out.println("Crop.showProductItem(): товар №" + productItemId); }

    @Override
    public String toString() {
        return "Crop{" +
                "id=" + id +
                ", name='" + name + "'" +
                ", variety='" + variety + "'" +
                ", cropGroup='" + cropGroup + "'" +
                ", productItemId=" + productItemId +
                ", description='" + description + "'" +
                "}";
    }
}