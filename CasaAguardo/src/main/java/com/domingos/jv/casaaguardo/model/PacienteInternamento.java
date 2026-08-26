package com.domingos.jv.casaaguardo.model;
import jakarta.persistence.*;

@Entity @Table(name="paciente_internamento")
public class PacienteInternamento {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="id_internamento")
 private Long idInternamento;
 @Column(name="uti", nullable=false) private Boolean uti=false;
 @Column(name="acomodacao") private String acomodacao;
 @Column(name="unidade") private String unidade;
 @Column(name="armario") private String armario;
 @ManyToOne(fetch=FetchType.LAZY, optional=false)
 @JoinColumn(name="id_paciente", nullable=false) private Paciente paciente;
 public PacienteInternamento() {}
 public Long getIdInternamento(){return idInternamento;} public void setIdInternamento(Long v){idInternamento=v;}
 public Boolean getUti(){return uti;} public void setUti(Boolean v){uti=v;}
 public String getAcomodacao(){return acomodacao;} public void setAcomodacao(String v){acomodacao=v;}
 public String getUnidade(){return unidade;} public void setUnidade(String v){unidade=v;}
 public String getArmario(){return armario;} public void setArmario(String v){armario=v;}
 public Paciente getPaciente(){return paciente;} public void setPaciente(Paciente v){paciente=v;}
}