package Etapa2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ValidadorEtapa2EstudanteMRK {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_VERDE = "\u001B[32m";
    private static final String ANSI_VERMELHO = "\u001B[31m";
    private static final String ANSI_LARANJA = "\u001B[38;5;208m";

    private static int totalTestes = 0;
    private static int acertos = 0;

    public static void main(String[] args) {
        System.out.println(ANSI_LARANJA + "+----------------------------------------------------------+");
        System.out.println("|         Etapa 2 | Validador com Nota do Estudante        |");
        System.out.println("+----------------------------------------------------------+" + ANSI_RESET);

        validaClasse("Candidato");
        validaAtributo("Candidato", "nome");
        validaAtributo("Candidato", "partido");
        validaAtributo("Candidato", "intencoesVotos");
        validaMetodo("Candidato", "getNome");
        validaMetodo("Candidato", "setNome", String.class);
        validaMetodo("Candidato", "getPartido");
        validaMetodo("Candidato", "setPartido", String.class);
        validaMetodo("Candidato", "getIntencoesVotos");
        validaMetodo("Candidato", "setIntencoesVotos", int.class);
        validaMetodo("Candidato", "toString");

        validaClasse("OrdenarCandidatos");
        validaMetodo("OrdenarCandidatos", "ordenaCandidatosPorNome", Candidato[].class);
        validaMetodo("OrdenarCandidatos", "ordenaCandidatosPorVotos", Candidato[].class);
        validaMetodo("OrdenarCandidatos", "ordenaCandidatosPorPartido", Candidato[].class);
        validaMetodo("OrdenarCandidatos", "pesquisaBinariaCandidatos", Candidato[].class, String.class);

        validaClasse("PrincipalCandidatos");
        validaMetodo("PrincipalCandidatos", "main", String[].class);
        validaChamadasMetodosOrdenacao("src/Etapa2/PrincipalCandidatos.java");

        System.out.println(ANSI_LARANJA + "+----------------------------------------------------------+" + ANSI_RESET);
        double notaFinal = totalTestes > 0 ? 1.5 * ((double) acertos / totalTestes) : 0.0;
        System.out.printf(ANSI_LARANJA + "| %-65s |%n",
                String.format("Nota final: %.2f/1.50 (%d acertos em %d testes)", notaFinal, acertos, totalTestes));
        System.out.println("+----------------------------------------------------------+" + ANSI_RESET);
    }

    private static void contabilizaTeste(boolean sucesso) {
        totalTestes++;
        if (sucesso)
            acertos++;
    }

    private static void validaClasse(String nomeClasse) {
        try {
            Class.forName("Etapa2." + nomeClasse);
            System.out.println(formatarMensagem("[OK] Classe " + nomeClasse + " encontrada.", true));
            contabilizaTeste(true);
        } catch (ClassNotFoundException e) {
            System.out.println(formatarMensagem("[NOK] Classe " + nomeClasse + " não encontrada.", false));
            contabilizaTeste(false);
        }
    }

    private static void validaMetodo(String nomeClasse, String nomeMetodo, Class<?>... parametros) {
        try {
            Class<?> classe = Class.forName("Etapa2." + nomeClasse);
            classe.getDeclaredMethod(nomeMetodo, parametros);
            System.out.println(formatarMensagem("[OK] Método " + nomeMetodo + " encontrado.", true));
            contabilizaTeste(true);
        } catch (Exception e) {
            System.out.println(formatarMensagem("[NOK] Método " + nomeMetodo + " não encontrado.", false));
            contabilizaTeste(false);
        }
    }

    private static void validaAtributo(String nomeClasse, String nomeAtributo) {
        try {
            Class<?> classe = Class.forName("Etapa2." + nomeClasse);
            Field campo = classe.getDeclaredField(nomeAtributo);
            System.out.println(formatarMensagem("[OK] Atributo " + nomeAtributo + " encontrado.", true));
            contabilizaTeste(true);
        } catch (Exception e) {
            System.out.println(formatarMensagem("[NOK] Atributo " + nomeAtributo + " não encontrado.", false));
            contabilizaTeste(false);
        }
    }

    private static void validaChamadasMetodosOrdenacao(String caminhoArquivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            boolean chamouPorNome = false;
            boolean chamouPorVotos = false;
            boolean chamouPorPartido = false;

            while ((linha = br.readLine()) != null) {
                if (linha.trim().startsWith("//"))
                    continue;
                if (linha.contains("OrdenarCandidatos.ordenaCandidatosPorPartido"))
                    chamouPorPartido = true;
                if (linha.contains("OrdenarCandidatos.ordenaCandidatosPorVotos"))
                    chamouPorVotos = true;
                if (linha.contains("OrdenarCandidatos.ordenaCandidatosPorNome"))
                    chamouPorNome = true;
            }

            if (chamouPorNome && chamouPorVotos && chamouPorPartido) {
                System.out.println(formatarMensagem("[OK] Todos os métodos de ordenação foram chamados.", true));
                contabilizaTeste(true);
            } else {
                if (!chamouPorNome) {
                    System.out
                            .println(formatarMensagem("[NOK] Método ordenaCandidatosPorNome não foi chamado.", false));
                    contabilizaTeste(false);
                }
                if (!chamouPorVotos) {
                    System.out
                            .println(formatarMensagem("[NOK] Método ordenaCandidatosPorVotos não foi chamado.", false));
                    contabilizaTeste(false);
                }
                if (!chamouPorPartido) {
                    System.out.println(
                            formatarMensagem("[NOK] Método ordenaCandidatosPorPartido não foi chamado.", false));
                    contabilizaTeste(false);
                }
            }
        } catch (IOException e) {
            System.out.println(formatarMensagem("[NOK] Erro ao validar chamadas: " + e.getMessage(), false));
            contabilizaTeste(false);
        }
    }

    private static String formatarMensagem(String mensagem, boolean ok) {
        return String.format((ok ? ANSI_VERDE : ANSI_VERMELHO) + "| %-56s |" + ANSI_RESET, mensagem);
    }
}
