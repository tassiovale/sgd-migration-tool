package sgd_import_xml.entity;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.List;


/**
 * The persistent class for the origem_vaga database table.
 * 
 */
@Entity
@Table(name="origem_vaga")
public class OrigemVaga implements Serializable, BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_origem_vaga")
	private int idOrigemVaga;

	@Column(name="origem_vaga")
	private String origemVaga;

	//bi-directional many-to-one association to Docente
	@OneToMany(mappedBy="origemVaga")
	@Cascade({CascadeType.SAVE_UPDATE})
	private List<Docente> docentes;

	public OrigemVaga() {
	}

	public int getIdOrigemVaga() {
		return this.idOrigemVaga;
	}

	public void setIdOrigemVaga(int idOrigemVaga) {
		this.idOrigemVaga = idOrigemVaga;
	}

	public String getOrigemVaga() {
		return this.origemVaga;
	}

	public void setOrigemVaga(String origemVaga) {
		this.origemVaga = origemVaga;
	}

	public List<Docente> getDocentes() {
		return this.docentes;
	}

	public void setDocentes(List<Docente> docentes) {
		this.docentes = docentes;
	}

	public Docente addDocente(Docente docente) {
		getDocentes().add(docente);
		docente.setOrigemVaga(this);

		return docente;
	}

	public Docente removeDocente(Docente docente) {
		getDocentes().remove(docente);
		docente.setOrigemVaga(null);

		return docente;
	}
	
	@Override
	public String toString() {
		return this.origemVaga;
	}

	public Long getId() {
		return (long) idOrigemVaga;
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