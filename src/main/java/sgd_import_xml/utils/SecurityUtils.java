package sgd_import_xml.utils; 

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import sgd_import_xml.entity.Usuario;

public final class SecurityUtils {

	private static MessageDigest algorithm;
	private static final String[] character = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
			"k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A",
			"B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
			"S", "T", "U", "V", "W", "X", "Y", "Z" };

	private static final String[] digit = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "_",
			"@", "*" };

	public static final String USUARIO = "ROLE_USER";
	public static final String ADMINISTRADOR = "ROLE_ADMIN";

	static {
		try {
			algorithm = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo que gera a criptografia.
	 *
	 * @param password
	 *            Passe a senha como parametro
	 * @return a senha criptografada e pronta para ser salva no banco. Use
	 *         tambem para comparar com alguma senha ja salva anteriormente.
	 * @throws UnsupportedEncodingException
	 * @throws NoSuchAlgorithmException
	 */
	public static String criptography(String password) throws UnsupportedEncodingException,
			NoSuchAlgorithmException {
		if (algorithm == null)
			throw new NoSuchAlgorithmException("No instance for MessageDigest");
		byte messageDigest[];

		messageDigest = algorithm.digest(password.getBytes("UTF-8"));
		StringBuilder hexString = new StringBuilder();
		for (byte b : messageDigest) {
			hexString.append(String.format("%02X", 0xFF & b));
		}
		return hexString.toString();

	}

	/**
	 * Gera senha aleatoria para o usuario.
	 *
	 * @return uma nova senha para ser enviada via sftp.
	 */
	public static String generatePassword() {
		StringBuilder password = new StringBuilder();
		for (int x = 0; x < 8; x++) {

			if (x % 3 != 0) {
				int j = (int) (Math.random() * character.length);
				password.append(character[j]);
			} else {
				int j = (int) (Math.random() * digit.length);
				password.append(digit[j]);
			}

		}
		return password.toString();
	}

	public static String getUserSiapeNome(){
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		Usuario usuario = ((Usuario) session.getAttribute("usuario"));
		return usuario.getSiape() + " - " + usuario.getEmail();
	}
	
	public static Usuario getUsuario(){
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		Usuario usuario = ((Usuario) session.getAttribute("usuario"));
		return usuario;
	}

}
