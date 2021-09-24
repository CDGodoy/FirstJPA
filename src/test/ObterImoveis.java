package test;

import java.util.List;

import infra.DAOImoveis;
import model.Imovel;

/**
 * Classe que obtém N imóveis no banco
 * @author Carlos Daniel Nascimento
 *
 */
public class ObterImoveis {

  public static void main(String[] args) {
    DAOImoveis < Imovel > dao = new DAOImoveis < > (Imovel.class);

    List < Imovel > imoveis = dao.obterTodos();

    for (Imovel imovel: imoveis) {
      System.out.println("ID: " + imovel.getId() + ", Nome: " + imovel.getNomeDoImovel() +
        ", Valor: " + imovel.getValorImovel() + ", Comissão: " + imovel.getComissao()    +
        ", Tipo: " + imovel.getTipoImovel() + ", Status do Imovel: " + imovel.getStatusImovel());
    }

  }

}