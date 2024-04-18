package com.project.listadetarefas.model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Representa o MODEL da lista de tarefas.
 */
@Entity
public class Tarefa {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String observacao;

    private LocalTime hora;

    private LocalDate dia;

    private String titulo;

    
    /**
     * Construtor da Tarefa.
     * @param id
     * @param observacao
     * @param hora
     * @param dia
     * @param titulo
     */
    public Tarefa(Integer id, String observacao, LocalTime hora, LocalDate dia, String titulo) {
        this.id = id;
        this.observacao = observacao;
        this.hora = hora;
        this.dia = dia;
        this.titulo = titulo;
    }

    //#region Getters and Setters
    /**
     * Obtém o código da tarefa.
     * @return O cógido da tarefa.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Define o código da tarefa.
     * @param codigo O novo código da tarefa.
     */
    public void setId(Integer codigo) {
        if(codigo < 0){
            throw new IllegalArgumentException("O id não pode ser negativo");
        }
        this.id = codigo;
    }

    /**
     * Obtém a observação da tarefa.
     * @return A observação da tarefa.
     */
    public String getObservacao() {
        return observacao;
    }

    /**
     * Define a observação da tarefa.
     * @param observacao A nova observação da tarefa.
     */
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    /**
     * Obtém a hora da tarefa.
     * @return A hora da tarefa.
     */
    public LocalTime getHora() {
        return hora;
    }

    /**
     * Define a hora da tarefa.
     * @param hora A nova hora da tarefa.
     */
    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    /**
     * Obtém o dia da tarefa.
     * @return O dia da tarefa.
     */
    public LocalDate getDia() {
        return dia;
    }

    /**
     * Define o dia da tarefa.
     * @param dia O novo dia da tarefa.
     */
    public void setDia(LocalDate dia) {
        this.dia = dia;
    }

    /**
     * Obtém o título da tarefa.
     * @return O título da tarefa.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Define o título da tarefa.
     * @param titulo O novo título da tarefa.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    //#endregion

}
