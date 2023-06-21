package Desafio;

import java.time.LocalDate;
import java.util.*;

public class Registro {

    static List<Venda> vendas = new ArrayList<>();
    static List<Produto> produtos = new ArrayList<>();
    static Map<String, Cliente> clientes = new HashMap<>();
    public static Map<String, Vendedor> vendedores = new HashMap<>(2);


    public void cadastrarCliente(String nomeC, String emailC, String cpfC) {
        clientes.put("1233", new Cliente("Renato", "renato@gmail.com", "1233"));
//        try {
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
        }
        clientes.put(cpfC, new Cliente(nomeC, emailC, cpfCliente));
        System.out.println("Registrado com sucesso");

//        } catch (IllegalArgumentException exception) {
//            System.out.println(exception.getMessage());
//        }
    }

    public void cadastrarFuncionario(String nomeF, String emailF, String cpfF) {
        vendedores.put("raissa@gmail.com", new Vendedor("Raissa", "raissa@gmail.com", "1234"));
//        try {

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

        vendedores.put(emailF, new Vendedor(nomeF, emailF, cpfVendedor));
        System.out.println("Registrado com sucesso");
        if (vendedores.size() > 1) {
            System.out.println("Lista de vendedores completa");
        }
//        } catch (IllegalArgumentException exception) {
//            System.out.println(exception.getMessage());
//            System.out.println();
//        }
    }

    public void cadastrarCompra(String cpfC, String emailF, int quantidade, String nomeDoProduto) {
        clientes.put("1233", new Cliente("Renato", "renato@gmail.com", "1233"));
        vendedores.put("raissa@gmail.com", new Vendedor("Raissa", "raissa@gmail.com", "1234"));

        Produto celular1 = new Produto("Celular1", 1233211, 2500, 0);
        Produto celular2 = new Produto("Celular2", 1876211, 2799, 0);
        Produto celular3 = new Produto("Celular3", 1233644, 3179, 0);
        produtos.add(celular1);
        produtos.add(celular2);
        produtos.add(celular3);
//        try {
        if (!clientes.containsKey(cpfC)) {
            throw new IllegalArgumentException("Cliente não cadastrado");
        }
        if (!vendedores.containsKey(emailF)) {
            throw new IllegalArgumentException("Vendedor não cadastrado");
        }
        for (Produto produto : produtos) {
            produto.setQuantidade(quantidade);
            produto.setValorTotal(produto.getQuantidade() * produto.getPreco());
        }
        for (Produto produto : produtos) {
            System.out.println(produto);
            System.out.println();
        }
        Produto produtoTemporario = null;
        for (Produto produto : produtos) {
            if (produto.getNomeDoProduto().equals(nomeDoProduto)) {
                produtoTemporario = produto;
            }
        }
        if (!produtos.contains(produtoTemporario)) {
            throw new IllegalArgumentException("Produto não cadastrado");
        }
        System.out.println("VENDA CADASTRADA COM SUCESSO!");

        LocalDate data = LocalDate.now();
        Vendedor vendedor = vendedores.get(emailF);
        Cliente cliente = clientes.get(cpfC);
        Venda venda = new Venda(produtoTemporario, vendedor, cliente, data);
        vendas.add(venda);
        System.out.println();
//        } catch (IllegalArgumentException exception) {
//            System.out.println(exception.getMessage());
//            System.out.println();
//        }
    }

    public void listarDeFuncionarios() {
        System.out.println("Lista de funcionarios cadastrados: ");
        for (Vendedor vendedor : vendedores.values()) {
            System.out.println(vendedor);
        }
    }

    public void listarClientes() {
        System.out.println("Lista de clientes cadastrados: ");
        for (Cliente cliente : clientes.values()) {
            System.out.print(cliente);
        }
    }

    public void consultarVendasPorCliente(String cpfC) {
                for (Venda venda : vendas) {
                    Cliente clienteAux = venda.getCliente();
                    if (clienteAux.getCpf().equals(cpfC)) {
                        System.out.println(venda);
                    }
                }
    }
    public void consultarVendasPorFuncionario(String emailF) {
        for (Venda venda : vendas) {
            Vendedor vendedorAux = venda.getVendedor();
            if (vendedorAux.getEmail().equals(emailF)) {
                System.out.println(venda);
            }
        }
    }
    public void consultarTodasAsVendas() {
        System.out.println("Lista de vendas finalizadas");
        for (Venda venda : vendas) {
            System.out.println(venda);
        }
    }

    public static boolean metodoUsadoParaValidarAEntradaDoEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email.matches(regex);
    }




}
