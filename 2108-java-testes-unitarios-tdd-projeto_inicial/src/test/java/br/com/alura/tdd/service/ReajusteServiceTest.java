package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.Assert;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ReajusteServiceTest {

    private ReajusteService reajusteService;
    private Funcionario funcionario;

    @BeforeEach
    public void inicializar(){
        this.funcionario =  new Funcionario("João", LocalDate.now(),new BigDecimal("1000"));
        this.reajusteService = new ReajusteService();
        System.out.println("inicializar");

    }

    @AfterEach
    public void finalizar(){
        System.out.println("finalizar");
    }

    @BeforeAll
    public static void antesDeTodos(){
        System.out.println("Inicializando testes");
    }
    @AfterAll
    public static void depoisDeTodos(){
        System.out.println("Finalizado todos os testes");
    }

    @Test
    public void reajusteDeveriaSerDeTresPorcentoQuandoDesempenhoADesejar(){

        reajusteService.concederReajuste(funcionario, Desempenho.A_DESEJAR);
        Assert.assertEquals(new BigDecimal("1030.00"),funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerDeQuinzePorcentoQuandoDesempenhoForBom(){

        reajusteService.concederReajuste(funcionario, Desempenho.BOM);
        Assert.assertEquals(new BigDecimal("1150.00"),funcionario.getSalario());
    }


    @Test
    public void reajusteDeveriaSerDeVintePorcentoQuandoDesempenhoForOtimo(){

        reajusteService.concederReajuste(funcionario, Desempenho.OTIMO);
        Assert.assertEquals(new BigDecimal("1200.00"),funcionario.getSalario());
    }

    @Test
    public void deveRetornarErroParaFuncionarioQueNaoPodemReceberBonus(){
        ReajusteService reajusteService = new ReajusteService();
        Funcionario funcionario = new Funcionario("João", LocalDate.now(),new BigDecimal("25000"));
        assertThrows(IllegalArgumentException.class,() -> reajusteService.concederReajuste(funcionario, Desempenho.OTIMO));

    }



}
