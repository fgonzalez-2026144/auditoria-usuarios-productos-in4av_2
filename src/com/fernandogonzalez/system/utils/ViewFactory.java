/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fernandogonzalez.system.utils;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import com.fernandogonzalez.system.ClasePrincipal;

/**
 *
 * @author informatica
 */
public class ViewFactory {
    
    private final String PATH_VIEWS = "/com/fernandogonzalez/system/view/";
    
    public ViewFactory() {
        
    }
    
    public Scene loadFileFXML(String nameFXML, int width, int height) {
        String pathOfFile = PATH_VIEWS + nameFXML;
        try {
            //FXMLLoader
            FXMLLoader loaderFXML = new FXMLLoader();
            //Leer la URL del archivo
            //Llamar archivo main
            URL urlFile = ClasePrincipal.class.getResource(pathOfFile);
            loaderFXML.setBuilderFactory(new JavaFXBuilderFactory());
            loaderFXML.setLocation(urlFile);
            return new Scene(loaderFXML.load(), width, height);
        } catch (IOException exception) {
            throw new UncheckedIOException(exception);
        }
    }
    
    public void loadScene(String nameFXML) {
        Scene scene = null;
        try {
            switch (nameFXML) {
                case "login" -> {
                    SceneManager.getInstanciaSceneManager().getStagePrincipal().setTitle("LOGIN USUARIO");
                    SceneManager.getInstanciaSceneManager().getStagePrincipal().setResizable(false);
                    SceneManager.getInstanciaSceneManager().getStagePrincipal().getIcons().add(new Image(ClasePrincipal.class.getResourceAsStream("/com/fernandogonzalez/system/resources/images/Designer.png")));
                    scene = loadFileFXML("LoginsView.fxml", 500, 550);
                }
                case "register" -> {
                    SceneManager.getInstanciaSceneManager().getStagePrincipal().setTitle("REGISTRO USUARIO");
                    SceneManager.getInstanciaSceneManager().getStagePrincipal().setResizable(false);
                    scene = loadFileFXML("RegisterUsersView.fxml", 500, 600);
                }
                default ->
                    scene = loadFileFXML("LoginsView.fxml", 500, 550);
            }
            SceneManager.getInstanciaSceneManager().chageScene(scene);
        } catch (NullPointerException objetoNulo) {
            System.out.println(" error al cargar escena");
        }
    }
    
    public void viewLogin() {
        loadScene("login");
    }

    public void viewRegister() {
        loadScene("register");
    }
}
