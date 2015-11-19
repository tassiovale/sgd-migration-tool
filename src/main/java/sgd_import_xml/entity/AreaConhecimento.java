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
 * The persistent class for the area database table.
 * 
 */
@Entity
@Table(name="area_conhecimento")
@XStreamAlias("Area")
public class AreaConhecimento implements Serializable, BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_area")
	@XStreamAlias("nCodigoArea")
	@XStreamAsAttribute
	private int idArea;

	@Column(name="nome_area")
	@XStreamAlias("sDescricaoArea")
	@XStreamAsAttribute
	private String nomeArea;

	//bi-directional many-to-one association to Docente
	@OneToMany(mappedBy="area")//,orphanRemoval = true)
	@Cascade({CascadeType.SAVE_UPDATE})
	@XStreamImplicit // defina lista implicita
//	@XStreamOmitField // diz que n faz parte do XML      
	private List<Docente> docentes;

	public AreaConhecimento() {
	}

	public int getIdArea() {
		return this.idArea;
	}

	public void setIdArea(int idArea) {
		this.idArea = idArea;
	}

	public String getNomeArea() {
		return this.nomeArea;
	}

	public void setNomeArea(String nomeArea) {
		this.nomeArea = nomeArea;
	}

	public List<Docente> getDocentes() {
		return this.docentes;
	}

	public void setDocentes(List<Docente> docentes) {
		this.docentes = docentes;
	}

	public Docente addDocente(Docente docente) {
		getDocentes().add(docente);
		docente.setArea(this);

		return docente;
	}

	public Docente removeDocente(Docente docente) {
		getDocentes().remove(docente);
		docente.setArea(null);
		return docente;
	}

	@Override
	public String toString() {
		return this.nomeArea;
	}

	public Long getId() {
		return (long) idArea;
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