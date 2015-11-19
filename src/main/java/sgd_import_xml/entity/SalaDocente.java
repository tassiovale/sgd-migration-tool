package sgd_import_xml.entity;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.List;


/**
 * The persistent class for the sala database table.
 * 
 */
@Entity
@Table(name="sala_docente")
public class SalaDocente implements Serializable, BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_sala")
	private int idSala;

	private String local;

	private String sala;

	//bi-directional one-to-many association to Docente
	@OneToMany(mappedBy="salaDocente")
	@Cascade({CascadeType.SAVE_UPDATE})
	private List<Docente> docentes;

	public SalaDocente() {
	}

	public int getIdSala() {
		return this.idSala;
	}

	public void setIdSala(int idSala) {
		this.idSala = idSala;
	}

	public String getLocal() {
		return this.local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getSala() {
		return this.sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public List<Docente> getDocentes() {
		return this.docentes;
	}

	public void setDocentes(List<Docente> docentes) {
		this.docentes = docentes;
	}

	@Override
	public String toString() {
		return this.sala + " - " + this.local;
	}

	public Long getId() {
		return (long) idSala;
	}

	@PreRemove
	private void preRemove(){
		for (Docente docente : docentes) {
			docente.setSalaDocente(null);
		}
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