import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

public class Main {
    public static void main(String[] args) {
        Curso curso1 = new Curso("curso java","descrição curso java",8);
        Curso curso2 = new Curso("curso js","descrição curso js",4);

        Mentoria mentoria = new Mentoria("mentoria de java","descrição mentoria java");

        Bootcamp bootcamp = new Bootcamp("Bootcamp Java Developer","Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        Dev devCamila = new Dev("Camila");
        devCamila.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos Camila:" + devCamila.getConteudosInscritos());
        devCamila.progredir(devCamila.getConteudoInscrito("curso java"), bootcamp);
        System.out.println("-");
        System.out.println("Conteúdos Inscritos Camila:" + devCamila.getConteudosInscritos());
        System.out.println("Conteúdos Concluídos Camila:" + devCamila.getConteudosConcluidos());
        System.out.println("XP:" + devCamila.calcularTotalXp());

        System.out.println("-------");

        Dev devJoao = new Dev("Joao");
        devJoao.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos João:" + devJoao.getConteudosInscritos());
        devJoao.progredir(devJoao.getConteudoInscrito("curso java"), bootcamp);
        System.out.println("-");
        System.out.println("Conteúdos Inscritos João:" + devJoao.getConteudosInscritos());
        devJoao.progredir(mentoria, bootcamp);
        devJoao.progredir(curso1, bootcamp);
        devJoao.progredir(curso2, bootcamp);

        System.out.println("Conteúdos Concluidos João:" + devJoao.getConteudosConcluidos());
        System.out.println("XP:" + devJoao.calcularTotalXp());
        System.out.println( bootcamp.toString());
        System.out.println("Bootcamps Concluidos João:" + devJoao.getBootcampsConcluidos());
        System.out.println("Certificados João:" + devJoao.getMeusCertificados());


    }

}
