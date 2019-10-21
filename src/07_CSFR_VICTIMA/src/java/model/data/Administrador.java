/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.data;

/**
 *
 * @author cazucito
 */
public class Administrador extends Usuario {

    public Administrador(int idUsuario, String nombre, String pwd, boolean escritor, boolean lector, boolean ejecutor) {
        super(idUsuario, nombre, pwd, escritor, lector, ejecutor);
    }



    
}
