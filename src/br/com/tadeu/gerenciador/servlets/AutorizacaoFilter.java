package br.com.tadeu.gerenciador.servlets;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.tadeu.gerenciador.models.Usuario;

@WebFilter("/empresa")
public class AutorizacaoFilter implements Filter {

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("AutorizacaoFilter");

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		String paramAcao = request.getParameter("acao");

		HttpSession session = request.getSession();

		boolean usuarioInvalido = (session.getAttribute("usuario") == null);
		boolean ehProtegida = !(paramAcao.equals("LoginUsuario") || paramAcao.equals("LoginUsuarioForm"));
		if (usuarioInvalido && ehProtegida) {
			response.sendRedirect("empresa?acao=LoginUsuarioForm");
			return;
		}

		chain.doFilter(request, response);

		Usuario usuario = (Usuario) session.getAttribute("usuario");
		System.out.printf("Usuario logado: -> %s\n", usuario.getLogin());

	}

}
