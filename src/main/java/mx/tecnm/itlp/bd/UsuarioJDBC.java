package mx.tecnm.itlp.bd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mx.tecnm.itlp.modelos.Usuario;

@Repository
public class UsuarioJDBC {
	
	@Autowired
	JdbcTemplate conexion;
	
	public List<Usuario> consultarUsuarios(){
		String sql = "SELECT * FROM usuarios WHERE activo = 1";
		return conexion.query(sql, new UsuarioRM());
	}

	public Usuario buscarUsuario(int id) {
		String sql = "SELECT * FROM usuarios WHERE id = ? AND activo = 1";
		return conexion.queryForObject(sql, new UsuarioRM(), id);
	}

	public void desactivarUsuario(int id) {
		String sql = "UPDATE usuarios SET activo = 0 WHERE id = ?";
		conexion.update(sql, id);
	}

	public void agregarUsuario(Usuario user) {
		String sql = "INSERT INTO usuarios(usuario, contrasena) VALUES(?, ?)";
		conexion.update(sql, user.getUsuario(), user.getContrasena());	
	}
	

}
