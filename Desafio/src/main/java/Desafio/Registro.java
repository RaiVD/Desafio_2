package Desafio;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;
import java.util.*;

public class Registro {
    static List<Venda> vendas = new ArrayList<>();
    static List<Produto> produtos = new ArrayList<>();
    static Map<String, Cliente> clientes = new HashMap<>();
    public static Map<String, Vendedor> vendedores = new HashMap<>(2);
    public void cadastrarCliente(String nomeC, String emailC, String cpfC, String senhaC) {
        clientes.put("1233", new Cliente("Renato", "renato@gmail.com", "1233", "renato123"));
        try {
            if (!metodoUsadoParaValidarAEntradaDoEmail(emailC)) {
                throw new IllegalArgumentException("E-mail invalido");
            }
            boolean encontrado = false;
            for (Cliente produto : clientes.values()) {
                if (produto.getEmail().equals(emailC)) {
                    encontrado = true;
                    break;
                }
            }
            if (encontrado) {
                throw new IllegalArgumentException("E-mail ja cadastrado para outro cliente");
            }
            String cpfCliente = String.valueOf(Integer.parseInt(cpfC));
            if (clientes.containsKey(cpfCliente)) {
                throw new IllegalArgumentException("CPF ja cadastrado para outro cliente");
            } else {
                clientes.put(cpfC, new Cliente(nomeC, emailC, cpfCliente, senhaC));
                System.out.println("Registrado com sucesso");
            }
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void cadastrarFuncionario(String nomeF, String emailF, String cpfF, String senhaF) {
        vendedores.put("raissa@gmail.com", new Vendedor("Raissa", "raissa@gmail.com", "1234", "raissa123"));
        try {

            if (!metodoUsadoParaValidarAEntradaDoEmail(emailF)) {
                throw new IllegalArgumentException("E-mail invalido");
            }
            if (vendedores.containsKey(emailF)) {
                throw new IllegalArgumentException("E-mail ja cadastrado para outro funcionario");
            }

            String cpfVendedor = String.valueOf(Integer.parseInt(cpfF));
            boolean encontrado = false;
            for (Vendedor produto : vendedores.values()) {
                if (produto.getCpf().equals(cpfF)) {
                    encontrado = true;
                    break;
                }
            }
            if (encontrado) {
                throw new IllegalArgumentException("CPF já cadastrado para outro funcionario");
            }
            if (vendedores.size() > 1) {
                System.out.println("Lista de vendedores completa");
            } else {
                vendedores.put(emailF, new Vendedor(nomeF, emailF, cpfVendedor, senhaF));
                System.out.println("Registrado com sucesso");
            }
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            System.out.println();
        }
    }

    public void fazerLoginCliente(String senhaLogin, String cpfLogin) {
        clientes.put("1233", new Cliente("Renato", "renato@gmail.com", "1233", "renato123"));
        Scanner scanner = new Scanner(System.in);

        if (!clientes.containsKey(cpfLogin)) {
            throw new IllegalArgumentException("Cliente não cadastrado");
        }

        boolean encontrado = false;
        for (Cliente senha : clientes.values()) {
            if (senha.getSenha().equals(senhaLogin)) {
                encontrado = true;
                break;
            }
        }
        if (encontrado) {
            System.out.println("Bem - Vindo");

            boolean finalizar = false;
            while (!finalizar) {
                System.out.println("1. Realizar Compra | 2. Listar Compras | 3. Finalizar");
                int entrada = scanner.nextInt();
                switch (entrada) {
                    case 1 -> realizarCompra();
                    case 2 -> {
                        for (Venda venda : vendas) {
                            Cliente clienteAux = venda.getCliente();
                            if (clienteAux.getCpf().equals(cpfLogin)) {
                                System.out.println(venda);
                            }
                            System.out.println("==============================================================================");
                        }
                    }
                    case 3 -> finalizar = true;
                    default -> System.out.println("Opção invalida");
                }
            }
        }
    }
    public void realizarCompra() {
        Scanner scanner = new Scanner(System.in);
        clientes.put("1233", new Cliente("Renato", "renato@gmail.com", "1233", "renato123"));
        vendedores.put("raissa@gmail.com", new Vendedor("Raissa", "raissa@gmail.com", "1234", "raissa123"));

        Produto celular1 = new Produto("Celular1", 1233211, 2500, 0);
        Produto celular2 = new Produto("Celular2", 1876211, 2799, 0);
        Produto celular3 = new Produto("Celular3", 1233644, 3179, 0);
        produtos.add(celular1);
        produtos.add(celular2);
        produtos.add(celular3);
        try {
            System.out.println("Qual o CPF do cliente? (Digite apenas numeros)");
            String cpfCliente1 = scanner.next();
            if (!clientes.containsKey(cpfCliente1)) {
                throw new IllegalArgumentException("Cliente não cadastrado");
            }
            System.out.println("Qual o E-mail do funcionario?");
            String emailVendedor1 = scanner.next();
            if (!vendedores.containsKey(emailVendedor1)) {
                throw new IllegalArgumentException("Vendedor não cadastrado");
            }
            System.out.println("Qual a quantidade do produto?");
            int qntProduto = scanner.nextInt();
            for (Produto produto : produtos) {
                produto.setQuantidade(qntProduto);
                produto.setValorTotal(produto.getQuantidade() * produto.getPreco());
            }
            for (Produto produto : produtos) {
                System.out.println(produto);
                System.out.println();
            }
            System.out.println("Qual produto deseja comprar?");
            String nomeProduto = scanner.next();
            Produto produtoTemporario = null;
            for (Produto produto : produtos) {
                if (produto.getNomeDoProduto().equals(nomeProduto)) {
                    produtoTemporario = produto;
                }
            }

            if (!produtos.contains(produtoTemporario)) {
                throw new IllegalArgumentException("Produto não cadastrado");
            }

            System.out.println("VENDA CADASTRADA COM SUCESSO!");

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

    public void fazerLoginFuncionario(String senhaLogin, String emailogin) {
        vendedores.put("raissa@gmail.com", new Vendedor("Raissa", "raissa@gmail.com", "1234", "raissa123"));
        Scanner scanner = new Scanner(System.in);

        if (!metodoUsadoParaValidarAEntradaDoEmail(emailogin)) {
            throw new IllegalArgumentException("E-mail invalido");
        }
        if (!vendedores.containsKey(emailogin)) {
            throw new IllegalArgumentException("E-mail não cadastrado");
        }

        boolean encontrado = false;
        for (Vendedor produto : vendedores.values()) {
            if (produto.getSenha().equals(senhaLogin)) {
                encontrado = true;
                break;
            }
        }
        if (encontrado) {
            System.out.println("Bem - Vindo");

            boolean finalizar = false;
            while (!finalizar) {
                System.out.println("1. Lista de Funcionarios cadastrados");
                System.out.println("2. Lista de Clientes cadastrados");
                System.out.println("3. Pesquisar venda por cliente");
                System.out.println("4. Pesquisar venda por funcionario");
                System.out.println("5. Pesquisar todas as vendas");
                System.out.println("6. Finalizar");
                int entrada = scanner.nextInt();
                switch (entrada) {
                    case 1 -> listarDeFuncionarios();
                    case 2 -> listarClientes();
                    case 3 -> consultarVendasPorCliente();
                    case 4 -> consultarVendasPorFuncionario();
                    case 5 -> consultarTodasAsVendas();
                    case 6 -> finalizar = true;
                    default -> System.out.println("Opção invalida");
                }
            }
        }
    }

    public void listarDeFuncionarios() {
        vendedores.put("raissa@gmail.com", new Vendedor("Raissa", "raissa@gmail.com", "1234", "raissa123"));
        System.out.println("Lista de funcionarios cadastrados: ");
        for (Vendedor vendedor : vendedores.values()) {
            System.out.println(vendedor);
        }
        System.out.println("==============================================================================");
    }

    public void listarClientes() {
        clientes.put("1233", new Cliente("Renato", "renato@gmail.com", "1233", "renato123"));
        System.out.println("Lista de clientes cadastrados: ");
        for (Cliente cliente : clientes.values()) {
            System.out.println(cliente);
        }
        System.out.println("==============================================================================");
    }

    public void consultarVendasPorCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o CPF do cliente (apenas numeros): ");
        String cpfCliente = scanner.nextLine();
        for (Venda venda : vendas) {
            Cliente clienteAux = venda.getCliente();
            if (clienteAux.getCpf().equals(cpfCliente)) {
                System.out.println(venda);
            }
        }
        System.out.println("==============================================================================");
    }

    public void consultarVendasPorFuncionario() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o email do vendedor");
        String emailVendedor = scanner.next();
        for (Venda venda : vendas) {
            Vendedor vendedorAux = venda.getVendedor();
            if (vendedorAux.getEmail().equals(emailVendedor)) {
                System.out.println(venda);
            }
        }
        System.out.println("==============================================================================");
    }

    public void consultarTodasAsVendas() {
        System.out.println("Lista de vendas finalizadas");
        for (Venda venda : vendas) {
            System.out.println(venda);
        }
        System.out.println("==============================================================================");
    }

    public static boolean metodoUsadoParaValidarAEntradaDoEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email.matches(regex);
    }


}
