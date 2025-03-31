package com.test.mockito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ServicoEnvioTeste {

    @Mock
    private PlataformaDeEnvio plataforma;

    @InjectMocks
    private ServicoEnvioEmail servicoEnvio;

    @Captor
    private ArgumentCaptor<Email> captor;

    @Test
    void validarDadosEnviadosParaPlataforma() {
        String enderecoEmail = "test@test.test";
        String mensagem = "Mensagem";
        boolean formato = false;

        servicoEnvio.enviaEmail(enderecoEmail, mensagem, formato);

        Mockito.verify(plataforma).enviaEmail(captor.capture());

        Email email = captor.getValue();

        Assertions.assertEquals(enderecoEmail, email.getEnderecoEmail());
        Assertions.assertEquals(mensagem, email.getMensagem());
        Assertions.assertEquals(Formato.TEXTO, email.getFormato());
    }
}
