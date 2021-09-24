package infra;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Imovel;

/**
 * Esta classe é um Data Access Object, aqui tratamos as conexões, SQL's e funções de CRUD do banco
 * @author Carlos Daniel Nascimento
 *
 * @param <E> Entidade de classe genérica
 */
public class DAOImoveis < E > {

  private static EntityManagerFactory emf;
  private EntityManager em;
  private Class < E > classe;

  static {
    try {
      emf = Persistence.createEntityManagerFactory("Exercicio-JPA");
    } catch (Exception e) {
      // TODO: handle exception
    }
  }

  public DAOImoveis() {
    this(null);
  }
  
 /**
  * Construtor do DAO
  * @param classe Classe de entidade específica
  */
  public DAOImoveis(Class < E > classe) {
    this.classe = classe;
    em = emf.createEntityManager();
  }

/**
 * Abrir transação.
 * @return this
 */
  public DAOImoveis < E > abrirT() {
    em.getTransaction().begin();
    return this;
  }
  
  /**
   * Fechar transação
   * @return this
   */
  public DAOImoveis < E > fecharT() {
    em.getTransaction().commit();
    return this;
  }
  
/**
 * Incluir um objeto no banco
 * @param entidade Objeto a ser incluida no banco
 */
  public DAOImoveis < E > incluir(E entidade) {
    em.persist(entidade);
    return this;
  }
  
/**
 * Realizar toda a operação de incluir um objeto no banco
 * (Abre transação, inclui e fecha a transação).
 * @param entidade Entidade a ser incluida no banco
 */
  public DAOImoveis < E > incluirAtomico(E entidade) {
    return this.abrirT().incluir(entidade).fecharT();
  }
  
/**
 * Obtém um imóvel pelo seu ID
 * @param id Chave de identificação do imóvel
 * @return em.find()
 */
  public Imovel obterPorId(Long id) {
	  return em.find(Imovel.class, id);
  }
  
/**
 * Deleta um imóvel pelo objeto escolhido.
 * Este método procura o ID do imóvel e chama o método {@link infra.DAOImoveis#removeById(Long)}
 * @param imovel Objeto a ser pesquisado para ser removido do banco
 */
  public void remove(Imovel imovel) {
	  try {
		  this.abrirT();
		  imovel = em.find(Imovel.class, imovel.getId());
		  em.remove(imovel);
		  this.fecharT();
	  }catch (Exception ex) {
		  ex.printStackTrace();
		  em.getTransaction().rollback();
	  }
  }

 /**
  * Realiza o merge no banco
  * @param imovel Objeto imóvel
  */
  public void merge(Imovel imovel) {
	  
	  try {
		  this.abrirT();
		  em.merge(imovel);
		  this.fecharT();
	  }catch (Exception ex) {
          ex.printStackTrace();
          em.getTransaction().rollback();
       }
	  
  }
  
/**
 * Remove um imóvel pelo seu ID
 * @param id Id a ser pesquisado para remover no banco
 */
  public void removeById(final Long id) {
	  try {
		  Imovel imovel = obterPorId(id);
		  remove(imovel);
	  }catch (Exception ex) {
		  ex.printStackTrace();
	  }
  }
  
/**
 * Acesso rápido para obter os 10 primeiros objetos do banco
 */
  public List < E > obterTodos() {
    return this.obterTodos(10, 0);
  }
  
/**
 * Obter N objetos do banco
 * @param qtde Quantidade de objetos a serem pesquisados
 * @param deslocamento Deslocamento da pesquisa inicial (começando a partir do objeto k)
 * @return query.getResultList()
 */
  public List < E > obterTodos(int qtde, int deslocamento) {
    if (classe == null) {
      throw new UnsupportedOperationException("Classe nula.");
    }

    String jpql = "select e from " + classe.getName() +
      " e";
    TypedQuery < E > query = em.createQuery(jpql, classe);
    query.setMaxResults(qtde);
    query.setFirstResult(deslocamento);
    return query.getResultList();
  }

/**
 * Fechar entity manager
 */
  public void fechar() {
    em.close();
  }

}