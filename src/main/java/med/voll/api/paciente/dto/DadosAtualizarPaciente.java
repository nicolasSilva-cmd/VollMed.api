package med.voll.api.paciente.dto;

import med.voll.api.endereco.DadosEndereco;

public record DadosAtualizarPaciente(String nome, String telefone, DadosEndereco endereco) {
}
