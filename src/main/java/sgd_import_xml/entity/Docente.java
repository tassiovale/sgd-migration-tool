package sgd_import_xml.entity;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;


import java.util.Date;
import java.util.List;


/**
 * The persistent class for the docente database table.
 * 
 */
@Entity
@XStreamAlias("Docente")
public class Docente implements Serializable, BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@XStreamAlias("nMatriculaSiape")
	@XStreamAsAttribute
	private int siape;
	
	@XStreamAlias("nCodigoDocente")
	@XStreamAsAttribute
	private int IdXml;

	@Temporal(TemporalType.DATE)
	@Column(name="data_ingresso")
	@XStreamAlias("dDataIngressoCETEC")
	@XStreamAsAttribute
	private Date dataIngresso;

	@Column(unique=true)
	@XStreamAlias("sEmail")
	@XStreamAsAttribute
	private String email;

	private String nome;

	@Column(name="telefone_1")
	private String telefone1;

	@Column(name="telefone_2")
	private String telefone2;

	//bi-directional many-to-one association to CargoDocente
	@OneToMany(mappedBy="docente")
	//@OneToMany(mappedBy="docente", cascade = {CascadeType.REFRESH})
	private List<HistoricoCargo> cargoDocentes;

	//bi-directional many-to-one association to ContolePit
	@OneToMany(mappedBy="docente")
	private List<ContolePit> contolePits;

	//bi-directional many-to-one association to ContoleRad
	@OneToMany(mappedBy="docente")
	private List<ContoleRad> contoleRads;

	//bi-directional many-to-one association to ContoleRit
	@OneToMany(mappedBy="docente")
	private List<ContoleRit> contoleRits;

	//bi-directional many-to-one association to Area
	@ManyToOne
	@JoinColumn(name="id_area")
	private AreaConhecimento area;

	//bi-directional many-to-one association to CargaHoraria
	@ManyToOne
	@JoinColumn(name="id_carga_horaria")
	private CargaHoraria cargaHoraria;

	//bi-directional many-to-one association to ClasseDocente
	@ManyToOne
	@JoinColumn(name="id_classe_docente")
	private ClasseDocente classeDocente;

	//bi-directional many-to-one association to NivelClasse
	@ManyToOne
	@JoinColumn(name="id_nivel_classe")
	private NivelClasse nivelClasse;

	//bi-directional many-to-one association to OrigemVaga
	@ManyToOne
	@JoinColumn(name="id_origem_vaga")
	private OrigemVaga origemVaga;

	//bi-directional many-to-one association to Titulacao
	@ManyToOne
	@JoinColumn(name="id_titulacao")
	private Titulacao titulacao;

	//bi-directional one-to-many association to DocenteDisciplina
	@OneToMany(mappedBy="docente")
	@Cascade({CascadeType.SAVE_UPDATE})
	private List<DocenteDisciplina> docenteDisciplinas;

	//bi-directional many-to-one association to Sala
	@ManyToOne
	@JoinColumn(name="id_sala")
	private SalaDocente salaDocente;
	
	@ManyToOne
	@JoinColumn(name="id_centro")
	private Centro centro;
	
	//bi-directional many-to-one association to CursoGraduacao
		@ManyToOne
		@JoinColumn(name="id_cursoGrad")
		private CursoGraduacao cursoGraduacao;

	public Docente() {
	}

	public int getSiape() {
		return this.siape;
	}

	public void setSiape(int siape) {
		this.siape = siape;
	}

	public Date getDataIngresso() {
		return this.dataIngresso;
	}

	public void setDataIngresso(Date dataIngresso) {
		this.dataIngresso = dataIngresso;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone1() {
		return this.telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return this.telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public List<HistoricoCargo> getCargoDocentes() {
		return this.cargoDocentes;
	}

	public void setCargoDocentes(List<HistoricoCargo> cargoDocentes) {
		this.cargoDocentes = cargoDocentes;
	}

	public HistoricoCargo addCargoDocente(HistoricoCargo cargoDocente) {
		getCargoDocentes().add(cargoDocente);
		cargoDocente.setDocente(this);

		return cargoDocente;
	}

	public HistoricoCargo removeCargoDocente(HistoricoCargo cargoDocente) {
		getCargoDocentes().remove(cargoDocente);
		cargoDocente.setDocente(null);

		return cargoDocente;
	}

	public List<ContolePit> getContolePits() {
		return this.contolePits;
	}

	public void setContolePits(List<ContolePit> contolePits) {
		this.contolePits = contolePits;
	}

	public ContolePit addContolePit(ContolePit contolePit) {
		getContolePits().add(contolePit);
		contolePit.setDocente(this);

		return contolePit;
	}

	public ContolePit removeContolePit(ContolePit contolePit) {
		getContolePits().remove(contolePit);
		contolePit.setDocente(null);

		return contolePit;
	}

	public List<ContoleRad> getContoleRads() {
		return this.contoleRads;
	}

	public void setContoleRads(List<ContoleRad> contoleRads) {
		this.contoleRads = contoleRads;
	}

	public ContoleRad addContoleRad(ContoleRad contoleRad) {
		getContoleRads().add(contoleRad);
		contoleRad.setDocente(this);

		return contoleRad;
	}

	public ContoleRad removeContoleRad(ContoleRad contoleRad) {
		getContoleRads().remove(contoleRad);
		contoleRad.setDocente(null);

		return contoleRad;
	}

	public List<ContoleRit> getContoleRits() {
		return this.contoleRits;
	}

	public void setContoleRits(List<ContoleRit> contoleRits) {
		this.contoleRits = contoleRits;
	}

	public ContoleRit addContoleRit(ContoleRit contoleRit) {
		getContoleRits().add(contoleRit);
		contoleRit.setDocente(this);

		return contoleRit;
	}

	public ContoleRit removeContoleRit(ContoleRit contoleRit) {
		getContoleRits().remove(contoleRit);
		contoleRit.setDocente(null);

		return contoleRit;
	}

	public AreaConhecimento getArea() {
		return this.area;
	}

	public void setArea(AreaConhecimento area) {
		this.area = area;
	}

	public CargaHoraria getCargaHoraria() {
		return this.cargaHoraria;
	}

	public void setCargaHoraria(CargaHoraria cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public ClasseDocente getClasseDocente() {
		return this.classeDocente;
	}

	public void setClasseDocente(ClasseDocente classeDocente) {
		this.classeDocente = classeDocente;
	}

	public NivelClasse getNivelClasse() {
		return this.nivelClasse;
	}

	public void setNivelClasse(NivelClasse nivelClasse) {
		this.nivelClasse = nivelClasse;
	}

	public OrigemVaga getOrigemVaga() {
		return this.origemVaga;
	}

	public void setOrigemVaga(OrigemVaga origemVaga) {
		this.origemVaga = origemVaga;
	}

	public Titulacao getTitulacao() {
		return this.titulacao;
	}

	public void setTitulacao(Titulacao titulacao) {
		this.titulacao = titulacao;
	}

	public List<DocenteDisciplina> getDocenteDisciplinas() {
		return this.docenteDisciplinas;
	}

	public void setDocenteDisciplinas(List<DocenteDisciplina> docenteDisciplinas) {
		this.docenteDisciplinas = docenteDisciplinas;
	}

	public DocenteDisciplina addDocenteDisciplina(DocenteDisciplina docenteDisciplina) {
		getDocenteDisciplinas().add(docenteDisciplina);
		docenteDisciplina.setDocente(this);

		return docenteDisciplina;
	}

	public DocenteDisciplina removeDocenteDisciplina(DocenteDisciplina docenteDisciplina) {
		getDocenteDisciplinas().remove(docenteDisciplina);
		docenteDisciplina.setDocente(null);

		return docenteDisciplina;
	}

	public SalaDocente getSalaDocente() {
		return this.salaDocente;
	}

	public void setSalaDocente(SalaDocente salaDocente) {
		this.salaDocente = salaDocente;
	}
	
	public CursoGraduacao getCursoGraduacao() {
		return this.cursoGraduacao;
	}

	public void setCursoGraduacao(CursoGraduacao cursoGraduacao) {
		this.cursoGraduacao = cursoGraduacao;
	}

	public Long getId() {
		return Long.valueOf(siape);
	}
	
	@Override
	public String toString() {
		return this.siape + " - " + this.nome;
	}

	public Centro getCentro() {
		return centro;
	}

	public void setCentro(Centro centro) {
		this.centro = centro;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getIdXml() {
		return IdXml;
	}

	public void setIdXml(int idXml) {
		IdXml = idXml;
	}

	
}