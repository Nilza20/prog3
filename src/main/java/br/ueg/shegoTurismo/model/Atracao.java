package br.ueg.shegoTurismo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class Atracao {
	
	@Id
	private String id;	
	private String nome;
	private String descricao;
	private String bairro;
	private String cidade;
	private String categorias;
	
	
	public Atracao() {
		super();
	}


	public Atracao(String id, String nome, String descricao, String bairro, String cidade, String categorias) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.bairro = bairro;
		this.cidade = cidade;
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
                ", descricao='" + descricao + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", categorias='" + categorias + '\'' +
                '}';
    }
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Atracao)) return false;
        Atracao atracao = (Atracao) o;
        return Objects.equals(id, atracao.id) &&
                Objects.equals(nome, atracao.nome) &&
                Objects.equals(descricao, atracao.descricao) &&
                Objects.equals(bairro, atracao.bairro) &&
                Objects.equals(cidade, atracao.cidade) &&
                Objects.equals(categorias, atracao.categorias);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, descricao, bairro, cidade, categorias);
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


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descrcao) {
		this.descricao = descrcao;
	}


	public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public String getCategorias() {
		return categorias;
	}


	public void setCategorias(String categorias) {
		this.categorias = categorias;
	}
	
	
	
	
}
