package service;

import model.Usuario;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    private List<Usuario> usuarios = new ArrayList<>();

    public void cadastrar(Usuario usuario) {
        usuarios.add(usuario);
    }

    public List<Usuario> listar() {
        return usuarios;
    }

    public boolean removerPorId(String id) {
        return usuarios.removeIf(u -> u.getId().equals(id));
    }
}

