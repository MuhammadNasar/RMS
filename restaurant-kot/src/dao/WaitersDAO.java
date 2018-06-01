package dao;

import entity.Waiters;

public class WaitersDAO {

    public WaitersDAO() {
    }

    public int registerWaiters(Waiters waiters) {

        int dataInserted = 0;
       String  query = " INSERT INTO `waiters`(`full_name`, `father_name`, `waiter_number`, `phone_number`, `cnic`, `address`) "
                + " VALUES ('" + waiters.getName() 
                + "','" + waiters.getFatherName() 
                + "','" + waiters.getWaiterNumber() 
                + "','" + waiters.getPhoneNumber() 
                + "','" + waiters.getCnic() + "','" 
                + waiters.getAddress() + "');";
       return dataInserted;

    }

}
