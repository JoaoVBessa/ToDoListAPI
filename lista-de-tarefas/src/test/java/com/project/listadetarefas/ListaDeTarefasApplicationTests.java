package com.project.listadetarefas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.listadetarefas.model.Tarefa;
import com.project.listadetarefas.services.TarefaService;

@SpringBootTest
class ListaDeTarefasApplicationTests {

	@Test
	public void testAdicionarTarefa() {
		TarefaService tarefaService = new TarefaService();
		Tarefa tarefa = new Tarefa("Teste com JUnit.", "Primeiro teste." );

		Tarefa tarefaAdicionada = tarefaService.adicionarTarefa(tarefa);

		assertEquals(tarefa, tarefaAdicionada);
	}

}
