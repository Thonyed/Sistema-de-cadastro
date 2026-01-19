package service;

import model.Usuario;
import java.util.ArrayList;
import java.util.List;
import exception.RegraNegocioException;


public class UserService {

    private List<Usuario> usuarios = new ArrayList<>();

    public boolean cadastrar (Usuario usuario){

        if (usuario.getNome() == null || usuario.getNome().isBlank()){
            throw new RegraNegocioException("Nome não pode ser vazio");
        }

        if (usuario.getId() == null || usuario.getId().isBlank()){
            throw new RegraNegocioException("ID não pode ser vazio");
        }

        boolean idExiste = usuarios.stream()
        .anyMatch(u -> u.getId().equals(usuario.getId()));

        if (idExiste) {
            throw new RegraNegocioException("ID já existe");
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

