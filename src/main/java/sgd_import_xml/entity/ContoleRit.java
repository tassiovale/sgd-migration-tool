package sgd_import_xml.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the contole_rit database table.
 * 
 */
@Entity
@Table(name="contole_rit")
public class ContoleRit implements Serializable, BaseEntity {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_contole_rit")
	private int idContoleRit;

	@Temporal(TemporalType.DATE)
	@Column(name="data_entrega")
	private Date dataEntrega;

	//bi-directional many-to-one association to Docente
	@ManyToOne
	@JoinColumn(name="siape")
	private Docente docente;

	public ContoleRit() {
	}

	public int getIdContoleRit() {
		return this.idContoleRit;
	}

	public void setIdContoleRit(int idContoleRit) {
		this.idContoleRit = idContoleRit;
	}

	public Date getDataEntrega() {
		return this.dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public Docente getDocente() {
		return this.docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public Long getId() {
		return (long) idContoleRit;
	}

}