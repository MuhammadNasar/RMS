/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entity.Menu;
import entity.PandigBillUpdate;
import entity.PandingBill;
import entity.Tables;
import entity.User;
import entity.Waiters;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import util.SQLQueryUtil;

/**
 *
 * @author User
 */
public class CommonService {

    public int total;

    public CommonService() {
    }

    public Vector<Menu> getVectorMenuItem() {
        SQLQueryUtil sql = new SQLQueryUtil();
        sql.connect(false);

        String query = "SELECT * FROM `menu_items` ORDER BY `id` ASC;";
        Vector<Menu> vectorMenuItem = new Vector<>();

        ResultSet resultSet;
        Menu menu;
        try {
            resultSet = sql.executeQuery(query);
            while (resultSet.next()) {
                menu = new Menu();
                menu.setMenuId(resultSet.getInt("id"));
                menu.setMenuName(resultSet.getString("item_name"));
                menu.setPrice(resultSet.getInt("price"));

                vectorMenuItem.add(menu);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            sql.disconnect();
        }

        return vectorMenuItem;
    }

    public Vector<Waiters> getVectorWaiters() {
        SQLQueryUtil sql = new SQLQueryUtil();
        sql.connect(false);

        String query = "SELECT * FROM `waiters` ORDER BY `id` ASC;";
        Vector<Waiters> vectorwaiters = new Vector<>();

        ResultSet resultSet;
        Waiters waiters;

        try {

            resultSet = sql.executeQuery(query);
            while (resultSet.next()) {
                waiters = new Waiters();
                waiters.setWaiterId(resultSet.getInt("id"));
                waiters.setName(resultSet.getString("full_name"));
                waiters.setFatherName(resultSet.getString("father_name"));
                waiters.setWaiterNumber(resultSet.getString("waiter_number"));
                waiters.setPhoneNumber(resultSet.getString("phone_number"));
                waiters.setCnic(resultSet.getString("cnic"));
                waiters.setAddress(resultSet.getString("address"));

                vectorwaiters.add(waiters);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vectorwaiters;
    }

    public Vector<Tables> getVectorTables() {
        SQLQueryUtil sql = new SQLQueryUtil();
        sql.connect(false);

        String query = "SELECT * FROM `tables` ORDER BY `id` ASC;";
        Vector<Tables> vectorTables = new Vector<>();

        ResultSet resultSet;
        Tables tables;
        try {
            resultSet = sql.executeQuery(query);
            while (resultSet.next()) {
                tables = new Tables();
                tables.setTableId(resultSet.getInt("id"));
                tables.setAsAvailable(resultSet.getInt("is_available"));
                tables.setTableNumber(resultSet.getString("table_number"));

                vectorTables.add(tables);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            sql.disconnect();
        }

        return vectorTables;
    }

    public Vector<User> getVectorUser() {
        SQLQueryUtil sql = new SQLQueryUtil();
        sql.connect(false);

        String query = "SELECT * FROM `users` ORDER BY `id` ASC;";
        Vector<User> vectorUsers = new Vector<>();

        ResultSet rs;
        User user;
        try {
            rs = sql.executeQuery(query);
            while (rs.next()) {
                user = new User();
                user.setUserId(rs.getInt("id"));
                user.setDisplayName(rs.getString("display_name"));
                user.setUserName(rs.getString("user_name"));
                user.setPassword(rs.getString("password"));
                vectorUsers.add(user);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vectorUsers;
    }

    public Vector<PandingBill> getVectorPangdingBill() {
        SQLQueryUtil sql = new SQLQueryUtil();
        sql.connect(false);
        Vector<PandingBill> vectorPandingBills = new Vector<>();
        PandingBill pandingBill;
        Waiters waiters;
        Tables tables;
        ResultSet rs;
        String Qurey = "SELECT `id`,`table_id`,`waiter_id`FROM restaurant_kot WHERE "
                + "`is_transfered_to_pending_payments`=0 and`is_pending_payment_closed`=0;";
        try {
            rs = sql.executeQuery(Qurey);
            while (rs.next()) {
                waiters = new Waiters();
                tables = new Tables();
                pandingBill = new PandingBill();
                waiters.setWaiterId(rs.getInt("waiter_id"));
                tables.setTableId(rs.getInt("table_id"));
                pandingBill.setId(rs.getInt("id"));
                pandingBill.setTables(tables);
                pandingBill.setWaiter(waiters);
                vectorPandingBills.add(pandingBill);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sql.disconnect();
        }
        return vectorPandingBills;
    }

    public Vector<PandigBillUpdate> getVectorPandingBill(String kot_id) {
        SQLQueryUtil sql = new SQLQueryUtil();
        sql.connect(false);
        Vector<PandigBillUpdate> vector = new Vector<>();
        Menu menu;
        PandigBillUpdate pandigBillUpdate;
        ResultSet rs;
        String query = "Select i.item_name ,i.price,d.`quantity`,d.`rate`,d.quantity*d.rate as summ"
                + " from menu_items as i "
                + ", restaurant_kot_details as d, restaurant_kot as r where d.kot_id=r.id and d.`kot_id`='" + kot_id + "'"
                + " and d.`item_id`=i.id";
        String totalSum = "Select sum(d.quantity*d.rate) as total from menu_items as i "
                + ", restaurant_kot_details as d, restaurant_kot as r where d.kot_id=r.id "
                + "and d.`kot_id`='" + kot_id + "' and d.`item_id`=i.id";
        try {
            rs = sql.executeQuery(query);

            while (rs.next()) {
                menu = new Menu();
                pandigBillUpdate = new PandigBillUpdate();
                menu.setMenuName(rs.getString("i.item_name"));
                menu.setPrice(rs.getInt("i.price"));
                pandigBillUpdate.setQuantity(rs.getInt("quantity"));
                pandigBillUpdate.setAmount(rs.getInt("rate"));
                pandigBillUpdate.setSum(rs.getInt("summ"));
                pandigBillUpdate.setMenu(menu);
                vector.add(pandigBillUpdate);

            }
            rs = sql.executeQuery(totalSum);
            rs.next();
            total = rs.getInt("total");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sql.disconnect();

        }
        return vector;
    }

}
