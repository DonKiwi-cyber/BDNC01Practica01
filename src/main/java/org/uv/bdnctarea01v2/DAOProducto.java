/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.bdnctarea01v2;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author ian
 */
public class DAOProducto implements IDAOGeneral<Producto>{

    SessionFactory sf = null;
    Transaction tra = null;
    Session session = null;
    
    @Override
    public boolean guardar(Producto p) {
        boolean success = false;
        try{
            sf = HibernateUtil.getSessionFactory();
            session = sf.getCurrentSession();
            tra = session.beginTransaction();
            session.save(p);
            tra.commit();
            session.close();
            success = true;
        }
        catch(HibernateException e) {
            if (tra != null) {
                tra.rollback();
            }
        } 
        return success;
    }

    @Override
    public boolean modificar(Producto p, Long id) {
        boolean success = false;
        try{
            sf = HibernateUtil.getSessionFactory();
            session = sf.getCurrentSession();
            tra = session.beginTransaction();
            Producto pro = session.get(Producto.class, id);
            if (pro != null){
                session.update(p);
                tra.commit();
                success = true;
            }
            session.close();
        }
        catch(HibernateException e) {
            if (tra != null) {
                tra.rollback();
            }
        } 
        return success;
    }

    @Override
    public boolean eliminar(int id) {
        boolean success = false;
        try{
            sf = HibernateUtil.getSessionFactory();
            session = sf.getCurrentSession();
            tra = session.beginTransaction();
            Producto pro = session.get(Producto.class, id);
            if (pro != null){
                session.delete(id);
                tra.commit();
                success = true;
            }
            session.close();
        }
        catch(HibernateException e) {
            if (tra != null) {
                tra.rollback();
            }
        } 
        return success;
    }

    @Override
    public Producto findByID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Producto> findAll() {
        try{
            sf = HibernateUtil.getSessionFactory();
            session = sf.getCurrentSession();
            tra = session.beginTransaction();
            List<Producto> list = 
                    session.createQuery("from producto", 
                            Producto.class).list();
            tra.commit();
            return list;
        } catch(HibernateException e){
            if (tra != null) {
                tra.rollback();
            }
            return null;
        }  
    }
    
}
