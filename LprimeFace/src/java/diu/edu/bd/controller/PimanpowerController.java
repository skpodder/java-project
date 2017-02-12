/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diu.edu.bd.controller;

import diu.edu.bd.Pimanpower;
import diu.edu.bd.impl.PimanpowerDao;
import java.util.ArrayList;
import javax.faces.component.UIForm;



/**
 *
 * @author sagar
 */
public class PimanpowerController {
    public Pimanpower pimanpower=new Pimanpower();
    public PimanpowerDao pimanpowerDao=new PimanpowerDao();
    
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

    public Pimanpower getPimanpower() {
        return pimanpower;
    }

    public void setPimanpower(Pimanpower pimanpower) {
        this.pimanpower = pimanpower;
    }

    public PimanpowerDao getPimanpowerDao() {
        return pimanpowerDao;
    }

    public void setPimanpowerDao(PimanpowerDao pimanpowerDao) {
        this.pimanpowerDao = pimanpowerDao;
    }
    
    
    public PimanpowerController() {
        tableForm.setRendered(false);
    }
    public void save(){
    pimanpowerDao.save(pimanpower);
        setMsg("data saved");
    }
    public void update(){
    pimanpowerDao.update(pimanpower);
        setMsg("data has been updated");
    }
    public void delete(){
    pimanpowerDao.delete(pimanpower);
        setMsg("data has been deleted");
    }
    public ArrayList<Pimanpower> getPimanpowerList(){
    return (ArrayList<Pimanpower>) pimanpowerDao.display();
    }
    
    public void find(){
    Pimanpower manpower=pimanpowerDao.find(pimanpower.getPimanPowerSerial());
    if(manpower==null){
        setMsg("data not found");
    }
    else{
    pimanpower.setDate(manpower.getDate());
    pimanpower.setSweingOperatorPresent(manpower.getSweingOperatorPresent());
    pimanpower.setSweingHelperPresent(manpower.getSweingHelperPresent());
    pimanpower.setSweingOperatorHelperPresent(manpower.getSweingOperatorHelperPresent());
    pimanpower.setCuttingTotalManPower(manpower.getCuttingTotalManPower());
    pimanpower.setFinishingTotalManPower(manpower.getFinishingTotalManPower());
    pimanpower.setFactoryTotalManPower(manpower.getFactoryTotalManPower());
    pimanpower.setTotalNoOfManHourAvilableMohel(manpower.getTotalNoOfManHourAvilableMohel());
    pimanpower.setTotalNoOfManHourAvailableCutting(manpower.getTotalNoOfManHourAvailableCutting());
    pimanpower.setTotalNoOfManHourAvailableFinishing(manpower.getTotalNoOfManHourAvailableFinishing());
    pimanpower.setTotalNoOfManHourAvailableFactory(manpower.getTotalNoOfManHourAvailableFactory());
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
