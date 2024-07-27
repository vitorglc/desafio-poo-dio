package br.com.dio.desafio.dominio;

import java.time.LocalDate;

public class Certificado {
    @Override
    public String toString() {
        return "Certificado [curso=" + curso + ", aluno=" + aluno + ", data=" + data + "]";
    }
    private Conteudo curso;
    private String aluno;
    private LocalDate data;

    public Certificado(Conteudo curso, String aluno, LocalDate data) {
        this.curso = curso;
        this.aluno = aluno;
        this.data = (LocalDate.now());   
    }

    public Conteudo getCurso() {
        return curso;
    }

    public String getAluno() {
        return aluno;
    }
    public LocalDate getData() {
        return data;
    }

}
