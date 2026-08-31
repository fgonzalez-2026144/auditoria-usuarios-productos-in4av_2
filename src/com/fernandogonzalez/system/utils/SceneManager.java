/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fernandogonzalez.system.utils;

import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author informatica
 */
public class SceneManager {

    private static SceneManager instanciaSceneManager;
    private Stage stagePrincipal;

    private SceneManager() {

    }

    public static SceneManager getInstanciaSceneManager() {
        if (instanciaSceneManager == null) {
            instanciaSceneManager = new SceneManager();
        }
        return instanciaSceneManager;
    }
    /**
     * Este metodo permite recibir un parametro de tipo Scene y
     * es la escena que mostrara en el Stage
     * @param scene Escena a mostrar en el Stage
     */
    
    public void chageScene(Scene scene) {
        try {
            stagePrincipal.setScene(scene);
            stagePrincipal.sizeToScene();
            stagePrincipal.show();
        } catch (NullPointerException objetoNulo) {
        }
    }

    public Stage getStagePrincipal() {
        return stagePrincipal;
    }

    public void setStagePrincipal(Stage stagePricipal) {
        this.stagePrincipal = stagePricipal;
    }

}
