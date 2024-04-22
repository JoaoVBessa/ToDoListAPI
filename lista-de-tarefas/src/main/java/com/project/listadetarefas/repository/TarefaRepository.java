package com.project.listadetarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.listadetarefas.model.Tarefa;


@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Integer>{
    
}
