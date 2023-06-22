package Desafio;

public class Cliente {
    private String nome;
    private String email;
    private String cpf;
    private String senha;
    public Cliente(String nome, String email, String cpf, String senha) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.senha = senha;
    }
    public String getNome() {
        return nome;
    }
    public String getEmail() {
        return email;
    }
    public String getCpf() {
        return cpf;
    }

    public String getSenha() {
        return senha;
    }

    public String toString(){
        return "\nNome do Cliente: "+getNome()+
                "\nE-mail: " + getEmail()+
                "\nCPF: "+getCpf();
    }
}
