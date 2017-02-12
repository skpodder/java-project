/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diu.edu.bd.controller;

import diu.edu.bd.Pishipment;
import diu.edu.bd.impl.PishipmentDao;
import java.util.ArrayList;
import javax.faces.component.UIForm;

/**
 *
 * @author sagar
 */
public class PishipmentController {

    public Pishipment pishipment = new Pishipment();
    public PishipmentDao pishipmentDao = new PishipmentDao();

    private UIForm tableForm = new UIForm();

    public UIForm getTableForm() {
        return tableForm;
    }

    public void setTableForm(UIForm tableForm) {
        this.tableForm = tableForm;
    }

    public Pishipment getPishipment() {
        return pishipment;
    }

    public void setPishipment(Pishipment pishipment) {
        this.pishipment = pishipment;
    }

    public PishipmentDao getPishipmentDao() {
        return pishipmentDao;
    }

    public void setPishipmentDao(PishipmentDao pishipmentDao) {
        this.pishipmentDao = pishipmentDao;
    }
    public String msg = "";

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public PishipmentController() {
        tableForm.setRendered(false);
    }

    public void save() {
        pishipmentDao.save(pishipment);
        setMsg("data saved successfully");
    }

    public void update() {
        pishipmentDao.update(pishipment);
        setMsg("data update");
    }

    public void delete() {
        pishipmentDao.delete(pishipment);
        setMsg("data deleted");
    }

    public ArrayList<Pishipment> getPishipmentList() {
        return (ArrayList<Pishipment>) pishipmentDao.display();

    }

    public void find() {
        Pishipment shipment = pishipmentDao.find(pishipment.getPishipmentSerial());
        if (shipment == null) {
            setMsg("data not found");
        } else {
            pishipment.setShipmentDate(shipment.getShipmentDate());
            pishipment.setActualShippedQuantityTotal(shipment.getActualShippedQuantityTotal());
            pishipment.setPlanShippedQuantityTotal(shipment.getPlanShippedQuantityTotal());
            setMsg("data has been found");
        }
    }
    
    public void display(){
    tableForm.setRendered(true);
    }
    
    public void hide(){
    tableForm.setRendered(false);
    }

}
