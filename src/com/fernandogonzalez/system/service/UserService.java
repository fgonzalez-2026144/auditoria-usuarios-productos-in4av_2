/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fernandogonzalez.system.service;

import com.fernandogonzalez.system.repository.UserRepository;
import com.fernandogonzalez.system.utils.AlertInformation;
import com.fernandogonzalez.system.utils.Validations;
import com.fernandogonzalez.system.model.User;

/**
 *
 * @author informatica
 */
public class UserService {

    private Validations validate = new Validations();
    private AlertInformation alertInfo = new AlertInformation();
    private UserRepository userRepo = new UserRepository();

    public UserStatus createUser(String user, String name, String lastName,
            String email, String password) {
        if (validate.emptyText(user) == true
                || validate.emptyText(name) == true
                || validate.emptyText(lastName) == true
                || validate.emptyText(email) == true
                || validate.emptyText(password) == true) {

            alertInfo.viewAlert(2, "ERROR DE CAMPOS VACIOS",
                    "ERROR CAMPO", "DEJO CAMPOS VACIOS EN EL FORMULARIO");
            return UserStatus.FIELDS_EMPTY;
        }
        try {
            User newUser = new User(password, name, lastName, email, user);
            userRepo.create(newUser);
            return UserStatus.USER_CREATE;
        } catch (Exception e) {
            return UserStatus.ERROR_USER_CREATE;
        }
    }
}
