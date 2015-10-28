package sgd_import_xml.XML;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import sgd_import_xml.DAO.*;
import sgd_import_xml.converters.DocenteConverter;
import sgd_import_xml.entity.*;

/**
 * 
 * @author Marco Aurelio
 * @Date 09/09/2015
 *
 */

public class XML {
	
	private final String patch;
	private  BufferedReader input;
	private XStream stream;
	
	
	public XML(){
		stream = new XStream(new DomDriver("UTF - 8"));
		stream.autodetectAnnotations(true);
		input = null;
		patch = System.getProperty("user.dir") + "/docs/xml/";
	}
	
	
	/**
	 * Abre arquivo XML
	 * @param url caminho do arquivo XML dentro da pasta C:\Users\Marco\programa��o\Programa��o\projetos\sgd\docs\xml\
	 */
	
	public void abrirXML(String url){	
		try {
			input = new BufferedReader(new InputStreamReader (new FileInputStream (this.patch + url), "UTF-8")); 
			System.out.println("Arquivo aberto");
		} catch (Exception e) {
			System.out.println("Arquivo não encontrado");
			e.printStackTrace();
		}
	}
	
	
	/**
	 * fecha arquivo XML aberto
	 */
	public void closeXML(){
		try {
			input.close();
			System.out.println("Arquivo fechado");
		} catch (IOException e) {
			System.out.println("Algum erro impediu o 'input.close'\n");
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * Le o arquvo XML e salva as Areas de conhecimento validas no Banco
	 */
	@SuppressWarnings("unchecked")
	public void importarAreaConhecimento(){
		AreaConhecimentoDAO areaConhecimentoDAO = new AreaConhecimentoDAO();
		
		List<AreaConhecimento> lista;
		this.abrirXML("Area.xml");
		stream.alias("Area", AreaConhecimento.class);
		lista  = (List<AreaConhecimento>) stream.fromXML(input);
		
		for(AreaConhecimento ac : lista){
			if(ac.getId() == 0 || ac.getNomeArea() == null){
				System.out.println(ac.getClass().toString()+" Invalida: ID: "+ ac.getIdArea()+ " "+ac.getClass().toString()+" : "+ac.getNomeArea());
				lista.remove(ac);
			}
			
			System.out.println(ac.getClass().toString()+" Salva: ID: "+ ac.getIdArea()+ " "+ac.getClass().toString()+" : "+ac.getNomeArea());
		}
		
		areaConhecimentoDAO.saveArea(lista); 	
		this.closeXML();
	}	
	
	
	/**
	 * Le o arquvo XML e salva as Carga Horaria validas no Banco
	 */
	@SuppressWarnings("unchecked")
	public void importarCargaHoraria(){
		CargaHorariaDAO cargaHorarioDAO = new CargaHorariaDAO();
		List<CargaHoraria> lista;
		this.abrirXML("Carga Horaria.xml");
		stream.alias("Carga_x0020_Horaria", CargaHoraria.class);
		
		
//		stream.registerConverter(new CargahorariaConverter()); // caso precise de conversor

		
		lista = (List<CargaHoraria>) stream.fromXML(input);
	
		for(CargaHoraria ac : lista){
			if(ac.getId() == 0 || ac.getCargaHoraria() == null){
				System.out.println(ac.getClass().toString()+" Invalida: ID: "+ ac.getIdCargaHoraria()+ " "+ac.getClass().toString()+" : "+ac.getCargaHoraria());
				lista.remove(ac);
			}
			
			System.out.println(ac.getClass().toString()+" Salva: ID: "+ ac.getIdCargaHoraria()+ " "+ac.getClass().toString()+" : "+ac.getCargaHoraria());
		}
		
		
		
		cargaHorarioDAO.saveCargaHoraria(lista);
		this.closeXML();	
	}	
	
	

	/**
	 * Le o arquvo XML e salva as Classe docente validas no Banco
	 */
	@SuppressWarnings("unchecked")
	public void importarClasseDocente(){
		ClasseDocenteDAO classeDocenteDAO = new ClasseDocenteDAO();
		List<ClasseDocente> lista;
		this.abrirXML("Classe Docente.xml");
		stream.alias("Classe_x0020_Docente", ClasseDocente.class);
		
		
//		stream.registerConverter(new CargahorariaConverter()); // caso precise de conversor

		
		lista = (List<ClasseDocente>) stream.fromXML(input);
	
		for(ClasseDocente ac : lista){
			if(ac.getId() == 0 || ac.getClasseDocente() == null){
				System.out.println(ac.getClass().toString()+" Invalida: ID: "+ ac.getId()+ " "+ac.getClass().toString()+" : "+ ac.getClasseDocente());
				lista.remove(ac);
			}
			
			System.out.println(ac.getClass().toString()+" Salva: ID: "+ ac.getId()+ " "+ac.getClass().toString()+" : "+ ac.getClasseDocente());
		}
		
		
		
		classeDocenteDAO.saveClasseDocente(lista);
		this.closeXML();	
	}	
	
	
	/**
	 * Le o arquvo XML e salva as Titulacao validas no Banco
	 */
	@SuppressWarnings("unchecked")
	public void importarTitulacao(){
		TitulacaoDAO titulacaoDAO = new TitulacaoDAO();
		List<Titulacao> lista;
		this.abrirXML("Titulacao.xml");
		stream.alias("Titulacao", Titulacao.class);
		
		
//		stream.registerConverter(new CargahorariaConverter()); // caso precise de conversor

		
		lista = (List<Titulacao>) stream.fromXML(input);
	
		for(Titulacao ac : lista){
			if(ac.getId() == 0 || ac.getTitulacao() == null){
				System.out.println(ac.getClass().toString()+" Invalida: ID: "+ ac.getId()+ " "+ac.getClass().toString()+" : "+ ac.getTitulacao());
				lista.remove(ac);
			}
			
			System.out.println(ac.getClass().toString()+" Salva: ID: "+ ac.getId()+ " "+ac.getClass().toString()+" : "+ ac.getTitulacao());
		}
		
		
		titulacaoDAO.saveTitulacao(lista);
		this.closeXML();	
	}	
	
	
	/**
	 * Le o arquvo XML e salva as Nivel da Classe validas no Banco
	 */
	@SuppressWarnings("unchecked")
	public void importarNivelClasse(){
		NivelClasseDAO nivelClasse = new NivelClasseDAO();
		List<NivelClasse> lista;
		this.abrirXML("Nivel da Classe.xml");
		stream.alias("Nivel_x0020_da_x0020_Classe", NivelClasse.class);
		
		
//		stream.registerConverter(new CargahorariaConverter()); // caso precise de conversor

		
		lista = (List<NivelClasse>) stream.fromXML(input);
	
		for(NivelClasse ac : lista){
			if(ac.getId() == 0 || ac.getNivelClasse() == null){
				System.out.println(ac.getClass().toString()+" Invalida: ID: "+ ac.getId()+ " "+ac.getClass().toString()+" : "+ ac.getNivelClasse());
				lista.remove(ac);
			}
			
			System.out.println(ac.getClass().toString()+" Salva: ID: "+ ac.getId()+ " "+ac.getClass().toString()+" : "+ ac.getNivelClasse());
		}
		
		
		nivelClasse.saveNivelClasse(lista);
		this.closeXML();	
	}
	
	/**
	 * Le o arquvo XML e salva as Origem da vaga validas no Banco
	 */
	@SuppressWarnings("unchecked")
	public void importarOrigemVaga(){
		OrigemVagaDAO origemVagaDAO = new OrigemVagaDAO();
		List<OrigemVaga> lista;
		this.abrirXML("Origem Vaga.xml");
		stream.alias("Origem_x0020_Vaga", OrigemVaga.class);
		
		
//		stream.registerConverter(new CargahorariaConverter()); // caso precise de conversor

		
		lista = (List<OrigemVaga>) stream.fromXML(input);
	
		for(OrigemVaga ac : lista){
			if(ac.getId() == 0 || ac.getOrigemVaga() == null){
				System.out.println(ac.getClass().toString()+" Invalida: ID: "+ ac.getId()+ " "+ac.getClass().toString()+" : "+ ac.getOrigemVaga());
				lista.remove(ac);
			}
			
			System.out.println(ac.getClass().toString()+" Salva: ID: "+ ac.getId()+ " "+ac.getClass().toString()+" : "+ ac.getOrigemVaga());
		}
		
		
		origemVagaDAO.saveOrigemVaga(lista);
		this.closeXML();	
	}
	
	
	/**
	 * Le o arquvo XML e salva os cursos e validas no Banco
	 */
	@SuppressWarnings("unchecked")
	public void importarCursoGraduacao(){
		CursoGraduacaoDAO cursoGraduacaoDAO = new CursoGraduacaoDAO();
		List<CursoGraduacao> lista;
		this.abrirXML("Curso.xml");
		stream.alias("Curso", CursoGraduacao.class);

		
		lista = (List<CursoGraduacao>) stream.fromXML(input);
	
		for(CursoGraduacao ac : lista){
			if(ac.getId() == 0 || ac.getCursoGrad() == null){
				System.out.println(ac.getClass().toString()+" Invalida: ID: "+ ac.getId()+ " "+ac.getClass().toString()+" : "+ ac.getCursoGrad());
				lista.remove(ac);
			}
			
			System.out.println(ac.getClass().toString()+" Salva: ID: "+ ac.getId()+ " "+ac.getClass().toString()+" : "+ ac.getCursoGrad());
		}
		
		
		cursoGraduacaoDAO.saveCursoGraduacao(lista);
		this.closeXML();	
	}
	
	
	/**
	 * Le o arquvo XML e salva os docentes e validas no Banco
	 */
	@SuppressWarnings("unchecked")
	public void importarDocentes(){
		DocenteDAO docenteDAO = new DocenteDAO();
		List<Docente> lista;
		this.abrirXML("Docente.xml");
		stream.alias("Docente", Docente.class);
		
		stream.registerConverter(new DocenteConverter()); 
		
		lista = (List<Docente>) stream.fromXML(input);
	
		for(Docente ac : lista){
			if(ac.getSiape() == 0){
				System.out.println(ac.getClass().toString()+" Invalida: ID: "+ ac.getId()+ " "+ac.getClass().toString()+" : "+ ac.getSiape());
				lista.remove(ac);
			}
			
			System.out.println(ac.getClass().toString()+" Salva: ID: "+ ac.getId()+ " "+ac.getClass().toString()+" : "+ ac.getSiape());
		}
		
		
		docenteDAO.saveDocente(lista);
		this.closeXML();	
	}
	
	
}
