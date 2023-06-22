package Desafio;

public class Vendedor {

    private String nome;
    private String email;
    private String cpf;
    private String senha;
    public Vendedor(String nome, String email, String cpf, String senha) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.senha = senha;
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
    public String getSenha() {
        return senha;
    }
    public String toString(){
        return "\nNome do vendedor: "+getNome()+
                "\nE-mail: " + getEmail()+
                "\nCPF: "+getCpf();
    }
}
