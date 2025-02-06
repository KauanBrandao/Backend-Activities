import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Scanner;

public class Lanches {
    private int codigo;
    private String nome;
    private double preco;
    private String imagem;
    private Scanner sc = new Scanner(System.in);

    public Lanches() {}

    public Lanches(int codigo, String nome, double preco, String imagem) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.imagem = imagem;
    }

    public int getCodigo() {
        return codigo;
    }

    public double getPreco() {
        return preco;
    }

    public String getNome() {
        return nome;
    }

    public String getImagem() {
        return imagem;
    }

    public void cadastrarLanche(ArrayList<Lanches> lanches) {
        System.out.print("Informe o código do lanche: ");
        int codigo = sc.nextInt();
        sc.nextLine();

        System.out.print("Informe o nome do lanche: ");
        String nome = sc.nextLine();

        System.out.print("Informe o preço do lanche: ");
        double preco = sc.nextDouble();
        sc.nextLine();

        System.out.print("Informe o caminho da imagem do lanche: ");
        String caminhoOriginal = sc.nextLine();


        String diretorioDestino = "imagens/";
        new File(diretorioDestino).mkdirs();


        String nomeArquivo = "lanche_" + codigo + ".jpg";
        String caminhoFinal = diretorioDestino + nomeArquivo;


        try {
            File origem = new File(caminhoOriginal);
            File destino = new File(caminhoFinal);

            if (origem.exists()) {
                Files.copy(origem.toPath(), destino.toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Imagem salva em: " + caminhoFinal);
            } else {
                System.out.println("Erro: Arquivo de imagem não encontrado!");
                return;
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar a imagem: " + e.getMessage());
            return;
        }

        Lanches lanche = new Lanches(codigo, nome, preco, caminhoFinal);
        lanches.add(lanche);
        System.out.println("Lanche cadastrado com sucesso!");
    }

    public void listarLanches(ArrayList<Lanches> lanches) {
        if (lanches.isEmpty()) {
            System.out.println("Não há lanches cadastrados!");
        } else {
            System.out.println("\nLanches cadastrados:");
            for (Lanches l : lanches) {
                System.out.println("Nome: " + l.getNome() + " | Código: " + l.getCodigo() + " | Preço: R$ " + l.getPreco());
                System.out.println("Imagem: " + l.getImagem());
            }
        }
    }

    public void venda(ArrayList<Lanches> lanches) {
        System.out.print("Informe o código do lanche: ");
        int codigo = sc.nextInt();

        System.out.print("Informe a quantidade desejada: ");
        int quantidade = sc.nextInt();

        boolean encontrado = false;

        for (Lanches l : lanches) {
            if (l.getCodigo() == codigo) {
                double total = l.getPreco() * quantidade;
                System.out.println("\nPedido realizado: " + quantidade + "x " + l.getNome());
                System.out.printf("Total a pagar: R$ %.2f%n", total);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Nenhum lanche encontrado! Tente novamente.");
        }
    }
}
