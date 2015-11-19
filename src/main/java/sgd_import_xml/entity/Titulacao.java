package sgd_import_xml.entity;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

import java.util.List;


/**
 * The persistent class for the titulacao database table.
 * 
 */
@Entity
@XStreamAlias("Classe_x0020_Docente")
public class Titulacao implements Serializable, BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_titulacao")
	@XStreamAlias("nCodigoTitulacao")
	@XStreamAsAttribute
	private int idTitulacao;

	@XStreamAlias("DescricaoTitulacao")
	@XStreamAsAttribute
	private String titulacao;

	//bi-directional many-to-one association to Docente
	@OneToMany(mappedBy="titulacao")
	@Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
	private List<Docente> docentes;

	public Titulacao() {
	}

	public int getIdTitulacao() {
		return this.idTitulacao;
	}

	public void setIdTitulacao(int idTitulacao) {
		this.idTitulacao = idTitulacao;
	}

	public String getTitulacao() {
		return this.titulacao;
	}

	public void setTitulacao(String titulacao) {
		this.titulacao = titulacao;
	}

	public List<Docente> getDocentes() {
		return this.docentes;
	}

	public void setDocentes(List<Docente> docentes) {
		this.docentes = docentes;
	}

	public Docente addDocente(Docente docente) {
		getDocentes().add(docente);
		docente.setTitulacao(this);

		return docente;
	}

	public Docente removeDocente(Docente docente) {
		getDocentes().remove(docente);
		docente.setTitulacao(null);

		return docente;
	}
	
	@Override
	public String toString() {
		return this.titulacao;
	}

	public Long getId() {
		return (long) idTitulacao;
	}

	@Override
	public boolean equals(Object obj) {
		return obj.toString().equals(this.toString());
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

}