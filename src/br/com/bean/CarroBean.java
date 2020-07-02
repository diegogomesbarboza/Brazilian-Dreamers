package br.com.bean;

import java.io.Serializable;

public class CarroBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer idCarro;

	private String modelo;
	
	private String fabricante;
	
	private String ano;
	
	private String potencia;
	
	private String peso;
	
	private String uppgrade_interno;
	
	private String estetica_externo;
	
	private String imagem;

	public CarroBean() {

	}

	public CarroBean(Integer idCarro, String modelo, String fabricante, String ano, String potencia, String peso,
			String uppgrade_interno, String estetica_externo, String imagem) {
		super();
		this.idCarro = idCarro;
		this.modelo = modelo;
		this.fabricante = fabricante;
		this.ano = ano;
		this.potencia = potencia;
		this.peso = peso;
		this.uppgrade_interno = uppgrade_interno;
		this.estetica_externo = estetica_externo;
		this.imagem = imagem;
	}



	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getPotencia() {
		return potencia;
	}

	public void setPotencia(String potencia) {
		this.potencia = potencia;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getUppgrade_interno() {
		return uppgrade_interno;
	}

	public void setUppgrade_interno(String uppgrade_interno) {
		this.uppgrade_interno = uppgrade_interno;
	}

	public String getEstetica_externo() {
		return estetica_externo;
	}

	public void setEstetica_externo(String estetica_externo) {
		this.estetica_externo = estetica_externo;
	}

	public Integer getIdCarro() {
		return idCarro;
	}

	public void setIdCarro(Integer idCarro) {
		this.idCarro = idCarro;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCarro == null) ? 0 : idCarro.hashCode());
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
		CarroBean other = (CarroBean) obj;
		if (idCarro == null) {
			if (other.idCarro != null)
				return false;
		} else if (!idCarro.equals(other.idCarro))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CarroBean [idCarro=" + idCarro + ", modelo=" + modelo + ", fabricante=" + fabricante + ", ano=" + ano
				+ ", potencia=" + potencia + ", peso=" + peso + ", uppgrade_interno=" + uppgrade_interno
				+ ", estetica_externo=" + estetica_externo + ", imagem=" + imagem + "]";
	}

}
