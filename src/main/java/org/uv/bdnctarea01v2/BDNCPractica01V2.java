/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.bdnctarea01v2;

/**
 *
 * @author ian
 */
public class BDNCPractica01V2 {
    
    public static void main(String[] args){
//        DAODepartamento daoD = new DAODepartamento();
//        Departamento dep = new Departamento();
//        
//        dep.setNombre("Contabilidad");
//        
//        boolean res = daoD.guardar(dep);
//        if(res){
//            System.out.println("se guardó");
//        }

        DAOEmpleado daoE = new DAOEmpleado();
        Empleado emp = new Empleado();
        
        emp.setNombre("Uriel");
        emp.setDireccion("puebla");
        emp.setTelefono("88888");
        emp.setDepartamento(1);
        
        boolean res = daoE.guardar(emp);
        if(res){
            System.out.println("se guardó");
        }
    }
}
