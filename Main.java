package demo;

import farm.*;

public class Main {
    public static void main(String[] args) {
        Farm farm = new Farm(
                1,
                "Злагода",
                "Одеська область",
                "farm@example.com",
                new String[]{"Рослинництво", "Тваринництво"},
                1,
                new int[]{1},
                new int[]{1},
                new int[]{1},
                new int[]{1}
        );

        Employee employee = new Employee(
                1,
                "Петренко Іван",
                "Керiвник господарства",
                "Не вказано",
                "2024-03-01",
                "Працює",
                new String[]{"Керiвник", "Облiковець"},
                1
        );

        Field field = new Field(
                1,
                "Пiвнiчне",
                25.0,
                "Одеська область",
                "Чорнозем",
                "Використовується",
                1,
                "Не вказано"
        );

        Crop crop = new Crop(
                1,
                "Пшениця",
                "Подолянка",
                "Зерновi",
                1,
                "Озима пшениця"
        );

        Sowing sowing = new Sowing(
                1,
                1,
                1,
                2026,
                "2025-09-25",
                25.0,
                0.0,
                100.0,
                "Зростає",
                null
        );

        Machinery machinery = new Machinery(
                1,
                "TR-001",
                "Трактор",
                "Сiльськогосподарська технiка",
                "John Deere",
                "6155M",
                2020,
                "Справний",
                1250.0,
                1,
                1
        );

        System.out.println("=== 1. Початковi об'єкти ===");
        System.out.println(farm);
        System.out.println(employee);
        System.out.println(field);
        System.out.println(crop);
        System.out.println(sowing);
        System.out.println(machinery);

        System.out.println("=== 2. Змiна через сеттери ===");

        farm.setName("Злагода Плюс");
        employee.setPhone("0501234567");
        field.setArea(30.0);
        crop.setDescription("Оновлений опис культури");
        sowing.setPlannedHarvest(120.0);
        machinery.setOperatingHours(1300.0);

        System.out.println("Назва: " + farm.getName());
        System.out.println("Телефон: " + employee.getPhone());
        System.out.println("Площа: " + field.getArea());
        System.out.println("Культура: " + crop.getDescription());
        System.out.println(
                "Плановий урожай: " + sowing.getPlannedHarvest()
        );
        System.out.println(
                "Напрацювання: " + machinery.getOperatingHours()
        );

        System.out.println("=== 3. Захист масивiв ===");

        String[] roles = {"Керiвник", "Облiковець"};
        employee.setRoles(roles);
        roles[0] = "Змiнено зовнi";

        String[] copy = employee.getRoles();
        copy[0] = "Змiнено копiю";

        System.out.println(
                "Збережена роль: " + employee.getRoles()[0]
        );

        System.out.println("=== 4. Перевiрка помилкових значень ===");

        try {
            field.setArea(-5.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }

        System.out.println(
                "Площа пiсля вiдхилення: " + field.getArea()
        );

        try {
            sowing.setHarvestedArea(26.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }

        System.out.println(
                "Зiбрана площа: " + sowing.getHarvestedArea()
        );

        try {
            machinery.setOperatingHours(-1.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }

        System.out.println(
                "Напрацювання пiсля вiдхилення: "
                        + machinery.getOperatingHours()
        );

        System.out.println("=== 5. Ієрархiя Person -> Employee ===");
        Person person = new Person(2, "Коваленко Олена", "0671234567");
        Person[] people = {person, employee};
        for (Person item : people) {
            item.showInfo();
            item.performWork();
        }
        employee.assignWork(10);
        employee.showWorkHistory();
        employee.changeRole("Агроном");

        System.out.println("=== 6. Ієрархiя LandPlot -> Field ===");
        LandPlot plot = new LandPlot(2, "Резервна", 40.0, "Одеська область");
        LandPlot[] plots = {plot, field};
        for (LandPlot item : plots) {
            item.showSowingHistory();
            item.checkSowingArea(20.0);
        }

        System.out.println("=== 7. Ієрархiя Equipment -> Machinery ===");
        Equipment equipment = new Equipment(2, "Насос", 100.0);
        Equipment[] equipmentItems = {equipment, machinery};
        for (Equipment item : equipmentItems) {
            item.assignWork(10);
            item.checkAvailability();
            item.recordOperatingHours(5.0);
        }

        System.out.println("=== 8. Робота решти класiв ===");
        farm.showResources();
        farm.showSummary();
        crop.selectForSowing();
        crop.showProductItem();
        sowing.showGrowingHistory();
        sowing.compareResults();
        sowing.calculateYield();

        System.out.println("=== 9. Доступ мiж пакетами ===");
        PackageAccessDemo.demonstrate(equipment);
        System.out.println("demo: доступний public-метод getName(): " + equipment.getName());
        System.out.println("demo: прямий доступ до package-private заборонений");
    }
}