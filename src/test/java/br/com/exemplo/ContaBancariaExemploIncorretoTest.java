package br.com.exemplo;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ContaBancariaExemploIncorretoTest {

    @Test
    void deveRetornarSucessoSeTiverSaldoSuficiente() {
        ContaBancaria contaBancaria = new ContaBancaria(new ServicoFakeDeEmail(), BigDecimal.valueOf(1000));

        String resultado = contaBancaria.sacar(BigDecimal.valueOf(800));

        assertEquals(resultado, "SUCESSO");
    }

    @Test
    void deveRetorarFalhaSeNaoTiverSaldoSuficiente() {
        ContaBancaria contaBancaria = new ContaBancaria(new ServicoFakeDeEmail(), BigDecimal.valueOf(1000));

        String resultado = contaBancaria.sacar(BigDecimal.valueOf(1200));

        assertEquals(resultado, "FALHA");
    }

    @Test
    void naoDeveSubtrairOSaldoSeNaoTiverSaldoSuficiente() {
        ContaBancaria contaBancaria = new ContaBancaria(new ServicoFakeDeEmail(), BigDecimal.valueOf(1000));

        contaBancaria.sacar(BigDecimal.valueOf(1200));

        assertEquals(contaBancaria.getSaldo(), new BigDecimal(1000));
    }
}
