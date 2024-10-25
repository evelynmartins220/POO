import java.time.LocalDateTime;

public class Cliente{
    
    private String nome;
    private String email;
    private String telefone;

    // construtor para criar um Cliente
    Cliente(String nome, String email, String telefone){
        this.setNome(nome);
        this.setEmail(email);
        this.setTelefone(telefone);
    }

    //setters
    //define o nome do cliente
    public void setNome(String nome){
        this.nome = nome;
    }

    // define o email do cliente
    public void setEmail(String email){
        this.email = email;
    }

    // define o telefone do cliente
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    // getters
    // retorna o nome do cliente
    public String getNome(){
        return this.nome;
    }

    // instancia uma nova reserva, confirma a reserva e adiciona ao hotel
    public void fazerReserva(Hotel hotel, Quarto quarto, LocalDateTime checkIn, LocalDateTime checkOut){
        Reserva reserva = new Reserva(this, quarto, checkIn, checkOut);
        reserva.confirmaReserva(quarto);
        hotel.adicionarReserva(reserva);
        System.out.println("\nReserva concluída"+ "\nHotel: "+ hotel.getNome() +"\nQuarto: " + quarto.getNumero() + "\nCliente: " + this.nome +"\n");
    }

    // cancela uma reserva existente
    public void cancelarReserva(Hotel hotel, Quarto quarto, Reserva reserva){
        reserva.cancelaReserva(quarto);
        hotel.removerReserva(reserva);
        System.out.println("\nReserva cancelada"+ "\nHotel: "+ hotel.getNome() +"\nQuarto: " + quarto.getNumero() + "\nCliente: " + this.nome +"\n");
    }
}