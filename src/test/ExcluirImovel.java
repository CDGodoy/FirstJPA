package test;

import infra.DAOImoveis;
import model.Imovel;

public class ExcluirImovel {
	public static void main(String[] args) {
		DAOImoveis<Imovel> dao = new DAOImoveis < > (Imovel.class);

		dao.removeById(1L);//Só passar o ID do imóvel como parâmetro
	
	}
}
