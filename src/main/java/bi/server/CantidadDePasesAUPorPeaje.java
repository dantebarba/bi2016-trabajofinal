package bi.server;

public class CantidadDePasesAUPorPeaje {
	public CantidadDePasesAUPorPeaje() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Estacion get_id() {
		return _id;
	}
	public void set_id(Estacion _id) {
		this._id = _id;
	}
	public Long getCantidad() {
		return cantidad;
	}
	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}
	Estacion _id;
	Long cantidad;
	
}
