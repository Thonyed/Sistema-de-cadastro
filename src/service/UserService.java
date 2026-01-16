package service;

import model.Usuario;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    private List<Usuario> usuarios = new ArrayList<>();

    public boolean cadastrar (Usuario usuario){

        if (usuario.getNome() == null || usuario.getNome().isBlank()){
            return false;
        }

        if (usuario.getId() == null || usuario.getId().isBlank()){
            return false;
        }

        boolean idExiste = usuarios.stream()
        .anyMatch(u -> u.getId().equals(usuario.getId()));

        if (idExiste) {
            return false;
        }

        usuarios.add(usuario);
        return true;
    }

    public List<Usuario> listar() {
        return usuarios;
    }

    public boolean removerPorId(String id) {
        return usuarios.removeIf(u -> u.getId().equals(id));
    }
}

