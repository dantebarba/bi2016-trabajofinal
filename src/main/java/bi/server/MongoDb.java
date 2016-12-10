package bi.server;

import java.util.ArrayList;
import java.util.List;

import org.jongo.Aggregate.ResultsIterator;
import org.jongo.Jongo;
import org.springframework.stereotype.Repository;

import com.mongodb.DB;
import com.mongodb.MongoClient;

@Repository
public class MongoDb {

	public List<CantidadDePasesPorHoraDto> getMolinetesPorHora() {
		Jongo jongo = getJongo();
		ResultsIterator<CantidadDePasesPorHoraDto> result = jongo
				.getCollection("molinetes")
				.aggregate(
						"{$group: { _id: { hora: '$DESDE' },cantidad: { $sum: '$TOTAL' },} }")
				.as(CantidadDePasesPorHoraDto.class);
		return (List<CantidadDePasesPorHoraDto>) createResultList(result);
	}

	private List<?> createResultList(ResultsIterator<?> result) {
		List resultList = new ArrayList();
		while (result.hasNext()) {
			resultList.add(result.next());
		}
		return resultList;
	}

	private Jongo getJongo() {
		DB db = new MongoClient().getDB("CiudadDeBuenosAires");
		Jongo jongo = new Jongo(db);
		return jongo;
	}

	public List<CantidadDePasesPorEstacionDto> getPasesPorEstacion() {
		Jongo jongo = getJongo();
		ResultsIterator<CantidadDePasesPorEstacionDto> result = jongo
				.getCollection("molinetes")
				.aggregate(
						"{ $group: { _id: { estacion: '$ESTACION' }, cantidad: { $sum: '$TOTAL' },} }, { $sort : { 'cantidad' : -1 }}")
				.as(CantidadDePasesPorEstacionDto.class);
		return (List<CantidadDePasesPorEstacionDto>) createResultList(result);

	}

	public List<CantidadDePasesPorLineaDto> getPasesPorLinea() {
		Jongo jongo = getJongo();
		ResultsIterator<CantidadDePasesPorLineaDto> result = jongo
				.getCollection("molinetes")
				.aggregate(
						"{ $group: { _id: { linea: '$LINEA' }, cantidad: { $sum: '$TOTAL' },} }, { $sort : { 'cantidad' : -1 }}")
				.as(CantidadDePasesPorLineaDto.class);
		return (List<CantidadDePasesPorLineaDto>) createResultList(result);
	}

	public List<CantidadDePasesAUPorPeaje> getPasesAUPorPeaje(String startDate,
			String endDate) {
		Jongo jongo = getJongo();
		System.out.println("{ $match: { FECHA: { $lt: '"
								+ endDate
								+ "', $gte: '"
								+ startDate
								+ "' } } },{ $group: { _id: { estacion: '$ESTACION' }, cantidad: { $sum: '$CANTIDAD_PASOS' },} }, { $sort : { 'cantidad' : -1 }}");
		ResultsIterator<CantidadDePasesAUPorPeaje> result = jongo
				.getCollection("vehiculos-peajes")
				.aggregate(
						"{ $group: { _id: { estacion: '$ESTACION' }, cantidad: { $sum: '$CANTIDAD_PASOS' },} }, { $sort : { 'cantidad' : -1 }}")
				.as(CantidadDePasesAUPorPeaje.class);
		return (List<CantidadDePasesAUPorPeaje>) createResultList(result);
	}

}
