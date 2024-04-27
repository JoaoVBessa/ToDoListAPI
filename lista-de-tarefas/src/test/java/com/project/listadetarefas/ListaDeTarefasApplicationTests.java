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
    // Adiciona algumas tarefas para listar
    	Tarefa tarefa1 = new Tarefa("Tarefa 1", "Descrição da tarefa 1");
    	Tarefa tarefa2 = new Tarefa("Tarefa 2", "Descrição da tarefa 2");
    	TarefaDTO tarefaDTO1 = modelMapper.map(tarefa1, TarefaDTO.class);
    	TarefaDTO tarefaDTO2 = modelMapper.map(tarefa2, TarefaDTO.class);

    	tarefaService.adicionarTarefa(tarefaDTO1);
    	tarefaService.adicionarTarefa(tarefaDTO2);

    // Lista todas as tarefas
    	List<TarefaDTO> tarefas = tarefaService.listarTodas();

    // Verifica se as tarefas retornadas contêm as tarefas adicionadas
    	assertTrue(tarefas.stream().anyMatch(t -> t.getTitulo().equals(tarefaDTO1.getTitulo())));
    	assertTrue(tarefas.stream().anyMatch(t -> t.getTitulo().equals(tarefaDTO2.getTitulo())));
	}

	@Test
	public void testAtualizarTarefa() {
    // Adiciona uma tarefa para ser atualizada
    	Tarefa tarefa = new Tarefa("Tarefa Original", "Descrição original");
    	TarefaDTO tarefaDTOOriginal = modelMapper.map(tarefa, TarefaDTO.class);
    	TarefaDTO tarefaAdicionada = tarefaService.adicionarTarefa(tarefaDTOOriginal);

    // Modifica a tarefa adicionada
    	tarefaAdicionada.setTitulo("Tarefa Atualizada");
    	tarefaAdicionada.setObservacao("Descrição atualizada");

    // Atualiza a tarefa
    	TarefaDTO tarefaAtualizada = tarefaService.atualizarTarefa(tarefaAdicionada.getId(), tarefaAdicionada);

    // Verifica se a tarefa foi atualizada corretamente
    	assertEquals(tarefaAdicionada.getTitulo(), tarefaAtualizada.getTitulo());
    	assertEquals(tarefaAdicionada.getObservacao(), tarefaAtualizada.getObservacao());
    // Adicione mais verificações conforme necessário
	}

	@Test
	public void testBuscarTarefaPorId() {
    	Tarefa tarefa = new Tarefa("Tarefa de busca por ID", "Descrição da tarefa.");
    	TarefaDTO tarefaDTO = modelMapper.map(tarefa, TarefaDTO.class);

    // Adiciona a tarefa para ter um ID válido
    	TarefaDTO tarefaAdicionada = tarefaService.adicionarTarefa(tarefaDTO);

    // Busca a tarefa pelo ID retornado na adição
    	TarefaDTO tarefaEncontrada = tarefaService.buscarPorId(tarefaAdicionada.getId());

    // Verifica se a tarefa encontrada é a mesma que foi adicionada
    	assertEquals(tarefaAdicionada.getId(), tarefaEncontrada.getId());
    	assertEquals(tarefaAdicionada.getTitulo(), tarefaEncontrada.getTitulo());
    	assertEquals(tarefaAdicionada.getObservacao(), tarefaEncontrada.getObservacao());
    // Adicione mais verificações conforme necessário
	}

	@Test
	public void testExcluirTarefa() {
    	Tarefa tarefa = new Tarefa("Tarefa de exclusão", "Descrição da tarefa.");
    	TarefaDTO tarefaDTO = modelMapper.map(tarefa, TarefaDTO.class);

    // Adiciona a tarefa para ter um ID válido
    	TarefaDTO tarefaAdicionada = tarefaService.adicionarTarefa(tarefaDTO);

    // Exclui a tarefa pelo ID retornado na adição
    	tarefaService.excluirTarefa(tarefaAdicionada.getId());

    // Verifica se a tarefa foi removida
    	assertThrows(ResourceNotFoundException.class, () -> tarefaService.buscarPorId(tarefaAdicionada.getId()));
}

}
