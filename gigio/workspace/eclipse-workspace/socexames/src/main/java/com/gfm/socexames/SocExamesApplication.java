package com.gfm.socexames;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gfm.socexames.common.PacienteVO;
import com.gfm.socexames.dao.DaoFactory;
import com.gfm.socexames.dao.PacienteDao;

@RestController
@SpringBootApplication
public class SocExamesApplication {

	// @GetMapping("/findAllExame")
	// public ResponseEntity<List<ExamePacienteVO>> home() {
	// Connection conn = Config.getConnection();
	// Config.closeConnection();
	// ExamePacienteDao examepacientedao = DaoFactory.createExamePacienteDao();
	// List<ExamePacienteVO> listAll = examepacientedao.findAll();

	// return ResponseEntity.ok().body("ok");
	// }

	@GetMapping(value = "/paciente/{idPaciente}")
	public ResponseEntity<PacienteVO> findById(@PathVariable Integer idPaciente) {
		PacienteDao pacientedao = DaoFactory.createPacienteDao();
		PacienteVO pacientevo = pacientedao.findById(idPaciente);
		return ResponseEntity.ok().body(pacientevo);

	}
	
	@PostMapping
	
	public ResponseEntity<PacienteVO> inserirPaciente(@RequestBody PacienteVO paciente){
		
		
		return ResponseEntity.ok().body(paciente);
		
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SocExamesApplication.class, args);

		// ExamePacienteVO exame = new ExamePacienteVO(0, "nome do exame", new Date(),
		// "observacao aqui", "resultado do exame", paciente);

		// PacienteVO paciente = new PacienteVO(1, "Giovanni");
		// ExamePacienteDaoJDBC examepacientedao = DaoFactory.createExamePacienteDao();
		// System.out.println("examePaciente findbyPaciente: ");
		// List<ExamePacienteVO> list = examepacientedao.findByPaciente(paciente);

		// for(ExamePacienteVO obj: list) {
		// System.out.println(obj);
		// }
		/*
		 * System.out.println("examePaciente findAll: "); List<ExamePacienteVO> listAll
		 * = examepacientedao.findAll();
		 * 
		 * for(ExamePacienteVO obj: listAll) { System.out.println(obj); }
		 * 
		 * System.out.println("examePaciente insertExamePaciente: "); ExamePacienteVO
		 * novoExame = new ExamePacienteVO(null, "nome do exame", new Date(),
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

		// PacienteDao pacientedao = DaoFactory.createPacienteDao();
		// System.out.println("examePaciente insertExamePaciente: ");

		// PacienteVO novoPaciente = new PacienteVO(null, "Vinicius");
		// pacientedao.insert(novoPaciente);
		// System.out.println("o novo paciente id é: "+ novoPaciente.getIdPaciente());

	}

}
