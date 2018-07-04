
package entity;

public class Waiters {
    private int waiterId;
    private String  name;
    private String fatherName;
    private String waiterNumber;
    private int phoneNumber;
    private String cnic;
    private String address;

    public int getWaiterId() {
        return waiterId;
    }

    public void setWaiterId(int waiterId) {
        this.waiterId = waiterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getWaiterNumber() {
        return waiterNumber;
    }

    public void setWaiterNumber(String waiterNumber) {
        this.waiterNumber = waiterNumber;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCnic() {
        return cnic;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    
    @Override
    public String toString() {
        return name;
    }
}
