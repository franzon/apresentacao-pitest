package br.com.exemplo;

import java.math.BigDecimal;

public class ContaBancaria {

    private final ServicoFakeDeEmail servicoFakeDeEmail;
    private BigDecimal saldo;


    public ContaBancaria(ServicoFakeDeEmail servicoFakeDeEmail, BigDecimal saldoInicial) {
        this.servicoFakeDeEmail = servicoFakeDeEmail;
        this.saldo = saldoInicial;
    }

    public String sacar(BigDecimal valorSaque) {
        if (saldo.compareTo(valorSaque) >= 0) {
            saldo = saldo.subtract(valorSaque);
            servicoFakeDeEmail.enviarComprovante("Saque realizado com sucesso!");
            return "SUCESSO";
        }

        return "FALHA";
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

}
