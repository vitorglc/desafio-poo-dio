package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.util.*;

public class Dev {
    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();
    private Set<Bootcamp> bootcampsConcluidos = new LinkedHashSet<>();
    private List<Certificado> meusCertificados = new ArrayList<>();

    public Dev(String nome) {
        this.nome = nome;
    }
    public void inscreverBootcamp(Bootcamp bootcamp){
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);
    }

    public void progredir(Conteudo conteudo, Bootcamp bootcamp) {
        if(conteudo !=null) {
            this.conteudosConcluidos.add(conteudo);
            this.conteudosInscritos.remove(conteudo);
            this.meusCertificados.add(new Certificado(conteudo, this.nome, LocalDate.now()));

        } else {
            System.err.println("Você não está matriculado em nenhum conteúdo!");
        }

        if(this.conteudosConcluidos.equals(bootcamp.getConteudos())){
            this.bootcampsConcluidos.add(bootcamp);
            System.out.println("Bootcamp Concluido!Parabens!");
        }
    }

    public double calcularTotalXp() {
        Iterator<Conteudo> iterator = this.conteudosConcluidos.iterator();
        double soma = 0;
        while(iterator.hasNext()){
            double next = iterator.next().calcularXp();
            soma += next;
        }
        return soma;

        /*return this.conteudosConcluidos
                .stream()
                .mapToDouble(Conteudo::calcularXp)
                .sum();*/
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Conteudo getConteudoInscrito(String titulo) {
        Conteudo conteudo = null;
        for(Conteudo c : this.conteudosInscritos){
            if(titulo == c.getTitulo()){
                conteudo = c;
            }
        }

        return conteudo;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }

    public Set<Bootcamp> getBootcampsConcluidos() {
        return bootcampsConcluidos;
    }

    public List<Certificado> getMeusCertificados() {
        return meusCertificados;
    }
    public void concluirBootcamp(Bootcamp bootcamp){
        this.bootcampsConcluidos.add(bootcamp);
        System.out.println("Bootcamp Concluido!Parabens!");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) && Objects.equals(conteudosInscritos, dev.conteudosInscritos) && Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudosInscritos, conteudosConcluidos);
    }
}
