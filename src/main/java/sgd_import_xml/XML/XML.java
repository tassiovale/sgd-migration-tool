package sgd_import_xml.XML;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
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
	 * @param url caminho do arquivo XML dentro da pasta C:\Users\Marco\programaï¿½ï¿½o\Programaï¿½ï¿½o\projetos\sgd\docs\xml\
	 */
	
	public void abrirXML(String url){	
		try {
			input = new BufferedReader(new InputStreamReader (new FileInputStream (this.patch + url), "UTF-8")); 
			System.out.println("Arquivo aberto");
		} catch (Exception e) {
			System.out.println("Arquivo nÃ£o encontrado");
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
		
		HashMap<Integer, Docente> hashDocente = new HashMap<Integer,Docente>();
		ArrayList<Docente> listaSemRepeticao = new ArrayList<Docente>();
		for(Docente ac : lista){
			if(!hashDocente.containsKey(ac.getSiape())){
				System.out.println(ac.getClass().toString()+" Salva: ID: "+ ac.getId()+ " "+ac.getClass().toString()+" : "+ ac.getSiape());
				hashDocente.put(ac.getSiape(), ac);
				listaSemRepeticao.add(ac);
			}
		}
		
		System.out.println(lista.size());
		System.out.println(listaSemRepeticao.size());
		docenteDAO.saveDocente(listaSemRepeticao);
		this.closeXML();	
	}
	
	
	/**
	 * Le o arquvo XML e salva os cargos validos no Banco
	 * Este metodo tem faz algumas conversoes usando varios xml`s
	 */
	public void importarCargo(){
		CargoDAO cargoDAO = new CargoDAO();
		ArrayList<Cargo> listaCargo = new ArrayList<Cargo>();
		Cargo cargo;
	
		try {
			System.out.println("CENTRO");
			CentroDAO centroDAO = new CentroDAO();
			String cargos[] = {"Diretor", "Vice Diretor", "Gestor Ensino", "Gestor Pesquisa", "Gestor Extensão"};
			for(String nomeCargo: cargos){
				System.out.println("PROXIMO CARGO");
				for(Centro c: centroDAO.findAll()){
					cargo = new Cargo();
					cargo.setNomeCargo(nomeCargo);
					cargo.setCentro(c);
					cargo.setVinculo(3);
					System.out.println(cargo.getClass().toString()+" Salva: Nome: "+ cargo.getNomeCargo()+ " Vinculo : "+ cargo.getVinculo() + " CENTRO: "+ c.getNomeCentro());
					listaCargo.add(cargo);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			System.out.println("CURSO");
			CursoGraduacaoDAO cursoGraduacaoDAO = new CursoGraduacaoDAO();
			String cargos[] = {"Coordenador", "Vice Coordenador"};
			System.out.println("PROXIMO CARGO");
			for(String nomeCargo: cargos){
				for(CursoGraduacao cg: cursoGraduacaoDAO.findAll()){
					cargo = new Cargo();
					cargo.setNomeCargo(nomeCargo);
					cargo.setCursoGraduacao(cg);
					cargo.setVinculo(2);
					System.out.println(cargo.getClass().toString()+" Salva: Nome: "+ cargo.getNomeCargo()+ " Vinculo : "+ cargo.getVinculo() + " CURSO: "+ cg.getCursoGrad());
					listaCargo.add(cargo);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		try {
			System.out.println("AREA CONHECIMENTO");
			AreaConhecimentoDAO areaConhecimentoDAO = new AreaConhecimentoDAO();
			String cargos[] = {"Coordenador", "Vice Coordenador"};
			for(String nomeCargo: cargos){
				System.out.println("PROXIMO CARGO");
				for(AreaConhecimento a: areaConhecimentoDAO.findAll()){
					cargo = new Cargo();
					cargo.setNomeCargo(nomeCargo);
					cargo.setArea(a);
					cargo.setVinculo(1);
					System.out.println(cargo.getClass().toString()+" Salva: Nome: "+ cargo.getNomeCargo()+ " Vinculo : "+ cargo.getVinculo() + " AREA: "+ a.getNomeArea());
					listaCargo.add(cargo);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		cargoDAO.saveCargo(listaCargo);
		
	}
	
	/**
	 * Le o arquvo XML e salva os cargos validos no Banco
	 * Este metodo tem faz algumas conversoes usando varios xml`s
	 */
	
	@SuppressWarnings("unchecked")
	public List<DocenteCurso> getDocenteCurso(){
		List<DocenteCurso> listaDocenteCurso;
		this.abrirXML("DocenteCurso.xml");
		stream.alias("DocenteCurso", DocenteCurso.class);
		listaDocenteCurso = (List<DocenteCurso>) stream.fromXML(input);
		this.closeXML();
		return listaDocenteCurso;
	}
	
	@SuppressWarnings("unchecked")
	public List<CargoArea> getCargoArea(){
		List<CargoArea> listaCargoArea;
		this.abrirXML("Cargo Area.xml");
		stream.alias("Cargo_x0020_Area", CargoArea.class);
		listaCargoArea = (List<CargoArea>) stream.fromXML(input);
		this.closeXML();
		return listaCargoArea;
	}
	
	

	@SuppressWarnings("unchecked")
	public void importarHistoricoCargo(){
		List<HistoricoCargoCurso> listaCargoCurso;
		this.abrirXML("Historico Cargo Curso.xml");
		stream.alias("Historico_x0020_Cargo_x0020_Curso", HistoricoCargoCurso.class);
		listaCargoCurso = (List<HistoricoCargoCurso>) stream.fromXML(input);	
		this.closeXML();
		
		
		
	}
	
}
