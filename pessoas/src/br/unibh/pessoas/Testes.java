package br.unibh.pessoas;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.unibh.pessoas.entidades.PessoaFisica;
import br.unibh.pessoas.entidades.PessoaJuridica;
import br.unibh.pessoas.persistencia.PessoaFisicaDAO;
import br.unibh.pessoas.persistencia.PessoaJuridicaDAO;

public class Testes {

	@Test	
	public void testePessoaFisicaFindAll(){
		
		PessoaFisicaDAO dao = new PessoaFisicaDAO();
		List<PessoaFisica> l = dao.findAll();
		Assert.assertEquals(l.size(), 100);
		
	}
	
	@Test	
	public void testePessoaFisicaFind(){
		
		PessoaFisicaDAO dao = new PessoaFisicaDAO();
		PessoaFisica p = dao.find(6L);
		Assert.assertEquals(p.getNome(), "Yoshi K. Leach");
		
	}
	
	@Test	
	public void testePessoaFisicaInserirExcluir(){
		
		PessoaFisicaDAO dao = new PessoaFisicaDAO();
		
		// New
		PessoaFisica pf = new PessoaFisica(
				null, "Francis Costa", "Rua top",
				"212121", "121212", "francis@francis.com", new Date(), "M");
		
		// Insert
		dao.insert(pf);
		PessoaFisica pf2 = dao.find("Francis Costa");
		Assert.assertNotNull(pf2);
		
		// Delete
		dao.delete(pf2);
		PessoaFisica pf3 = dao.find("Lucas Costa");
		Assert.assertNull(pf3);
		
	}
	
	@Test	
	public void testePessoaFisicaAtualizar(){
		
		PessoaFisicaDAO dao = new PessoaFisicaDAO();
		
		// New
		PessoaFisica pf = new PessoaFisica(
				null, "Francis Costa", "Rua top",
				"212121", "121212", "francis@francis.com", new Date(), "M");
		
		// Insert
		dao.insert(pf);
		PessoaFisica pf2 = dao.find("Francis Costa");
		
		// Update
		pf2.setNome("Lucas Costa");
		pf2.setEmail("lucas@costa.com");
		dao.update(pf2);
		PessoaFisica pf3 = dao.find("Lucas Costa");
		Assert.assertEquals(pf3.getEmail(), "lucas@costa.com");
		Assert.assertNotNull(pf3);
		dao.delete(pf3);
		
	}
	
	
	// PESSOA JURIDICA
	
	@Test	
	public void testePessoaJuridicaFindAll(){
		
		PessoaJuridicaDAO dao = new PessoaJuridicaDAO();
		List<PessoaJuridica> l = dao.findAll();
		Assert.assertEquals(l.size(), 100);
		
	}
	
	@Test	
	public void testePessoaJuridicaFind(){
		
		PessoaJuridicaDAO dao = new PessoaJuridicaDAO();
		PessoaJuridica p = dao.find(6L);
		Assert.assertEquals(p.getNome(), "Eagan G. Roberts");
		
	}
	
	@Test	
	public void testePessoaJuridicaInserirExcluir(){
		
		PessoaJuridicaDAO dao = new PessoaJuridicaDAO();
		
		// New
		PessoaJuridica pf = new PessoaJuridica(
				null, "Francis Costa", "Rua top",
				"212121", "132112", new Date(), "www.franciscosta.com.br");
		
		// Insert
		dao.insert(pf);
		PessoaJuridica pf2 = dao.find("Francis Costa");
		Assert.assertNotNull(pf2);
		
		// Delete
		dao.delete(pf2);
		PessoaJuridica pf3 = dao.find("Francis Costa");
		Assert.assertNull(pf3);
		
	}
	
	@Test	
	public void testePessoaJuridicaAtualizar(){
		
		PessoaJuridicaDAO dao = new PessoaJuridicaDAO();
		
		// New
		PessoaJuridica pf = new PessoaJuridica(
				null, "Francis Costa", "Rua top",
				"212121", "321123", new Date(), "www.franciscosta.com.br");
		
		// Insert
		dao.insert(pf);
		PessoaJuridica pf2 = dao.find("Francis Costa");
		
		// Update
		pf2.setNome("Lucas Costa");
		pf2.setSite("www.lucas.com.br");
		dao.update(pf2);
		PessoaJuridica pf3 = dao.find("Lucas Costa");
		Assert.assertEquals(pf3.getSite(), "www.lucas.com.br");
		Assert.assertNotNull(pf3);
		dao.delete(pf3);
		
	}
	
}
