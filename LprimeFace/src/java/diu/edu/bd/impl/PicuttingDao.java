/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diu.edu.bd.impl;
import diu.edu.bd.Picutting;
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
public class PicuttingDao implements Dao<Picutting>{
    Session session=KpiUtil.getSessionFactory().openSession();
    @Override
    public boolean save(Picutting data) {
        Transaction t=session.beginTransaction();
        session.save(data);
        t.commit();
        return true;
    }
    @Override
    public List<Picutting> display() {
        ArrayList <Picutting> arrayList=(ArrayList<Picutting>)session.createCriteria(Picutting.class).list();
        return arrayList;
    }
    @Override                       
    public void delete(Picutting data) {
        
        Picutting p = find(data.getPicuttingSerial());
        Transaction t=session.beginTransaction();
        session.delete(p);
        t.commit();
    }
    @Override
    public Picutting find(int id) {
        return (Picutting)session.get(Picutting.class, id);
    }
    
    @Override
    public boolean update(Picutting data) {
        Picutting p=find(data.getPicuttingSerial());
        if(p!=null){
        Transaction t=session.beginTransaction();
       p.setCuttingDate(data.getCuttingDate());
       p.setPlanCuttingProduction(data.getPlanCuttingProduction());
       p.setActualCuttingProduction(data.getActualCuttingProduction());
       p.setTotalWorkingDay(data.getTotalWorkingDay());
       p.setAverageWorkinghourCutting(data.getAverageWorkinghourCutting());
       p.setCuttingTotalManPower(data.getCuttingTotalManPower());
       p.setTotalNoOfManHourAvailableCutting(data.getTotalNoOfManHourAvailableCutting());
        session.update(p);
        t.commit();}
        return true;
    }
    
}