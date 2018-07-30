/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;


/**
 *
 * @author ibrar
 */
public class PandingBill {
    private int id;
    private Tables table;
    private Waiters waiter;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Tables getTables() {
        return table;
    }

    public void setTables(Tables table) {
        this.table = table;
    }

    public Waiters getWaiter() {
        return waiter;
    }

    public void setWaiter(Waiters waiter) {
        this.waiter = waiter;
    }
    
    
}
