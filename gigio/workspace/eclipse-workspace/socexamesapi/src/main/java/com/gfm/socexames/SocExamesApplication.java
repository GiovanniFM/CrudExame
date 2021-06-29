package com.gfm.socexames;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SocExamesApplication {

	
	/*
	 * @GetMapping("/findAllExame") public ResponseEntity<List<ExamePaciente>>
	 * home() {
	 * 
	 * //List<ExamePaciente> listAll = ExamePacienteService.listarExames();
	 * 
	 * return ResponseEntity.ok().body(listAll); }
	 */
	 

	/*
	 * @GetMapping(value = "/paciente/{idPaciente}") public ResponseEntity<Paciente>
	 * findById(@PathVariable Integer idPaciente) { PacienteDao pacientedao =
	 * EntitiesRepository.createPacienteDao(); Paciente pacientevo =
	 * pacientedao.findById(idPaciente); return
	 * ResponseEntity.ok().body(pacientevo);
	 * 
	 * }
	 * 
	 * @PostMapping(value = "/inserirExames/") public ResponseEntity<Paciente>
	 * inserirPaciente(@RequestBody Paciente paciente){ ExamePacienteService
	 * examePaciente = new ExamePacienteService();
	 * examePaciente.inserirExames(paciente);
	 * 
	 * return ResponseEntity.ok().body(paciente); }
	 */
	
	public static void main(String[] args) {
		SpringApplication.run(SocExamesApplication.class, args);

		// ExamePaciente exame = new ExamePaciente(0, "nome do exame", new Date(),
		// "observacao aqui", "resultado do exame", paciente);

		// Paciente paciente = new Paciente(1, "Giovanni");
		// ExamePacienteRepository examepacientedao = EntitiesRepository.createExamePacienteDao();
		// System.out.println("examePaciente findbyPaciente: ");
		// List<ExamePaciente> list = examepacientedao.findByPaciente(paciente);

		// for(ExamePaciente obj: list) {
		// System.out.println(obj);
		// }
		/*
		 * System.out.println("examePaciente findAll: "); List<ExamePaciente> listAll
		 * = examepacientedao.findAll();
		 * 
		 * for(ExamePaciente obj: listAll) { System.out.println(obj); }
		 * 
		 * System.out.println("examePaciente insertExamePaciente: "); ExamePaciente
		 * novoExame = new ExamePaciente(null, "nome do exame", new Date(),
		 * "observacao aqui", "resultado do exame", examepaciente.getPaciente());
		 * examepacientedao.insert(novoExame); System.out.println("o novo id é: "+
		 * novoExame.getIdexamepaciente());
		 * 
		 * 
		 * System.out.println("examePaciente updateExamePaciente: ");
		 * examepaciente.setNomeExame("Sangue"); examepaciente.setObservacao("");
		 * examepaciente.setResultadoExame(null);
		 * examepacientedao.update(examepaciente);
		 * System.out.println("o novo exame é: "+ examepaciente.getNomeExame());
		 * 
		 * System.out.println("examePaciente deleteExamePaciente: "); Integer idDel =
		 * novoExame.getIdexamepaciente(); examepacientedao.deletebyId(idDel);
		 * System.out.println("deletou o registro: "+ idDel.toString());
		 */

		// PacienteDao pacientedao = EntitiesRepository.createPacienteDao();
		// System.out.println("examePaciente insertExamePaciente: ");

		// Paciente novoPaciente = new Paciente(null, "Vinicius");
		// pacientedao.insert(novoPaciente);
		// System.out.println("o novo paciente id é: "+ novoPaciente.getIdPaciente());

	}

}
