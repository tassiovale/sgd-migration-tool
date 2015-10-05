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
 * The persistent class for the cargo database table.
 * 
 */
@Entity
@XStreamAlias("Cargo_x0020_Area")
public class Cargo implements Serializable, BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_cargo")
	@XStreamAlias("nCodigoCargo")
	@XStreamAsAttribute
	private int idCargo;

	@Column(name="nome_cargo")
	@XStreamAlias("DescricaoCargo")
	@XStreamAsAttribute
	private String nomeCargo;

	//bi-directional many-to-one association to CargoDocente
	@OneToMany(mappedBy="cargo")
	@Cascade({CascadeType.SAVE_UPDATE})
	@XStreamImplicit // defina lista implicita  
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
	
	
}