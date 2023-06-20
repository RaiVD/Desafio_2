
import Desafio.Cliente;
import Desafio.Registro;
import Desafio.Vendedor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MainTest {
    @Spy
    private Registro registros;
    @Mock
    private Map<String, Cliente> cpfsCadastrados;
    @Test
    public void deveCadastraVendedorComSucesso(){
        //Criando cenario de teste
        String nome="Raissa";
        String email="Raissa@nunes";
        String cpf="12345";
        //Realizando ação de teste
        registros.cadastrarFuncionario(nome,email,cpf);
        //Comparando os resultados
        verify(registros).cadastrarFuncionario(nome,email,cpf);
    }
    @Test
    public void deveLancarUmaExecaoQuandoOEmailDoVendedorForInvalido(){
        //Criando cenario de teste
        String nome="raissa";
        String email="raissa123";
        String cpf="12345";
        //Realizando ação de teste
        //Comparando os resultados
        var response= Assertions.assertThrows(IllegalArgumentException.class,()-> registros.cadastrarFuncionario(nome,email,cpf));
        assertEquals("E-mail invalido",response.getMessage());
    }
    @Test
    public void deveLancarUmaExecaoQuandoOCpfJaEstiverCadastradoParaOutroVendedor(){
        //Criando cenario de teste
        String nome="raissa";
        String email="raissa@gmail.com";
        String cpf="1233";
        //Realizando ação de teste
        //Comparando os resultados
        var response= Assertions.assertThrows(IllegalArgumentException.class,()-> registros.cadastrarFuncionario(nome,email,cpf));
        assertEquals("CPF já cadastrado para outro vendedor",response.getMessage());
    }
    @Test
    public void deveCadastraClienteComSucesso(){
        //Criando cenario de teste
        String nome="Ana";
        String email="ana@nunes";
        String cpf="12345";
        //Realizando ação de teste
        registros.cadastrarCliente(nome,email,cpf);
        //Comparando os resultados
        verify(registros).cadastrarCliente(nome,email,cpf);
    }
    @Test
    public void deveLancarUmaExecaoQuandoOEmailDoClienteForInvalido(){
        //Criando cenario de teste
        String nome="renato";
        String email="renato123";
        String cpf="1233";
        //Realizando ação de teste
        //Comparando os resultados
        var response= Assertions.assertThrows(IllegalArgumentException.class,()-> registros.cadastrarCliente(nome,email,cpf));
        assertEquals("E-mail invalido",response.getMessage());
    }
    @Test
    public void deveLancarUmaExecaoQuandoOCpfJaEstiverCadastradoParaOutroCliente(){
        //Criando cenario de teste
        String nome="renato";
        String email="renato@gmail.com";
        String cpf="1233";
        //Realizando ação de teste
        //Comparando os resultados
        var response= Assertions.assertThrows(IllegalArgumentException.class,()-> registros.cadastrarCliente(nome,email,cpf));
        assertEquals("CPF ja cadastrado para outro cliente",response.getMessage());
    }
    @Test
    public void deveCadastraProdutoComSucesso(){
        //Criando cenario de teste
        String cpfC="1233";
        String emailF="raissa@gmail.com";
        int quantidadeProduto = 2;
        String nomeProduto = "Celular3";
        //Realizando ação de teste
        registros.cadastrarCompra(cpfC,emailF,quantidadeProduto,nomeProduto);
        //Comparando os resultados
        verify(registros).cadastrarCompra(cpfC,emailF,quantidadeProduto,nomeProduto);
    }
    @Test
    public void deveLancarUmaExecaoQuandoOVendedorNaoForCadastrado(){
        String cpfC="1233";
        String emailF="renato@gmail.com";
        int quantidadeProduto = 2;
        String nomeProduto = "Celular3";

        //Realizando ação de teste
        //Comparando os resultados
        var response= Assertions.assertThrows(IllegalArgumentException.class,()-> registros.cadastrarCompra(cpfC,emailF,quantidadeProduto,nomeProduto));
        assertEquals("Vendedor não cadastrado",response.getMessage());
    }
    @Test
    public void deveLancarUmaExecaoQuandoOClienteNaoForCadastrado(){
        String cpfC="12334";
        String emailF="raissa@gmail.com";
        int quantidadeProduto = 2;
        String nomeProduto = "Celular3";

        //Realizando ação de teste
        //Comparando os resultados
        var response= Assertions.assertThrows(IllegalArgumentException.class,()-> registros.cadastrarCompra(cpfC,emailF,quantidadeProduto,nomeProduto));
        assertEquals("Cliente não cadastrado",response.getMessage());
    }
    @Test
    public void deveLancarUmaExecaoQuandoOProdutoNaoEstiverCadastrado(){
        String cpfC="1233";
        String emailF="raissa@gmail.com";
        int quantidadeProduto = 2;
        String nomeProduto = "Celular7";

        //Realizando ação de teste
        //Comparando os resultados
        var response= Assertions.assertThrows(IllegalArgumentException.class,()-> registros.cadastrarCompra(cpfC,emailF,quantidadeProduto,nomeProduto));
        assertEquals("Produto não cadastrado",response.getMessage());
    }
}