package controleBoletimOcorrencia;

import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);

        GerenciadorOcorrencias gerenciador =
                new GerenciadorOcorrencias();
        
        cadastrarDadosIniciais(gerenciador);
        int opcao;

        do {
            System.out.println("\n====================================");
            System.out.println(" SIGO - GESTÃO DE OCORRÊNCIAS");
            System.out.println("====================================");
            System.out.println("1 - Cadastrar boletim");
            System.out.println("2 - Buscar boletim");
            System.out.println("3 - Alterar boletim");
            System.out.println("4 - Excluir boletim");
            System.out.println("5 - Listar boletins");
            System.out.println("6 - Listar boletins ordenados");
            System.out.println("7 - Visualizar histórico");
            System.out.println("0 - Sair");
            System.out.println("====================================");
            System.out.print("Escolha uma opção: ");

            opcao = entrada.nextInt();

            switch (opcao) {

                case 1:
                    System.out.println(
                        "Cadastro será implementado na próxima etapa."
                    );
                    break;

                case 2:
                    System.out.print("Número do BO: ");
                    int numeroBusca = entrada.nextInt();

                    Ocorrencia encontrada =
                            gerenciador.buscarPorNumero(numeroBusca);

                    if (encontrada != null) {
                        System.out.println(
                            encontrada.gerarRelatorio()
                        );
                    } else {
                        System.out.println("Boletim não encontrado.");
                    }
                    break;

                case 3:
                    System.out.print("Número do BO: ");
                    int numeroAlteracao = entrada.nextInt();

                    System.out.println("1 - Alterar status");
                    System.out.println("2 - Alterar descrição");
                    System.out.print("Escolha: ");
                    int tipoAlteracao = entrada.nextInt();

                    entrada.nextLine();

                    boolean alterado = false;

                    if (tipoAlteracao == 1) {
                        System.out.print("Novo status: ");
                        String novoStatus = entrada.nextLine();

                        alterado = gerenciador.alterarStatus(
                                numeroAlteracao, novoStatus
                        );

                    } else if (tipoAlteracao == 2) {
                        System.out.print("Nova descrição: ");
                        String novaDescricao = entrada.nextLine();

                        alterado = gerenciador.alterarDescricao(
                                numeroAlteracao, novaDescricao
                        );
                    }

                    if (alterado) {
                        System.out.println("Boletim atualizado!");
                    } else {
                        System.out.println(
                            "Alteração não realizada."
                        );
                    }
                    break;

                case 4:
                    System.out.print("Número do BO: ");
                    int numeroExclusao = entrada.nextInt();

                    if (gerenciador.remover(numeroExclusao)) {
                        System.out.println("Boletim excluído!");
                    } else {
                        System.out.println(
                            "Boletim não encontrado."
                        );
                    }
                    break;

                case 5:
                    gerenciador.listarEmTabela();
                    break;

                case 6:
                    gerenciador.ordenarPorNumero();
                    break;

                case 7:
                    System.out.println(
                        "Consulta de histórico será implementada."
                    );
                    break;

                case 0:
                    System.out.println("Encerrando o SIGO...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        entrada.close();
    
	}


public static void cadastrarDadosIniciais(
        GerenciadorOcorrencias gerenciador) {

    for (int i = 1; i <= 7; i++) {

        SubtracaoPatrimonial subtracao =
                new SubtracaoPatrimonial(
                    1000 + i,
                    "20/11/2026",
                    "10:00",
                    "Salvador - BA",
                    "Subtração de objeto pessoal",
                    false,
                    "",
                    "Furto",
                    "Celular",
                    1000.00 + i * 100
                );

        gerenciador.cadastrar(subtracao);

        CrimeContraVida contraVida =
                new CrimeContraVida(
                    2000 + i,
                    "20/11/2026",
                    "11:00",
                    "Salvador - BA",
                    "Tentativa de homicídio",
                    true,
                    "Arma de fogo",
                    "Tentativa de homicídio",
                    0
                );

        gerenciador.cadastrar(contraVida);

        CrimeCibernetico cibernetico =
                new CrimeCibernetico(
                    3000 + i,
                    "21/11/2026",
                    "14:00",
                    "Salvador - BA",
                    "Fraude realizada pela internet",
                    false,
                    "",
                    "Fraude digital",
                    "WhatsApp",
                    500.00 + i * 200
                );

        gerenciador.cadastrar(cibernetico);

        OcorrenciaTransito transito =
                new OcorrenciaTransito(
                    4000 + i,
                    "22/11/2026",
                    "18:00",
                    "Av. Paralela, Salvador - BA",
                    "Colisão entre veículos",
                    false,
                    "",
                    "Colisão",
                    false,
                    false,
                    2,
                    1
                );

        gerenciador.cadastrar(transito);

        Outros outros =
                new Outros(
                    5000 + i,
                    "23/11/2026",
                    "22:00",
                    "Salvador - BA",
                    "Perturbação do sossego",
                    false,
                    "",
                    "Perturbação do sossego",
                    "Som alto em residência vizinha"
                );

        gerenciador.cadastrar(outros);

        Pessoa vitima = new Pessoa(
                "Vitima " + i,
                "7199999000" + i
        );

        Pessoa testemunha = new Pessoa(
                "Testemunha " + i,
                "7188888000" + i
        );

        subtracao.adicionarVitima(vitima);
        contraVida.adicionarVitima(vitima);
        cibernetico.adicionarVitima(vitima);
        transito.adicionarVitima(vitima);
        outros.adicionarVitima(vitima);

        subtracao.adicionaTestemunha(testemunha);
        transito.adicionaTestemunha(testemunha);
    }

    System.out.println("Dados iniciais cadastrados!");
    
	}

}
