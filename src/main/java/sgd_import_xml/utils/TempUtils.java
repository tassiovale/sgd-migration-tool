package sgd_import_xml.utils;

import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

public class TempUtils {
	
	public static Object getTempObject(String name){
		return FacesContext.getCurrentInstance().getExternalContext().getFlash().get(name);
	}
	
	public static void setTempObject(String name, Object obj){
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put(name, obj);
	}
	
	public static void showDialog(String name){
		RequestContext.getCurrentInstance().execute(name + ".show();");
	}

}
