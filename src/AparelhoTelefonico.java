import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public non-sealed class AparelhoTelefonico extends Iphone {
    private String numero;
    private Map<String, List<String>> mensagensPorNumero = new HashMap<>();
    private boolean ligacaoEstaAcontecendo;
    Random random = new Random();

    public void ligar(String numero) {
        boolean numeroValido = !numero.isBlank() && numero.contains("9");
        if (numeroValido) {
            System.out.println("Você está ligando para o número: " + numero);
            boolean ligacaoAtendida = random.nextBoolean();
            if (ligacaoAtendida) {
                ligacaoEstaAcontecendo = true;
                System.out.println(numero + ": 'Alô?' \nUma conversa muito deleitosa se inicia...");
            } else System.out.println("Trim trim trim... A ligação não foi atendida, sinto muito.");
        } else System.out.println("O número inserido é inválido.");
    }

    public void desligar() {
        if (ligacaoEstaAcontecendo) {
            ligacaoEstaAcontecendo = false;
            System.out.println("Você desligou abruptamente a ligação. Seu interlocutor se lembrará disso...");
        } else System.out.println("Você sequer está em uma ligação.");
    }

    public void iniciarCorreioVoz() {
        System.out.println("Iniciando gravação do correio de voz!");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("A gravação foi terminada e enviada! Você foi muito sucinto, sinta-se orgulhoso(a).");
    }

    public void enviarTexto(String numero, String mensagem) {
        mensagensPorNumero.computeIfAbsent(numero, k -> new ArrayList<>()).add(mensagem);
        System.out.println("Mensagem enviada para " + numero + ":" + mensagem);
    }

    public void visualizarTextoEnviado(String numero) {
        List<String> mensagens = mensagensPorNumero.get(numero);
        if (mensagens == null || mensagens.isEmpty()) {
            System.out.println("Nenhuma mensagem enviada para " + numero);
        } else {
            System.out.println("Mensagens enviadas para " + numero + ":");
            for (String msg : mensagens) {
                System.out.println(msg);
            }
        }
    }
}

