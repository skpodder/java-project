/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diu.edu.bd.util;

import diu.edu.bd.Picutting;
import diu.edu.bd.impl.PicuttingDao;

/**
 *
 * @author sagar
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        PicuttingDao dao=new PicuttingDao();
        Picutting p=dao.find(1);
        System.out.println(p.getCuttingDate());
    }
    
}
