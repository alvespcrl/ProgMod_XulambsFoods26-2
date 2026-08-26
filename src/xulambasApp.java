import java.util.LinkedList;
import java.util.List;

public class xulambasApp {

    private List<Pizza> listaPizza;

    private void pausa() {
        IO.readln("Digite <ENTER> para continuar");
        limparTela();
    }

    private void limparTela() {
        IO.println("\033[H\033[2J");
    }

    private void cabecalho() {
        limparTela();
        IO.println("XULAMBS PIZZA - v0.1");
        IO.println("-----------------------------------");
    }

    private int exibirMenu() {

        IO.println("XULAMBS PIZZA - v0.1");
        IO.println("-----------------------------------");
        IO.println("1 - Comprar Pizza");
        IO.println("2 - Ver todas as pizzas");
        IO.println("0 - Sair");
        return Integer.parseInt(IO.readln("Digite sua opção: "));

    }

    void comprarPizza() {
        cabecalho();
        int adicionais = Integer.parseInt(IO.readln("Quantos ingredientes? "));
        Pizza nova = new Pizza(adicionais);

        mostrarNota(nova);
        listaPizza.add(nova);
    }

    void mostrarNota(Pizza pizza) {
        cabecalho();
        IO.println("Pizza comprada: ");
        IO.println(pizza.gerarCupom());
        IO.println("----------------------------------------");
        
    }

    void mostrarPizzas() {
        cabecalho();
        for (Pizza pizza : listaPizza){
            mostrarNota(pizza);
        }
    }

    void main(){
        int opcao;
        listaPizza = new LinkedList<>();
        
        do {
            opcao = exibirMenu();
            switch (opcao){
                case 1 -> comprarPizza();
                case 2 -> mostrarPizzas();
                case 0 -> IO.println("Encerrando!!");
                default -> IO.println("Opção Inválida");
            }
            pausa();
        } while(opcao != 0);

    }
}