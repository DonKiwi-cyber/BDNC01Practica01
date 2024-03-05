/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.bdnctarea01v2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ian
 */
public class DAODepartamento implements IDAOGeneral<Departamento>{
    
    boolean res = false;
    ResultSet rset = null;

    @Override
    public boolean guardar(Departamento p) {
        ConexionDB con= ConexionDB.getInstance();
        String sql="insert into departamento (nombre) values ('" + p.getNombre()+"')";
        res = con.execute(sql);
        return res;
    }

    @Override
    public boolean modificar(Departamento p, Long id) {
        ConexionDB con= ConexionDB.getInstance();
        String sql="update departamento set nombre = '" + p.getNombre()
                + "' where id = '"+ id +"'";
        res = con.execute(sql);
        return res;
    }

    @Override
    public boolean eliminar(int id) {
        ConexionDB con= ConexionDB.getInstance();
        String sql="delete from departamento where id = '"+ String.valueOf(id) +"'";
        res = con.execute(sql);
        return res;
    }

    @Override
    public Departamento findByID(int id) {
        try {
            Departamento dep = null;
            ConexionDB con= ConexionDB.getInstance();
            String sql = "Select from departamento where id = '"+ String.valueOf(id)+"'";
            rset = con.select(sql);
            if(rset.next()){
                dep = new Departamento();
                dep.setId(rset.getInt("id"));
                dep.setNombre(rset.getString("nombre"));
            }
            return dep;
        } catch (SQLException ex) {
            Logger.getLogger(DAODepartamento.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<Departamento> findAll() {
        try {
            Departamento dep = null;
            ArrayList<Departamento> list = new ArrayList<>();
            ConexionDB con= ConexionDB.getInstance();
            String sql = "Select * from departamento";
            rset = con.select(sql);
            while(rset.next()){
                dep = new Departamento();
                dep.setId(rset.getInt("id"));
                dep.setNombre(rset.getString("nombre"));
                list.add(dep);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(DAODepartamento.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
