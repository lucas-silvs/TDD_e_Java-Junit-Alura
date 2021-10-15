package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ReajusteService {
    public void concederReajuste(Funcionario funcionario, Desempenho desempenho) {

        BigDecimal valor = funcionario.getSalario().multiply(desempenho.percentualReajuste());


        if (valor.compareTo(new BigDecimal("1000")) > 0) {
            throw new IllegalArgumentException("Funcionario com salario acima de 1000");
        }
        funcionario.reajusteSalario(valor);


    }
}
