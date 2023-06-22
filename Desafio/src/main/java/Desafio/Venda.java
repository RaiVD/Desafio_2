package Desafio;

import java.time.LocalDate;

public class Venda {
    public LocalDate data;
    public Produto produto;
    public Vendedor vendedor;
    public Cliente cliente;

    public Venda(Produto produto, Vendedor vendedor, Cliente cliente, LocalDate data) {
        this.produto = produto;
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.data = data;
    }
    public Vendedor getVendedor() {
        return vendedor;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public LocalDate getData(){
        return data;
    }
    @Override
    public String toString() {
        return "O vendedor (a) " + vendedor.getNome() +
                " realizou uma venda para o (a) cliente " + cliente.getNome() +
                ", do produto " + produto.getNomeDoProduto()+
                ", no valor de "+ produto.getValorTotal()+
                ", no dia "+getData();

    }
}


