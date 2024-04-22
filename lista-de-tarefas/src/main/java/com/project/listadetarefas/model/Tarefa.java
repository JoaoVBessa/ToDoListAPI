package com.project.listadetarefas.model;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

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

    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime hora;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate data;

    private String titulo;

    /**
     * Construtor da Tarefa.
     */
    public Tarefa() {
        this.data = LocalDate.now();
        this.hora = LocalTime.now();
    }

    /**
     * Construtor da Tarefa com parâmetros.
     * @param observacao
     * @param titulo
     */
    public Tarefa(String titulo, String observacao) {
        this.titulo = titulo;
        this.observacao = observacao;
        this.data = LocalDate.now();
        this.hora = LocalTime.now();
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
    public LocalDate getData() {
        return data;
    }

    /**
     * Define o dia da tarefa.
     * @param dia O novo dia da tarefa.
     */
    public void setData(LocalDate dia) {
        this.data = dia;
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
