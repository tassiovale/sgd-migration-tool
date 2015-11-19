package sgd_import_xml.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the contole_rad database table.
 * 
 */
@Entity
@Table(name="contole_rad")
public class ContoleRad implements Serializable, BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_controle_rad")
	private int idControleRad;

	@Temporal(TemporalType.DATE)
	@Column(name="data_entrega")
	private Date dataEntrega;

	@Temporal(TemporalType.DATE)
	@Column(name="data_envio")
	private Date dataEnvio;

	@Temporal(TemporalType.DATE)
	@Column(name="data_envio_coordenador")
	private Date dataEnvioCoordenador;

	//bi-directional many-to-one association to Docente
	@ManyToOne
	@JoinColumn(name="siape")
	private Docente docente;

	public ContoleRad() {
	}

	public int getIdControleRad() {
		return this.idControleRad;
	}

	public void setIdControleRad(int idControleRad) {
		this.idControleRad = idControleRad;
	}

	public Date getDataEntrega() {
		return this.dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public Date getDataEnvio() {
		return this.dataEnvio;
	}

	public void setDataEnvio(Date dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

	public Date getDataEnvioCoordenador() {
		return this.dataEnvioCoordenador;
	}

	public void setDataEnvioCoordenador(Date dataEnvioCoordenador) {
		this.dataEnvioCoordenador = dataEnvioCoordenador;
	}

	public Docente getDocente() {
		return this.docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public Long getId() {
		return (long) idControleRad;
	}

}