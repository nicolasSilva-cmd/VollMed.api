package med.voll.api.medico.dto;

import med.voll.api.endereco.DadosEndereco;
import med.voll.api.medico.Especialidade;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

// Aqui, especialidade é composta por somente 4 opções, então, é criado um ENUM para representar essas opções.
// Na hora da requisição, pelo tipo da especialidade ser enums em MAIUSCULO, a requisição deverá ser feita também
// em maiúsculo.
public record DadosCadastroMedico(
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,
        @NotNull
        Especialidade especialidade,
        @NotNull
        @Valid
        DadosEndereco endereco) {
}
