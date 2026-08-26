package com.domingos.jv.casaaguardo.model;
import jakarta.persistence.*;

@Entity @Table(name="usuario")
public class Usuario {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="id_usuario")
 private Long idUsuario;
 @Column(name="nome_usuario", nullable=false, unique=true) private String nomeUsuario;
 @Column(name="senha", nullable=false) private String senha;
 public Usuario() {}
 public Long getIdUsuario(){return idUsuario;} public void setIdUsuario(Long v){idUsuario=v;}
 public String getNomeUsuario(){return nomeUsuario;} public void setNomeUsuario(String v){nomeUsuario=v;}
 public String getSenha(){return senha;} public void setSenha(String v){senha=v;}
}