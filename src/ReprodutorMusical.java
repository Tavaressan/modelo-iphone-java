import java.util.ArrayList;
import java.util.List;

public non-sealed class ReprodutorMusical extends Iphone {
    private List<String> musicas = new ArrayList<>();
    private boolean estaTocando;
    private boolean musicaEstaSelecionada;
    private String musicaSelecionada;

    public void tocar() {
        if (musicaEstaSelecionada) {
            estaTocando = true;
            System.out.println("A música" + musicaSelecionada + "está tocando agora.");
        } else System.out.println("Nenhuma música foi selecionada ainda.");
    }

    public void pausar() {
        if (estaTocando) {
            estaTocando = false;
            System.out.println("A música" + musicaSelecionada + "foi pausada.");
        } else System.out.println("A música já está pausada.");
    }

    public void adicionarMusica(String musica) {
        if (!musica.isEmpty()) {
            musicas.add(musica);
            System.out.println("A música" + musica + " foi adicionada!");
        } else throw new IllegalArgumentException("Erro: A música inserida não é válida.");
    }

    public void selecionarMusica (String musica) {
        boolean musicaExistente = musicas.contains(musica);
        if (musicaExistente) {
            musicaSelecionada = musica;
            musicaEstaSelecionada = true;
            System.out.println("A música" + musica + "foi selecionada.");
        } else System.out.println("A música inserida não existe no registro.");
    }

    public void excluirMusica (String musica) {
        boolean musicaExistente = musicas.contains(musica);
        if (musicaExistente) {
            musicas.remove(musica);
            System.out.println("A música" + musica + "foi removida.");
        } else System.out.println("A música inserida não existe no registro.");
    }
}
