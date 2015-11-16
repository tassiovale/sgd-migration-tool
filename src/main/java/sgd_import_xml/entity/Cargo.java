package sgd_import_xml.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaUpdate;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.List;


/**
 * The persistent class for the cargo database table.
 * 
 */
@Entity
public class Cargo implements Serializable, BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_cargo")
	private int idCargo;

	@Column(name="nome_cargo")
	private String nomeCargo;
	
	@Column(name="vinculo")
	private int vinculo;
	
	@Column(name="area_conhecimento")
	@JoinColumn(name="id_area")
	private AreaConhecimento area;
	
	@Column(name="curso_graduacao")
	@JoinColumn(name="id_cursoGrad")
	private Centro centro;
	
	@Column(name="id_centro")
	@JoinColumn(name="id_cursoGrad")
	private CursoGraduacao cursoGraduacao;

	//bi-directional many-to-one association to CargoDocente
	@OneToMany(mappedBy="cargo")
	@Cascade({CascadeType.SAVE_UPDATE})
	private List<CargoDocente> cargoDocentes;

	public Cargo() {
	}

	public int getIdCargo() {
		return this.idCargo;
	}

	public void setIdCargo(int idCargo) {
		this.idCargo = idCargo;
	}

	public String getNomeCargo() {
		return this.nomeCargo;
	}

	public void setNomeCargo(String nomeCargo) {
		this.nomeCargo = nomeCargo;
	}

	public List<CargoDocente> getCargoDocentes() {
		return this.cargoDocentes;
	}

	public void setCargoDocentes(List<CargoDocente> cargoDocentes) {
		this.cargoDocentes = cargoDocentes;
	}

	/*public CargoDocente addCargoDocente(CargoDocente cargoDocente) {
		getCargoDocentes().add(cargoDocente);
		cargoDocente.setCargo(this);
		return cargoDocente;
	}

	public CargoDocente removeCargoDocente(CargoDocente cargoDocente) {
		getCargoDocentes().remove(cargoDocente);
		cargoDocente.setCargo(null);
		return cargoDocente;
	}*/

	@Override
	public Long getId() {
		return (long) idCargo;
	}
	
	@Override
	public String toString() {
		return this.nomeCargo;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	public int getVinculo() {
		return vinculo;
	}

	public void setVinculo(int vinculo) {
		this.vinculo = vinculo;
	}

	public AreaConhecimento getArea() {
		return area;
	}

	public void setArea(AreaConhecimento area) {
		this.area = area;
	}

	public Centro getCentro() {
		return centro;
	}

	public void setCentro(Centro centro) {
		this.centro = centro;
	}

	public CursoGraduacao getCursoGraduacao() {
		return cursoGraduacao;
	}

	public void setCursoGraduacao(CursoGraduacao cursoGraduacao) {
		this.cursoGraduacao = cursoGraduacao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}