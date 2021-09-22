package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "imoveis")
public class Imovel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "ImovelName", nullable = false)
  private String nomeDoImovel = "";

  @Column(name = "ImovelBuilder", nullable = false)
  private String construtora = "";

  @Column(name = "ImovelValue", nullable = false)
  private double valorImovel = 0;

  @Column(name = "ImovelCommission", nullable = false)
  private double comissao = 0;

  @Column(name = "ImovelType", nullable = false)
  private Enum<model.TipoImovel> tipoImovel;

  @Column(name = "ImovelStats", nullable = false)
  private Enum<model.StatusImovel> StatusImovel;

  public Imovel() {}

  public Imovel(String nomeDoImovel, String construtora, double valorImovel, double comissao, Enum<TipoImovel> tipoImovel, Enum<model.StatusImovel> statusImovel) {
    this.nomeDoImovel = nomeDoImovel;
    this.construtora = construtora;
    this.valorImovel = valorImovel;
    this.comissao = comissao;
    this.tipoImovel = tipoImovel;
    StatusImovel = statusImovel;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNomeDoImovel() {
    return nomeDoImovel;
  }

  public void setNomeDoImovel(String nomeDoImovel) {
    this.nomeDoImovel = nomeDoImovel;
  }

  public String getConstrutora() {
    return construtora;
  }

  public void setConstrutora(String construtora) {
    this.construtora = construtora;
  }

  public double getValorImovel() {
    return valorImovel;
  }

  public void setValorImovel(double valorImovel) {
    this.valorImovel = valorImovel;
  }

  public double getComissao() {
    return comissao;
  }

  public void setComissao(double comissao) {
    this.comissao = comissao;
  }

  @java.lang.Override
  public java.lang.String toString() {
    return "Imovel{" +
      "id=" + id +
      ", nomeDoImovel='" + nomeDoImovel + '\'' +
      ", construtora='" + construtora + '\'' +
      ", valorImovel=" + valorImovel +
      ", comissao=" + comissao +
      '}';
  }

  public Enum<model.TipoImovel> getTipoImovel() {
      return tipoImovel;
  }

  public void setTipoImovel(Enum<model.TipoImovel> tipoImovel) {
      this.tipoImovel = tipoImovel;
  }

  public Enum<model.StatusImovel> getStatusImovel() {
      return StatusImovel;
  }

  public void setStatusImovel(Enum<model.StatusImovel> statusImovel) {
      StatusImovel = statusImovel;
  }

}