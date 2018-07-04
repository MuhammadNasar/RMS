
package entity;


public class Tables {
    private int tableId ;
    private String tableNumber ;
    private int asAvailable ;
    
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

    /**
     * @return the asAvailable
     */
    public int getAsAvailable() {
        return asAvailable;
    }

    /**
     * @param asAvailable the asAvailable to set
     */
    public void setAsAvailable(int asAvailable) {
        this.asAvailable = asAvailable;
    }
    @Override
    public String toString() {
        return tableNumber;
    }
    
   
}
