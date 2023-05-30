/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.produccionModels;
import view.DashBoard;

public class produccionDTO {

    List<produccionModels> elementos = new ArrayList<produccionModels>();

    public produccionDTO() {

    }

    public int lastItemList() {
        return elementos.get(elementos.size() - 1).getId();
    }

    public void Aceptar(String actividad, String codigo, int id, String nombre, String responsable, String uso) {
        elementos.add(new produccionModels(actividad, codigo, id, nombre, responsable, uso));
        JOptionPane.showMessageDialog(null, "Se agrego correctamente");
    }

    public void setDatos(DashBoard db) {
        DefaultTableModel modeloTabla = (DefaultTableModel) db.tblProduccion.getModel();
        limpiarTable(modeloTabla);
        int columnas = modeloTabla.getColumnCount();
        Object[] datos = new Object[columnas];
        for (int i = 0; i < elementos.size(); i++) {
            datos[0] = i;
            datos[1] = elementos.get(i).getId();
            datos[2] = elementos.get(i).getActividad();
            datos[3] = elementos.get(i).getNombre();
            datos[4] = elementos.get(i).getCodigo();
            datos[5] = elementos.get(i).getResponsable();
            datos[6] = elementos.get(i).getUso();
            modeloTabla.addRow(datos);
        }
    }

    public void limpiarTable(DefaultTableModel modeloTabla) {
        for (int i = 0; i < modeloTabla.getRowCount(); i++) {
            modeloTabla.removeRow(i);
            i = i - 1;
        }
    }

    public void filaSeleccionar(int filaActual, DashBoard db) {
        db.txt_id.setText("" + db.tblProduccion.getValueAt(filaActual, 1));
        db.txt_Actividad.setText("" + db.tblProduccion.getValueAt(filaActual, 2));
        db.txt_Codigo.setText("" + db.tblProduccion.getValueAt(filaActual, 4));
        db.txt_Nombre.setText("" + db.tblProduccion.getValueAt(filaActual, 3));
        db.txt_Responsable.setText("" + db.tblProduccion.getValueAt(filaActual, 5));
        db.txt_uso.setText("" + db.tblProduccion.getValueAt(filaActual, 6));
    }

    public void Actualizar(String actividad, String codigo, int id, String nombre, String responsable, String uso) {
        elementos.get(id).setActividad(actividad);
        elementos.get(id).setCodigo(codigo);
        elementos.get(id).setNombre(nombre);
        elementos.get(id).setResponsable(responsable);
        elementos.get(id).setUso(uso);
    }

    public void removeRow(int filaActual) {
        if (filaActual != -1) {
            System.out.println(filaActual);
            JOptionPane.showMessageDialog(null, "Se elimino el registro: " + filaActual);
            elementos.remove(filaActual);
        }
    }

    public void LimpiarCampos(DashBoard db) {
        int contador = Integer.parseInt(db.ilbd.getText());
        db.txt_Nombre.setText("");
        db.txt_Actividad.setText("");
        db.txt_id.setText("");
        db.txt_Responsable.setText("");
        db.txt_uso.setText("");
        db.txt_Actividad.requestFocus(true);
    }

    public boolean ExportarInfo() {
        String ruta = System.getProperty("user.home");
        String url = ruta + "\\OneDrive\\Escritorio\\tblProduccion.txt";
        System.out.println("Inico guardar archivo");
        File archivo = new File(url);
        PrintWriter escribir;
        try {
            escribir = new PrintWriter(archivo);
            for (produccionModels prod : elementos) {
                escribir.print("ID: " + prod.getId() + "  ");
                escribir.print("Actividad : " + prod.getActividad() + "  ");
                escribir.print("Codigo: " + prod.getCodigo() + "  ");
                escribir.print("Nombre: " + prod.getNombre() + "  ");
                escribir.print("Responsable: " + prod.getResponsable()+ "\n");
                escribir.print("Uso: " + prod.getUso()+ "\n");
            }
            escribir.close();
            return true;
        } catch (FileNotFoundException ex) {
            System.out.println("Error en crear archivo " + ex.getMessage());
            return false;
        }
    }

}
