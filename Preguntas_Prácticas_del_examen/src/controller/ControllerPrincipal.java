/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import view.DashBoard;

public class ControllerPrincipal {
    
    DashBoard mn;

    public ControllerPrincipal(DashBoard mn) {
        this.mn = mn;
        imprimirProduccion();
    }
    
    
    public void imprimirProduccion(){
        String Produccion = " Actividad: SubProceso de Autorización de Insumos para su compra\n" +
"    Codigo: FAB-006\n" +
"    Id: 7\n" +
"    Nombre: FAB-005 Control de Calidad\n" +
"    Responsable: FABRICACION\n" +
"    Uso: CALIDAD";
        mn.textArea.setText(Produccion);
    }
    
}
