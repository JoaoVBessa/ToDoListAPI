package com.project.listadetarefas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.listadetarefas.dto.TarefaDTO;
import com.project.listadetarefas.model.Tarefa;
import com.project.listadetarefas.model.exception.ResourceNotFoundException;
import com.project.listadetarefas.services.TarefaService;

@SpringBootTest
class ListaDeTarefasApplicationTests {

    @Autowired
    private TarefaService tarefaService;

    @Autowired
    private ModelMapper modelMapper;

    @Test
    public void testAdicionarTarefa() {
        Tarefa tarefa = new Tarefa("Teste com JUnit.", "Primeiro teste." );
        TarefaDTO tarefaDTO = modelMapper.map(tarefa, TarefaDTO.class);

        TarefaDTO tarefaAdicionada = tarefaService.adicionarTarefa(tarefaDTO);

        assertEquals(tarefa.getTitulo(), tarefaAdicionada.getTitulo());
        assertEquals(tarefa.getObservacao(), tarefaAdicionada.getObservacao());
    }

	@Test
	public void testListarTodas() {
    	Tarefa tarefa1 = new Tarefa("Tarefa 1", "Descrição da tarefa 1");
    	Tarefa tarefa2 = new Tarefa("Tarefa 2", "Descrição da tarefa 2");
    	TarefaDTO tarefaDTO1 = modelMapper.map(tarefa1, TarefaDTO.class);
    	TarefaDTO tarefaDTO2 = modelMapper.map(tarefa2, TarefaDTO.class);

    	tarefaService.adicionarTarefa(tarefaDTO1);
    	tarefaService.adicionarTarefa(tarefaDTO2);

    	List<TarefaDTO> tarefas = tarefaService.listarTodas();

    	assertTrue(tarefas.stream().anyMatch(t -> t.getTitulo().equals(tarefaDTO1.getTitulo())));
    	assertTrue(tarefas.stream().anyMatch(t -> t.getTitulo().equals(tarefaDTO2.getTitulo())));
	}

	@Test
	public void testAtualizarTarefa() {
    	Tarefa tarefa = new Tarefa("Tarefa Original", "Descrição original");
    	TarefaDTO tarefaDTOOriginal = modelMapper.map(tarefa, TarefaDTO.class);
    	TarefaDTO tarefaAdicionada = tarefaService.adicionarTarefa(tarefaDTOOriginal);

    	tarefaAdicionada.setTitulo("Tarefa Atualizada");
    	tarefaAdicionada.setObservacao("Descrição atualizada");

    	TarefaDTO tarefaAtualizada = tarefaService.atualizarTarefa(tarefaAdicionada.getId(), tarefaAdicionada);

    	assertEquals(tarefaAdicionada.getTitulo(), tarefaAtualizada.getTitulo());
    	assertEquals(tarefaAdicionada.getObservacao(), tarefaAtualizada.getObservacao());
	}

	@Test
	public void testBuscarTarefaPorId() {
    	Tarefa tarefa = new Tarefa("Tarefa de busca por ID", "Descrição da tarefa.");
    	TarefaDTO tarefaDTO = modelMapper.map(tarefa, TarefaDTO.class);

    	TarefaDTO tarefaAdicionada = tarefaService.adicionarTarefa(tarefaDTO);

    	TarefaDTO tarefaEncontrada = tarefaService.buscarPorId(tarefaAdicionada.getId());

    	assertEquals(tarefaAdicionada.getId(), tarefaEncontrada.getId());
    	assertEquals(tarefaAdicionada.getTitulo(), tarefaEncontrada.getTitulo());
    	assertEquals(tarefaAdicionada.getObservacao(), tarefaEncontrada.getObservacao());
	}

	@Test
	public void testExcluirTarefa() {
    	Tarefa tarefa = new Tarefa("Tarefa de exclusão", "Descrição da tarefa.");
    	TarefaDTO tarefaDTO = modelMapper.map(tarefa, TarefaDTO.class);

    	TarefaDTO tarefaAdicionada = tarefaService.adicionarTarefa(tarefaDTO);

    	tarefaService.excluirTarefa(tarefaAdicionada.getId());

    	assertThrows(ResourceNotFoundException.class, () -> tarefaService.buscarPorId(tarefaAdicionada.getId()));
}

}
