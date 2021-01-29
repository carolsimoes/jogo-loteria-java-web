package io.github.carolsimoes.vraptor.controller;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import io.github.carolsimoes.vraptor.dao.UsuarioDAO;
import io.github.carolsimoes.vraptor.model.Usuario;

@Path("dashboard")
@Controller
public class DashboardController {
	
	
	@Get("")
	public void dashboard() {
		
	}
	
}
