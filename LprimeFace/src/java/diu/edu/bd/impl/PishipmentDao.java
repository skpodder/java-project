/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diu.edu.bd.impl;
import diu.edu.bd.Pishipment;
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
public class PishipmentDao implements Dao<Pishipment>{
    Session session=KpiUtil.getSessionFactory().openSession();
    @Override
    public boolean save(Pishipment data) {
        Transaction t = session.beginTransaction();
        session.save(data);
        t.commit();
        return true;
    }
    @Override
    public List<Pishipment> display() {
    ArrayList<Pishipment>arrayList= (ArrayList<Pishipment>)session.createCriteria(Pishipment.class).list();
           return arrayList;
    }
    @Override
    public void delete(Pishipment data) {
        Pishipment p=find(data.getPishipmentSerial());
        Transaction t = session.beginTransaction();
        session.delete(p);
        }
    @Override
    public Pishipment find(int id) {
    return (Pishipment)session.get(Pishipment.class, id);
    
    }
    @Override
     public boolean update(Pishipment data) {
        Pishipment p=find(data.getPishipmentSerial());
        if(p!=null){
        Transaction t=session.beginTransaction();
       p.setShipmentDate(data.getShipmentDate());
       p.setPlanShippedQuantityTotal(data.getActualShippedQuantityTotal());
       p.setActualShippedQuantityTotal(data.getActualShippedQuantityTotal());
        session.update(p);
        t.commit();}
        return true;
    }
    
}