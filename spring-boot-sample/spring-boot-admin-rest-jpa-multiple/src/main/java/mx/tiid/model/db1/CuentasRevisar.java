package mx.tiid.model.db1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cuentasrevisar")
public class CuentasRevisar {

	@Id
	@Column(name = "Cuenta")
	private String cuenta;

	@Column(name = "Producto")
	private String producto;

	public String getCuenta() {
		return cuenta;
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

}