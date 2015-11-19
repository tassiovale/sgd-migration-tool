package sgd_import_xml.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the docente_disciplina database table.
 * 
 */
@Entity
@Table(name="docente_disciplina")
public class DocenteDisciplina implements Serializable, BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_docente_disciplina")
	private int idDocenteDisciplina;

	@Column(name="id_disciplina")
	private int idDisciplina;

	//bi-directional one-to-one association to Disciplina
	@OneToOne
	@JoinColumn(name="id_docente_disciplina")
	private Disciplina disciplina;

	//bi-directional many-to-one association to Docente
	@ManyToOne
	@JoinColumn(name="siape")
	private Docente docente;

	public DocenteDisciplina() {
	}

	public int getIdDocenteDisciplina() {
		return this.idDocenteDisciplina;
	}

	public void setIdDocenteDisciplina(int idDocenteDisciplina) {
		this.idDocenteDisciplina = idDocenteDisciplina;
	}

	public int getIdDisciplina() {
		return this.idDisciplina;
	}

	public void setIdDisciplina(int idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	public Disciplina getDisciplina() {
		return this.disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Docente getDocente() {
		return this.docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public Long getId() {
		return (long) idDocenteDisciplina;
	}

}