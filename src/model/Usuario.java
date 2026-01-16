//package model;
//
//public class Usuario {
//    public String nome;
//    public String id;
//
//    public Usuario(String nome, String id) {
//        this.nome = nome;
//        this.id = id;
//    }
//}

package model;

public class Usuario {

    private String nome;
    private String id;

    public Usuario(String nome, String id) {
        this.nome = nome;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public String getId() {
        return id;
    }
}
