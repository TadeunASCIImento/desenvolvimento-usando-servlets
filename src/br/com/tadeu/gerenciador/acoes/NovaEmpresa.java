package br.com.tadeu.gerenciador.acoes;

import java.io.IOException;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tadeu.gerenciador.models.Banco;
import br.com.tadeu.gerenciador.models.Empresa;

public class NovaEmpresa {

	public void executa(String paramData, String paramNome, String paramId, HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		Date dataAbertura = null;
		try {
			SimpleDateFormat sdfc = new SimpleDateFormat("yyyy-MM-dd");
			dataAbertura = sdfc.parse(paramData);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Empresa empresa = new Empresa();
		empresa.setNome(paramNome);
		empresa.setId(new BigInteger(paramId));
		empresa.setDataAbertura(dataAbertura);
		new Banco().adiciona(empresa);

		response.sendRedirect("controller?acao=list");

	}

}
