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
import sgd_import_xml.DAO.ClasseDocenteDAO;
import sgd_import_xml.entity.Docente;

public class DocenteConverter implements Converter{
	
	private Docente docente;
	private AreaConhecimentoDAO areaConhecimentoDAO = new AreaConhecimentoDAO();
	private ClasseDocenteDAO classeDocenteDAO = new ClasseDocenteDAO();

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

		reader.moveDown();
		System.out.println(reader.getNodeName()+" "+reader.getValue());
		reader.moveUp();

		reader.moveDown();
		System.out.println(reader.getNodeName()+" "+reader.getValue());
		docente.setSiape(Integer.parseInt(reader.getValue()));
		reader.moveUp();
		
		reader.moveDown();
		System.out.println(reader.getNodeName()+" "+reader.getValue());
		docente.setNome(reader.getValue());
		reader.moveUp();
		
		reader.moveDown();
		System.out.println(reader.getNodeName()+" "+reader.getValue());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			docente.setDataIngresso((Date) format.parse(reader.getValue().split("T")[0]));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		reader.moveUp();

		reader.moveDown();
		System.out.println(reader.getNodeName()+" "+reader.getValue());
		docente.setArea(this.areaConhecimentoDAO.findByID(Integer.parseInt(reader.getValue())));
		System.out.println(docente.getArea().getNomeArea());
		reader.moveUp();
		
		//entrogou PTT
		reader.moveDown();
		System.out.println(reader.getNodeName()+" "+reader.getValue());
		reader.moveUp();
		
		//AprovadoEstagio
		reader.moveDown();
		System.out.println(reader.getNodeName()+" "+reader.getValue());
		reader.moveUp();
		
		reader.moveDown();		
		System.out.println(reader.getNodeName()+" "+reader.getValue());
		docente.setClasseDocente(classeDocenteDAO.findByID(Integer.parseInt(reader.getValue())));
		System.out.println(docente.getClasseDocente());
		reader.moveUp();
		
		reader.moveDown();
		System.out.println(reader.getNodeName()+" "+reader.getValue());
		reader.moveUp();
		
		reader.moveDown();
		System.out.println(reader.getNodeName()+" "+reader.getValue());
		reader.moveUp();

		
		reader.moveDown();
		System.out.println(reader.getNodeName()+" "+reader.getValue());
		reader.moveUp();
		
		reader.moveDown();
		System.out.println(reader.getNodeName()+" "+reader.getValue());
		reader.moveUp();
		
//		reader.moveDown();
//		System.out.println(reader.getNodeName()+" "+reader.getValue());
//		reader.moveUp();
//		
		System.out.println("\n");

		
		return null;
	}

}
