package sgd_import_xml.entity;

import java.util.Date;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Historico_x0020_Cargo")
public class HistoricoCargoAreaConhecimento {
	
	private int nCodigoArea;
	private int Sequencia;
	private int nCodigoDocente;
	private int nCodigoCargo;
	private Date Data_x0020_Inicio;
	private Date Data_x0020_Fim;
	
	public int getnCodigoArea() {
		return nCodigoArea;
	}
	public void setnCodigoArea(int nCodigoArea) {
		this.nCodigoArea = nCodigoArea;
	}
	public int getSequencia() {
		return Sequencia;
	}
	public void setSequencia(int sequencia) {
		Sequencia = sequencia;
	}
	public int getnCodigoDocente() {
		return nCodigoDocente;
	}
	public void setnCodigoDocente(int nCodigoDocente) {
		this.nCodigoDocente = nCodigoDocente;
	}
	public int getnCodigoCargo() {
		return nCodigoCargo;
	}
	public void setnCodigoCargo(int nCodigoCargo) {
		this.nCodigoCargo = nCodigoCargo;
	}
	public Date getData_x0020_Inicio() {
		return Data_x0020_Inicio;
	}
	public void setData_x0020_Inicio(Date data_x0020_Inicio) {
		Data_x0020_Inicio = data_x0020_Inicio;
	}
	public Date getData_x0020_Fim() {
		return Data_x0020_Fim;
	}
	public void setData_x0020_Fim(Date data_x0020_Fim) {
		Data_x0020_Fim = data_x0020_Fim;
	}

	
	

}
