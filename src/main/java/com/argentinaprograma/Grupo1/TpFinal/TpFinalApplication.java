package com.argentinaprograma.Grupo1.TpFinal;

import com.argentinaprograma.Grupo1.TpFinal.model.*;
import com.argentinaprograma.Grupo1.TpFinal.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;


@SpringBootApplication


public class TpFinalApplication {
	private static ClienteService clienteService;
	private static ServicioService servicioService;
	private static TecnicoService tecnicoService;
	private static EspecialidadService especialidadService;
	private  static TipoProblemaService tipoProblemaService;
	private static IncidenteService incidenteService;
	private static MedioComunicacionService medioComunicacionService;
	@Autowired
	public TpFinalApplication(
							  ClienteService clienteService,
							  ServicioService servicioService,
							  TecnicoService tecnicoService,
							  EspecialidadService especialidadService,
							  IncidenteService incidenteService,
							  MedioComunicacionService medioComunicacionService,
							  TipoProblemaService tipoProblemaService
	)
	{
		this.clienteService = clienteService;
		this.servicioService = servicioService;
		this.tecnicoService = tecnicoService;
		this.especialidadService = especialidadService;
		this.incidenteService = incidenteService;
		this.medioComunicacionService = medioComunicacionService;
		this.tipoProblemaService = tipoProblemaService;

	}

	public static void main(String[] args) {

		SpringApplication.run(TpFinalApplication.class, args);

		inicializarEntidades();





		System.out.println("Funca todo ok ok");
	}

	private static void inicializarEntidades(){

		MedioComunicacion m1 = new MedioComunicacion(1,MedioEnum.WHATSAPP,"Pedro");

		m1.setId(medioComunicacionService.guardar(m1));

		Especialidad e1 = new Especialidad(1,"Windows","soporte de windows");

		e1.setId(especialidadService.guardar(e1));

		Tecnico t1 = new Tecnico(1,"Pedro","Gonzales",List.of(e1),m1);

		t1.setId(tecnicoService.guardar(t1));

		Servicio s1= new Servicio(1,"Windows","esto es un servicio de windows ");

		s1.setId(servicioService.guardar(s1));

		TipoProblema tp1 = new TipoProblema(1,"error al cargar widows", 12,24 );

		tp1.setId(tipoProblemaService.guardar(tp1));

		Cliente c1 = new Cliente(1,1234,"mail@mail","primerempresa","juan","pablo",s1);

		c1.setId(clienteService.guardar(c1));


		//Borrar por id
		// Primero se guarda  y despues de borra?


        c1.setId(clienteService.deleteById(c1).getId());


		c1.setId(clienteService.buscarPorId(c1).getId());


		Incidente i1 = new Incidente(
				1,
				"no carga windows",
				"pantalla azul de windows cuando inicia",
				LocalDate.now(),
				LocalDate.of(2023,11,26),
				LocalDate.of(2023,11,25),
				EstadoEnum.INCOMPLETO,
				"es un servidor",
				c1,tp1,List.of(s1), List.of(e1),t1);
		i1.setId(incidenteService.guardar(i1));


	}

}
