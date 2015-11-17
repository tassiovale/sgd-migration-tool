package sgd_import_xml.converters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import sgd_import_xml.entity.HistoricoCargoCurso;

public class HistoricoCargoCursoConverter implements Converter{

	@Override
	public boolean canConvert(@SuppressWarnings("rawtypes") Class type) {
		return type.equals(HistoricoCargoCurso.class);
	}

	@Override
	public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
		HistoricoCargoCurso historicoCargoCurso = new HistoricoCargoCurso();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		while(reader.hasMoreChildren()){
			reader.moveDown();
			
			if(reader.getNodeName().equals("nCodigoCurso")){
				historicoCargoCurso.setnCodigoCargo(Integer.parseInt(reader.getValue()));
			}else if (reader.getNodeName().equals("Sequencia")){
				historicoCargoCurso.setSequencia(Integer.parseInt(reader.getValue()));
			}else if(reader.getNodeName().equals("nCodigoDocente")){
				historicoCargoCurso.setnCodigoDocente(Integer.parseInt(reader.getValue()));
			}else if(reader.getNodeName().equals("nCodigoCargo")){
				historicoCargoCurso.setnCodigoCargo(Integer.parseInt(reader.getValue()));
			}else if(reader.getNodeName().equals("Data_x0020_Inicio")){
				try {
					historicoCargoCurso.setData_x0020_Inicio((Date) format.parse(reader.getValue().split("T")[0]));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(reader.getNodeName().equals("Data_x0020_Fim")){
				try {
					historicoCargoCurso.setData_x0020_Fim((Date) format.parse(reader.getValue().split("T")[0]));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			reader.moveUp();
		}
		
		
		return historicoCargoCurso;
	}

}
