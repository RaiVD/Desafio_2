
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Venda {
    private Set<Cliente> clientes;
    private Set<Vendedor> vendedores;

    public Venda() {
        clientes = new HashSet<>();
        vendedores = new HashSet<>(2);
    }

    public void cadastrar(){
        Scanner cadastro = new Scanner(System.in);
        System.out.print("1. Cadastrar Cliente \n2. Cadastrar Funcionario");
        int entrada = cadastro.nextInt();

        switch (entrada) {
            case 1:
                System.out.println("Digite seu nome: ");
                String nomeCliente = cadastro.nextLine();
                System.out.println("Digite seu email: ");
                String emailCliente = cadastro.next();
                System.out.println("Digite seu CPF: ");
                int cpfCliente = cadastro.nextInt();

                Cliente cliente1 = new Cliente(nomeCliente, emailCliente, cpfCliente);
                clientes.add(cliente1);
                System.out.println("Registrado com sucesso");
                break;
            case 2:
                System.out.println("Digite seu nome: ");
                String nomeVendedor = cadastro.nextLine();
                System.out.println("Digite seu email: ");
                String emailVendedor = cadastro.next();
                System.out.println("Digite seu CPF: ");
                int cpfVendedor = cadastro.nextInt();

                Vendedor vendedor1 = new Vendedor(nomeVendedor, emailVendedor, cpfVendedor);
                vendedores.add(vendedor1);
                System.out.println("Registrado com sucesso");

                if (vendedores.size() > 2){
                    System.out.println("Lista de vendedores completa");
                }
                break;
            default:
                System.out.println("Opção inválida");
        }
    }

//    public void acessoFuncionato(){
//        Scanner cadastro = new Scanner(System.in);
//        System.out.print("1. Cadastrar Cliente \n2. Cadastrar Funcionario");
//
//
//
//    }
}
