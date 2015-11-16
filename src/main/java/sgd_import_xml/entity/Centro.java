package sgd_import_xml.entity;

import java.io.Serializable;

import javax.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import java.util.List;


@Entity
@Table(name="centro")

public class Centro implements Serializable, BaseEntity {
	public String getSiglaCentro() {
		return siglaCentro;
	}

	public void setSiglaCentro(String siglaCentro) {
		this.siglaCentro = siglaCentro;
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_centro")
	private int idCentro;

	@Column(name="nome_centro")
	private String nomeCentro;
	
	@Column(name="sigla_centro")
	private String siglaCentro;
	//bi-directional many-to-one association to Docente
	@OneToMany(mappedBy="area")//,orphanRemoval = true)
	@Cascade({CascadeType.SAVE_UPDATE})  
	private List<Docente> docentes;

	public Centro() {}

	public int getIdCentro() {
		return this.idCentro;
	}

	public void setIdCentro(int idCentro) {
		this.idCentro = idCentro;
	}

	public String getNomeCentro() {
		return this.nomeCentro;
	}

	public void setNomeCentro(String nomeCentro) {
		this.nomeCentro = nomeCentro;
	}

	public List<Docente> getDocentes() {
		return this.docentes;
	}

	public void setDocentes(List<Docente> docentes) {
		this.docentes = docentes;
	}

	public Docente addDocente(Docente docente) {
		getDocentes().add(docente);
		docente.setCentro(this);

		return docente;
	}

	public Docente removeDocente(Docente docente) {
		getDocentes().remove(docente);
		docente.setArea(null);
		return docente;
	}

	@Override
	public String toString() {
		return this.nomeCentro;
	}

	@Override
	public Long getId() {
		return (long) idCentro;
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
