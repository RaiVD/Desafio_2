
import java.util.*;

public class Venda {
    private Map<Cliente, CadastroProdutos> comprasdoCliente;
    private List<CadastroProdutos> produtos;
    private Map<Integer, Cliente> clientes;
    private Map<String, Vendedor> vendedores;

    public Venda() {
        produtos = new ArrayList<>();
        clientes = new HashMap<>();
        vendedores = new HashMap<>(2);
    }

    public void cadastrar() {
        Scanner cadastro = new Scanner(System.in);
        System.out.print("1. Cadastrar Cliente \n2. Cadastrar Funcionario");
        int entrada = cadastro.nextInt();

        switch (entrada) {
            case 1 -> {
                System.out.println("Digite seu nome: ");
                cadastro.nextLine();
                String nomeCliente = cadastro.nextLine();
                System.out.println("Digite seu email: ");
                String emailCliente = cadastro.next();
                System.out.println("Digite seu CPF: ");
                int cpfCliente = cadastro.nextInt();
                clientes.put(cpfCliente, new Cliente(nomeCliente, emailCliente, cpfCliente));
                System.out.println("Registrado com sucesso");
            }
            case 2 -> {
                System.out.println("Digite seu nome: ");
                cadastro.nextLine();
                String nomeVendedor = cadastro.nextLine();
                System.out.println("Digite seu email: ");
                String emailVendedor = cadastro.next();
                System.out.println("Digite seu CPF: ");
                int cpfVendedor = cadastro.nextInt();
                vendedores.put(emailVendedor, new Vendedor(nomeVendedor, emailVendedor, cpfVendedor));
                System.out.println("Registrado com sucesso");
                if (vendedores.size() > 2) {
                    System.out.println("Lista de vendedores completa");
                }
            }
            default -> System.out.println("Opção inválida");
        }
    }

    public void acessoCliente() {
        CadastroProdutos celular1 = new CadastroProdutos("Celular1", 1233211, 1, 2500, 2500);
        CadastroProdutos celular2 = new CadastroProdutos("Celular2", 1876211, 1, 2799, 2799);
        CadastroProdutos celular3 = new CadastroProdutos("Celular3", 1233644, 1, 3179, 3179);
        produtos.add(1, celular1);
        produtos.add(2, celular2);
        produtos.add(3, celular3);

        Scanner acesso = new Scanner(System.in);
        System.out.println("Digite seu CPF");
        int cpfAcesso = acesso.nextInt();

        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.containsKey(cpfAcesso)) {
                System.out.println("=== Bem-Vindo ===");
            } else {
                System.out.println("CPF invalido, por favor tente novamente");
            }
        }
        System.out.println("Qual produto deseja comprar?");
        System.out.println(produtos);
        System.out.println("1. Celular1\n2. Celular2\n3. Celular3");
        int compra = acesso.nextInt();

        switch (compra) {
            case 1 -> {


            }
        }
    }

    public void listas() {
        Scanner cadastro = new Scanner(System.in);
        System.out.print("1. Lista de Funcionarios/Clientes\n2. Vendas do funcionario\n3. Compras do cliente");
        int entrada1 = cadastro.nextInt();

        switch (entrada1) {
            case 1 -> {
                System.out.println("Lista de funcionarios cadastrados: ");
                //Listar todos os vendedores
                System.out.println("Lista de funcionarios cadastrados: ");
                //Listar todos os clientes
            }
            case 2 -> {
                System.out.println("Digite o E-mail do funcionario: ");
                String emailFuncionario = cadastro.next();
                if (vendedores.containsKey(emailFuncionario)) {
                    //Listar Vendas do funcionario
                } else {
                    System.out.println("E-mail invalido, por favor tente novamente");
                }
            }
            case 3 -> {
                System.out.println("Digite o CPF do cliente: ");
                String cpfCliente = cadastro.next();
                if (vendedores.containsKey(cpfCliente)) {
                    //Listar compras do cliente
                } else {
                    System.out.println("CPF invalido, por favor tente novamente");
                }
            }
            default -> System.out.println("Opção inválida");
        }
    }

    public void sair() {
        System.out.println("Acesso finalizado");
        System.out.println("=====OBRIGADO=====");
    }
}


