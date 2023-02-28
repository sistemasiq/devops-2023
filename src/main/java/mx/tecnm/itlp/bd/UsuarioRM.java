package mx.tecnm.itlp.bd;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mx.tecnm.itlp.modelos.Usuario;

public class UsuarioRM implements RowMapper<Usuario> {

	@Override
	public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
		Usuario user = new Usuario();
		user.setId(rs.getInt("id"));
		user.setUsuario(rs.getString("usuario"));
		user.setContrasena(rs.getString("contrasena"));
		return user;
	}

}
