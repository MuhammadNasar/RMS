
package entity;


public class Tables {
    private int tableId ;
    private String tableNumber ;
    private int available ;
    private int unavailable ;

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public String getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(String tableNumber) {
        this.tableNumber = tableNumber;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public int getUnavailable() {
        return unavailable;
    }

    public void setUnavailable(int unavailable) {
        this.unavailable = unavailable;
    }
    
}
