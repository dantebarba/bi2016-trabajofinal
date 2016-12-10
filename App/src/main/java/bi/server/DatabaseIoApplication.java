package bi.server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
@EnableAutoConfiguration
public class DatabaseIoApplication {

	@Autowired
	MongoDb db;

	@RequestMapping("/")
	@ResponseBody
	String home() {
		return "Hello World!";
	}

	@RequestMapping("/cantidadDePasesPorHora")
	public @ResponseBody
	List<CantidadDePasesPorHoraDto> cantidadDePasesPorHora() {
		return db.getMolinetesPorHora();
	}

	@RequestMapping("/cantidadDePasesPorEstacion")
	public @ResponseBody
	List<CantidadDePasesPorEstacionDto> cantidadDePasesPorEstacion() {
		return db.getPasesPorEstacion();
	}

	@RequestMapping("/cantidadDePasesPorLinea")
	public @ResponseBody
	List<CantidadDePasesPorLineaDto> cantidadDePasesPorLinea() {
		return db.getPasesPorLinea();
	}

	@RequestMapping("/cantidadDePasesAuPorPeaje")
	public @ResponseBody
	List<CantidadDePasesAUPorPeaje> cantidadDePasesAuPorPeaje(
			@RequestParam(value = "startDate", defaultValue = "01/01/2015") String startDate,
			@RequestParam(value = "endDate", defaultValue = "30/12/2015") String endDate) {
		return db.getPasesAUPorPeaje(startDate, endDate);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(DatabaseIoApplication.class, args);
	}
}
