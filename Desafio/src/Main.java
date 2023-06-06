import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Venda venda = new Venda();

        Scanner scanner = new Scanner(System.in);
        int entrada = 0;

        while (entrada != 4){

            System.out.println("=====Menu=====");
            System.out.println("1. Cadastro");
            System.out.println("2. Acessar conta Cliente");
            System.out.println("3. Acessar conta Funcionario");
            System.out.println("4. Sair");
            System.out.println("Digite a opção desejada:");
            entrada = scanner.nextInt();

            switch (entrada) {
                case 1 -> venda.cadastrar();
                case 2 -> venda.acessoCliente();
                case 3 -> venda.listas();
                case 4 -> venda.sair();
                default -> System.out.println("Opção inválida");
            }
        }

    }
}
