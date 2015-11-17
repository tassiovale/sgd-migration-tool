package sgd_import_xml.XML;

import sgd_import_xml.DAO.CentroDAO;
import sgd_import_xml.entity.Centro;

public class Testes {
	public static void main(String[] args) {
		XML xml = new XML();
	
		xml.importarAreaConhecimento();	
		System.out.println("NEXT");
		xml.importarCargaHoraria();
		System.out.println("NEXT");
		xml.importarClasseDocente();
		System.out.println("NEXT");
		xml.importarTitulacao();
		System.out.println("NEXT");
		xml.importarNivelClasse();
		System.out.println("NEXT");
		xml.importarOrigemVaga();
		System.out.println("NEXT");
		xml.importarCursoGraduacao();
		System.out.println("NEXT");		
		xml.importarDocentes();
		System.out.println("NEXT");	
		Centro centro = new Centro();	
		centro.setNomeCentro("Centro de Ciencias Exatas e Tecnologicas");
		centro.setSiglaCentro("CETEC");
		CentroDAO centroDAO = new CentroDAO();
		centroDAO.saveCentro(centro);
		System.out.println("NEXT");	
		xml.importarCargo();
		System.out.println("NEXT");
		System.out.println("NEXT");	
		System.out.println("NEXT");	
		xml.importarHistoricoCargo();
		
		
	}
}
