package mx.tiid.model.db2;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import mx.tiid.util.CustomDate;
import mx.tiid.util.CustomDateTime;

@Entity
@Table(name = "pcj_tsolicitudes")
public class Solicitud implements Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_solicitud")
	private int idSolicitud;

	@Column(name = "numero_telefonico")
	private String numeroTelefonico;

	@Column(name = "fecha_inicio")
	@JsonSerialize(using = CustomDate.class)
	private Date fechaInicio;

	@Column(name = "fecha_fin")
	@JsonSerialize(using = CustomDate.class)
	private Date fechaFin;

	@Column(name = "estatus")
	private String estatus;

	@Column(name = "correo")
	private String correo;

	@Column(name = "formato")
	private String formato;

	@Column(name = "fecha_solicitud")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonSerialize(using = CustomDateTime.class)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date fechaSolicitud;

	@Column(name = "inicio_proceso")
	@JsonSerialize(using = CustomDateTime.class)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date inicioProceso;

	@Column(name = "fin_proceso")
	@JsonSerialize(using = CustomDateTime.class)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date finProceso;

	@Column(name = "id_proceso",nullable = true)
	private int idProceso;

	@Column(name = "creado_por")
	private String creadoPor;

	@Column(name = "fecha_creacion")
	@JsonSerialize(using = CustomDate.class)
	private Date fechaCreacion;

	@Column(name = "sistema")
	private String sistema;

	@Column(name = "modificado_por")
	private String modificadoPor;

	@Column(name = "fecha_modificacion")
	@JsonSerialize(using = CustomDate.class)
	private Date fechaModificacion;

	public int getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(int idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	public String getNumeroTelefonico() {
		return numeroTelefonico;
	}

	public void setNumeroTelefonico(String numeroTelefonico) {
		this.numeroTelefonico = numeroTelefonico;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public Date getInicioProceso() {
		return inicioProceso;
	}

	public void setInicioProceso(Date inicioProceso) {
		this.inicioProceso = inicioProceso;
	}

	public Date getFinProceso() {
		return finProceso;
	}

	public void setFinProceso(Date finProceso) {
		this.finProceso = finProceso;
	}

	public int getIdProceso() {
		return idProceso;
	}

	public void setIdProceso(int idProceso) {
		this.idProceso = idProceso;
	}

	public String getCreadoPor() {
		return creadoPor;
	}

	public void setCreadoPor(String creadoPor) {
		this.creadoPor = creadoPor;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getSistema() {
		return sistema;
	}

	public void setSistema(String sistema) {
		this.sistema = sistema;
	}

	public String getModificadoPor() {
		return modificadoPor;
	}

	public void setModificadoPor(String modificadoPor) {
		this.modificadoPor = modificadoPor;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((correo == null) ? 0 : correo.hashCode());
		result = prime * result + ((creadoPor == null) ? 0 : creadoPor.hashCode());
		result = prime * result + ((estatus == null) ? 0 : estatus.hashCode());
		result = prime * result + ((fechaCreacion == null) ? 0 : fechaCreacion.hashCode());
		result = prime * result + ((fechaFin == null) ? 0 : fechaFin.hashCode());
		result = prime * result + ((fechaInicio == null) ? 0 : fechaInicio.hashCode());
		result = prime * result + ((fechaModificacion == null) ? 0 : fechaModificacion.hashCode());
		result = prime * result + ((fechaSolicitud == null) ? 0 : fechaSolicitud.hashCode());
		result = prime * result + ((finProceso == null) ? 0 : finProceso.hashCode());
		result = prime * result + ((formato == null) ? 0 : formato.hashCode());
		result = prime * result + idProceso;
		result = prime * result + idSolicitud;
		result = prime * result + ((inicioProceso == null) ? 0 : inicioProceso.hashCode());
		result = prime * result + ((modificadoPor == null) ? 0 : modificadoPor.hashCode());
		result = prime * result + ((numeroTelefonico == null) ? 0 : numeroTelefonico.hashCode());
		result = prime * result + ((sistema == null) ? 0 : sistema.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Solicitud other = (Solicitud) obj;
		if (correo == null) {
			if (other.correo != null)
				return false;
		} else if (!correo.equals(other.correo))
			return false;
		if (creadoPor == null) {
			if (other.creadoPor != null)
				return false;
		} else if (!creadoPor.equals(other.creadoPor))
			return false;
		if (estatus == null) {
			if (other.estatus != null)
				return false;
		} else if (!estatus.equals(other.estatus))
			return false;
		if (fechaCreacion == null) {
			if (other.fechaCreacion != null)
				return false;
		} else if (!fechaCreacion.equals(other.fechaCreacion))
			return false;
		if (fechaFin == null) {
			if (other.fechaFin != null)
				return false;
		} else if (!fechaFin.equals(other.fechaFin))
			return false;
		if (fechaInicio == null) {
			if (other.fechaInicio != null)
				return false;
		} else if (!fechaInicio.equals(other.fechaInicio))
			return false;
		if (fechaModificacion == null) {
			if (other.fechaModificacion != null)
				return false;
		} else if (!fechaModificacion.equals(other.fechaModificacion))
			return false;
		if (fechaSolicitud == null) {
			if (other.fechaSolicitud != null)
				return false;
		} else if (!fechaSolicitud.equals(other.fechaSolicitud))
			return false;
		if (finProceso == null) {
			if (other.finProceso != null)
				return false;
		} else if (!finProceso.equals(other.finProceso))
			return false;
		if (formato == null) {
			if (other.formato != null)
				return false;
		} else if (!formato.equals(other.formato))
			return false;
		if (idProceso != other.idProceso)
			return false;
		if (idSolicitud != other.idSolicitud)
			return false;
		if (inicioProceso == null) {
			if (other.inicioProceso != null)
				return false;
		} else if (!inicioProceso.equals(other.inicioProceso))
			return false;
		if (modificadoPor == null) {
			if (other.modificadoPor != null)
				return false;
		} else if (!modificadoPor.equals(other.modificadoPor))
			return false;
		if (numeroTelefonico == null) {
			if (other.numeroTelefonico != null)
				return false;
		} else if (!numeroTelefonico.equals(other.numeroTelefonico))
			return false;
		if (sistema == null) {
			if (other.sistema != null)
				return false;
		} else if (!sistema.equals(other.sistema))
			return false;
		return true;
	}

}
