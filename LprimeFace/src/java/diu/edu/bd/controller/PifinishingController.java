/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diu.edu.bd.controller;

import diu.edu.bd.Pifinishing;
import diu.edu.bd.impl.PifinishingDao;
import java.util.ArrayList;

import javax.faces.component.UIForm;


public class PifinishingController {

   public Pifinishing pifinishing=new Pifinishing();
   public PifinishingDao pifinishingDao=new PifinishingDao();
   String msg="";
   
   
   private UIForm tableForm=new UIForm();
   
   public UIForm getTableForm(){
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

    public Pifinishing getPifinishing() {
        return pifinishing;
    }

    public void setPifinishing(Pifinishing pifinishing) {
        this.pifinishing = pifinishing;
    }

    public PifinishingDao getPifinishingDao() {
        return pifinishingDao;
    }

    public void setPifinishingDao(PifinishingDao pifinishingDao) {
        this.pifinishingDao = pifinishingDao;
    }
   
    public PifinishingController() {
        tableForm.setRendered(false);
    }
    
    public void save(){
    pifinishingDao.save(pifinishing);
        setMsg("data has been saved");
    }
    
    public void update(){
    pifinishingDao.update(pifinishing);
        setMsg("data has been updated");
    }
    
    public void delete(){
    pifinishingDao.delete(pifinishing);
        setMsg("data has been deleted");
    }
   public ArrayList<Pifinishing> getPifinishingList(){
        return (ArrayList<Pifinishing>)pifinishingDao.display();
    }
   public void find(){
   Pifinishing finishing=pifinishingDao.find(pifinishing.getPifinishingSerial());
   if(finishing==null){
       setMsg("data not found");
   }else{
   pifinishing.setFinishingDate(finishing.getFinishingDate());
   pifinishing.setPlanFinishingProduction(finishing.getPlanFinishingProduction());
   pifinishing.setActualFinishingProduction(finishing.getActualFinishingProduction());
   pifinishing.setTotalWorkingDay(finishing.getTotalWorkingDay());
   pifinishing.setAverageWorkinghourFinishing(finishing.getAverageWorkinghourFinishing());
   pifinishing.setFinishingTotalManPower(finishing.getFinishingTotalManPower());
   pifinishing.setTotalNoOfManHourAvailableFinishing(finishing.getTotalNoOfManHourAvailableFinishing());
   
       setMsg("Data Found");
   }
   }
   
   public void display(){
   tableForm.setRendered(true);
   }
   public void hide(){
   tableForm.setRendered(false);
   }
}
