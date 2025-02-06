import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean sair = false;
        Scanner sc = new Scanner(System.in);
        ArrayList<Lanches> lanches = new ArrayList<>();
        Lanches lanchesObj = new Lanches();

        while (!sair) {
            System.out.println("\n------ Menu ------");
            System.out.println("1. Cadastrar lanche");
            System.out.println("2. Listar lanches");
            System.out.println("3. Fazer uma venda");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            char op = sc.next().charAt(0);
            sc.nextLine();

            switch (op) {
                case '1':
                    lanchesObj.cadastrarLanche(lanches);
                    break;
                case '2':
                    lanchesObj.listarLanches(lanches);
                    break;
                case '3':
                    lanchesObj.venda(lanches);
                    break;
                case '4':
                    sair = true;
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
        sc.close();
    }
}
