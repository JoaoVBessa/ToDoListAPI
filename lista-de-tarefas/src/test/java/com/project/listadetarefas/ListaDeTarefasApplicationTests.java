package com.project.listadetarefas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.listadetarefas.dto.TarefaDTO;
import com.project.listadetarefas.model.Tarefa;
import com.project.listadetarefas.services.TarefaService;

@SpringBootTest
class ListaDeTarefasApplicationTests {

	@Test
	public void testAdicionarTarefa() {
		TarefaService tarefaService = new TarefaService();
		Tarefa tarefa = new Tarefa("Teste com JUnit.", "Primeiro teste." );

		ModelMapper modelMapper = new ModelMapper();
		TarefaDTO tarefaDTO = modelMapper.map(tarefa, TarefaDTO.class);

		TarefaDTO tarefaAdicionada = tarefaService.adicionarTarefa(tarefaDTO);

		assertEquals(tarefa, tarefaAdicionada);
	}

}
