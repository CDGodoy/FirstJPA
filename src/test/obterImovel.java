package test;

import java.util.List;

import infra.DAOImoveis;
import model.Imovel;

public class obterImovel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    DAOImoveis < Imovel > dao = new DAOImoveis < > (Imovel.class);

	    List < Imovel > imoveis = dao.obterTodos(1,0);

	    for (Imovel imovel: imoveis) {
	      System.out.println("ID: " + imovel.getId() + ", Nome: " + imovel.getNomeDoImovel() +
	        ", Valor: " + imovel.getValorImovel() + ", Comissão: " + imovel.getComissao()    +
	        ", Tipo: " + imovel.getTipoImovel() + ", Status do Imovel: " + imovel.getStatusImovel());
	    }
	}

}
