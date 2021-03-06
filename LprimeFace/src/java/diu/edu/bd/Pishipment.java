package diu.edu.bd;
// Generated Jun 4, 2016 8:48:36 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Pishipment generated by hbm2java
 */
public class Pishipment  implements java.io.Serializable {


     private int pishipmentSerial;
     private Date shipmentDate;
     private Integer planShippedQuantityTotal;
     private Integer actualShippedQuantityTotal;

    public Pishipment() {
    }

	
    public Pishipment(int pishipmentSerial) {
        this.pishipmentSerial = pishipmentSerial;
    }
    public Pishipment(int pishipmentSerial, Date shipmentDate, Integer planShippedQuantityTotal, Integer actualShippedQuantityTotal) {
       this.pishipmentSerial = pishipmentSerial;
       this.shipmentDate = shipmentDate;
       this.planShippedQuantityTotal = planShippedQuantityTotal;
       this.actualShippedQuantityTotal = actualShippedQuantityTotal;
    }
   
    public int getPishipmentSerial() {
        return this.pishipmentSerial;
    }
    
    public void setPishipmentSerial(int pishipmentSerial) {
        this.pishipmentSerial = pishipmentSerial;
    }
    public Date getShipmentDate() {
        return this.shipmentDate;
    }
    
    public void setShipmentDate(Date shipmentDate) {
        this.shipmentDate = shipmentDate;
    }
    public Integer getPlanShippedQuantityTotal() {
        return this.planShippedQuantityTotal;
    }
    
    public void setPlanShippedQuantityTotal(Integer planShippedQuantityTotal) {
        this.planShippedQuantityTotal = planShippedQuantityTotal;
    }
    public Integer getActualShippedQuantityTotal() {
        return this.actualShippedQuantityTotal;
    }
    
    public void setActualShippedQuantityTotal(Integer actualShippedQuantityTotal) {
        this.actualShippedQuantityTotal = actualShippedQuantityTotal;
    }




}


