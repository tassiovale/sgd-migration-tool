package sgd_import_xml.entity; 

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the disciplina database table. 
 *
 */
@Entity
public class Disciplina implements Serializable, BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_disciplina")
	private int idDisciplina;

	@Column(name="local_disciplina")
	private String localDisciplina;

	@Column(name="nome_disciplina")
	private int nomeDisciplina;

	//bi-directional one-to-one association to DocenteDisciplina
	@OneToOne(mappedBy="disciplina")
	private DocenteDisciplina docenteDisciplina;

	/**
	 ADICIONAR CAMPOS DE CODIGO DE CARGA HORARIA
	 */

	public Disciplina() {
	}

	public int getIdDisciplina() {
		return this.idDisciplina;
	}

	public void setIdDisciplina(int idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	public String getLocalDisciplina() {
		return this.localDisciplina;
	}

	public void setLocalDisciplina(String localDisciplina) {
		this.localDisciplina = localDisciplina;
	}

	public int getNomeDisciplina() {
		return this.nomeDisciplina;
	}

	public void setNomeDisciplina(int nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	public DocenteDisciplina getDocenteDisciplina() {
		return this.docenteDisciplina;
	}

	public void setDocenteDisciplina(DocenteDisciplina docenteDisciplina) {
		this.docenteDisciplina = docenteDisciplina;
	}

	public Long getId() {
		return (long) idDisciplina;
	}

}
