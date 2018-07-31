/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.PendingBillDAO;
import entity.PendigBillUpdate;
import javax.swing.JOptionPane;
import util.SQLQueryUtil;

/**
 *
 * @author ibrar
 */
public class PandingBillService {
    private PendingBillDAO pandingBillDAO;

    public PandingBillService() {
        pandingBillDAO=new PendingBillDAO();
    }
    

    public void generatePandingbill(PendigBillUpdate billUpdate) {
        int rowAffect=0;
      rowAffect=  pandingBillDAO.generatPandingBill(billUpdate);
      if(rowAffect>0){
          JOptionPane.showMessageDialog(null, "Bill Genarated Successfully");
      }else{
          JOptionPane.showMessageDialog(null, "Bill Not Genarated");
      }
        
        
   }
    
}
