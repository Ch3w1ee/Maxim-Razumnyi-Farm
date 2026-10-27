package farm;

import java.util.Arrays;

public class Employee extends Person {
    private String position;
    private String startDate;
    private String employmentStatus;
    private String[] roles;
    private int farmId;

    public Employee(int id, String fullName, String position,
                    String phone, String startDate,
                    String employmentStatus, String[] roles,
                    int farmId) {
        super(id, fullName, phone);
        setPosition(position);
        setStartDate(startDate);
        setEmploymentStatus(employmentStatus);
        setRoles(roles);
        setFarmId(farmId);
    }

    public String getPosition() { return position; }

    public void setPosition(String position) { this.position = position; }

    public String getStartDate() { return startDate; }

    public void setStartDate(String startDate) { this.startDate = startDate; }

    public String getEmploymentStatus() { return employmentStatus; }

    public void setEmploymentStatus(String employmentStatus) { this.employmentStatus = employmentStatus; }

    public String[] getRoles() { return Arrays.copyOf(roles, roles.length); }

    public void setRoles(String[] roles) {
        if (roles == null) {
            throw new IllegalArgumentException(
                    "roles: масив не може бути null"
            );
        }
        this.roles = Arrays.copyOf(roles, roles.length);
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

    public void assignWork(int workId) {
        if (workId <= 0) throw new IllegalArgumentException("workId має бути додатним");
        System.out.println("Employee.assignWork(): " + fullName + ", робота №" + workId);
    }

    public void showWorkHistory() { System.out.println("Employee.showWorkHistory(): " + fullName + ", працює з " + startDate); }

    public void changeRole(String role) {
        if (role == null || role.trim().isEmpty())
            throw new IllegalArgumentException("Роль не може бути порожньою");
        setRoles(new String[]{role});
        System.out.println("Employee.changeRole(): " + role);
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Employee.showInfo(): " + fullName + ", посада " + position);
    }
    @Override
    public void performWork() { System.out.println("Employee.performWork(): " + fullName + " працює на посадi " + position); }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fullName='" + fullName + "'" +
                ", position='" + position + "'" +
                ", phone='" + phone + "'" +
                ", startDate='" + startDate + "'" +
                ", employmentStatus='" + employmentStatus + "'" +
                ", roles=" + Arrays.toString(roles) +
                ", farmId=" + farmId +
                "}";
    }
}