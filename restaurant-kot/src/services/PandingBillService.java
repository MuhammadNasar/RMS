/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.PandingBillDAO;
import entity.PandigBillUpdate;
import javax.swing.JOptionPane;
import util.SQLQueryUtil;

/**
 *
 * @author ibrar
 */
public class PandingBillService {
    private PandingBillDAO pandingBillDAO;

    public PandingBillService() {
        pandingBillDAO=new PandingBillDAO();
    }
    

    public void generatePandingbill(PandigBillUpdate billUpdate) {
        int rowAffect=0;
      rowAffect=  pandingBillDAO.generatPandingBill(billUpdate);
      if(rowAffect>0){
          JOptionPane.showMessageDialog(null, "Bill Genarated Successfully");
      }else{
          JOptionPane.showMessageDialog(null, "Bill Not Genarated");
      }
        
        
   }
    
}
