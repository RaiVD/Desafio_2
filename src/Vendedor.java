import java.util.HashSet;
import java.util.Set;

class Vendedor {
        private String nome;
        private String email;
        private  int cpf;

        public Vendedor(String nome, String email, int cpf) {
            this.nome = nome;
            this.email = email;
            this.cpf = cpf;
        }

        public String getNome() {
            return nome;
        }

        public String getEmail() {
            return email;
        }

        public int getCpf() {
            return cpf;
        }

}
