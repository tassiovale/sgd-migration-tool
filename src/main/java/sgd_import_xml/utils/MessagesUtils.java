package sgd_import_xml.utils;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext; 

/**
 * Adiciona mensagens para os usuarios
 * @author Caique
 *
 */
public final class MessagesUtils {

	public static final String SIAPE_INVALIDO = "SIAPE ou E-mail inv�lido!";
	public static final String SENHA_INVALIDA = "Senha inv�lida!";
	public static final String ERRO_ACESSAR_SISTEMA = "N�o foi possivel acessar o sistema!";

	public static void sendInfoMessageToUser(String message) {
		FacesMessage facesMessage = createMessage(FacesMessage.SEVERITY_INFO, message);
		addMessageToJsfContext(facesMessage);
	}

	public static void sendErrorMessageToUser(String message) {
		FacesMessage facesMessage = createMessage(FacesMessage.SEVERITY_ERROR, message);
		addMessageToJsfContext(facesMessage);
	}

	public static void sendWarnMessageToUser(String message) {
		FacesMessage facesMessage = createMessage(FacesMessage.SEVERITY_WARN, message);
		addMessageToJsfContext(facesMessage);
	}

	public static void sendInfoMessageToUser(String componentId, String message) {
		FacesMessage facesMessage = createMessage(FacesMessage.SEVERITY_INFO, message);
		addMessageToJsfContext(componentId, facesMessage);
	}

	public static void sendErrorMessageToUser(String componentId, String message) {
		FacesMessage facesMessage = createMessage(FacesMessage.SEVERITY_ERROR, message);
		addMessageToJsfContext(componentId, facesMessage);
	}

	public static void sendWarnMessageToUser(String componentId, String message) {
		FacesMessage facesMessage = createMessage(FacesMessage.SEVERITY_WARN, message);
		addMessageToJsfContext(componentId, facesMessage);
	}

	private static FacesMessage createMessage(Severity severity, String mensagemErro) {
		return new FacesMessage(severity, mensagemErro, mensagemErro);
	}

	private static void addMessageToJsfContext(FacesMessage facesMessage) {
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
	}

	private static void addMessageToJsfContext(String componentId, FacesMessage facesMessage) {
		FacesContext.getCurrentInstance().addMessage(componentId, facesMessage);
	}

}
