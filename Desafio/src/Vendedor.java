class Vendedor {

    private String nome;
    private String email;
    private String cpf;

    public Vendedor(String nome, String email, String cpf ) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String toString(){
        return "\nNome do vendedor: "+getNome()+
                "\nE-mail: " + getEmail()+
                "\nCPF: "+getCpf();
    }
}
