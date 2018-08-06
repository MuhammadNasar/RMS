/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.ReportDAO;
import entity.Report;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import util.SQLQueryUtil;

/**
 *
 * @author Salman Khan
 *
 */
public class ReportService {

    private ReportDAO reportDAO;

    public ReportService() {
        reportDAO = new ReportDAO();
    }

    public void getCashReportVector(String fromDate, String toDate, String paymentMethid) {
        SQLQueryUtil sql = new SQLQueryUtil();
        sql.connect(false);
        Vector<Report> vectorCashReport = new Vector<>();

        String cashQuery = "SELECT `id` AS `bill_number`, `total_amount_receivable`, `discount_amount`, "
                + "`net_amount`, `payment_method`, "
                + "DATE_FORMAT(`bill_date_time`, '%d %b %Y') AS `bill_date` "
                + "FROM `restaurant_kot` WHERE DATE_FORMAT(`bill_date_time`, '%Y-%m-%d')"
                + " BETWEEN '" + fromDate + "' AND '" + toDate + "' AND `payment_method` ='" + paymentMethid + "'"
                + "ORDER BY `id` ASC;";

        ResultSet resultSet;
        Report report;

        try {
            resultSet = sql.executeQuery(cashQuery);

            while (resultSet.next()) {
                report = new Report();
                report.setBillNumber(resultSet.getString("bill_number"));
                report.setTotalAmountReceivable(resultSet.getString("total_amount_receivable"));
                report.setDiscountAmount(resultSet.getString("discount_amount"));
                report.setNetAmount(resultSet.getString("net_amount"));
                report.setPaymentMethod(resultSet.getString("payment_method"));
                report.setBillDate(resultSet.getString("bill_date"));

                vectorCashReport.add(report);
            }
            if (vectorCashReport.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No Results found!");
            } else {
                reportDAO.printCashReport(vectorCashReport, toDate, fromDate);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            sql.disconnect();
        }

    }

    public Vector<Report> getOfTotalCashVector(String fromDate, String toDate) {
        SQLQueryUtil sql = new SQLQueryUtil();
        sql.connect(false);

        Vector<Report> vectorTotalCash = new Vector<>();

        String queryTotal = "SELECT SUM(`total_amount_receivable`) AS `totalOf_revceivable`,"
                + " SUM(`discount_amount`) AS `totalOf_discountAmount`, "
                + "SUM(`net_amount`) AS `totalOf_netAmount` "
                + "FROM `restaurant_kot` WHERE DATE_FORMAT(`bill_date_time`, '%Y-%m-%d') " +
                    " BETWEEN '"+fromDate+"' AND '"+toDate+"' AND `payment_method` = 'CASH' ORDER BY `id` ASC;;";
        
        ResultSet resultSet;
        Report report;
        try {
            resultSet = sql.executeQuery(queryTotal);
            while (resultSet.next()) {
                report = new Report();
                report.setTotalOf_recieveable(resultSet.getString("totalOf_revceivable"));
                report.setTotalOf_discountAmount(resultSet.getString("totalOf_discountAmount"));
                report.setTotalOf_netAmount(resultSet.getString("totalOf_netAmount"));
                vectorTotalCash.add(report);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return vectorTotalCash;
    }

    public void printChequeMethod(String fromDate, String toDate, String paymentMethid) {
        SQLQueryUtil sql = new SQLQueryUtil() ;
        sql.connect(false);
        Vector<Report> vectorChequeReport = new Vector<>() ;
        
        String chequeQuery = "SELECT `id` AS `bill_number`, `total_amount_receivable`, `discount_amount`, "
                + "`net_amount`, `payment_method`, "
                + "DATE_FORMAT(`bill_date_time`, '%d %b %Y') AS `bill_date` "
                + "FROM `restaurant_kot` WHERE DATE_FORMAT(`bill_date_time`, '%Y-%m-%d')"
                + " BETWEEN '" + fromDate + "' AND '" + toDate + "' AND `payment_method` ='" + paymentMethid + "'"
                + "ORDER BY `id` ASC;";
        
        ResultSet resultSet;
        Report report;

        try {
            resultSet = sql.executeQuery(chequeQuery);

            while (resultSet.next()) {
                report = new Report();
                report.setBillNumber(resultSet.getString("bill_number"));
                report.setTotalAmountReceivable(resultSet.getString("total_amount_receivable"));
                report.setDiscountAmount(resultSet.getString("discount_amount"));
                report.setNetAmount(resultSet.getString("net_amount"));
                report.setPaymentMethod(resultSet.getString("payment_method"));
                report.setBillDate(resultSet.getString("bill_date"));

                vectorChequeReport.add(report);
            }
            if (vectorChequeReport.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No Results found!");
            } else {
                reportDAO.printChequeReport(vectorChequeReport, toDate, fromDate);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            sql.disconnect();
        }
    }
    
     public Vector<Report> getOfTotalChequeVector(String fromDate, String toDate) {
        SQLQueryUtil sql = new SQLQueryUtil();
        sql.connect(false);

        Vector<Report> vectorTotalCash = new Vector<>();

        String queryTotal = "SELECT SUM(`total_amount_receivable`) AS `totalOf_revceivable`,"
                + " SUM(`discount_amount`) AS `totalOf_discountAmount`, "
                + "SUM(`net_amount`) AS `totalOf_netAmount` "
                + "FROM `restaurant_kot` WHERE DATE_FORMAT(`bill_date_time`, '%Y-%m-%d') " +
                    " BETWEEN '"+fromDate+"' AND '"+toDate+"' AND `payment_method` = 'CHEQUE' ORDER BY `id` ASC;;";
        
        ResultSet resultSet;
        Report report;
        try {
            resultSet = sql.executeQuery(queryTotal);
            while (resultSet.next()) {
                report = new Report();
                report.setTotalOf_recieveable(resultSet.getString("totalOf_revceivable"));
                report.setTotalOf_discountAmount(resultSet.getString("totalOf_discountAmount"));
                report.setTotalOf_netAmount(resultSet.getString("totalOf_netAmount"));
                vectorTotalCash.add(report);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return vectorTotalCash;
    }

    public void printCreditCardMethod(String fromDate, String toDate, String paymentMethid) {
        SQLQueryUtil sql = new SQLQueryUtil();
        sql.connect(false);
        Vector<Report> vectorCreditCardReport = new Vector<>();

        String cashQuery = "SELECT `id` AS `bill_number`, `total_amount_receivable`, `discount_amount`, "
                + "`net_amount`, `payment_method`, "
                + "DATE_FORMAT(`bill_date_time`, '%d %b %Y') AS `bill_date` "
                + "FROM `restaurant_kot` WHERE DATE_FORMAT(`bill_date_time`, '%Y-%m-%d')"
                + " BETWEEN '" + fromDate + "' AND '" + toDate + "' AND `payment_method` ='" + paymentMethid + "'"
                + "ORDER BY `id` ASC;";

        ResultSet resultSet;
        Report report;

        try {
            resultSet = sql.executeQuery(cashQuery);

            while (resultSet.next()) {
                report = new Report();
                report.setBillNumber(resultSet.getString("bill_number"));
                report.setTotalAmountReceivable(resultSet.getString("total_amount_receivable"));
                report.setDiscountAmount(resultSet.getString("discount_amount"));
                report.setNetAmount(resultSet.getString("net_amount"));
                report.setPaymentMethod(resultSet.getString("payment_method"));
                report.setBillDate(resultSet.getString("bill_date"));

                vectorCreditCardReport.add(report);
            }
            if (vectorCreditCardReport.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No Results found!");
            } else {
                reportDAO.printCreditCardReport(vectorCreditCardReport, toDate, fromDate);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            sql.disconnect();
        }
    }

    public Vector<Report> getOfTotalCreditCardVector(String fromDate, String toDate) {
        SQLQueryUtil sql = new SQLQueryUtil();
        sql.connect(false);

        Vector<Report> vectorTotalCash = new Vector<>();

        String queryTotal = "SELECT SUM(`total_amount_receivable`) AS `totalOf_revceivable`,"
                + " SUM(`discount_amount`) AS `totalOf_discountAmount`, "
                + "SUM(`net_amount`) AS `totalOf_netAmount` "
                + "FROM `restaurant_kot` WHERE DATE_FORMAT(`bill_date_time`, '%Y-%m-%d') " +
                    " BETWEEN '"+fromDate+"' AND '"+toDate+"' AND `payment_method` = 'CREDIT_CARD' ORDER BY `id` ASC;;";
        
        ResultSet resultSet;
        Report report;
        try {
            resultSet = sql.executeQuery(queryTotal);
            while (resultSet.next()) {
                report = new Report();
                report.setTotalOf_recieveable(resultSet.getString("totalOf_revceivable"));
                report.setTotalOf_discountAmount(resultSet.getString("totalOf_discountAmount"));
                report.setTotalOf_netAmount(resultSet.getString("totalOf_netAmount"));
                vectorTotalCash.add(report);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return vectorTotalCash;
    }

}
