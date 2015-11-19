package sgd_import_xml.converters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import sgd_import_xml.entity.HistoricoCargoCentro;

public class HistoricoCargoCentroConverter implements Converter{

	@Override
	public boolean canConvert(@SuppressWarnings("rawtypes") Class type) {
		return type.equals(HistoricoCargoCentro.class);
	}

	@Override
	public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {}

	@Override
	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
		HistoricoCargoCentro historicoCargoCentro = new HistoricoCargoCentro();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		while(reader.hasMoreChildren()){
			reader.moveDown();
			
			if(reader.getNodeName().equals("Sequencia")){
				historicoCargoCentro.setSequencia(Integer.parseInt(reader.getValue()));
			}else if (reader.getNodeName().equals("nCodigoDocente")){
				historicoCargoCentro.setnCodigoDocente(Integer.parseInt(reader.getValue()));
			}else if(reader.getNodeName().equals("nCodigoCargo")){
				historicoCargoCentro.setnCodigoCargo(Integer.parseInt(reader.getValue()));
			}else if(reader.getNodeName().equals("Data_x0020_Inicio")){
				try {
					historicoCargoCentro.setData_x0020_Inicio((Date) format.parse(reader.getValue().split("T")[0]));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}else if(reader.getNodeName().equals("Data_x0020_Fim")){
				try {
					historicoCargoCentro.setData_x0020_Fim((Date) format.parse(reader.getValue().split("T")[0]));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			
			reader.moveUp();
		}
		
		return historicoCargoCentro;
	}

}
