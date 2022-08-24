package Candidatura;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {

        System.out.println("-=-=-=-= PROCESSO SELETIVO 1.0  =-=-=-=-");
        //analisarCandidatos();
        //selecaoCandidatos();
        //imprimirSelecionados();
        ligarCandidatos();


    }



    static void selecaoCandidatos(){

        String [] candidatos = {"MARCELO", "FLORA", "SARA", "GABRIEL", "NELSON", "ROSANGELA",
                "PATRICIA", "FELIPE", "FABIANA", "ULISSES", "AUGUSTO", "GLORIA", "CARLOS"};
        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000d;

        while(candidatosSelecionados < 5 && candidatosAtual < candidatos.length){
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido =   valorPretendido();
            System.out.println("O candidato " + candidato + " solicitou este valor de salário " + salarioPretendido);
            if(salarioBase >= salarioPretendido){
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga");
                candidatosSelecionados++;
            }
            candidatosAtual++;
        }


    }

    static void analisarCandidato(double salarioPretendido){

        double salarioBase = 2000d;

        if(salarioBase > salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO");
        } else if(salarioBase == salarioPretendido){
            System.out.println("LIGAR PARA O CANDIDATO E EFETUAR CONTRA PROPOSTA");
        } else {
            System.out.println("AGUADANDO O RESULTADO DOS DEMAIS CANDIDATOS");
        }

    }

    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void imprimirSelecionados(){
        String [] candidatos = {"MARCELO", "FLORA", "SARA", "GABRIEL", "ROSANGELA"};

        System.out.println("-=-=-=-= IMPRIMINDO LISTA DE CANDIDATOS COM SEUS ÍNDICES =-=-=-=-");

        for(int indice = 0; indice < candidatos.length; indice++){
            System.out.println("O candidato de nº " + (indice + 1) + " é o(a) " + candidatos[indice]);
        }

        System.out.println("-=-=-=-= IMPRIMINDO LISTA DE CANDIDATOS DE FORMA ABREVIADA =-=-=-=-");

        for (String candidato: candidatos) {
            System.out.println("O candidato selecionado foi " + candidato);
        }

    }

    static void ligarCandidatos(){
        String [] candidatos = {"MARCELO", "FLORA", "SARA", "GABRIEL", "ROSANGELA"};

        System.out.println("-=-=-=-= LIGANDO PARA OS CANDIDATOS =-=-=-=-=-");

        for (String candidato: candidatos) {
            entrandoEmContato(candidato);
        }


    }

    static void entrandoEmContato(String candidato){
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;

        do{
            atendeu = atender();
            continuarTentando = !atendeu;
            if(continuarTentando){
                tentativasRealizadas++;
            }else{
                System.out.println("CONTATO REALIZADO COM SUCESSO!");
            }
        }while(continuarTentando && tentativasRealizadas < 3);

        if(atendeu){
            System.out.println("CONSEGUIMOS CONTATO COM "
                    + candidato
                    + " NA "
                    + tentativasRealizadas
                    + " TENTATIVA.");
        }else{
            System.out.println("NÃO CONSEGUIMOS CONTATO COM "
                    + candidato
                    + " NÚMERO MAXIMO TENTATIVAS "
                    + tentativasRealizadas
                    + " REALIZADA.");
        }
    }


    static boolean atender(){
        return new Random().nextInt(3) == 1;
    }





}
