package br.com.daoGenerico;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.conexao.JpaUtil;

public class DaoGenerico<E> {
	private EntityManager conexao = JpaUtil.getEntityManager();

	public void salvar(E entidade ) {
       EntityTransaction transacao = conexao.getTransaction();
       transacao.begin();
       conexao.merge(entidade);
       transacao.commit();
       conexao.close();
	}

}
