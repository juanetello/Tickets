package com.juan.ejercicio.tickets.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.juan.ejercicio.tickets.entity.Estados;

@Repository
public class EstadosDao {
	
	private static final List<Estados> estados = new ArrayList<Estados>();

	static {
		initData();
	}
	
	private static void initData() {
		
		Estados abierto = new Estados(1L, "abierto", "Abierto");
		Estados cerrado = new Estados(2L, "cerrado", "Cerrado");
		Estados pendiente = new Estados(3L, "pendiente", "Pendiente");
		Estados resuelto = new Estados(4L, "resuelto", "Resuelto");
		
		estados.add(abierto);
		estados.add(cerrado);
		estados.add(pendiente);
		estados.add(resuelto);
	}

	public static List<Estados> getEstados() {
		return estados;
	}
	
	public Map<Long, String> getMapEstados(){
		Map<Long, String> mapEstados = new HashMap<Long, String>();
		for (Estados estado : estados) {
			mapEstados.put(estado.getIdEstado(), estado.getNombreEstado());
		}
		return mapEstados;
	}
	
}
