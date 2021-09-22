package infra;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Imovel;


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
  
  //Construtor DAO
  public DAOImoveis(Class < E > classe) {
    this.classe = classe;
    em = emf.createEntityManager();
  }

  //Abrir transação
  public DAOImoveis < E > abrirT() {
    em.getTransaction().begin();
    return this;
  }
  
  //Fechar transação
  public DAOImoveis < E > fecharT() {
    em.getTransaction().commit();
    return this;
  }
  
  //Incluir no banco
  public DAOImoveis < E > incluir(E entidade) {
    em.persist(entidade);
    return this;
  }
  
  //Incluir com menos linhas
  public DAOImoveis < E > incluirAtomico(E entidade) {
    return this.abrirT().incluir(entidade).fecharT();
  }

  //Obter todos os 10 primeiros elementos do banco
  public List < E > obterTodos() {
    return this.obterTodos(10, 0);
  }
  
  //Obter um elemento por ID
  public Imovel obterPorId(Long id) {
	  return em.find(Imovel.class, id);
  }
  
  //Remover um elemento
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
  
  //Remover um elemento por ID
  public void removeById(final Long id) {
	  try {
		  Imovel imovel = obterPorId(id);
		  remove(imovel);
	  }catch (Exception ex) {
		  ex.printStackTrace();
	  }
  }
  
  //Obter todos os elementos do banco
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
  
  //Fechar o entity manager
  public void fechar() {
    em.close();
  }

}