package med.voll.api.medico.dto;

import med.voll.api.medico.Especialidade;
import med.voll.api.medico.entity.Medico;

public record DadosListagemMedico(Long id, String nome, String crm, String email, Especialidade especialidade) {

    public DadosListagemMedico(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getCrm(), medico.getEmail(), medico.getEspecialidade());
    }

}
