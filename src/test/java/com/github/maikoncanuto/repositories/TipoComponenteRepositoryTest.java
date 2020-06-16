package com.github.maikoncanuto.repositories;

import com.github.maikoncanuto.repositories.config.H2DatabaseTestResource;
import com.github.maikoncanuto.entities.TipoComponente;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@QuarkusTestResource(H2DatabaseTestResource.class)
@QuarkusTest
public class TipoComponenteRepositoryTest {

    @Inject
    TipoComponenteRepository tipoComponenteRepository;

    @Test
    public void test_Salvar_Tipo_Componente() {
        TipoComponente tipoComponente = new TipoComponente();
        tipoComponente.setNome("INPUT");

        TipoComponente tipoComponenteResultado = tipoComponenteRepository.save(tipoComponente);

        Assertions.assertEquals("INPUT", tipoComponente.getNome());
    }

}
