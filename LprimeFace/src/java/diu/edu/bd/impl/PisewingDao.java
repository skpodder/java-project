/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diu.edu.bd.impl;
import diu.edu.bd.Pisewing;
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
public class PisewingDao implements Dao<Pisewing>{
    Session session=KpiUtil.getSessionFactory().openSession();
    
    @Override
    public boolean save(Pisewing data) {
        Transaction t=session.beginTransaction();
        session.save(data);
        t.commit();
        return true;
    }
    @Override
    public List<Pisewing> display() {
    ArrayList <Pisewing> arrayList=(ArrayList<Pisewing>)session.createCriteria(Pisewing.class).list();
    return arrayList;
    }
    @Override
    public void delete(Pisewing data) {
    Pisewing p= find(data.getPisewingSerial());
        Transaction t=session.beginTransaction();
        session.delete(p);
        t.commit();
    }
    @Override
    public Pisewing find(int id) {
    return (Pisewing) session.get(Pisewing.class, id);
    }
    @Override
    public boolean update(Pisewing data) {
    Pisewing p=find(data.getPisewingSerial());
    if(p!=null){
    Transaction t= session.beginTransaction();
    p.setSewingDate(data.getSewingDate());
    p.setPlanSewingProduction(data.getPlanSewingProduction());
    p.setActualSewingProduction(data.getActualSewingProduction());
    p.setNoOfLineSewing(data.getNoOfLineSewing());
    p.setNoOfLineDaysSewing(data.getNoOfLineDaysSewing());
    p.setNoOfLineHoursSewing(data.getNoOfLineHoursSewing());
    p.setTotalWorkingDay(data.getTotalWorkingDay());
    p.setAverageWorkinghourSewing(data.getAverageWorkinghourSewing());
    p.setMonthlyTotalRunningMc(data.getMonthlyTotalRunningMc());
    p.setMonthlyAverageRunningMc(data.getMonthlyAverageRunningMc());
    p.setFactoryTotalMc(data.getFactoryTotalMc());
    p.setSewingOperatorPresent(data.getSewingOperatorPresent());
    p.setSewingHelperPresent(data.getSewingHelperPresent());
    p.setSewingOperatorHelperPresent(data.getSewingOperatorHelperPresent());
    p.setTotalNoOfManHourAvilableMohel(data.getTotalNoOfManHourAvilableMohel());
    session.update(p);
    t.commit();}
    return true;
    }
    
}