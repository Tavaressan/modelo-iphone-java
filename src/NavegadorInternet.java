public non-sealed class NavegadorInternet extends Iphone {
    private String paginaSendoExibida;
    private boolean exibindoPagina;
    private static int contadorAbas;


    public void exibirPagina(String url) {
        boolean urlEValida = !url.isBlank();
        if (urlEValida) {
            exibindoPagina = true;
            paginaSendoExibida = url;
            contadorAbas++;
            System.out.println("Você está vendo a página: " + url);
        } else System.out.println("Insira uma url válida.");
    }

    public void adicionarNovaAba() {
        contadorAbas++;
        System.out.printf("Você abriu mais uma aba,\n agora você está com %d abas abertas.", contadorAbas);
    }

    public void atualizarPagina() {
        if (exibindoPagina) {
            System.out.println("Atualizando a página " + paginaSendoExibida);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("A página foi atualizada, obrigado pela espera.");
        } else System.out.println("Você não está acessando página alguma!");

    }
}
