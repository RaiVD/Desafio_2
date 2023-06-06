class Cliente {
    private String nome;
    private String email;
    private int cpf;

    public Cliente(String nome, String email, int cpf) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
    }

    public int getCpf() {
        return cpf;
    }
}
