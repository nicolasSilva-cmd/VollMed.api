package med.voll.api.paciente.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.Endereco;
import med.voll.api.paciente.dto.DadosAtualizarPaciente;
import med.voll.api.paciente.dto.DadosCadastroPaciente;

import javax.persistence.*;

@Table(name = "Pacientes")
@Entity(name = "paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String telefone;

    private String CPF;

    @Embedded
    private Endereco endereco;

    private Boolean ativo;
    public Paciente(DadosCadastroPaciente dados){
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.CPF = dados.CPF();
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizar(DadosAtualizarPaciente dados){
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.telefone() != null){
            this.telefone = dados.telefone();
        }
        if(dados.endereco() != null){
            this.endereco.atualizar(dados.endereco());
        }
    }

    public void excluir(){
        this.ativo = false;
    }


}
