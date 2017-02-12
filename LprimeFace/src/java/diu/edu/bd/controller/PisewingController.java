/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diu.edu.bd.controller;
import diu.edu.bd.Pisewing;
import diu.edu.bd.impl.PisewingDao;
import java.util.ArrayList;
import javax.faces.component.UIForm;
/**
 *
 * @author sagar
 */
public class PisewingController {
    public Pisewing pisewing= new Pisewing();
    public PisewingDao pisewingDao=new PisewingDao();
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
    public Pisewing getPisewing() {
        return pisewing;
    }
    public void setPisewing(Pisewing pisewing) {
        this.pisewing = pisewing;
    }
    public PisewingDao getPisewingDao() {
        return pisewingDao;
    }
    public void setPisewingDao(PisewingDao pisewingDao) {
        this.pisewingDao = pisewingDao;
    }
    
    
    public PisewingController() {
        tableForm.setRendered(false);
    }
    
    
    public void save(){
    pisewingDao.save(pisewing);
        setMsg("data has been saved");
    }
    public void delete(){
    pisewingDao.delete(pisewing);
        setMsg("data has been deleted");
    }
    public void update(){
    pisewingDao.update(pisewing);
        setMsg("data has been updated");
    }
    public ArrayList<Pisewing> getPisewingList(){
    return (ArrayList<Pisewing>) pisewingDao.display();
    }
    
    public void find(){
    Pisewing sewing=pisewingDao.find(pisewing.getPisewingSerial());
    if(sewing==null){
        setMsg("data not found");
    }
    else{
    pisewing.setSewingDate(sewing.getSewingDate());
    pisewing.setPlanSewingProduction(sewing.getPlanSewingProduction());
    pisewing.setActualSewingProduction(sewing.getActualSewingProduction());
    pisewing.setNoOfLineSewing(sewing.getNoOfLineSewing());
    pisewing.setNoOfLineDaysSewing(sewing.getNoOfLineDaysSewing());
    pisewing.setNoOfLineHoursSewing(sewing.getNoOfLineHoursSewing());
    pisewing.setTotalWorkingDay(sewing.getTotalWorkingDay());
    pisewing.setAverageWorkinghourSewing(sewing.getAverageWorkinghourSewing());
    pisewing.setMonthlyTotalRunningMc(sewing.getMonthlyTotalRunningMc());
    pisewing.setMonthlyAverageRunningMc(sewing.getMonthlyAverageRunningMc());
    pisewing.setFactoryTotalMc(sewing.getFactoryTotalMc());
    pisewing.setSewingOperatorPresent(sewing.getSewingOperatorPresent());
    pisewing.setSewingHelperPresent(sewing.getSewingHelperPresent());
    pisewing.setSewingOperatorHelperPresent(sewing.getSewingOperatorHelperPresent());
    pisewing.setTotalNoOfManHourAvilableMohel(sewing.getTotalNoOfManHourAvilableMohel());
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