class CadastroProdutos extends Venda{
    private String vendedor;
    private String cliente;
    private String nomeDoProduto;
    private int codigo;
    private int quantidade;
    private double preco;
    private double valorTotal;


    public CadastroProdutos() {
        this.vendedor = vendedor;
        this.cliente=cliente;
        this.nomeDoProduto=nomeDoProduto;
        this.codigo=codigo;
        this.quantidade=quantidade;
        this.preco=preco;
        this.valorTotal=valorTotal;
    }

    public String getVendedor() {
        return vendedor;
    }

    public String getCliente() {
        return cliente;
    }

    public String getNomeDoProduto() {
        return nomeDoProduto;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public double getValorTotal() {
        return valorTotal;
    }



}
