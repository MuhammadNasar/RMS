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
public class PendigBillUpdate extends PendingBill {

    private Menu menu;
    private int quantity;
    private int amount;
    private int sum;
    private int total;
    private int totalRecievabelAmount;
    private int discount;
    private int discountAmount;
    private int NetAmount;

    public int getTotalRecievabelAmount() {
        return totalRecievabelAmount;
    }

    public void setTotalRecievabelAmount(int totalRecievabelAmount) {
        this.totalRecievabelAmount = totalRecievabelAmount;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(int discountAmount) {
        this.discountAmount = discountAmount;
    }

    public int getNetAmount() {
        return NetAmount;
    }

    public void setNetAmount(int NetAmount) {
        this.NetAmount = NetAmount;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}
