/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fernandogonzalez.system.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import com.fernandogonzalez.system.service.UserService;
import com.fernandogonzalez.system.service.UserStatus;
import com.fernandogonzalez.system.utils.AlertInformation;
import com.fernandogonzalez.system.utils.Validations;
import com.fernandogonzalez.system.utils.ViewFactory;

/**
 *
 * @author informatica
 */
public class RegisterController implements Initializable {

    @FXML
    private TextField txtUser;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtLastName;
    @FXML
    private TextField txtMail;
    @FXML
    private PasswordField pwdPassword;
    @FXML
    private PasswordField pwdConfirmPassword;
    private Validations validate = new Validations();
    private AlertInformation alertInfo = new AlertInformation();
    private UserService userService = new UserService();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    public void onCancel(MouseEvent event) {
        ViewFactory viewFactory = new ViewFactory();
        viewFactory.viewLogin();
    }

    @FXML
    public void onCreateUser(MouseEvent event) {
        boolean isValidEmail = validate.validateEmail(txtMail.getText().trim());
        if (isValidEmail == false) {
            alertInfo.viewAlert(3, "ERROR MAIL", "ERROR CAMPO",
                    "HAS INGRESADO UN MAIL INVALIDO");
            ;
        } 
        String user, name, lastName, mail, password, confirmPassword;
        user = txtUser.getText().trim();
        name = txtUser.getText().trim();
        lastName = txtLastName.getText().trim();
        mail = txtMail.getText().trim();
        password = pwdConfirmPassword.getText().trim();
        confirmPassword = pwdConfirmPassword.getText().trim();

        if (validate.emptyText(user) == true
                || validate.emptyText(name) == true
                || validate.emptyText(lastName) == true
                || validate.emptyText(mail) == true
                || validate.emptyText(password) == true
                || validate.emptyText(confirmPassword) == true) {

            alertInfo.viewAlert(2, "ERROR DE CAMPOS VACIOS",
                    "ERROR CAMPO", "DEJO CAMPOS VACIOS EN EL FORMULARIO");
            return;
        }
        //LONGITUD DE TEXTO
//        if (validate.validateLengthText(user, 25)
//                || validate.validateLengthText(name, 50)
//                || validate.validateLengthText(lastName, 50)
//                || validate.validateLengthText(mail, 50)
//                || validate.validateLengthText(password, 16)
//                || validate.validateLengthText(confirmPassword, 16)) {
//            return;
        String msfField = "";
        if (validate.validateLengthText(user, 25) == false) {
            msfField = "El campo USUARIO es mayor a 25 caracteres";
        }
        if (validate.validateLengthText(name, 50) == false) {
            msfField = "El campo NOMBRE es mayor a 25 caracteres";
        }
        if (validate.validateLengthText(lastName, 50) == false) {
            msfField = "El campo APELLIDO es mayor a 25 caracteres";
        }
        if (validate.validateLengthText(mail, 50) == false) {
            msfField = "El campo MAIL es mayor a 25 caracteres";
        }
        if (validate.validateLengthText(password, 16) == false) {
            msfField = "El campo CONTRASEÑA es mayor a 16 caracteres";
        }
        if (msfField.isEmpty() == false) {
            alertInfo.viewAlert(3, "ERROR", "ERROR CAMPO", msfField);
            return;
        }
        if (validate.equalsText(password, confirmPassword) == false) {
            alertInfo.viewAlert(4, "ERROR CONTRASEÑA", "ERROR ", "SUS CONTRASEÑAS NO COINCIDEN");
            return;
        }
        UserStatus status
                = userService.createUser(user, name, lastName, mail, password);
        switch (status) {
            case UserStatus.ERROR_USER_CREATE ->
                System.out.println("Error al crear en controller");
            case UserStatus.USER_CREATE ->
                System.out.println("Si se creo el Usuario");
            case UserStatus.FIELDS_EMPTY ->
                System.out.println("Los campos no estan vacios");
            case UserStatus.VALUE_LENGHT_INVALID ->
                System.out.println("Validar longitud de texto");
            default ->
                System.out.println("Error desconocido");
        }
    }
}
