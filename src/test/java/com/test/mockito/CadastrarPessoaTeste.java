package com.test.mockito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class CadastrarPessoaTeste {

    @Mock
    private ApiDosCorreios apiDosCorreios;

    @InjectMocks
    private CadastrarPessoa cadastrarPessoa;

    @Test
    void validarDadosDeCadastro() {
        DadosLocalizacao dadosLocalizacao = new DadosLocalizacao("MG", "Pato de Minas", "Rua 2", "apto", "2");
        Mockito.when(apiDosCorreios.buscaDadosComBaseNoCep("987989")).thenReturn(dadosLocalizacao);
        Pessoa pessoa = cadastrarPessoa.cadastraPessoa("gabriel", "656965", LocalDate.now(), "987989");

        Assertions.assertEquals("gabriel", pessoa.getNome());
        Assertions.assertEquals("656965", pessoa.getDocumento());
        Assertions.assertEquals("MG", pessoa.getEndereco().getUf());
        Assertions.assertEquals("apto", pessoa.getEndereco().getComplemento());
    }

}
