/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diu.edu.bd.dao;

import java.util.List;



/**
 *
 * @author sagar
 */
public interface Dao <T>{
    public boolean save (T data);
    public List <T> display();
    public void delete (T data);
    public T find(int id);
    public boolean update(T data);
}
