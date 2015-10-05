package sgd_import_xml.XML;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import sgd_import_xml.DAO.AreaConhecimentoDAO;
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
	public List<AreaConhecimento> importarAreaConhecimento(){
		AreaConhecimentoDAO areaConhecimentoDAO = new AreaConhecimentoDAO();
		
		List<AreaConhecimento> lista;
		this.abrirXML("Area.xml");
		stream.alias("Area", AreaConhecimento.class);
		lista  = (List<AreaConhecimento>) stream.fromXML(input);
		
		for(AreaConhecimento ac : lista){
			if(ac.getId() == 0 || ac.getNomeArea() == null){
				System.out.println("Area de conhecimento Invalida: ID: "+ ac.getIdArea()+ "Area de conhecimento: "+ ac.getNomeArea());
				lista.remove(ac);
			}
			
			System.out.println("Area de conhecimento Salva: ID: "+ ac.getIdArea()+ ", Area de conhecimento: "+ ac.getNomeArea());
		}
		
		areaConhecimentoDAO.saveArea(lista); 	
		this.closeXML();
		return lista;	
	}	
}
