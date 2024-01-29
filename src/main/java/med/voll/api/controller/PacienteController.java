package med.voll.api.controller;

import med.voll.api.paciente.dto.DadosAtualizarPaciente;
import med.voll.api.paciente.dto.DadosCadastroPaciente;
import med.voll.api.paciente.dto.DadosListagemPaciente;
import med.voll.api.paciente.entity.Paciente;
import med.voll.api.paciente.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RequestMapping("pacientes")
@RestController
public class PacienteController {

    @Autowired
    PacienteRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroPaciente dados){
        repository.save(new Paciente(dados));
    }

    @GetMapping
    public Page<DadosListagemPaciente> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemPaciente::new);
    }

    @PutMapping("/{id}")
    @Transactional
    public void atualizar (@PathVariable Long id, @RequestBody @Valid DadosAtualizarPaciente dados){
        var paciente = repository.getReferenceById(id);
        paciente.atualizar(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir (@PathVariable Long id){
        var paciente = repository.getReferenceById(id);
        paciente.excluir();
    }


}
