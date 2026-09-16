import static org.junit.Assert.assertEquals;

import java.io.PipedInputStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PedidoTest {

    Pedido pedido;
    Pizza pizzaVazia;
    Pedido pedidoComPizza;

    @BeforeEach 
    public void setUp(){
        //Arrange
        pedido = new Pedido();
        pizzaVazia = new Pizza();
        pedidoComPizza = new Pedido();
        pedidoComPizza.adicionarPizza(pizzaVazia);
    }
    
    @Test
    public void naoAdicionaPizzaEmPedidoFechado(){
        //Arrange
        pedidoComPizza.fecharPedido();

        //Act
        int quantidade = pedido.adicionarPizza(new Pizza());
    
        //Assert
        assertEquals(1, quantidade);
    }

    @Test 
    public void adicionarPizzaEmPedidpAberto(){
        //Act
        int quantidade = pedido.adicionarPizza(new Pizza());
        pedido.fecharPedido();

        //assert
        assertEquals(2,quantidade);
    }

    @Test
    public void precoPagarPizza(){
        
        double preco = pedidoComPizza.precoAPagar();
    
        assertEquals(29, preco, 0.01);

    }

    @Test
    public void precoVazio(){

        double preco = pedido.precoAPagar();

        assertEquals(0, preco, 0.01);

    }

    @Test
    public void relatorio(){



    }

}
