package sgd_import_xml.converters;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import sgd_import_xml.entity.CargaHoraria;

public class CargahorariaConverter implements Converter{

	@SuppressWarnings("rawtypes")
	@Override
	public boolean canConvert(Class classe) {
		return classe.equals(CargaHoraria.class);
	}

	@Override
	public void marshal(Object value, HierarchicalStreamWriter writter, MarshallingContext context) {}

	@Override
	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
		
		CargaHoraria cargaHoraria = new CargaHoraria();
		while(reader.hasMoreChildren()){
			reader.moveDown();
			System.out.println("Nome do no: "+reader.getNodeName());
		
			 
			
			
			
			if("nCargaHoraria".equals(reader.getNodeName())){
				cargaHoraria.setIdCargaHoraria((Integer) context.convertAnother(cargaHoraria, Integer.class));
//				System.out.println("ID: "+cargaHoraria.getIdCargaHoraria());
			}
			
		
			if("sDescricaoCarga".equals(reader.getNodeName())){
				
//				cargaHoraria
			}
			
			
		}
		
		reader.moveUp();
		
		return cargaHoraria;
	}

}
