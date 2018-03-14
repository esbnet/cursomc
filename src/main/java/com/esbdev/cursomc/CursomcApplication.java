package com.esbdev.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.esbdev.cursomc.domain.Categoria;
import com.esbdev.cursomc.domain.Cidade;
import com.esbdev.cursomc.domain.Cliente;
import com.esbdev.cursomc.domain.Endereco;
import com.esbdev.cursomc.domain.Estado;
import com.esbdev.cursomc.domain.Produto;
import com.esbdev.cursomc.domain.enums.TipoCliente;
import com.esbdev.cursomc.repositories.CategoriaRepository;
import com.esbdev.cursomc.repositories.CidadeRepository;
import com.esbdev.cursomc.repositories.ClienteRepository;
import com.esbdev.cursomc.repositories.EnderecoRepository;
import com.esbdev.cursomc.repositories.EstadoRepository;
import com.esbdev.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;
		
	@Autowired
	private ClienteRepository clienteRepository;
		
	@Autowired
	private EnderecoRepository enderecoRepository;
		
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {

		//Populando Produtos e Categorias
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);

		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat1.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.save(Arrays.asList(cat1, cat2));
		produtoRepository.save(Arrays.asList(p1, p2, p3));

		//Populando cidades e estados
		Estado est1 = new Estado(null,"Minas Gerais");
		Estado est2= new Estado(null,"São Paulo");
		
		Cidade c3 = new Cidade(null,"Uberlândia", est1);
		Cidade c1 = new Cidade(null,"Campinas", est2);
		Cidade c2 = new Cidade(null,"São Paulo", est2);
				
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		estadoRepository.save(Arrays.asList(est1,est2));
		cidadeRepository.save(Arrays.asList(c1,c2,c3));
		
		//Cliente, endereço, telefone
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "50930877500", TipoCliente.PESSOA_FISICA);
		cli1.getTelefones().addAll(Arrays.asList("33931676","88630845"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Ap. 303", "Jadim","50930877500" ,cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro","50930877500" ,cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.save(Arrays.asList(cli1));
		enderecoRepository.save(Arrays.asList(e1,e2));
		
		
		
		
		
	}
}
