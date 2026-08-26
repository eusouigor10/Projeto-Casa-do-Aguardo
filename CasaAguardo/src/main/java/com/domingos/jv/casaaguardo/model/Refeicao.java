package com.domingos.jv.casaaguardo.model;
import jakarta.persistence.*;

@Entity @Table(name="refeicao")
public class Refeicao {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="id_refeicao")
 private Long idRefeicao;
 @Column(name="data", nullable=false) private String data;
 @Column(name="tipo", nullable=false) private String tipo;
 @Column(name="qtd", nullable=false) private Integer quantidade;
 public Refeicao() {}
 public Long getIdRefeicao(){return idRefeicao;} public void setIdRefeicao(Long v){idRefeicao=v;}
 public String getData(){return data;} public void setData(String v){data=v;}
 public String getTipo(){return tipo;} public void setTipo(String v){tipo=v;}
 public Integer getQuantidade(){return quantidade;} public void setQuantidade(Integer v){quantidade=v;}
}