/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.fernandogonzalez.system;

import javafx.application.Application;
import javafx.stage.Stage;
import com.fernandogonzalez.system.utils.SceneManager;
import com.fernandogonzalez.system.utils.ViewFactory;

/**
 *
 * @author informatica
 */
public class ClasePrincipal extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stageRoot) {
        SceneManager.getInstanciaSceneManager().setStagePrincipal(stageRoot);
        ViewFactory viewFactory = new ViewFactory();
        viewFactory.viewLogin();
    }

}
