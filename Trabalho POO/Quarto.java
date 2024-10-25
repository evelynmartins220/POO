public class Quarto{
    
    private String numero;
    private String tipo;
    private double preco;
    private boolean disponivel;

    // construtor para criar um Quarto
    Quarto(String numero, String tipo, double preco){
        this.setNumero(numero);
        this.setTipo(tipo);
        this.setPreco(preco);
        this.disponivel = true;
    }

    // setters
    // define o número do quarto
    public void setNumero(String numero){
        this.numero = numero;
    }

    // define o tipo do quarto
    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    // define o preço do quarto
    public void setPreco(double preco){
        this.preco = preco;
    }

    // getters
    // retorna o número do quarto
    public String getNumero(){
        return this.numero;
    }

    // retorna o tipo do quarto
    public String getTipo(){
        return this.tipo;
    }

    // retorna o preço do quarto
    public double getPreco(){
        return this.preco;
    }

    // retorna a disponibilidade do quarto
    public boolean getDisponibilidade(){
        return this.disponivel;
    }

    // marca o quarto como reservado
    public void reservar(){
        this.disponivel = false;
    }

    // libera o quarto
    public void liberar(){
        this.disponivel = true;
    }
}