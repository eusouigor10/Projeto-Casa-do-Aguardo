package com.domingos.jv.casaaguardo.model;
import jakarta.persistence.*;

@Entity @Table(name="acompanhante_telefone")
public class AcompanhanteTelefone {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="id_telefone")
 private Long idTelefone;
 @Column(name="telefone", nullable=false) private String telefone;
 @ManyToOne(fetch=FetchType.LAZY, optional=false)
 @JoinColumn(name="id_acompanhante", nullable=false) private Acompanhante acompanhante;
 public AcompanhanteTelefone() {}
 public Long getIdTelefone(){return idTelefone;} public void setIdTelefone(Long v){idTelefone=v;}
 public String getTelefone(){return telefone;} public void setTelefone(String v){telefone=v;}
 public Acompanhante getAcompanhante(){return acompanhante;} public void setAcompanhante(Acompanhante v){acompanhante=v;}
}