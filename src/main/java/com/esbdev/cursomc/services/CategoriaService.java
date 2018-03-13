package com.esbdev.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esbdev.cursomc.domain.Categoria;
import com.esbdev.cursomc.repositories.CategoriaRepository;
//-- import com.esbdev.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	public Categoria buscar(Integer id) {
		Categoria obj = repo.findOne(id);
//--		if (obj == null) {
//--			throw new ObjectNotFoundException(
//--					"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName());
//--		}
		return obj;
	}

}