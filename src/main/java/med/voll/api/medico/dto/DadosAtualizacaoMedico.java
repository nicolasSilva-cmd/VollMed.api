package med.voll.api.medico.dto;

import med.voll.api.endereco.DadosEndereco;

import javax.validation.constraints.NotNull;

public record DadosAtualizacaoMedico(@NotNull Long id,
                                     String nome,
                                     String email,
                                     String crm,
                                     DadosEndereco endereco) {


}
