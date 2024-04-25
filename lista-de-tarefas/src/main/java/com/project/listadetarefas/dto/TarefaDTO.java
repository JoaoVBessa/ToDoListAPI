package com.project.listadetarefas.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TarefaDTO {
    
    private Integer id;
    private String observacao;
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime hora;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate data;
    private String titulo;

    public TarefaDTO() {
        this.data = LocalDate.now();
        this.hora = LocalTime.now();
    }

    public TarefaDTO(Integer id, String observacao, LocalTime hora, LocalDate data, String titulo) {
        this.id = id;
        this.observacao = observacao;
        this.data = LocalDate.now();
        this.hora = LocalTime.now();
        this.titulo = titulo;
    }

    //#region Getters and Setters 
    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    //#endregion

    @Override
    public String toString() {
        return "TarefaDTO{" +
                "id=" + id +
                ", observacao='" + observacao + '\'' +
                ", hora=" + hora +
                ", data=" + data +
                ", titulo='" + titulo + '\'' +
                '}';
    }

}
