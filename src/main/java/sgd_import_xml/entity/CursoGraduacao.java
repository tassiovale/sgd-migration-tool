package sgd_import_xml.entity; 

import java.io.Serializable;
import javax.persistence.*;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

import java.util.List;

/**
 * The persistent class for the curso graduacao database table.
 * 
 */
@Entity
@Table(name = "curso_graduacao")
@XStreamAlias("Curso")
public class CursoGraduacao implements Serializable, BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_cursoGrad")
	@XStreamAlias("nCodigoCurso")
	@XStreamAsAttribute
	private int idCursoGrad;

	
	@XStreamAlias("sDescricaoCurso")
	@XStreamAsAttribute
	private String curso;

	// bi-directional one-to-many association to Docente
	@OneToMany(mappedBy = "cursoGraduacao")
	private List<Docente> docentes;

	public CursoGraduacao() {
	}

	public int getIdCursoGrad() {
		return this.idCursoGrad;
	}

	public void setIdCursoGrad(int idCursoGrad) {
		this.idCursoGrad = idCursoGrad;
	}

	public String getCursoGrad() {
		return this.curso;
	}

	public void setCursoGrad(String curso) {
		this.curso = curso;
	}

	public List<Docente> getDocentes() {
		return this.docentes;
	}

	public void setDocentes(List<Docente> docentes) {
		this.docentes = docentes;
	}

	@Override
	public String toString() {
		return this.curso;
	}

	public Long getId() {
		return (long) idCursoGrad;
	}

}
