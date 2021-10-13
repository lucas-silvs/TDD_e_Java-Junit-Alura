package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BonusServiceTest {

    @Test
    void bonusDeveSerZeroParaSalarioMaiorQueDezMil(){
        BonusService service = new BonusService();
        Funcionario funcionario = new Funcionario("Lucas", LocalDate.now(),new BigDecimal("20000"));
        Assert.assertEquals(new BigDecimal("0.00"),service.calcularBonus(funcionario));
    }

    @Test
    void bonusparaSalariomenorQueDezMil(){
        BonusService service = new BonusService();
        Funcionario funcionario = new Funcionario("Lucas", LocalDate.now(),new BigDecimal("2500"));
        Assert.assertEquals(new BigDecimal("250.00"),service.calcularBonus(funcionario));
    }

    @Test
    void paraSalarioComBonusIgualaMil(){
        BonusService service = new BonusService();
        Funcionario funcionario = new Funcionario("Lucas", LocalDate.now(),new BigDecimal("10000"));
        Assert.assertEquals(new BigDecimal("1000.00"),service.calcularBonus(funcionario));
    }

}
