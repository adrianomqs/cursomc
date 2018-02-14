package com.flexautomacao.cursomc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flexautomacao.cursomc.domain.Categoria;
import com.flexautomacao.cursomc.repositories.CategoriaRepository;
import com.flexautomacao.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		Categoria obj = repo.findOne(id);
		
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: "+ Categoria.class.getName());
		}
		
		return obj;
	}
	
	public List<Categoria> buscarTodos(){
		List<Categoria> obj = repo.findAll();
		
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Tipo: "+ Categoria.class.getName());
		}
		
		return obj;
	}
}
