package sgd_import_xml.XML;


public class Testes {
	public static void main(String[] args) {
		XML xml = new XML();
	
		xml.importarAreaConhecimento();	
		System.out.println("NEXT");
//		xml.importarCargaHoraria();
//		System.out.println("NEXT");
		xml.importarClasseDocente();
		System.out.println("NEXT");
//		xml.importarTitulacao();
//		System.out.println("NEXT");
//		xml.importarNivelClasse();
//		System.out.println("NEXT");
//		xml.importarOrigemVaga();
//		System.out.println("NEXT");
//		xml.importarCursoGraduacao();
		
		
		xml.importarDocentes();
	}
}
