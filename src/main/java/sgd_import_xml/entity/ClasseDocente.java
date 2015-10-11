package sgd_import_xml.entity;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;


/**
 * The persistent class for the classe_docente database table.
 * 
 */
@Entity
@Table(name="classe_docente")
@XStreamAlias("Classe_x0020_Docente")
public class ClasseDocente implements Serializable, BaseEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_classe_docente")
	@XStreamAlias("nCodigoClasse")
	@XStreamAsAttribute
	private int idClasseDocente;

	@Column(name="classe_docente")
	@XStreamAlias("DescricaoClasse")
	@XStreamAsAttribute
	private String classeDocente;

	//bi-directional many-to-one association to Docente
	@OneToMany(mappedBy="classeDocente")
	@Cascade({CascadeType.SAVE_UPDATE})
	@XStreamImplicit // defina lista implicita
	private List<Docente> docentes;

	public ClasseDocente() {
	}

	public int getIdClasseDocente() {
		return this.idClasseDocente;
	}

	public void setIdClasseDocente(int idClasseDocente) {
		this.idClasseDocente = idClasseDocente;
	}

	public String getClasseDocente() {
		return this.classeDocente;
	}

	public void setClasseDocente(String classeDocente) {
		this.classeDocente = classeDocente;
	}

	public List<Docente> getDocentes() {
		return this.docentes;
	}

	public void setDocentes(List<Docente> docentes) {
		this.docentes = docentes;
	}

	public Docente addDocente(Docente docente) {
		getDocentes().add(docente);
		docente.setClasseDocente(this);

		return docente;
	}

	public Docente removeDocente(Docente docente) {
		getDocentes().remove(docente);
		docente.setClasseDocente(null);

		return docente;
	}
	
	@Override
	public String toString() {
		return this.classeDocente;
	}

	public Long getId() {
		return (long) idClasseDocente;
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