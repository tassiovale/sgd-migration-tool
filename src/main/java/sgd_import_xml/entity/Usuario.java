package sgd_import_xml.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="USUARIOS")
public class Usuario implements Serializable, BaseEntity{

	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer siape;
	private String email;
	private String nome;
	private String senha;
	private boolean ativo;
	
	@OneToMany
	@JoinColumn(name="USUARIO_ID")
	private List<PapelUsuario> papelUsuario = new ArrayList<PapelUsuario>();
	
	public Integer getSiape() {
		return siape;
	}

	public void setSiape(Integer siape) {
		this.siape = siape;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public List<PapelUsuario> getPapelUsuario() {
		return papelUsuario;
	}

	public void setPapelUsuario(List<PapelUsuario> usuarioPapel) {
		this.papelUsuario = usuarioPapel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getId() {
		return (long) siape;
	}	
	
}
