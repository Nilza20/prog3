package br.ueg.shegoTurismo.model;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Estabelecimento {
	
	@Id
	private String id;	
	private String nome;
	private String rua;
	private int  numero;
	private String cep;
	private String cidade;
	private String telefone;
	private String email;
	private String site;
	private String categorias;
	
	
	public Estabelecimento() {
		super();
	}


	public Estabelecimento(String id, String nome, String rua, int numero, String cep, String cidade, String telefone,
			String email, String site, String categorias) {

		this.id = id;
		this.nome = nome;
		this.rua = rua;
		this.numero = numero;
		this.cep = cep;
		this.cidade = cidade;
		this.telefone = telefone;
		this.email = email;
		this.site = site;
		this.categorias = categorias;
	}
	
	@Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
	
	@Override
    public String toString() {
        return "Atracao{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", rua='" + rua + '\'' +
                ", numero='" + numero + '\'' +
                ", cep='" + cep + '\'' +
                ", cidade='" + cidade + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", site='" + site + '\'' +
                ", categorias='" + categorias + '\'' +
                '}';
    }
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Atracao)) return false;
        Estabelecimento estabelecimento = (Estabelecimento) o;
        return Objects.equals(id, estabelecimento.id) &&
                Objects.equals(nome, estabelecimento.nome) &&
                Objects.equals(rua, estabelecimento.rua) &&
                Objects.equals(numero, estabelecimento.numero) &&
                Objects.equals(cep, estabelecimento.cep) &&
                Objects.equals(cidade, estabelecimento.cidade) &&
                Objects.equals(telefone, estabelecimento.telefone) &&
                Objects.equals(email, estabelecimento.email) &&
                Objects.equals(site, estabelecimento.site) &&
                Objects.equals(categorias, estabelecimento.categorias);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, rua, numero, cep, cidade, telefone, email, site, categorias);
    }


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getRua() {
		return rua;
	}


	public void setRua(String rua) {
		this.rua = rua;
	}


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public String getCep() {
		return cep;
	}


	public void setCep(String cep) {
		this.cep = cep;
	}


	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSite() {
		return site;
	}


	public void setSite(String site) {
		this.site = site;
	}


	public String getCategorias() {
		return categorias;
	}


	public void setCategorias(String categorias) {
		this.categorias = categorias;
	}
	
    

}
