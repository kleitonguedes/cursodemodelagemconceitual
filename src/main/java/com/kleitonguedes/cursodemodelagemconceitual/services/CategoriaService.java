package com.kleitonguedes.cursodemodelagemconceitual.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kleitonguedes.cursodemodelagemconceitual.domain.Categoria;
import com.kleitonguedes.cursodemodelagemconceitual.repositories.CategoriaRepository;
import com.kleitonguedes.cursodemodelagemconceitual.services.exceptions.ObjetoNaoEncontradoException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjetoNaoEncontradoException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
}
