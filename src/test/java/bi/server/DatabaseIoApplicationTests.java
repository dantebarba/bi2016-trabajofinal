package bi.server;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DatabaseIoApplicationTests {

	@Autowired
	MongoDb mongoDb;

	@Test
	public void contextLoads() {
		List<CantidadDePasesPorHoraDto> result = mongoDb.getMolinetesPorHora();
		Assert.assertTrue(result.size() > 0);
		List<CantidadDePasesPorLineaDto> resultLinea = mongoDb
				.getPasesPorLinea();
		Assert.assertTrue(resultLinea.size() > 0);
		List<CantidadDePasesAUPorPeaje> resultPeaje = mongoDb
				.getPasesAUPorPeaje("04/01/2015", "10/01/2015");
		Assert.assertTrue(resultPeaje.size() > 0);
	}

}
