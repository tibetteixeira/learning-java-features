package io.github.tibetteixeira.java_initial_versions.reflection.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa implements Cloneable, Serializable {

    private Long id;
    private String cpf;
    private String nome;
    public String apelido;

    public String getPessoaFormatada() {
        return cpf + " " + nome;
    }

    public void setPessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String setCpfComRetorno(String cpf) {
        this.cpf = cpf;
        return this.cpf;
    }
}
