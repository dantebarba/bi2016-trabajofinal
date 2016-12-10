package bi.server;

public class CantidadDePasesPorLineaDto {
	public CantidadDePasesPorLineaDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Linea get_id() {
		return _id;
	}
	public void set_id(Linea _id) {
		this._id = _id;
	}
	public Long getCantidad() {
		return cantidad;
	}
	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}
	Linea _id;
	Long cantidad;
	
}
