package com.domingos.jv.casaaguardo.model;
import jakarta.persistence.*;

@Entity @Table(name="acompanhamento")
public class Acompanhamento {
 @Id @OneToOne @JoinColumn(name="id_paciente", nullable=false)
 private Paciente paciente;
 @ManyToOne(fetch=FetchType.LAZY, optional=false)
 @JoinColumn(name="id_acompanhante", nullable=false)
 private Acompanhante acompanhante;
 public Acompanhamento() {}
 public Paciente getPaciente(){return paciente;} public void setPaciente(Paciente v){paciente=v;}
 public Acompanhante getAcompanhante(){return acompanhante;} public void setAcompanhante(Acompanhante v){acompanhante=v;}
}