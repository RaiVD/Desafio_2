class CadastroProdutos extends Venda{
    private String nomeDoProduto;
    private int codigo;
    private int quantidade;
    private double preco;
    private double valorTotal;


    public CadastroProdutos(String nomeDoProduto,int codigo, int quantidade, double preco, double valorTotal) {
        this.nomeDoProduto=nomeDoProduto;
        this.codigo=codigo;
        this.quantidade=quantidade;
        this.preco=preco;
        this.valorTotal=valorTotal;
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
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    public double getValorTotal() {
        return quantidade * preco;
    }



    public String toString(){
        return "Nome do produto: "+getNomeDoProduto()+
                "Codigo: " + getCodigo()+
                "Quantidade: "+getQuantidade()+
                "Preço do produto: "+getPreco()+
                "Valor total a pagar: "+getValorTotal();
    }
}
