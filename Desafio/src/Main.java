
import java.time.LocalDate;
import java.util.*;

public class Main {
    static int contCliente = 1, contVendedor = 1;
    static List<Venda> vendas = new ArrayList<>();
    static List<Produto> produtos = new ArrayList<>();
    static Map<String, Cliente> clientes = new HashMap<>();
    static Map<String, Vendedor> vendedores = new HashMap<>(2);

    public static void main(String[] args) {
        Produto celular1 = new Produto("Celular1", 1233211, 2500, 1,0);
        Produto celular2 = new Produto("Celular2", 1876211,  2799, 2,0);
        Produto celular3 = new Produto("Celular3", 1233644,  3179, 3,0);
        produtos.add(celular1);
        produtos.add(celular2);
        produtos.add(celular3);

        Scanner scanner = new Scanner(System.in);
        boolean encerrar = false;
        while (!encerrar) {
            try {
                System.out.println("=====Menu=====");
                System.out.println("1. Cadastro de Funcionario e cliente");
                System.out.println("2. Cadastrar compra");
                System.out.println("3. Lista ");
                System.out.println("4. Consultar compras e vendas");
                System.out.println("5. Sair");
                System.out.println("Digite a opção desejada:");
                int opcao = scanner.nextInt();
                switch (opcao) {
                    case 1 -> cadastrar();
                    case 2 -> cadastrarVenda();
                    case 3 -> listar();
                    case 4 -> consultarVendas();
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

    public static void cadastrar() {
        Scanner cadastro = new Scanner(System.in);
        try {
            System.out.print("1. Cadastrar Cliente \n2. Cadastrar Funcionario");
            int entrada = cadastro.nextInt();
            switch (entrada) {
                case 1 -> {
                    System.out.println("Digite seu nome: ");
                    cadastro.nextLine();
                    String nomeCliente = cadastro.nextLine();
                    System.out.println("Digite seu email: ");
                    String emailCliente = cadastro.next();
                    if (!emailCliente.contains("@")) {
                        throw new IllegalArgumentException("E-mail invalido");
                    }else if (clientes.containsKey(emailCliente)) {
                        throw new IllegalArgumentException("E-mail ja cadastrado para outro cliente");
                    }
                    System.out.println("Digite seu CPF: ");
                    String cpf = cadastro.next();
                    String cpfCliente = String.valueOf(Integer.parseInt(cpf));
                    if (clientes.containsKey(cpfCliente)) {
                        throw new IllegalArgumentException("CPF ja cadastrado para outro cliente");
                    }
                    clientes.put(cpf, new Cliente(nomeCliente, emailCliente, cpfCliente, contCliente));
                    contCliente += 1;
                    System.out.println("Registrado com sucesso");
                }
                case 2 -> {
                    System.out.println("Digite seu nome: ");
                    cadastro.nextLine();
                    String nomeVendedor = cadastro.nextLine();
                    System.out.println("Digite seu email: ");
                    String emailVendedor = cadastro.next();
                    if (!emailVendedor.contains("@")) {
                        throw new IllegalArgumentException("E-mail invalido");
                    } else if (vendedores.containsKey(emailVendedor)) {
                        throw new IllegalArgumentException("E-mail ja cadastrado para outro cliente");
                    }
                    System.out.println("Digite seu CPF: ");
                    String cpf = cadastro.next();
                    String cpfVendedor = String.valueOf(Integer.parseInt(cpf));
                    if (vendedores.containsKey(cpfVendedor)) {
                        throw new IllegalArgumentException("CPF ja cadastrado para outro cliente");
                    }
                    vendedores.put(emailVendedor, new Vendedor(nomeVendedor, emailVendedor, cpfVendedor, contVendedor));
                    contVendedor += 1;
                    System.out.println("Registrado com sucesso");
                    if (vendedores.size() > 2) {
                        System.out.println("Lista de vendedores completa");
                    }
                }
                default -> System.out.println("Opção inválida");
            }
            System.out.println();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            System.out.println();
        }
    }

    public static void cadastrarVenda() {
        Scanner entrada = new Scanner(System.in);
        try {
            System.out.println("Qual o CPF do cliente?");
            String cpfCliente1 = entrada.next();
            if (!clientes.containsKey(cpfCliente1)) {
                throw new IllegalArgumentException("Cliente não cadastrado");
            }
            System.out.println("Qual o E-mail do funcionario?");
            String emailVendedor1 = entrada.next();
            if (!vendedores.containsKey(emailVendedor1)) {
                throw new IllegalArgumentException("Vendedor não cadastrado");
            }
            System.out.println("Qual a quantidade do produto?");
            int qntProduto = entrada.nextInt();
            for (Produto produto : produtos) {
                produto.setQuantidade(qntProduto);
                produto.setValorTotal(produto.getQuantidade() * produto.getPreco());
            }
            for (Produto produto : produtos) {
                System.out.println(produto);
                System.out.println();
            }
            System.out.println("Qual produto deseja comprar?");
            String nomeProduto = entrada.next();
            Produto produtoTemporario = null;
            for (Produto produto : produtos) {
                if (produto.getNomeDoProduto().equals(nomeProduto)) {
                    produtoTemporario = produto;
                }
            }
            if(!produtos.contains(produtoTemporario)){
                throw new IllegalArgumentException("Produto não cadastrado");
            }

            LocalDate data = LocalDate.now();
            Vendedor vendedor = vendedores.get(emailVendedor1);
            Cliente cliente = clientes.get(cpfCliente1);
            Venda venda = new Venda(produtoTemporario, vendedor, cliente, data);
            vendas.add(venda);
            System.out.println();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            System.out.println();
        }
    }

    public static void listar() {
        Scanner cadastro = new Scanner(System.in);
        System.out.print("1. Lista de Funcionarios/Clientes\n2. Vendas Finalizadas");
        int entrada1 = cadastro.nextInt();
        switch (entrada1) {
            case 1 -> {
                System.out.println("Lista de funcionarios cadastrados: ");
                for (Map.Entry<String, Vendedor> vendedor : vendedores.entrySet()) {
                    System.out.println(vendedor);
                    System.out.println();
                }
                System.out.println("Lista de clientes cadastrados: ");
                for (Map.Entry<String, Cliente> cliente : clientes.entrySet()) {
                    System.out.println(cliente);
                    System.out.println();
                }
            }
            case 2 -> {
                System.out.println("Lista de vendas finalizadas");
                for (Venda venda : vendas) {
                    System.out.println(venda);
                }
            }
            default -> System.out.println("Opção inválida");
        }
    }

    public static void consultarVendas() {
        Scanner consultaVendas = new Scanner(System.in);
        System.out.print("Consultar vendas por 1. Funcionario | 2. Cliente");
        int opcao = consultaVendas.nextInt();
        switch (opcao) {
            case 1 -> {
                System.out.println("Digite o email do vendedor");
                String emailVendedor = consultaVendas.next();
                for (Venda venda : vendas) {
                    Vendedor vendedorAux = venda.getVendedor();
                    if (vendedorAux.getEmail().equals(emailVendedor)) {
                        System.out.println(venda);
                    }
                }
            }
            case 2 -> {
                System.out.println("Digite o CPF do cliente");
                String cpfCliente = consultaVendas.next();
                for (Venda venda : vendas) {
                    Cliente clienteAux = venda.getCliente();
                    if (clienteAux.getCpf().equals(cpfCliente)) {
                        System.out.println(venda);
                    }
                }
            }
        }
    }
}


