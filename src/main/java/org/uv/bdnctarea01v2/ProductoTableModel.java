/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.bdnctarea01v2;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ian
 */
public abstract class ProductoTableModel<T> extends AbstractTableModel{
    
    protected String[] columnNames;
    protected List<T> list;
    
    public ProductoTableModel(String[] columnNames, List<T> list){
        this.list = list;
        this.columnNames = columnNames;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

//    @Override
//    public Object getValueAt(int rowIndex, int columnIndex) {
//        switch (columnIndex){
//            case 0: return list.get(rowIndex).getId();
//            case 1: return list.get(rowIndex).getDescripcion();
//            default: return null;
//        }
//    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
    
    
    
}
