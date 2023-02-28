package mx.tecnm.itlp.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mensajes")
public class Mensaje {

	@GetMapping("/hola")
	public String mostrarMensaje() {
		return "Hola mundo web";
	}
	
	@GetMapping("/eco")
	public String crearEco(@RequestParam String mensaje, @RequestParam int repeticiones) {
		String resultado="";
		for (int i = 0; i < repeticiones; i++) {
			resultado = resultado + mensaje + " ";
		}
		return resultado;
	}
}
