package com.domingos.jv.casaaguardo.model;
import jakarta.persistence.*;

@Entity @Table(name="pessoa") @Inheritance(strategy=InheritanceType.JOINED)
public class Pessoa {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="id_pessoa")
 protected Long idPessoa;
 @Column(name="nome", nullable=false) protected String nome;
 @Column(name="data_nascimento") protected String dataNascimento;
 @Column(name="cpf", nullable=false, unique=true) protected String cpf;
 public Pessoa() {}
 public Long getIdPessoa(){return idPessoa;} public void setIdPessoa(Long v){idPessoa=v;}
 public String getNome(){return nome;} public void setNome(String v){nome=v;}
 public String getDataNascimento(){return dataNascimento;} public void setDataNascimento(String v){dataNascimento=v;}
 public String getCpf(){return cpf;} public void setCpf(String v){cpf=v;}
}