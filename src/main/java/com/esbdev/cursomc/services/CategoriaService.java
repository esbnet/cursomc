package com.esbdev.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.esbdev.cursomc.domain.Categoria;
import com.esbdev.cursomc.repositories.CategoriaRepository;
import com.esbdev.cursomc.services.exceptions.DataIntegrityException;
import com.esbdev.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	public Categoria find(Integer id) {
		Categoria obj = repo.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName(), null);
		}
		return obj;
	}

	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
	}

	public void delete(Integer id) {
		find(id);

		try {
			repo.delete(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível incluir uma categoria que possui produtos.");

		}
	}
}