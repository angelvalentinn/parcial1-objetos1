package Modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AerolineasArgentinas {
	
	private List<Aeropuerto> lstAeropuerto;
	private List<Pasajero> lstPasajeros;
	private List<Vuelo> lstVuelos;
	
	public AerolineasArgentinas() {
		super();
		this.lstAeropuerto = new ArrayList<Aeropuerto>();
		this.lstPasajeros = new ArrayList<Pasajero>();
		this.lstVuelos = new ArrayList<Vuelo>();
	}

	public List<Aeropuerto> getLstAeropuerto() {
		return lstAeropuerto;
	}

	public void setLstAeropuerto(List<Aeropuerto> lstAeropuerto) {
		this.lstAeropuerto = lstAeropuerto;
	}

	public List<Pasajero> getLstPasajeros() {
		return lstPasajeros;
	}

	public void setLstPasajeros(List<Pasajero> lstPasajeros) {
		this.lstPasajeros = lstPasajeros;
	}

	public List<Vuelo> getLstVuelos() {
		return lstVuelos;
	}

	public void setLstVuelos(List<Vuelo> lstVuelos) {
		this.lstVuelos = lstVuelos;
	}
	
	private int generarIdAutoIncrementalAeropuerto() {
		
		int id;
		
		if( this.lstAeropuerto.isEmpty() ) id = 1;
		else id = this.lstAeropuerto.get( this.lstAeropuerto.size() - 1 ).getIdAeropuerto() + 1;
		
		return id;
	}
	
	private int generarIdAutoIncrementalPasajero() {
		
		int id;
		
		if( this.lstPasajeros.isEmpty() ) id = 1;
		else id = this.lstPasajeros.get( this.lstPasajeros.size() - 1 ).getIdPasajero() + 1;
		
		return id;
	}
	
	private int generarIdAutoIncrementalVuelo() {
		
		int id;
		
		if( this.lstVuelos.isEmpty() ) id = 1;
		else id = this.lstVuelos.get( this.lstVuelos.size() - 1 ).getIdVuelo() + 1;
		
		return id;
	}
	
	
	public boolean agregarAeropuerto(String codAeropuerto, String aeropuerto) throws Exception {
		
		if( codAeropuerto.length() != 3)  {
			throw new Exception("Error: La longitud es distinta de 3");
		}
		
		if( !( Character.isLetter(codAeropuerto.charAt(0))
			&& Character.isLetter(codAeropuerto.charAt(1))
			&& Character.isLetter(codAeropuerto.charAt(2)) )
				) {
			throw new Exception("Error: Los caracteres deben ser todos letras");
		}
		
		
		int id = this.generarIdAutoIncrementalAeropuerto();
		
		this.lstAeropuerto.add( new Aeropuerto(id, codAeropuerto, aeropuerto) );
		
		return true;
		
	}
	
	public Aeropuerto traerAeropuerto(String codAeropuerto) {
		
		Aeropuerto a = null;
		int i = 0;
		
		while( a == null && i < this.lstAeropuerto.size() ) {
			
			if( this.lstAeropuerto.get(i).getCodAeropuerto().equals(codAeropuerto) ) {
				a = this.lstAeropuerto.get(i);
			}
			
			i++;
		}
		
		return a;
		
	}
	
	
	public boolean agregarPasajero(String apellido, String nombre, int dni, boolean viajeroFrecuente) {
		
		int id = this.generarIdAutoIncrementalPasajero();
		
		this.lstPasajeros.add( new Pasajero(id, apellido, nombre, dni, viajeroFrecuente) );
		
		return true;
	}
	
	public Pasajero traerPasajero(int dni) {
		
		Pasajero p = null;
		int i = 0;
		
		while( p == null && i < this.lstPasajeros.size() ) {
			
			if( this.lstPasajeros.get(i).getDni() == dni ) p = this.lstPasajeros.get(i);
			
			i++;
		}
		
		return p;
		
	}
	
	
	public boolean agregarVuelo(LocalDate fecha, LocalTime horaSalida, LocalTime horaLlegada, 
			Aeropuerto aeropuertoSalida, Aeropuerto aeropuertoLlegada) throws Exception {
		
		if( aeropuertoLlegada.getCodAeropuerto().equals(aeropuertoSalida.getCodAeropuerto()) ) {
			throw new Exception("Error: Los aeropuertos de salida y llegada no pueden ser los mismos");
		}
		
		int id = this.generarIdAutoIncrementalVuelo();
		
		this.lstVuelos.add( new Vuelo(id, fecha, horaSalida, 
				horaLlegada, aeropuertoSalida, aeropuertoLlegada) );
		
		return true;
		
	}
	
	public Vuelo traerVuelo(int idVuelo) {
		
		Vuelo v = null;
		int i = 0;
		
		while( v == null && i < this.lstVuelos.size() ) {
			
			if( this.lstVuelos.get(i).getIdVuelo() == idVuelo ) v = this.lstVuelos.get(i);
			
			i++;
		}
		
		return v;
		
	}
	
	public List<Vuelo> traerVuelo(LocalDate fecha, Aeropuerto aeropuertoSalida) {
		
		List<Vuelo> vuelos = new ArrayList<Vuelo>();
		
		for(Vuelo v : this.lstVuelos) {
			
			if( v.getFecha().equals(fecha) && 
				v.getAeropuertoSalida().getCodAeropuerto().equals(aeropuertoSalida.getCodAeropuerto()) ) {
				
				vuelos.add(v);
				
			}
			
		}
		
		return vuelos;
		
	}
	
}
