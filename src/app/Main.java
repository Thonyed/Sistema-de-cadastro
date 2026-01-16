package app;

import model.Usuario;
import service.UserService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserService userService = new UserService();
        int opcao;

        do {
            System.out.println("\n1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Excluir");
            System.out.println("0 - Sair");
            System.out.println("Escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer (evitar problemas com scanner)

            switch (opcao) {

                case 1: {
                    System.out.println("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.println("ID: ");
                    String id = scanner.nextLine();

                   boolean sucesso = userService.cadastrar(new Usuario(nome, id));

                   if (sucesso) {
                       System.out.println("Usuário casdastrado com sucesso");
                   }else {
                       System.out.println("Dados incorretos, verifique e tente novamente.");
                   }
                    break;
                }

                case 2: {
                    if (userService.listar().isEmpty()){
                        System.out.println("Nenhum usuário cadastrado ");
                    }else {userService.listar().forEach(u -> System.out.println("Nome: " + u.getNome() + "\n" + "ID: " + u.getId() + "\n----------------")
                         );
                    }
                    break;
                }
                case 3: {
                System.out.println("Qual ID deseja remover? ");
                System.out.println("\nUsuários cadastrados" + "\n");

                if (userService.listar().isEmpty()){
                    System.out.println("Nenhum usuário cadastrado");
                } else {
                    userService.listar().forEach(u -> System.out.println("Nome: " + u.getNome() + "\n" + "ID: " + u.getId() + "\n--------------"));
                }
                String id = scanner.nextLine();



                if (userService.removerPorId(id)) {
                    System.out.println("Usuário removido com sucesso. ");
                } else {
                    System.out.println("Usuário incorreto ");
                   }
                break;
                }

                case 0: {
                    System.out.println("Saindo do sistema...");
                    break;
                }

            }


        } while (opcao != 0) ;
            scanner.close();

    }
}