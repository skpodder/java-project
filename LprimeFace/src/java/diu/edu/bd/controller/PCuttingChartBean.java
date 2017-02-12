/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diu.edu.bd.controller;

import diu.edu.bd.util.DatabaseUtil;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.naming.NamingException;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

/**
 *
 * @author sagar
 */
@ManagedBean
@RequestScoped
public class PCuttingChartBean implements Serializable{
public BarChartModel barChartModel=new BarChartModel();

DatabaseUtil databaseUtil=new DatabaseUtil();



    /**
     * Creates a new instance of PCuttingChartBean
     */
    public PCuttingChartBean() {
    try {
        Statement stm=databaseUtil.getKpi().getConnection().createStatement();
        ResultSet rsm=stm.executeQuery("SELECT monthname(cuttingDate) Month ,sum(planCuttingProduction) Plan,sum( p.`actualCuttingProduction`) actual  FROM kpi.picutting p group by month");
        ChartSeries actual=new ChartSeries();
        actual.setLabel("Actual");
        ChartSeries plan=new ChartSeries();
        plan.setLabel("Plan");
        ChartSeries month=new ChartSeries();
        month.setLabel("KPI");
        while(rsm.next()){
        actual.set(rsm.getString(1), rsm.getInt(3));
         plan.set(rsm.getString(1), rsm.getInt(2));
          month.set(rsm.getString(1), 100*rsm.getInt(3)/rsm.getInt(2));
        }
        barChartModel.addSeries(actual);
        barChartModel.addSeries(plan);
          barChartModel.addSeries(month);
    } catch (SQLException ex) {
        Logger.getLogger(PCuttingChartBean.class.getName()).log(Level.SEVERE, null, ex);
    } catch (NamingException ex) {
        Logger.getLogger(PCuttingChartBean.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    public BarChartModel getBarChartModel() {
        return barChartModel;
    }

    public void setBarChartModel(BarChartModel barChartModel) {
        this.barChartModel = barChartModel;
    }

    public DatabaseUtil getDatabaseUtil() {
        return databaseUtil;
    }

    public void setDatabaseUtil(DatabaseUtil databaseUtil) {
        this.databaseUtil = databaseUtil;
    }
    
}
