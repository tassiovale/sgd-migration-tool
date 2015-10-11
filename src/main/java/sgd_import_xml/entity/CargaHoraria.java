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
 * The persistent class for the carga_horaria database table.
 * 
 */
@Entity
@Table(name="carga_horaria")
@XStreamAlias("Carga_x0020_Horaria")
public class CargaHoraria implements Serializable, BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_carga_horaria")
	@XStreamAlias("nCargaHoraria")
	@XStreamAsAttribute
	private int idCargaHoraria;

	@Column(name="carga_horaria")
	@XStreamAlias("sDescricaoCarga")
	@XStreamAsAttribute
	private String cargaHoraria;

	//bi-directional many-to-one association to Docente
	@OneToMany(mappedBy="cargaHoraria")
	@Cascade({CascadeType.SAVE_UPDATE})
	@XStreamImplicit // defina lista implicita  
	private List<Docente> docentes;

	public CargaHoraria() {
	}

	public int getIdCargaHoraria() {
		return this.idCargaHoraria;
	}

	public void setIdCargaHoraria(int idCargaHoraria) {
		this.idCargaHoraria = idCargaHoraria;
	}

	public String getCargaHoraria() {
		return this.cargaHoraria;
	}

	public void setCargaHoraria(String cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public List<Docente> getDocentes() {
		return this.docentes;
	}

	public void setDocentes(List<Docente> docentes) {
		this.docentes = docentes;
	}

	public Docente addDocente(Docente docente) {
		getDocentes().add(docente);
		docente.setCargaHoraria(this);
		return docente;
	}

	public Docente removeDocente(Docente docente) {
		getDocentes().remove(docente);
		docente.setCargaHoraria(null);
		return docente;
	}
	
	@Override
	public String toString() {
		
		return String.valueOf(this.cargaHoraria) + "h";
	}

	public Long getId() {
		return (long) idCargaHoraria;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return obj.toString().equals(this.toString());
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
	

}