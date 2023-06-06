class Vendedor {
    private String nome;
    private String email;
    private int cpf;

    public Vendedor(String nome, String email, int cpf) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }
}
