package com.project.listadetarefas.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.project.listadetarefas.model.Tarefa;

@Service
public class TarefaService {
    
    private List<Tarefa> tarefas = new ArrayList<>();

    public List<Tarefa> listarTodas(){
        return tarefas;
    }

    public Tarefa adicionarTarefa(Tarefa tarefa){
        tarefas.add(tarefa);
        return tarefa;
    }

    public Tarefa buscarPorId(Integer id){
        for (Tarefa tarefa: tarefas){
            if(tarefa.getId().equals(id)){
                return tarefa;
            }
        }
        return null;
    }

    public Tarefa atualizarTarefa(Integer id, Tarefa tarefaAtualizada){
        for(int i = 0; i < tarefas.size(); i++){
            Tarefa tarefa = tarefas.get(i);
            if(tarefa.getId().equals(id)){
                tarefaAtualizada.setId(tarefa.getId()); // Mantém o mesmo ID.
                tarefas.set(i, tarefaAtualizada); // Substitui a tarefa antiga pela atual.
                return tarefaAtualizada;
            }
        }
        return null; // Retorna null se a tarefa não for encontrada.
    }

    public boolean excluirTarefa(Integer id){
        for(int i = 0; i < tarefas.size(); i++){
            Tarefa tarefa = tarefas.get(i);
            if(tarefa.getId().equals(id)); // Remove a tarefa da lista.
            tarefas.remove(i);
        }
        return false; // Retorna falso se a tarefa não for encontrada na lista.
    }

}
