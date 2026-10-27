package farm;

public class PackageAccessDemo {
    public static void demonstrate(Equipment equipment) {
        System.out.println("farm: читання package-private поля: " + equipment.internalCode);
        equipment.internalCode = "FARM-UPDATED";
        equipment.showInternalCode();
    }
}
