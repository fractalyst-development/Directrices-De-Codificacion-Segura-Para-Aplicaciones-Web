package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import model.data.Administrador;
import model.data.Usuario;

public class ServiceFacade {
    
    public boolean login(String nombre, String pwd, List<Usuario> usuarios) {
        boolean exito = false;
        Optional<Usuario> optU = usuarios.stream().filter(u -> u.getNombre().equals(nombre)).filter(u -> u.getPwd().equals(pwd)).findFirst();
        if (optU.isPresent()) {
            exito = true;
        }
        return exito;
    }
    
    public boolean esAdmin(String nombre, List<Usuario> usuarios) {
        boolean exito = false;
        Optional<Usuario> optU = usuarios.stream().filter(u -> u.getNombre().equals(nombre)).findFirst();
        if (optU.isPresent()) {
            if (optU.get() instanceof Administrador) {
                exito = true;
            }
        }
        return exito;
    }

    public boolean actualizaPermisos(Usuario usuarioNuevosPermisos, List<Usuario> usuariosDB) {
        boolean exito = false;
        Optional<Usuario> optU = usuariosDB.stream().filter(u -> u.getIdUsuario() == usuarioNuevosPermisos.getIdUsuario()).findFirst();
        if (optU.isPresent()) {
            optU.get().setEjecutor(usuarioNuevosPermisos.isEjecutor());
            optU.get().setEscritor(usuarioNuevosPermisos.isEscritor());
            optU.get().setLector(usuarioNuevosPermisos.isLector());
            exito = true;
        }
        return exito;
    }
    
    public List<Usuario> obtenSusUsuarios(String nombre, List<Usuario> usuarios) {
        List<Usuario> usuariosPersonales = null;
        Optional<Usuario> optU = usuarios.stream().filter(u -> u.getNombre().equals(nombre)).findFirst();
        if (optU.isPresent()) {
            if (optU.get() instanceof Administrador) {
                usuariosPersonales = usuarios;
            } else {
                usuariosPersonales = new ArrayList<>();
                usuariosPersonales.add(optU.get());
            }
        }
        return usuariosPersonales;
    }
    
    public Usuario obtenUsuario(String nombre, String pwd, List<Usuario> usuarios) {
        Usuario usuario = null;
        Optional<Usuario> optU = usuarios.stream().filter(u -> u.getNombre().equals(nombre)).filter(u -> u.getPwd().equals(pwd)).findFirst();
        if (optU.isPresent()) {
            usuario = optU.get();
        }
        return usuario;
    }
}
