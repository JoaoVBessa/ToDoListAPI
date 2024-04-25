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

import com.project.listadetarefas.dto.TarefaDTO;
import com.project.listadetarefas.services.TarefaService;

@RestController
@RequestMapping("/api/lista")
public class TarefaController {
 
    @Autowired
    private TarefaService tarefaService;

    @GetMapping
    public ResponseEntity<List<TarefaDTO>> listarTodas(){
        List<TarefaDTO> tarefasDTO = tarefaService.listarTodas();
        return ResponseEntity.ok(tarefasDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaDTO> obterPorID(@PathVariable Integer id){
        TarefaDTO tarefaDTO = tarefaService.buscarPorId(id);
        if(tarefaDTO != null) {
            return ResponseEntity.ok(tarefaDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<TarefaDTO> adicionarTarefa(@RequestBody TarefaDTO tarefaDTO) {
        TarefaDTO criarTarefa = tarefaService.adicionarTarefa(tarefaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(criarTarefa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TarefaDTO> atualizarTarefa(@PathVariable Integer id, @RequestBody TarefaDTO tarefaDTO){
        TarefaDTO tarefaAtualizada = tarefaService.atualizarTarefa(id, tarefaDTO);
        return tarefaAtualizada != null ? ResponseEntity.ok(tarefaAtualizada) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirTarefa(@PathVariable Integer id){
        tarefaService.excluirTarefa(id);
        return ResponseEntity.noContent().build();
    }

}
