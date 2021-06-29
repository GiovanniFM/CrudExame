package com.gfm.socexames.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gfm.socexames.entities.ExamePaciente;
import com.gfm.socexames.entities.Paciente;
import com.gfm.socexames.services.ExamePacienteService;
import com.gfm.socexames.services.PacienteService;

@RestController
@RequestMapping("/exames")
public class ExamePacienteResource {	
	
	

	@GetMapping(value = "/paciente/{idPaciente}")
	public ResponseEntity<Paciente> examesPaciente(@PathVariable Integer idPaciente) {
		ExamePacienteService pacienteService = new ExamePacienteService();				
		return ResponseEntity.ok().body(pacienteService.findById(idPaciente));

	}	

	
	@GetMapping(value = "/listar")
	public ResponseEntity<List<Paciente>> listarExamesPacientes(){
		ExamePacienteService examePacienteService = new ExamePacienteService();
		List<Paciente> pacientes = examePacienteService.listarExames();
		return ResponseEntity.ok().body(pacientes);
	}
	
	@PostMapping(value = "/inserir")
	public ResponseEntity<Paciente> insert(@RequestBody Paciente paciente){
		ExamePacienteService examePacienteService = new ExamePacienteService();
		examePacienteService.insertExames(paciente.getIdPaciente(), paciente.getExamePacienteVO());		
		return ResponseEntity.ok().body(paciente);
	}
	
	@PutMapping(value = "/")
	public ResponseEntity<ExamePaciente> update(@RequestBody ExamePaciente examePaciente){
		ExamePacienteService examePacienteService = new ExamePacienteService();
		ExamePaciente uptExame = examePacienteService.updateExame(examePaciente);
		return ResponseEntity.ok().body(uptExame) ;
	}
	
	
	@DeleteMapping(value = "/{idExamePaciente}")
	public ResponseEntity<Void> deleteExame(@PathVariable Integer idExamePaciente){
		ExamePacienteService examePacienteService = new ExamePacienteService();
		examePacienteService.delete(idExamePaciente);	
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/pacientes/listar")
	public ResponseEntity<List<Paciente>> listarPacientes(){
		PacienteService pacienteService = new PacienteService();
		List<Paciente> pacientes = pacienteService.listarPacientes();
		return ResponseEntity.ok().body(pacientes);
	}

	@PostMapping(value = "/pacientes/inserir")
	public ResponseEntity<Paciente> inserirPaciente(@RequestBody Paciente paciente) {
		PacienteService pacienteService = new PacienteService();
		paciente = pacienteService.insert(paciente);

		return ResponseEntity.ok().body(paciente);
	}
	 
	@GetMapping(value = "/pacientes/{idPaciente}")
	public ResponseEntity<Paciente> findById(@PathVariable Integer idPaciente) {
		PacienteService pacienteService = new PacienteService();		
		Paciente paciente = pacienteService.findById(idPaciente);
		return ResponseEntity.ok().body(paciente);

	}		
	
	
	
	
}
