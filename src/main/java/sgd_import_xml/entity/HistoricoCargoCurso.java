package sgd_import_xml.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Historico_x0020_Cargo_x0020_Curso")
public class HistoricoCargoCurso {

	private int CodigoCurso;
	private int Sequencia;
	private int nCodigoDocente;
	private int nCodigoCargo;
	private String Data_x0020_Inicio;
	
	
	public int getCodigoCurso() {
		return CodigoCurso;
	}
	public void setCodigoCurso(int codigoCurso) {
		CodigoCurso = codigoCurso;
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
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return format.parse(Data_x0020_Inicio.split("T")[0]);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	public void setData_x0020_Inicio(Date data_x0020_Inicio) {
		Data_x0020_Inicio = data_x0020_Inicio.toString();
	}
}
