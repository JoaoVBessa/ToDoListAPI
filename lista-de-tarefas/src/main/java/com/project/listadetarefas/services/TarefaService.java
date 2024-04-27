package com.project.listadetarefas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.listadetarefas.dto.TarefaDTO;
import com.project.listadetarefas.model.Tarefa;
import com.project.listadetarefas.model.exception.ResourceNotFoundException;
import com.project.listadetarefas.repository.TarefaRepository;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;
    
    @Autowired
    private ModelMapper modelMapper;

    public List<TarefaDTO> listarTodas(){
        List<Tarefa> tarefas = tarefaRepository.findAll();
        return tarefas.stream()
                .map(tarefa -> modelMapper.map(tarefa, TarefaDTO.class))
                .collect(Collectors.toList());
    }

    public TarefaDTO adicionarTarefa(TarefaDTO tarefaDTO) {
        if (tarefaDTO.getId() == null) {
            tarefaDTO.setId(0); // Define um valor padrão para o ID
        }
        Tarefa tarefa = modelMapper.map(tarefaDTO, Tarefa.class);
        Tarefa tarefaSalva = tarefaRepository.save(tarefa);
        return modelMapper.map(tarefaSalva, TarefaDTO.class);
    }

    public TarefaDTO buscarPorId(Integer id) {
        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tarefa com o ID " + id + " não encontrada."));
        return modelMapper.map(tarefa, TarefaDTO.class);
    }

    public TarefaDTO atualizarTarefa(Integer id, TarefaDTO tarefaAtualizada){
        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("A tarefa com o id " + id + " não foi encontrada."));
        
        tarefa.setTitulo(tarefaAtualizada.getTitulo());
        tarefa.setObservacao(tarefaAtualizada.getObservacao());
        tarefa.setData(tarefaAtualizada.getData());
        tarefa.setHora(tarefaAtualizada.getHora());
        
        tarefa = tarefaRepository.save(tarefa);
        
        return modelMapper.map(tarefa, TarefaDTO.class);
    }
    

    public ResponseEntity<Void> excluirTarefa(Integer id) {
        if (tarefaRepository.existsById(id)) {
            tarefaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            throw new ResourceNotFoundException("Tarefa com o ID " + id + " não encontrada.");
        }
    }

}
