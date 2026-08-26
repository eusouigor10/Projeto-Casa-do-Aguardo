package com.domingos.jv.casaaguardo.model;
import jakarta.persistence.*;
import java.util.*;

@Entity @Table(name="paciente") @PrimaryKeyJoinColumn(name="id_pessoa")
public class Paciente extends Pessoa {
 @Column(name="enfermidade") private String enfermidade;
 @Column(name="tratamento") private String tratamento;
 @Column(name="transporte") private String transporte;
 @Column(name="vinculo") private String vinculo;
 @Column(name="observacao") private String observacao;
 @OneToOne(mappedBy="paciente", cascade=CascadeType.ALL, orphanRemoval=true)
 private Acompanhamento acompanhamento;
 @OneToMany(mappedBy="paciente", cascade=CascadeType.ALL, orphanRemoval=true)
 private List<PacienteInternamento> internamentos=new ArrayList<>();
 public Paciente() {}
 public String getEnfermidade(){return enfermidade;} public void setEnfermidade(String v){enfermidade=v;}
 public String getTratamento(){return tratamento;} public void setTratamento(String v){tratamento=v;}
 public String getTransporte(){return transporte;} public void setTransporte(String v){transporte=v;}
 public String getVinculo(){return vinculo;} public void setVinculo(String v){vinculo=v;}
 public String getObservacao(){return observacao;} public void setObservacao(String v){observacao=v;}
 public Acompanhamento getAcompanhamento(){return acompanhamento;} public void setAcompanhamento(Acompanhamento v){acompanhamento=v;}
 public List<PacienteInternamento> getInternamentos(){return internamentos;} public void setInternamentos(List<PacienteInternamento> v){internamentos=v;}
}