package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe do objeto "imóvel"
 * @author Carlos Daniel Nascimento
 *
 */
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
/**
 * Construtor do imóvel
 * @param nomeDoImovel Nome do imóvel
 * @param construtora Construtora do imóvel
 * @param valorImovel Valor do imóvel
 * @param comissao Comissão do imóvel
 * @param tipoImovel Tipo do imóvel (casa, apartamento, rural, etc...)
 * @param statusImovel Status de construção do imóvel (Na planta, Em construção, pronto)
 */
  public Imovel(String nomeDoImovel, String construtora, double valorImovel, double comissao, Enum<TipoImovel> tipoImovel, Enum<model.StatusImovel> statusImovel) {
    this.nomeDoImovel = nomeDoImovel;
    this.construtora = construtora;
    this.valorImovel = valorImovel;
    this.comissao = comissao;
    this.tipoImovel = tipoImovel;
    StatusImovel = statusImovel;
  }
  
  /**
   * Obter ID do imóvel
   * @return id
   */
  public Long getId() {
    return id;
  }
  
  /**
   * Setar ID do imóvel
   * @param id Número de identificação do imóvel
   */
  public void setId(Long id) {
    this.id = id;
  }
/**
 * Obter nome do imóvel
 * @return nomeDoImovel
 */
  public String getNomeDoImovel() {
    return nomeDoImovel;
  }
/**
 * Setar nome do imóvel
 * @param nomeDoImovel  Nome do imóvel
 */
  public void setNomeDoImovel(String nomeDoImovel) {
    this.nomeDoImovel = nomeDoImovel;
  }
/**
 * Obter a construtora do imóvel
 * @return construtora 
 */
  public String getConstrutora() {
    return construtora;
  }
  /**
   * Setar a construtora do imóvel
   * @param construtora Construtora do imóvel
   */
  public void setConstrutora(String construtora) {
    this.construtora = construtora;
  }
/**
 * Obter o valor do imóvel
 * @return valorImovel
 */
  public double getValorImovel() {
    return valorImovel;
  }
/**
 * Setar o valor do imóvel
 * @param valorImovel Valor do imóvel
 */
  public void setValorImovel(double valorImovel) {
    this.valorImovel = valorImovel;
  }
/**
 * Obter o valor da comissao do imóvel
 * @return comissao
 */
  public double getComissao() {
    return comissao;
  }
/**
 * Setar o valor da comissao do imóvel
 * @param comissao Valor da comissao do imóvel
 */
  public void setComissao(double comissao) {
    this.comissao = comissao;
  }

  /**
   * Método toString
   */
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
/**
 * Obter Enum dos tipos de imóveis
 * @return tipoImovel
 */
  public Enum<model.TipoImovel> getTipoImovel() {
      return tipoImovel;
  }
/**
 * Setar Enum dos tipos de imóveis
 * @param tipoImovel Enum dos tipos de imóveis
 */
  void setTipoImovel(Enum<model.TipoImovel> tipoImovel) {
      this.tipoImovel = tipoImovel;
  }
  /**
   * Obter Enum dos status dos imóveis
   * @return tipoImovel
   */
  public Enum<model.StatusImovel> getStatusImovel() {
      return StatusImovel;
  }
/**
 * Setar Enum dos status dos imóveis
 * @param statusImovel Enum dos status dos imóveis
 */
  public void setStatusImovel(Enum<model.StatusImovel> statusImovel) {
      StatusImovel = statusImovel;
  }

}