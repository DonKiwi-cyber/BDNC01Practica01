/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.uv.bdnctarea01v2;

import java.util.List;

/**
 *
 * @author ian
 * @param <T>
 */
public interface IDAOGeneral<T> {
    public boolean guardar(T p);
    public boolean modificar(T p, Long id);
    public boolean eliminar(int id);
    public T findByID(int id);
    public List<T> findAll();
}
