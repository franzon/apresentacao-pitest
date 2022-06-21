package br.com.exemplo;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

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

//    @Test
//    void deveSubtrairOSaldoSeTiverSaldoSuficiente() {
//        ContaBancaria contaBancaria = new ContaBancaria(new ServicoFakeDeEmail(), BigDecimal.valueOf(1000));
//
//        contaBancaria.sacar(BigDecimal.valueOf(1000));
//
//        assertEquals(contaBancaria.getSaldo(), new BigDecimal(0));
//    }
//
//    @Test
//    void deveEnviarComprovantePorEmailSeConseguirSacar() {
//        ServicoFakeDeEmail mockEmail = mock(ServicoFakeDeEmail.class);
//        doNothing().when(mockEmail).enviarComprovante(anyString());
//
//        ContaBancaria contaBancaria = new ContaBancaria(mockEmail, BigDecimal.valueOf(1000));
//
//        contaBancaria.sacar(BigDecimal.valueOf(800));
//
//        assertEquals(contaBancaria.getSaldo(), new BigDecimal(200));
//        verify(mockEmail).enviarComprovante(anyString());
//    }
}
