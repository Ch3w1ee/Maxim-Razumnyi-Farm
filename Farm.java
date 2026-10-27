package farm;

import java.util.Arrays;

public class Farm {
    private int id;
    private String name;
    private String address;
    private String contacts;
    private String[] activityAreas;
    private int managerId;
    private int[] fieldIds;
    private int[] employeeIds;
    private int[] warehouseIds;
    private int[] machineryIds;

    public Farm(int id, String name, String address, String contacts,
                String[] activityAreas, int managerId,
                int[] fieldIds, int[] employeeIds,
                int[] warehouseIds, int[] machineryIds) {
        setId(id);
        setName(name);
        setAddress(address);
        setContacts(contacts);
        setActivityAreas(activityAreas);
        setManagerId(managerId);
        setFieldIds(fieldIds);
        setEmployeeIds(employeeIds);
        setWarehouseIds(warehouseIds);
        setMachineryIds(machineryIds);
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
            throw new IllegalArgumentException("name не може бути порожнiм");
        }
        this.name = name;
    }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public String getContacts() { return contacts; }

    public void setContacts(String contacts) { this.contacts = contacts; }

    public String[] getActivityAreas() { return Arrays.copyOf(activityAreas, activityAreas.length); }

    public void setActivityAreas(String[] activityAreas) {
        if (activityAreas == null) {
            throw new IllegalArgumentException(
                    "activityAreas: масив не може бути null"
            );
        }
        this.activityAreas = Arrays.copyOf(
                activityAreas, activityAreas.length
        );
    }

    public int getManagerId() { return managerId; }

    public void setManagerId(int managerId) {
        if (managerId <= 0) {
            throw new IllegalArgumentException(
                    "managerId має бути бiльше нуля"
            );
        }
        this.managerId = managerId;
    }

    public int[] getFieldIds() { return Arrays.copyOf(fieldIds, fieldIds.length); }

    public void setFieldIds(int[] fieldIds) {
        if (fieldIds == null) {
            throw new IllegalArgumentException(
                    "fieldIds: масив не може бути null"
            );
        }
        for (int value : fieldIds) {
            if (value <= 0) {
                throw new IllegalArgumentException(
                        "Ідентифiкатори мають бути додатними"
                );
            }
        }
        this.fieldIds = Arrays.copyOf(fieldIds, fieldIds.length);
    }

    public int[] getEmployeeIds() { return Arrays.copyOf(employeeIds, employeeIds.length); }

    public void setEmployeeIds(int[] employeeIds) {
        if (employeeIds == null) {
            throw new IllegalArgumentException(
                    "employeeIds: масив не може бути null"
            );
        }
        for (int value : employeeIds) {
            if (value <= 0) {
                throw new IllegalArgumentException(
                        "Ідентифiкатори мають бути додатними"
                );
            }
        }
        this.employeeIds = Arrays.copyOf(employeeIds, employeeIds.length);
    }

    public int[] getWarehouseIds() { return Arrays.copyOf(warehouseIds, warehouseIds.length); }

    public void setWarehouseIds(int[] warehouseIds) {
        if (warehouseIds == null) {
            throw new IllegalArgumentException(
                    "warehouseIds: масив не може бути null"
            );
        }
        for (int value : warehouseIds) {
            if (value <= 0) {
                throw new IllegalArgumentException(
                        "Ідентифiкатори мають бути додатними"
                );
            }
        }
        this.warehouseIds = Arrays.copyOf(
                warehouseIds, warehouseIds.length
        );
    }

    public int[] getMachineryIds() { return Arrays.copyOf(machineryIds, machineryIds.length); }

    public void setMachineryIds(int[] machineryIds) {
        if (machineryIds == null) {
            throw new IllegalArgumentException(
                    "machineryIds: масив не може бути null"
            );
        }
        for (int value : machineryIds) {
            if (value <= 0) {
                throw new IllegalArgumentException(
                        "Ідентифiкатори мають бути додатними"
                );
            }
        }
        this.machineryIds = Arrays.copyOf(
                machineryIds, machineryIds.length
        );
    }

    public void showResources() { System.out.println("Farm.showResources(): поля=" + fieldIds.length + ", працiвники=" + employeeIds.length + ", технiка=" + machineryIds.length); }

    public void showSummary() { System.out.println("Farm.showSummary(): " + name + ", " + address); }

    @Override
    public String toString() {
        return "Farm{" +
                "id=" + id +
                ", name='" + name + "'" +
                ", address='" + address + "'" +
                ", contacts='" + contacts + "'" +
                ", activityAreas=" + Arrays.toString(activityAreas) +
                ", managerId=" + managerId +
                ", fieldIds=" + Arrays.toString(fieldIds) +
                ", employeeIds=" + Arrays.toString(employeeIds) +
                ", warehouseIds=" + Arrays.toString(warehouseIds) +
                ", machineryIds=" + Arrays.toString(machineryIds) +
                "}";
    }
}