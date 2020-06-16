package com.github.maikoncanuto.repositories;

import com.github.maikoncanuto.entities.TipoComponente;
import com.github.maikoncanuto.repositories.config.H2DatabaseTestResource;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTestResource(H2DatabaseTestResource.class)
@QuarkusTest
public class TipoComponenteRepositoryTest {

    @Inject
    TipoComponenteRepository tipoComponenteRepository;

    TipoComponente tipoComponente;

    private static final String LABEL_INPUT = "INPUT";

    @BeforeEach
    public void setUp() {
        tipoComponente = new TipoComponente();
        tipoComponente.setNome(LABEL_INPUT);
    }

    @Test
    public void test_Salvar_E_Deletar_Tipo_Componente() {
        TipoComponente tipoComponenteResultado = tipoComponenteRepository.save(tipoComponente);
        assertEquals(LABEL_INPUT, tipoComponenteResultado.getNome());
        tipoComponenteRepository.delete(tipoComponenteResultado.getId());
    }

    @Test
    public void test_Find_By_Id_Tipo_Componente_Passando_Id() {
        TipoComponente tipoComponenteResultado = tipoComponenteRepository.save(tipoComponente);
        TipoComponente tipoComponenteFindById = tipoComponenteRepository.findById(tipoComponenteResultado.getId());
        assertEquals(tipoComponenteResultado.getNome(), tipoComponenteFindById.getNome());
        tipoComponenteRepository.delete(tipoComponenteResultado.getId());
    }

    @Test
    public void test_Find_All_Tipo_Componente() {
        TipoComponente tipoComponenteResultado = tipoComponenteRepository.save(tipoComponente);
        List<TipoComponente> tipoComponentes = tipoComponenteRepository.findAll();
        assertEquals(1, tipoComponentes.size());
        tipoComponenteRepository.delete(tipoComponenteResultado.getId());
    }

    @Test
    public void test_Salvar_E_Atualizar_Tipo_Componente() {
        final String LABEL_UPDATE = "INPUT-2";

        TipoComponente tipoComponenteResultado = tipoComponenteRepository.save(tipoComponente);
        assertEquals(LABEL_INPUT, tipoComponenteResultado.getNome());

        tipoComponenteResultado.setNome(LABEL_UPDATE);
        TipoComponente tipoComponenteUpdate = tipoComponenteRepository.update(tipoComponenteResultado);
        assertEquals(LABEL_UPDATE, tipoComponenteUpdate.getNome());

        tipoComponenteRepository.delete(tipoComponenteUpdate.getId());
    }
}
