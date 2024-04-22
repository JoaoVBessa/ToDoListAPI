package com.project.listadetarefas.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.listadetarefas.model.Tarefa;
import com.project.listadetarefas.services.TarefaService;

@RestController
@RequestMapping("/api/lista")
public class TarefaController {
 
    @Autowired
    private TarefaService tarefaService;

    @GetMapping
    public ResponseEntity<List<Tarefa>> obterTodos(){
        List<Tarefa> tarefas = tarefaService.listarTodas();
        return ResponseEntity.ok(tarefas);
    }

    @PostMapping
    public ResponseEntity<Tarefa> createTask(@RequestBody Tarefa task) {
        Tarefa criarTask = tarefaService.adicionarTarefa(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(criarTask);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizarTarefa(@PathVariable Integer id, @RequestBody Tarefa tarefa){
        Tarefa tarefaAtualizada = tarefaService.atualizarTarefa(id, tarefa);
        if(tarefaAtualizada != null){
            return ResponseEntity.ok(tarefaAtualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirTarefa(@PathVariable Integer id){
        tarefaService.excluirTarefa(id);
        return ResponseEntity.noContent().build();
    } 

}
