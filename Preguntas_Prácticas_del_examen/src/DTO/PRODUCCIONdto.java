/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.produccionModels;


public class produccionDTO {
    List<produccionModels> elementos = new ArrayList<produccionModels>();

    public produccionDTO() {
        
    }
    
    public int lastItemList(){
        return  elementos.get(elementos.size()-1).getId();
    }
    
    public void Aceptar(String actividad, String codigo, int id, String nombre, String responsable, String uso) {
        elementos.add(new produccionModels(actividad, codigo, id, nombre, responsable, uso));
        JOptionPane.showMessageDialog(null, "Se agrego correctamente");
    }

    public String setDatos() {
        String response = "";
        for (int i = 0; i < elementos.size(); i++) {
            response += "id " + elementos.get(i).getId()+"\n";
            response += "Actividad: " + elementos.get(i).getActividad()+"\n";
            response += "nombre " + elementos.get(i).getNombre()+"\n";
            response += "codigo " + elementos.get(i).getCodigo()+"\n";
            response += "responsable " + elementos.get(i).getResponsable()+"\n";
            response += "uso " + elementos.get(i).getUso()+"\n";
        }
        return response;
    }

}

