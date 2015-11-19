package sgd_import_xml.converters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import sgd_import_xml.entity.HistoricoCargoAreaConhecimento;

public class HistoricoCargoAreaConhecimentoConverter implements Converter{

	@Override
	public boolean canConvert(@SuppressWarnings("rawtypes") Class type) {
		return type.equals(HistoricoCargoAreaConhecimento.class);
	}

	@Override
	public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {}

	@Override
	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
		HistoricoCargoAreaConhecimento historicoCargoAreaConhecimento = new HistoricoCargoAreaConhecimento();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		while(reader.hasMoreChildren()){
			reader.moveDown();
			
			if(reader.getNodeName().equals("nCodigoArea")){
//				System.out.println("CONVERSOR: Codigo "+ Integer.parseInt(reader.getValue()));
				historicoCargoAreaConhecimento.setnCodigoArea(Integer.parseInt(reader.getValue()));
			}else if (reader.getNodeName().equals("Sequencia")){
//				System.out.println("CONVERSOR: Sequencia "+ Integer.parseInt(reader.getValue()));
				historicoCargoAreaConhecimento.setSequencia(Integer.parseInt(reader.getValue()));
			}else if(reader.getNodeName().equals("nCodigoDocente")){
//				System.out.println("CONVERSOR: codigo Docente "+ Integer.parseInt(reader.getValue()));
				historicoCargoAreaConhecimento.setnCodigoDocente(Integer.parseInt(reader.getValue()));
			}else if(reader.getNodeName().equals("nCodigoCargo")){
//				System.out.println("CONVERSOR: Codigo Cargo "+ Integer.parseInt(reader.getValue()));
				historicoCargoAreaConhecimento.setnCodigoCargo(Integer.parseInt(reader.getValue()));
			}else if(reader.getNodeName().equals("Data_x0020_Inicio")){
				try {
					historicoCargoAreaConhecimento.setData_x0020_Inicio((Date) format.parse(reader.getValue().split("T")[0]));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}else if(reader.getNodeName().equals("Data_x0020_Fim")){
				try {
					historicoCargoAreaConhecimento.setData_x0020_Fim((Date) format.parse(reader.getValue().split("T")[0]));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			
			reader.moveUp();
		}
		
		
		return historicoCargoAreaConhecimento;
	}

}
