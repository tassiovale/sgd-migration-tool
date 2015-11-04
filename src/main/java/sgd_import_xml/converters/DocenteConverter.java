package sgd_import_xml.converters;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import sgd_import_xml.DAO.AreaConhecimentoDAO;
import sgd_import_xml.DAO.CargaHorariaDAO;
import sgd_import_xml.DAO.ClasseDocenteDAO;
import sgd_import_xml.DAO.NivelClasseDAO;
import sgd_import_xml.DAO.OrigemVagaDAO;
import sgd_import_xml.DAO.TitulacaoDAO;
import sgd_import_xml.entity.Docente;

public class DocenteConverter implements Converter{
	
	private Docente docente;
	private AreaConhecimentoDAO areaConhecimentoDAO = new AreaConhecimentoDAO();
	private ClasseDocenteDAO classeDocenteDAO = new ClasseDocenteDAO();
	private NivelClasseDAO nivelClasseDAO = new NivelClasseDAO();
	private TitulacaoDAO titulacaoDAO = new TitulacaoDAO();
	private OrigemVagaDAO origemVagaDAO = new OrigemVagaDAO();
	private CargaHorariaDAO cargaHorariaDAO = new CargaHorariaDAO();

	@SuppressWarnings("rawtypes")
	@Override
	public boolean canConvert(Class type) {
		return type.equals(Docente.class);
	}

	@Override
	public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {}

	@Override
	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
		docente = new Docente();
		
		
		
		System.out.println(reader.getNodeName());
		while(reader.hasMoreChildren()){
			reader.moveDown();
			if(reader.getNodeName().equals("nMatriculaSiape")){
				docente.setSiape(Integer.parseInt(reader.getValue()));
				System.out.println("Siape: "+ docente.getSiape());
			}else if(reader.getNodeName().equals("sNomeDocente")){
				docente.setNome(reader.getValue());
				System.out.println("Nome: "+ docente.getNome());
			}else if(reader.getNodeName().equals("dDataIngresso")){
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				try {
					docente.setDataIngresso((Date) format.parse(reader.getValue().split("T")[0]));
					System.out.println("Data ingresso: "+ docente.getDataIngresso());
				} catch (ParseException e) {
					e.printStackTrace();
				}	
			}else if(reader.getNodeName().equals("nCodigoArea")){
				docente.setArea(this.areaConhecimentoDAO.findByID(Integer.parseInt(reader.getValue())));
				System.out.println("Area: "+ docente.getArea().getNomeArea());
			}else if(reader.getNodeName().equals("nCodigoClasse")){
				docente.setClasseDocente(classeDocenteDAO.findByID(Integer.parseInt(reader.getValue())));
				System.out.println("Classe: "+ docente.getClasseDocente().getClasseDocente());
			}else if(reader.getNodeName().equals("nCodigoNivel")){
				docente.setNivelClasse(this.nivelClasseDAO.findByID(Integer.parseInt(reader.getValue())));
				System.out.println("NIvel Classe: "+ docente.getNivelClasse().getNivelClasse());
			}else if(reader.getNodeName().equals("nCodigoTitulacao")){
				docente.setTitulacao(this.titulacaoDAO.findByID(Integer.parseInt(reader.getValue())));
				System.out.println("Titulação: "+ docente.getTitulacao().getTitulacao());
			}else if(reader.getNodeName().equals("nCodigoOrigemVaga")){
				docente.setOrigemVaga(this.origemVagaDAO.findByID(Integer.parseInt(reader.getValue())));
				System.out.println("Origem da vaga: "+ docente.getOrigemVaga().getOrigemVaga());
			}else if(reader.getNodeName().equals("sEmail")){
				docente.setEmail(reader.getValue().split(";")[0]);
				System.out.println("Email: "+ docente.getEmail());
			}else if(reader.getNodeName().equals("nCargaHoraria")){
				docente.setCargaHoraria(this.cargaHorariaDAO.findByID(Integer.parseInt(reader.getValue())));
				System.out.println("Carga Horaria: "+ docente.getCargaHoraria().getCargaHoraria());
			}else if(reader.getNodeName().equals("nTelefone")){
				String telefone[] = reader.getValue().split("/");
				docente.setTelefone1(telefone[0]);
				System.out.println("TELEFONE "+telefone.length);
				if(telefone.length > 1) docente.setTelefone2(telefone[1]);
			}
			
			reader.moveUp();
		}
		
		System.out.println("\n");

		
		return docente;
	}

}
