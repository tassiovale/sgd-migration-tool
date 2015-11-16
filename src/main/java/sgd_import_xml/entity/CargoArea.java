package sgd_import_xml.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Cargo_x0020_Area")
public class CargoArea {
	
	private int nCodigoCargo;
	private String DescricaoCargo;
	private int lTitular;
	
	public int getnCodigoCargo() {
		return nCodigoCargo;
	}
	public void setnCodigoCargo(int nCodigoCargo) {
		this.nCodigoCargo = nCodigoCargo;
	}
	public String getDescricaoCargo() {
		return DescricaoCargo;
	}
	public void setDescricaoCargo(String descricaoCargo) {
		DescricaoCargo = descricaoCargo;
	}
	public int getlTitular() {
		return lTitular;
	}
	public void setlTitular(int lTitular) {
		this.lTitular = lTitular;
	}

}
