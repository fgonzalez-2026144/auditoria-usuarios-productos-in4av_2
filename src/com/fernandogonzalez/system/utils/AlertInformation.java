/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fernandogonzalez.system.utils;

/**
 *
 * @author informatica
 */
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AlertInformation {

    /**
     * Constructor vacío público
     */
    public AlertInformation() {
    }

    /**
     * Muestra una alerta de JavaFX configurada con los parámetros recibidos.
     *
     * @param tipoAlerta Número que indica el tipo de alerta (1: INFO, 2:
     * WARNING, 3: ERROR, 4: CONFIRMATION)
     * @param titulo El título de la ventana de la alerta
     * @param mensaje El mensaje principal (contenido) de la alerta
     * @param encabezado El texto de encabezado de la alerta
     */
    public void viewAlert(int tipoAlerta, String titulo, String mensaje, String encabezado) {

        // Variable local de tipo AlertType que almacenará el resultado del switch
        AlertType tipoAlertaMostrar = AlertType.NONE;

        // Switch para determinar el tipo de Alerta de JavaFX
        switch (tipoAlerta) {
            case 1:
                tipoAlertaMostrar = AlertType.INFORMATION;
                break;
            case 2:
                tipoAlertaMostrar = AlertType.WARNING;
                break;
            case 3:
                tipoAlertaMostrar = AlertType.ERROR;
                break;
            case 4:
                tipoAlertaMostrar = AlertType.CONFIRMATION;
                break;
            default:
                tipoAlertaMostrar = AlertType.NONE;
                System.out.println("Tipo de alerta no reconocido, se usará NONE por defecto.");
                break;
        }

        // Creación y configuración de la alerta de JavaFX
        Alert alert = new Alert(tipoAlertaMostrar);
        alert.setTitle(titulo);
        alert.setHeaderText(encabezado);
        alert.setContentText(mensaje);

        // Mostrar la alerta y esperar a que el usuario la cierre
        alert.showAndWait();
    }
}
