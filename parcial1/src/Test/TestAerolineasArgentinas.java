package Test;

import java.time.LocalDate;
import java.time.LocalTime;

import Modelo.*;

public class TestAerolineasArgentinas {

	public static void main(String[] args) throws Exception {
		
		
		AerolineasArgentinas aa = new AerolineasArgentinas();
		
		System.out.println("1 - 1");
		try {
			aa.agregarAeropuerto("BUE", "BUENOS AIRES");
			aa.agregarAeropuerto("COR", "CORDOBA");
			aa.agregarAeropuerto("BRC", "BARILOCHE");
			
			for(Aeropuerto a : aa.getLstAeropuerto() ) {
				System.out.println(a.toString());
			}
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
		//ERROR
		System.out.println("1 - 2");
		try {
			
			aa.agregarAeropuerto("2BHI", "BAHIA BLANCA");
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
		System.out.println("2");
		System.out.println(aa.traerAeropuerto("COR"));
		
		
		System.out.println("3");
		try {
			
			aa.agregarPasajero("Ruina", "Oscar", 11111111, false);
			aa.agregarPasajero("Scordomaglia", "Ezequiel", 22222222, true);
			aa.agregarPasajero("Siciliano", "Gustavo", 33333333, true);
			aa.agregarPasajero("Vranic", "Alejandra", 44444444, false);
			aa.agregarPasajero("Altieri", "Angel", 55555555, true);
			
			for(Pasajero p : aa.getLstPasajeros() ) {
				System.out.println(p.toString());
			}
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
		System.out.println("4");
		System.out.println(aa.traerPasajero(55555555));
		
		Aeropuerto bue = aa.traerAeropuerto("BUE");
		Aeropuerto cor = aa.traerAeropuerto("COR");
		Aeropuerto brc = aa.traerAeropuerto("BRC");
		
		System.out.println("5");
		try {
			
			aa.agregarVuelo(LocalDate.of(2024, 9, 28), LocalTime.of(10, 30), 
				LocalTime.of(12, 30), bue, cor);
			
			aa.agregarVuelo(LocalDate.of(2024, 9, 29), LocalTime.of(18, 00), 
					LocalTime.of(20, 00), cor, bue);
			
			aa.agregarVuelo(LocalDate.of(2024, 9, 30), LocalTime.of(6, 00), 
					LocalTime.of(8, 00), bue, brc);
			
			for(Vuelo v : aa.getLstVuelos()) {
				System.out.println(v.toString());
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		//ERROR
		System.out.println("5-2");
		try {
			aa.agregarVuelo(LocalDate.of(2024, 10, 1), LocalTime.of(5,0), 
				LocalTime.of(5,0), bue, bue);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("6");
		System.out.println(aa.traerVuelo(3));
		
		System.out.println("7");
		System.out.println(aa.traerVuelo(3).calcularTiempoVuelo());
		
		System.out.println("8");
		try {
			
			Pasajero ezequiel = aa.traerPasajero(22222222);
			Pasajero elejandra = aa.traerPasajero(44444444);
			
			aa.traerVuelo(1).agregar(elejandra);
			aa.traerVuelo(1).agregar(ezequiel);
			
			System.out.println("Pasajeros del vuelo 1:");
			for(Pasajero p : aa.traerVuelo(1).getLstPasajeros()) {
				System.out.println(p.toString());
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("9");
		for(Vuelo v : aa.traerVuelo(LocalDate.of(2024, 9, 29), cor)) {
			System.out.println(v.toString());
		}
	}

}

