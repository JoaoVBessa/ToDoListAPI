package com.project.listadetarefas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.listadetarefas.model.Tarefa;
import com.project.listadetarefas.repository.TarefaRepository;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public List<Tarefa> listarTodas(){
        return tarefaRepository.findAll();
    }

    public Tarefa adicionarTarefa(Tarefa tarefa){
        return tarefaRepository.save(tarefa);
    }

    public Tarefa buscarPorId(Integer id){
        return tarefaRepository.findById(id).orElse(null);
    }

    public Tarefa atualizarTarefa(Integer id, Tarefa tarefaAtualizada){
        Optional<Tarefa> optionalTarefa = tarefaRepository.findById(id);
        if (optionalTarefa.isPresent()) {
            Tarefa tarefa = optionalTarefa.get();
            tarefa.setObservacao(tarefaAtualizada.getObservacao());
            tarefa.setHora(tarefaAtualizada.getHora());
            tarefa.setData(tarefaAtualizada.getData());
            tarefa.setTitulo(tarefaAtualizada.getTitulo());
            return tarefaRepository.save(tarefa);
        } else {
            return null; // Ou lançar uma exceção, dependendo do seu requisito
        }
    }

    public boolean excluirTarefa(Integer id){
        if (tarefaRepository.existsById(id)) {
            tarefaRepository.deleteById(id);
            return true;
        }
        return false; // Ou lançar uma exceção, dependendo do seu requisito
    }

}
