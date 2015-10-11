package sgd_import_xml.entity;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

import java.util.List;


/**
 * The persistent class for the nivel_classe database table.
 * 
 */
@Entity
@Table(name="nivel_classe")
@XStreamAlias("Nivel_x0020_da_x0020_Classe")
public class NivelClasse implements Serializable, BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_nivel_classe")
	@XStreamAlias("nCodigoNivel")
	@XStreamAsAttribute
	private int idNivelClasse;

	@Column(name="nivel_classe")
	@XStreamAlias("Descricao_x0020_Nivel")
	@XStreamAsAttribute
	private String nivelClasse;

	//bi-directional many-to-one association to Docente
	@OneToMany(mappedBy="nivelClasse")
	@Cascade({CascadeType.SAVE_UPDATE})
	private List<Docente> docentes;

	public NivelClasse() {
	}

	public int getIdNivelClasse() {
		return this.idNivelClasse;
	}

	public void setIdNivelClasse(int idNivelClasse) {
		this.idNivelClasse = idNivelClasse;
	}

	public String getNivelClasse() {
		return this.nivelClasse;
	}

	public void setNivelClasse(String nivelClasse) {
		this.nivelClasse = nivelClasse;
	}

	public List<Docente> getDocentes() {
		return this.docentes;
	}

	public void setDocentes(List<Docente> docentes) {
		this.docentes = docentes;
	}

	public Docente addDocente(Docente docente) {
		getDocentes().add(docente);
		docente.setNivelClasse(this);

		return docente;
	}

	public Docente removeDocente(Docente docente) {
		getDocentes().remove(docente);
		docente.setNivelClasse(null);

		return docente;
	}
	
	@Override
	public String toString() {
		return this.nivelClasse;
	}

	public Long getId() {
		return (long) idNivelClasse;
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