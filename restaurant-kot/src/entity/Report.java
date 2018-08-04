/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author itsSa
 */
public class Report {
    private String billNumber;
    private String totalAmountReceivable;
    private String discountAmount;
    private String netAmount;
    private String paymentMethod;
    private String billDate;
    private String totalOf_recieveable;
    private String totalOf_discountAmount;
    private String totalOf_netAmount;

    public String getTotalOf_recieveable() {
        return totalOf_recieveable;
    }

    public void setTotalOf_recieveable(String totalOf_recieveable) {
        this.totalOf_recieveable = totalOf_recieveable;
    }

    public String getTotalOf_discountAmount() {
        return totalOf_discountAmount;
    }

    public void setTotalOf_discountAmount(String totalOf_discountAmount) {
        this.totalOf_discountAmount = totalOf_discountAmount;
    }

    public String getTotalOf_netAmount() {
        return totalOf_netAmount;
    }

    public void setTotalOf_netAmount(String totalOf_netAmount) {
        this.totalOf_netAmount = totalOf_netAmount;
    }
    
    
    public Report() {
    }

    public String getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(String billNumber) {
        this.billNumber = billNumber;
    }

    public String getTotalAmountReceivable() {
        return totalAmountReceivable;
    }

    public void setTotalAmountReceivable(String totalAmountReceivable) {
        this.totalAmountReceivable = totalAmountReceivable;
    }

    public String getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(String discountAmount) {
        this.discountAmount = discountAmount;
    }

    public String getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(String netAmount) {
        this.netAmount = netAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    
}
