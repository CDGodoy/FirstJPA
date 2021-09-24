package test;

import infra.DAOImoveis;
import model.Imovel;

/**
 * Classe que altera dados de um imóvel no banco
 * @author Carlos Daniel Nascimento
 *
 */
public class AlterarImovel {
	public static void main(String[] args) {
		DAOImoveis <Imovel> dao = new DAOImoveis<> (Imovel.class);
		
		dao.abrirT();
		Imovel imovel = dao.obterPorId(1L);
		imovel.setNomeDoImovel("Casa do Lucas");
		imovel.setConstrutora("Pedreiro");
		imovel.setComissao(500);
		dao.merge(imovel);
		dao.fechar();
		
	}
}
