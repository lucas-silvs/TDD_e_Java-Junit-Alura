package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ReajusteServiceTest {


    @Test
    public void reajusteDeveriaSerDeTresPorcentoQuandoDesempenhoADesejar(){
        ReajusteService reajusteService = new ReajusteService();
        Funcionario funcionario = new Funcionario("João", LocalDate.now(),new BigDecimal("1000"));
        reajusteService.concederReajuste(funcionario, Desempenho.A_DESEJAR);
        Assert.assertEquals(new BigDecimal("1030.00"),funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerDeQuinzePorcentoQuandoDesempenhoForBom(){
        ReajusteService reajusteService = new ReajusteService();
        Funcionario funcionario = new Funcionario("João", LocalDate.now(),new BigDecimal("1000"));
        reajusteService.concederReajuste(funcionario, Desempenho.BOM);
        Assert.assertEquals(new BigDecimal("1150.00"),funcionario.getSalario());
    }


    @Test
    public void reajusteDeveriaSerDeVintePorcentoQuandoDesempenhoForOtimo(){
        ReajusteService reajusteService = new ReajusteService();
        Funcionario funcionario = new Funcionario("João", LocalDate.now(),new BigDecimal("1000"));
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
