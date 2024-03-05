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
public class DAOEmpleado implements IDAOGeneral<Empleado>{

    boolean res = false;
    ResultSet rset = null;
    
    @Override
    public boolean guardar(Empleado p) {
        ConexionDB con = ConexionDB.getInstance();
        String sql = "insert into empleado (nombre, direccion, telefono, departamento)"+
                "values ('"+ p.getNombre() +"', '"+ p.getDireccion() +"', '"+ p.getTelefono() +
                "', '"+ String.valueOf(p.getDepartamento())+"')";
        boolean res= con.execute(sql);
        return res;
    }

    @Override
    public boolean modificar(Empleado p, Long id) {
        ConexionDB con= ConexionDB.getInstance();
        String sql="update empleado set nombre = '" + p.getNombre()
                + "', direccion = '"+ p.getDireccion() +"', telefono = '"+ 
                p.getTelefono() +"', departamento = '"+ String.valueOf(p.getDepartamento()) +
                "' where id = '"+ id +"'";
        res = con.execute(sql);
        return res;
    }

    @Override
    public boolean eliminar(int id) {
        ConexionDB con= ConexionDB.getInstance();
        String sql="delete from departamento where id = '"+ id +"'";
        res = con.execute(sql);
        return res;
    }

    @Override
    public Empleado findByID(int id) {
        try {
            Empleado emp = null;
            ConexionDB con= ConexionDB.getInstance();
            String sql = "Select from empleado where id = '"+ id +"'";
            rset = con.select(sql);
            if(rset.next()){
                emp = new Empleado();
                emp.setId(rset.getInt("id"));
                emp.setNombre(rset.getString("nombre"));
                emp.setDireccion(rset.getString("direccion"));
                emp.setTelefono(rset.getString("telefono"));
                emp.setDepartamento(rset.getInt("departamento"));
            }
            return emp;
        } catch (SQLException ex) {
            Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<Empleado> findAll() {
        try {
            ArrayList<Empleado> list = new ArrayList<>();
            ConexionDB con= ConexionDB.getInstance();
            String sql = "Select * from empleado";
            rset = con.select(sql);
            while(rset.next()){
                Empleado emp = new Empleado();
                emp.setId(rset.getInt("id"));
                emp.setNombre(rset.getString("nombre"));
                emp.setDireccion(rset.getString("direccion"));
                emp.setTelefono(rset.getString("telefono"));
                emp.setDepartamento(rset.getInt("departamento"));
                list.add(emp);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
