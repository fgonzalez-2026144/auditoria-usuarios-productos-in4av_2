/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fernandogonzalez.system.repository;

/**
 *
 * @author informatica
 */
import java.sql.CallableStatement;
import java.sql.SQLException;
import com.fernandogonzalez.system.model.User;
import com.fernandogonzalez.system.config.ConexionDB;

public class UserRepository implements UserInterface {

    //CallableStatement
    private CallableStatement callSP;
    //ConexionDB
    private ConexionDB conexionDB
            = ConexionDB.getInstanciaConexionDB();

    public UserRepository() {

    }

    @Override
    public void create(User user) {
        try {
            callSP = conexionDB.getConnection().prepareCall("{call sp_create_users(?,?,?,?,?)}");
            callSP.setString(1, user.getName());
            callSP.setString(2, user.getLastname());
            callSP.setString(3, user.getEmail());
            callSP.setString(4, user.getUser());
            callSP.setString(5, user.getPassword());
            callSP.execute();
            callSP.close(); // Liberar los recurso utilizados
        } catch (SQLException exception) {
            System.out.println("Error al crear usuarios");
            System.out.println(exception.getMessage());
            exception.printStackTrace();
        }
    }
}
