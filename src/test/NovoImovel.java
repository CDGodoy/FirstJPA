package test;

import infra.DAOImoveis;
import model.Imovel;
import model.StatusImovel;
import model.TipoImovel;

public class NovoImovel {

  public static void main(String[] args) {
    DAOImoveis < Imovel > dao = new DAOImoveis < > (Imovel.class);

    Imovel imovel = new Imovel("Casa do Godoy","N sei cara", 250000, 25000, TipoImovel.CASA, StatusImovel.PRONTO);

    dao.incluirAtomico(imovel).fechar();
  }

}