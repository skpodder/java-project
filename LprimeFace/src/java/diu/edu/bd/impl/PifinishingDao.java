/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diu.edu.bd.impl;
import diu.edu.bd.Pifinishing;
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
public class PifinishingDao implements Dao<Pifinishing>{
    Session session = KpiUtil.getSessionFactory().openSession();
 
    @Override
    public boolean save(Pifinishing data) {
        Transaction t=session.beginTransaction();
        session.save(data);
        t.commit();
        return true;
    }
    @Override
    public List<Pifinishing> display() {
        ArrayList <Pifinishing>arrayList=(ArrayList<Pifinishing>)session.createCriteria(Pifinishing.class).list();
        return arrayList;
    }
    @Override
    public void delete(Pifinishing data) {
        Pifinishing p=find(data.getPifinishingSerial());
        Transaction t =session.beginTransaction();
        session.delete(p);
        t.commit();
    }
    @Override
    public Pifinishing find(int id) {
        return (Pifinishing)session.get(Pifinishing.class, id);
    }
    @Override
     public boolean update(Pifinishing data) {
        Pifinishing p=find(data.getPifinishingSerial());
        if(p!=null){
        Transaction t=session.beginTransaction();
       p.setFinishingDate(data.getFinishingDate());
       p.setPlanFinishingProduction(data.getPlanFinishingProduction());
       p.setActualFinishingProduction(data.getActualFinishingProduction());
       p.setTotalWorkingDay(data.getTotalWorkingDay());
       p.setAverageWorkinghourFinishing(data.getAverageWorkinghourFinishing());
       p.setFinishingTotalManPower(data.getFinishingTotalManPower());
       p.setTotalNoOfManHourAvailableFinishing(data.getTotalNoOfManHourAvailableFinishing());
        session.update(p);
        t.commit();}
        return true;
    }
    
}