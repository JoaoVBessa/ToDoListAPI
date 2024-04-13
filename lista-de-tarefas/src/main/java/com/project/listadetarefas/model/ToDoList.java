package com.project.listadetarefas.model;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Representa o MODEL da lista de tarefas.
 */
public class ToDoList {
 
    private Integer codigo;

    private String observacao;

    private LocalTime hora;

    private LocalDate dia;

    private String titulo;

    //#region Getters and Setters
    /**
     * Obtém o código da tarefa.
     * @return O cógido da tarefa.
     */
    public Integer getCodigo() {
        return codigo;
    }

    /**
     * Define o código da tarefa.
     * @param codigo O novo código da tarefa.
     */
    public void setCodigo(Integer codigo) {
        if(codigo < 0){
            throw new IllegalArgumentException("O código não pode ser negativo");
        }
        this.codigo = codigo;
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
