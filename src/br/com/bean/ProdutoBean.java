package br.com.bean;

import java.io.Serializable;

public class ProdutoBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id_produto;
	private String nome_produto;
	private float valor_produto;
	private String imagem_produto;
	
	public ProdutoBean() {
		
	}

	public ProdutoBean(Integer id_produto, String nome_produto, float valor_produto, String imagem_produto) {
		super();
		this.id_produto = id_produto;
		this.nome_produto = nome_produto;
		this.valor_produto = valor_produto;
		this.imagem_produto = imagem_produto;
	}

	public Integer getId_produto() {
		return id_produto;
	}

	public void setId_produto(Integer id_produto) {
		this.id_produto = id_produto;
	}

	public String getNome_produto() {
		return nome_produto;
	}

	public void setNome_produto(String nome_produto) {
		this.nome_produto = nome_produto;
	}

	public float getValor_produto() {
		return valor_produto;
	}

	public void setValor_produto(float valor_produto) {
		this.valor_produto = valor_produto;
	}

	public String getImagem_produto() {
		return imagem_produto;
	}

	public void setImagem_produto(String imagem_produto) {
		this.imagem_produto = imagem_produto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_produto == null) ? 0 : id_produto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdutoBean other = (ProdutoBean) obj;
		if (id_produto == null) {
			if (other.id_produto != null)
				return false;
		} else if (!id_produto.equals(other.id_produto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProdutoBean [id_produto=" + id_produto + ", nome_produto=" + nome_produto + ", valor_produto="
				+ valor_produto + ", imagem_produto=" + imagem_produto + "]";
	}

}
