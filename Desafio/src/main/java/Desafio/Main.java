package Desafio;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Registro registro = new Registro();
        Scanner scanner = new Scanner(System.in);

        boolean encerrar = false;
        while (!encerrar) {
            try {
                System.out.println("==============================  MENU  ==============================");
                System.out.println("1. Cadastro de Cliente");
                System.out.println("2. Cadastro de Funcionario");
                System.out.println("3. Login Cliente");
                System.out.println("4. Login Funcionario");
                System.out.println("5. Sair");
                System.out.println("Digite a opção desejada:");
                int opcao = scanner.nextInt();
                switch (opcao) {
                    case 1 -> {
                        System.out.println("Digite seu nome: ");
                        scanner.nextLine();
                        String nomeCliente = scanner.nextLine();
                        System.out.println("Digite seu email: ");
                        String emailCliente = scanner.nextLine();
                        System.out.println("Digite seu CPF (apenas numeros): ");
                        String cpf = scanner.nextLine();
                        System.out.println("Crie uma senha: ");
                        String senha = scanner.nextLine();
                        registro.cadastrarCliente(nomeCliente, emailCliente, cpf, senha);
                    }
                    case 2 -> {
                        System.out.println("Digite seu nome: ");
                        scanner.nextLine();
                        String nomeVendedor = scanner.nextLine();
                        System.out.println("Digite seu email: ");
                        String emailVendedor = scanner.next();
                        System.out.println("Digite seu CPF (apenas numeros): ");
                        String cpf = scanner.next();
                        System.out.println("Crie uma senha: ");
                        String senha = scanner.nextLine();
                        registro.cadastrarFuncionario(nomeVendedor, emailVendedor, cpf, senha);
                    }
                    case 3 -> {
                        System.out.println("Digite seu CPF: ");
                        String cpfLogin = scanner.next();
                        System.out.println("Digite sua senha: ");
                        String senhaLogin = scanner.next();
                        registro.fazerLoginCliente(senhaLogin,cpfLogin);
                    }
                    case 4 -> {
                        System.out.println("Digite seu E-mail: ");
                        String emailLogin = scanner.next();
                        System.out.println("Digite sua senha: ");
                        String senhaLogin = scanner.next();
                        registro.fazerLoginFuncionario(senhaLogin,emailLogin);
                    }
                    case 5 -> encerrar = true;
                    default -> System.out.println("Opção inválida");
                }
                System.out.println();
            } catch (NumberFormatException exception) {
                System.out.println("Entrada inválida. " + exception.getMessage());
                System.out.println();
            } catch (IllegalArgumentException | UnsupportedOperationException exception) {
                System.out.println(exception.getMessage());
                System.out.println();
            }
        }
    }
}


