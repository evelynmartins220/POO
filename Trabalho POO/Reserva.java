import java.time.LocalDateTime;

public class Reserva{
    private Cliente cliente;
    private Quarto quarto;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;

    // construtor para criar uma Reserva 
    Reserva(Cliente cliente, Quarto quarto, LocalDateTime checkIn, LocalDateTime checkOut){
        this.setCliente(cliente);
        this.setQuarto(quarto);
        this.setCheckIn(checkIn);
        this.setCheckOut(checkOut);
    }

    // setters
    // define o cliente da reserva
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }

    // define o quarto da reserva 
    public void setQuarto(Quarto quarto){
        this.quarto = quarto;
    }

    // define a data e a hora do check in
    public void setCheckIn(LocalDateTime checkIn){
        this.checkIn = checkIn;
    }

    // define a data e a hora do check out
    public void setCheckOut(LocalDateTime checkOut){
        this.checkOut = checkOut;
    }

    // getters
    // retorna o cliente
    public Cliente getCliente(){
        return this.cliente;
    }

    // retorna o quarto
    public Quarto getQuarto(){
        return this.quarto;
    }

    // Confirma a reserva, marcando o quarto como reservado
    public void confirmaReserva(Quarto quarto){
        quarto.reservar();
    }

    // Cancela a reserva, liberando o quarto
    public void cancelaReserva(Quarto quarto){
        quarto.liberar();
    }
}