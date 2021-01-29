package io.github.carolsimoes.vraptor.controller;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.IncludeParameters;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import io.github.carolsimoes.vraptor.dao.UsuarioDAO;
import io.github.carolsimoes.vraptor.model.Usuario;

@Path("cadastrar")
@Controller
public class CadastrarController {
	
	@Inject	EntityManager em;
	@Inject Result result;
	@Inject UsuarioDAO usuarioDao;
	@Inject Validator validador;

	
	@Get("")
	public void cadastrar() {
		
	}
	
	@IncludeParameters
	@Post("salvaUsuario")
	public void salvaUsuario(@NotNull @Valid Usuario usuario, String confirmaSenha) {

		boolean asSenhasSaoIguais = confirmaSenha.equals(usuario.getSenha());

		//se der erro direciona para cadastrar, caso der certo direciona para o Dashboard
		validador.addIf(!asSenhasSaoIguais,
				new SimpleMessage("confirmaSenha", "A confirmação de senha está diferente da senha"));
		validador.onErrorRedirectTo(this).cadastrar();
		usuarioDao.insertOrUpdate(usuario);
		result.redirectTo(DashboardController.class).dashboard();
	}
}
