 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diu.edu.bd.controller;

import diu.edu.bd.Picutting;
import diu.edu.bd.impl.PicuttingDao;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIForm;

/**
 *
 * @author sagar
 */
@ManagedBean
@RequestScoped
public class PicuttingController {
    public Picutting picutting=new Picutting();
    public PicuttingDao picuttingDao=new PicuttingDao();
    public String msg="";
      private UIForm tableForm=new UIForm();
      private UIForm uif=new UIForm();

    public UIForm getUif() {
        return uif;
    }

    public void setUif(UIForm uif) {
        this.uif = uif;
    }

    public UIForm getTableForm() {
        return tableForm;
    }

    public void setTableForm(UIForm tableForm) {
        this.tableForm = tableForm;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    
    public Picutting getPicutting() {
        return picutting;
    }

    public void setPicutting(Picutting picutting) {
        this.picutting = picutting;
    }

    public PicuttingDao getPicuttingDao() {
        return picuttingDao;
    }

    public void setPicuttingDao(PicuttingDao picuttingDao) {
        this.picuttingDao = picuttingDao;
    }
    
    
    public PicuttingController() {
        tableForm.setRendered(false);
        uif.setRendered(false);
    }
    public void save(){
    picuttingDao.save(picutting);
        setMsg("Data has been saved");
    }
    public void update(){
    picuttingDao.update(picutting);
        setMsg("Data has been successfully update");
    }
    public void find(){
    Picutting cutting=picuttingDao.find(picutting.getPicuttingSerial());
    if(cutting==null){
        setMsg("data is not found");
    }else{
    picutting.setCuttingDate(cutting.getCuttingDate());
       // System.out.println(picutting.getCuttingDate()+"   ....................."+cutting.getCuttingDate());
    picutting.setPlanCuttingProduction(cutting.getPlanCuttingProduction());
    picutting.setActualCuttingProduction(cutting.getActualCuttingProduction());
    
    picutting.setTotalWorkingDay(cutting.getTotalWorkingDay());
    picutting.setAverageWorkinghourCutting(cutting.getAverageWorkinghourCutting());
    picutting.setCuttingTotalManPower(cutting.getCuttingTotalManPower());
    picutting.setTotalNoOfManHourAvailableCutting(cutting.getTotalNoOfManHourAvailableCutting());
        setMsg("data found");
    }
    }
    public void delete(){
    picuttingDao.delete(picutting);
        setMsg("data has been deleted");
    }
    public ArrayList<Picutting>getPicuttingList(){
    return (ArrayList<Picutting>)picuttingDao.display();
    }
    
    public void display(){
    
    tableForm.setRendered(true);
  uif.setRendered(true);
    }
    public void hide(){
    tableForm.setRendered(false);
   uif.setRendered(false);
    }
    
    
    
}
