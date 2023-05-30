/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DTO.produccionDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import view.DashBoard;

public class ControllerPrincipal implements ActionListener, MouseListener{
    
    DashBoard mn;
    produccionDTO pro = new produccionDTO();
    int filaActual = 0;

    public ControllerPrincipal(DashBoard mn) {
        this.mn = mn;
        this.mn.btn_insertar.addActionListener(this);
        this.mn.btn_ver.addActionListener(this);
        this.mn.btn_insertar.addActionListener(this);
        this.mn.btn_modificar.addActionListener(this);
        this.mn.btn_eliminar.addActionListener(this);
        this.mn.tblProduccion.addMouseListener(this);
        this.mn.btn_export.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mn.btn_insertar) {
            pro.Aceptar(mn.txt_Actividad.getText(), mn.txt_Codigo.getText(), Integer.parseInt(mn.txt_id.getText()), mn.txt_Nombre.getText(), mn.txt_Responsable.getText(), mn.txt_uso.getText());
        } else if (e.getSource() == mn.btn_ver) {
            pro.setDatos(mn);
        } else if (e.getSource() == mn.btn_eliminar) {
            pro.removeRow(filaActual);
        } else if (e.getSource() == mn.btn_modificar) {
            pro.Actualizar(mn.txt_Actividad.getText(), mn.txt_Codigo.getText(), Integer.parseInt(mn.txt_id.getText()), mn.txt_Nombre.getText(), mn.txt_Responsable.getText(), mn.txt_uso.getText());
        }else if(e.getSource() == mn.btn_export){
                if(pro.ExportarInfo()){
                   JOptionPane.showMessageDialog(null, "Se creo correctamente");
                   mn.Exportar.setLocation(400,0);
                   mn.Exportar.setSize(600, 600);
                   mn.Exportar.setVisible(true);
               }else{
                   JOptionPane.showMessageDialog(null, "Error.. Verifique.");
               }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == mn.tblProduccion){
             filaActual = mn.tblProduccion.getSelectedRow();
            pro.filaSeleccionar(filaActual, mn);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
 }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    
    
}
