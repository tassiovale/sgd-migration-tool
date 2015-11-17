package sgd_import_xml.entity;

import java.util.Date;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Historico_x0020_Cargo_x0020_Curso")
public class HistoricoCargoCurso {

	private int nCodigoCurso;
	private int Sequencia;
	private int nCodigoDocente;
	private int nCodigoCargo;
	private Date Data_x0020_Inicio;
	private Date Data_x0020_Fim;
	
	
	public int getNCodigoCurso() {
		return nCodigoCurso;
	}
	public void setNCodigoCurso(int nCodigoCurso) {
		this.nCodigoCurso = nCodigoCurso;
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
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//		try {
//			return format.parse(Data_x0020_Inicio.split("T")[0]);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		return this.Data_x0020_Inicio;
	}
	public Date getData_x0020_Fim() {
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//		try {
//			return format.parse(Data_x0020_Fim.split("T")[0]);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		return this.Data_x0020_Fim;
	}
	
	
	public int getnCodigoCurso() {
		return nCodigoCurso;
	}
	public void setnCodigoCurso(int nCodigoCurso) {
		this.nCodigoCurso = nCodigoCurso;
	}
	public void setData_x0020_Fim(Date data_x0020_Fim) {
		Data_x0020_Fim = data_x0020_Fim;
	}
	public void setData_x0020_Inicio(Date data_x0020_Inicio) {
		this.Data_x0020_Inicio = data_x0020_Inicio;
	}
}
