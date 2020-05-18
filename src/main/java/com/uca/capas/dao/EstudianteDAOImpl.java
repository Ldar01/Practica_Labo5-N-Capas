package com.uca.capas.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Estudiante;

@Repository
public class EstudianteDAOImpl implements EstudianteDAO {

	@PersistenceContext(unitName = "capas")
	private EntityManager entityManager;
	
	@Override
	public List<Estudiante> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * FROM public.estudiante");
		Query query = entityManager.createNativeQuery(sb.toString(), Estudiante.class);
		List<Estudiante> resultset = query.getResultList();
		
		return resultset;
	}

	@Override
	public Estudiante findOne(Integer code) throws DataAccessException {
		// TODO Auto-generated method stub
		Estudiante estudiante = entityManager.find(Estudiante.class, code);
		return estudiante;
	}

}
