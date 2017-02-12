/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diu.edu.bd.impl;
import diu.edu.bd.Pimanpower;
import diu.edu.bd.dao.Dao;
import diu.edu.bd.util.KpiUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 *
 * @author sagar
 */
public class PimanpowerDao implements Dao<Pimanpower>{
    Session session=KpiUtil.getSessionFactory().openSession();
    @Override
    public boolean save(Pimanpower data) {
        Transaction t=session.beginTransaction();
        session.save(data);
        t.commit();
        return true;
    }
    @Override
    public List<Pimanpower> display() {
        ArrayList<Pimanpower> arrayList=(ArrayList<Pimanpower>)session.createCriteria(Pimanpower.class).list();
        return arrayList;
    }
    @Override
    public void delete(Pimanpower data) {
        Pimanpower p=find(data.getPimanPowerSerial());
        Transaction t= session.beginTransaction();
        session.delete(p);
        t.commit();
    }
    @Override
   public Pimanpower find(int id) {
        return (Pimanpower)session.get(Pimanpower.class, id);
    }
    @Override
    public boolean update(Pimanpower data) {
        Pimanpower p = find(data.getPimanPowerSerial());
        if(p!=null){
        Transaction t=session.beginTransaction();
       p.setDate(data.getDate());
       p.setSweingOperatorPresent(data.getSweingOperatorPresent());
       p.setSweingHelperPresent(data.getSweingHelperPresent());
       p.setSweingOperatorHelperPresent(data.getSweingOperatorHelperPresent());
       p.setCuttingTotalManPower(data.getCuttingTotalManPower());
       p.setFinishingTotalManPower(data.getFinishingTotalManPower());
       p.setFactoryTotalManPower(data.getFactoryTotalManPower());
       p.setTotalNoOfManHourAvilableMohel(data.getTotalNoOfManHourAvilableMohel());
       p.setTotalNoOfManHourAvailableCutting(data.getTotalNoOfManHourAvailableCutting());
       p.setTotalNoOfManHourAvailableFinishing(data.getTotalNoOfManHourAvailableFinishing());
       p.setTotalNoOfManHourAvailableFactory(data.getTotalNoOfManHourAvailableFactory());
       
        session.update(p);
        t.commit();}
        return true;
    }
   
    
}