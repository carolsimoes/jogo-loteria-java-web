package io.github.carolsimoes.vraptor.dao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import io.github.carolsimoes.vraptor.model.Usuario;

@RequestScoped
public class UsuarioDAO extends DAO<Usuario> {
	
	@Inject
	public UsuarioDAO(EntityManager em) {
		super(em, Usuario.class);
	}
	
	@Deprecated
	public UsuarioDAO() {
		this(null);
	}

}
