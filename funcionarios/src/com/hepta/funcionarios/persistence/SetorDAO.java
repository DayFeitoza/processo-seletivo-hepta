package com.hepta.funcionarios.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.hepta.funcionarios.entity.Setor;

import net.bytebuddy.implementation.bytecode.Throw;

public class SetorDAO implements InterfaceDAO<Setor>{

	@Override
	public void save(Setor setor) throws Exception {
		EntityManager em = HibernateUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(setor);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new Exception(e);
		} finally {
			em.close();
		}
		
	}

	@Override
	public Setor update(Integer id, Setor setor) throws Exception {
		EntityManager em = HibernateUtil.getEntityManager();
		Setor setorAtualizado = null;
		try {
			em.getTransaction().begin();
			setorAtualizado = em.merge(setor);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new Exception(e);
		} finally {
			em.close();
		}
		return setorAtualizado;
	}

	@Override
	public void delete(Integer id) throws Exception {
		EntityManager em = HibernateUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			Setor setor = em.find(Setor.class, id);
			em.remove(setor);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new Exception(e);
		} finally {
			em.close();
		}
	}

	@Override
	public Setor find(Integer id) throws Exception {
		EntityManager em = HibernateUtil.getEntityManager();
		Setor setor = null;
		try {
			setor = em.find(Setor.class, id);
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new Exception(e);
		} finally {
			em.close();
		}
		return setor;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Setor> getAll() throws Exception {
		EntityManager em = HibernateUtil.getEntityManager();
		List<Setor> setores = new ArrayList<>();
		try {
			Query query = em.createQuery("FROM Setor");
			setores = query.getResultList();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new Exception(e);
		} finally {
			em.close();
		}
		return setores;
	}
	
	public void salvarSetor(Setor setor) throws Exception {
		if(setor != null && !setor.getNome().isEmpty()) {
			List<Setor> setores = new ArrayList<Setor>(this.getAll());
			
			for(Setor s: setores) {
				if(s.getId().equals(setor.getId())) {
					setor.setId(s.getId());
					return;
				}
			}
			throw new Exception("Não foi possivel atualizar o setor");
		}
	}

}