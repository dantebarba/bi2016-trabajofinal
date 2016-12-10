package bi.server;

public class CantidadDePasesPorHoraDto {
	public CantidadDePasesPorHoraDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Hora get_id() {
		return _id;
	}
	public void set_id(Hora _id) {
		this._id = _id;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	Hora _id;
	Integer cantidad;
	
	
	
}
