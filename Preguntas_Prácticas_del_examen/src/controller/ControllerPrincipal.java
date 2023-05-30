/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DTO.produccionDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.DashBoard;

public class ControllerPrincipal implements ActionListener{
    
    DashBoard mn;
    produccionDTO pro = new produccionDTO();
    

    public ControllerPrincipal(DashBoard mn) {
        this.mn = mn;
        this.mn.btn_insertar.addActionListener(this);
        this.mn.btn_ver.addActionListener(this);
    }
    
    
    public void imprimirProduccion(String textoProduccion){
        mn.textArea.setText(textoProduccion);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mn.btn_insertar) {
            pro.Aceptar(mn.txt_Actividad.getText(), mn.txt_Codigo.getText(), Integer.parseInt(mn.txt_id.getText()), mn.txt_Nombre.getText(), mn.txt_Responsable.getText(), mn.txt_uso.getText());
        } else if (e.getSource() == mn.btn_ver) {
            imprimirProduccion(pro.setDatos());
        }
    }
    
    
    
}
