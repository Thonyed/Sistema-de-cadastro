package app;

import Usuario.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaCadastro {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Usuario> usuarios = new ArrayList<>();
        int opcao;
        int remover;

        do {
            System.out.println("\n1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Excluir");
            System.out.println("0 - Sair");
            System.out.println("Escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer (evitar problemas com scanner)


            if (opcao == 1) {
                System.out.println("Nome: ");
                String nome = scanner.nextLine();

                System.out.println("ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();

                usuarios.add(new Usuario(nome, id));
                System.out.println("Cadastro Realizado");
            } else if (opcao == 2) {
                if (usuarios.isEmpty()){
                    System.out.println("Nenhum usuário encontrado ");
                } else {
                    for (int i = 0; i < usuarios.size(); i++) {
                        Usuario u = usuarios.get(i);
                        System.out.println(u.nome + " - " + "ID: " + u.id);
                    }
                }
            } else if (opcao == 3) {
                if (usuarios.isEmpty()) {
                    System.out.println("Nenhum usuário para remover.");
                } else {
                System.out.println("Qual usuário gostaria de deletar? ");
                for (int i = 0; i < usuarios.size(); i++) {
                    Usuario u = usuarios.get(i);
                    System.out.println(i + " - " + u.nome + " ID: " + u.id);
                }
                System.out.println("Digite o número: ");
                remover = scanner.nextInt();
                scanner.nextLine();

                if (remover >= 0 && remover < usuarios.size()){
                    usuarios.remove(remover);
                    System.out.println("usuário removido com sucesso ");
                }else {
                    System.out.println("Inválido");
                }
                }

            }
        } while (opcao != 0) ;
            scanner.close();

    }
}