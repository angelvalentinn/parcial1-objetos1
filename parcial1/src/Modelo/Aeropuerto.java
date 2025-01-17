package Modelo;

public class Aeropuerto {
	
	private int idAeropuerto;
	private String codAeropuerto;
	private String aeropuerto;
	
	public Aeropuerto(int idAeropuerto, String codAeropuerto, String aeropuerto) {
		super();
		this.idAeropuerto = idAeropuerto;
		this.codAeropuerto = codAeropuerto;
		this.aeropuerto = aeropuerto;
	}

	public int getIdAeropuerto() {
		return idAeropuerto;
	}

	public void setIdAeropuerto(int idAeropuerto) {
		this.idAeropuerto = idAeropuerto;
	}

	public String getCodAeropuerto() {
		return codAeropuerto;
	}

	public void setCodAeropuerto(String codAeropuerto) {
		this.codAeropuerto = codAeropuerto;
	}

	public String getAeropuerto() {
		return aeropuerto;
	}

	public void setAeropuerto(String aeropuerto) {
		this.aeropuerto = aeropuerto;
	}

	@Override
	public String toString() {
		return "Aeropuerto [idAeropuerto=" + idAeropuerto + ", codAeropuerto=" + codAeropuerto + ", aeropuerto="
				+ aeropuerto + "]";
	}
	
	
}
