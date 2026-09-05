package com.domingos.jv.casaaguardo.model;
import jakarta.persistence.*;
import java.util.*;

@Entity @Table(name="acompanhante") @PrimaryKeyJoinColumn(name="id_pessoa")
public class Acompanhante extends Pessoa {
 @Column(name="cadastro_unico") private String cadastroUnico;
 @Column(name="problema_saude") private String problemaSaude;
 @Column(name="data_entrada") private String dataEntrada;
 @Column(name="data_saida") private String dataSaida;
 @Column(name="renda") private Double renda;
 @Column(name="ocupacao") private String ocupacao;
 @Column(name="beneficios_governo") private String beneficiosGoverno;
 @Column(name="status") private String status;
 @Column(name="autorizacao_imagem", nullable=false) private Boolean autorizacaoImagem=false;
 @Column(name="rua") private String rua;
 @Column(name="numero_casa") private String numeroCasa;
 @Column(name="cidade") private String cidade;
 @Column(name="uf") private String uf;

 @OneToMany(mappedBy="acompanhante", cascade=CascadeType.ALL, orphanRemoval=true)
 private List<AcompanhanteTelefone> telefones=new ArrayList<>();
 @OneToMany(mappedBy="acompanhante", cascade=CascadeType.ALL, orphanRemoval=true)
 private List<Acompanhamento> acompanhamentos=new ArrayList<>();

 public Acompanhante() {}
 public String getCadastroUnico(){return cadastroUnico;} public void setCadastroUnico(String v){cadastroUnico=v;}
 public String getProblemaSaude(){return problemaSaude;} public void setProblemaSaude(String v){problemaSaude=v;}
 public String getDataEntrada(){return dataEntrada;} public void setDataEntrada(String v){dataEntrada=v;}
 public String getDataSaida(){return dataSaida;} public void setDataSaida(String v){dataSaida=v;}
 public Double getRenda(){return renda;} public void setRenda(Double v){renda=v;}
 public String getOcupacao(){return ocupacao;} public void setOcupacao(String v){ocupacao=v;}
 public String getBeneficiosGoverno(){return beneficiosGoverno;} public void setBeneficiosGoverno(String v){beneficiosGoverno=v;}
 public String getStatus(){return status;} public void setStatus(String v){status=v;}
 public Boolean getAutorizacaoImagem(){return autorizacaoImagem;} public void setAutorizacaoImagem(Boolean v){autorizacaoImagem=v;}
 public String getRua(){return rua;} public void setRua(String v){rua=v;}
 public String getNumeroCasa(){return numeroCasa;} public void setNumeroCasa(String v){numeroCasa=v;}
 public String getCidade(){return cidade;} public void setCidade(String v){cidade=v;}
 public String getUf(){return uf;} public void setUf(String v){uf=v;}
 public List<AcompanhanteTelefone> getTelefones(){return telefones;} public void setTelefones(List<AcompanhanteTelefone> v){telefones=v;}
 public List<Acompanhamento> getAcompanhamentos(){return acompanhamentos;} public void setAcompanhamentos(List<Acompanhamento> v){acompanhamentos=v;}
}