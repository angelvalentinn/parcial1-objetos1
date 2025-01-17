package Modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Vuelo {
	
	private int idVuelo;
	private LocalDate fecha;
	private LocalTime horaSalida;
	private LocalTime horaLlegada;
	private Aeropuerto aeropuertoSalida;
	private Aeropuerto aeropuertoLlegada;
	private List<Pasajero> lstPasajeros;
	
	public Vuelo(int idVuelo, LocalDate fecha, LocalTime horaSalida, LocalTime horaLlegada, Aeropuerto aeropuertoSalida,
			Aeropuerto aeropuertoLlegada) {
		super();
		this.idVuelo = idVuelo;
		this.fecha = fecha;
		this.horaSalida = horaSalida;
		this.horaLlegada = horaLlegada;
		this.aeropuertoSalida = aeropuertoSalida;
		this.aeropuertoLlegada = aeropuertoLlegada;
		this.lstPasajeros = new ArrayList<Pasajero>();
	}

	public int getIdVuelo() {
		return idVuelo;
	}

	public void setIdVuelo(int idVuelo) {
		this.idVuelo = idVuelo;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(LocalTime horaSalida) {
		this.horaSalida = horaSalida;
	}

	public LocalTime getHoraLlegada() {
		return horaLlegada;
	}

	public void setHoraLlegada(LocalTime horaLlegada) {
		this.horaLlegada = horaLlegada;
	}

	public Aeropuerto getAeropuertoSalida() {
		return aeropuertoSalida;
	}

	public void setAeropuertoSalida(Aeropuerto aeropuertoSalida) {
		this.aeropuertoSalida = aeropuertoSalida;
	}

	public Aeropuerto getAeropuertoLlegada() {
		return aeropuertoLlegada;
	}

	public void setAeropuertoLlegada(Aeropuerto aeropuertoLlegada) {
		this.aeropuertoLlegada = aeropuertoLlegada;
	}

	public List<Pasajero> getLstPasajeros() {
		return lstPasajeros;
	}

	public void setLstPasajeros(List<Pasajero> lstPasajeros) {
		this.lstPasajeros = lstPasajeros;
	}
	
	public int calcularTiempoVuelo() {

		int salidaEnMinutos = this.horaSalida.getHour() * 60 + this.horaSalida.getMinute();
		int llegadaEnMinutos = this.horaLlegada.getHour() * 60 + this.horaSalida.getMinute();
	
		return llegadaEnMinutos - salidaEnMinutos;
	}
	
	public boolean agregar(Pasajero pasajero) {
		
		this.lstPasajeros.add(pasajero);
		
		return true;
		
	}

	@Override
	public String toString() {
		return "Vuelo [idVuelo=" + idVuelo + ", fecha=" + fecha + ", horaSalida=" + horaSalida + ", horaLlegada="
				+ horaLlegada + ", aeropuertoSalida=" + aeropuertoSalida + ", aeropuertoLlegada=" + aeropuertoLlegada
				+ ", lstPasajeros=" + lstPasajeros + "]";
	}
	
	
}
