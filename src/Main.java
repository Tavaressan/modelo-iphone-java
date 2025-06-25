import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Bem-vindo ao Sistema do Iphone!");
            executarMenu(scanner);
        }
    }

    private static void executarMenu(Scanner scanner) {
        boolean menu = true;
        AparelhoTelefonico telefone = new AparelhoTelefonico();
        NavegadorInternet navegador = new NavegadorInternet();
        ReprodutorMusical reprodutor = new ReprodutorMusical();
        while (menu) {
            mostrarMenu();
            String acao = scanner.nextLine();
            switch (acao) {
                case "1" -> {
                    System.out.print("Digite o número para ligar: ");
                    String numero = scanner.nextLine();
                    telefone.ligar(numero);
                }
                case "2" -> telefone.desligar();
                case "3" -> {
                    System.out.print("Digite o número para enviar mensagem: ");
                    String numero = scanner.nextLine();
                    System.out.print("Digite a mensagem: ");
                    String mensagem = scanner.nextLine();
                    telefone.enviarTexto(numero, mensagem);
                }
                case "4" -> {
                    System.out.print("Digite o número para visualizar mensagens: ");
                    String numero = scanner.nextLine();
                    telefone.visualizarTextoEnviado(numero);
                }
                case "5" -> telefone.iniciarCorreioVoz();
                case "6" -> {
                    System.out.print("Digite a URL para navegar: ");
                    String url = scanner.nextLine();
                    navegador.exibirPagina(url);
                }
                case "7" -> navegador.adicionarNovaAba();
                case "8" -> navegador.atualizarPagina();
                case "9" -> {
                    System.out.print("Digite o nome da música para adicionar: ");
                    String musica = scanner.nextLine();
                    try {
                        reprodutor.adicionarMusica(musica);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                case "10" -> {
                    System.out.print("Digite o nome da música para selecionar: ");
                    String musica = scanner.nextLine();
                    reprodutor.selecionarMusica(musica);
                }
                case "11" -> reprodutor.tocar();
                case "12" -> reprodutor.pausar();
                case "13" -> {
                    System.out.print("Digite o nome da música para excluir: ");
                    String musica = scanner.nextLine();
                    reprodutor.excluirMusica(musica);
                }
                case "0" -> {
                    System.out.println("Sistema encerrado");
                    menu = false;
                }
                default -> System.out.println("Ação inválida, por favor escolha uma ação válida");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("\nEscolha uma ação:");
        System.out.println("1 - Ligar para um número");
        System.out.println("2 - Desligar ligação");
        System.out.println("3 - Enviar mensagem de texto");
        System.out.println("4 - Visualizar mensagens enviadas");
        System.out.println("5 - Iniciar correio de voz");
        System.out.println("6 - Navegar para uma URL");
        System.out.println("7 - Abrir nova aba no navegador");
        System.out.println("8 - Atualizar página do navegador");
        System.out.println("9 - Adicionar música");
        System.out.println("10 - Selecionar música");
        System.out.println("11 - Tocar música");
        System.out.println("12 - Pausar música");
        System.out.println("13 - Excluir música");
        System.out.println("0 - Sair");
    }
}
