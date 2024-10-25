import java.util.ArrayList;
import java.util.List;

public class Administrador{

    private String nome;
    private String id;
    private List<Hotel> hoteis;

    // construtor para criar um administrador
    Administrador(String nome, String id){
        this.setNome(nome);
        this.setId(id);
        this.hoteis = new ArrayList<>();
    }

    // setters
    // define o nome do administrador
    public void setNome(String nome){
        this.nome = nome;
    }

    // define o id do administrador
    public void setId(String id){
        this.id = id;
    }

    // Método para buscar um hotel pelo nome
    public Hotel buscarHotel(String nomeHotel) {
        for (Hotel hotel : hoteis) {
            if (hotel.getNome().equals(nomeHotel)) {
                return hotel;
            }
        }
        return null;
    }

    // Adiciona um hotel na lista de hoteis
    public void adicionarHotel(Hotel hotel){
        hoteis.add(hotel);
        System.out.println("\nHotel adicionado!\n");
    }

    //remove um hotel da lista de hoteis
    public void removerHotel(Hotel hotel){
        hoteis.remove(hotel);
        System.out.println("\nHotel removido!\n");
    }

    //lista todos os hoteis cadastrados
    public void listarHoteis(){
        for(Hotel hotel : hoteis){
            System.out.println("\nHotel: " + "\n" + hotel.getNome() + "\nEndereço: " + "\n" + hotel.getEndereco() + "\n");
        }
    }

    // lista todas as reservas de um cliente específico
    public void listarReservasCliente(String nome) {
        boolean encontrouReserva = false;
        for (Hotel hotel : hoteis) {
            for (Reserva reserva : hotel.getReservas()) {
                if (reserva.getCliente().getNome().equals(nome)) {
                    System.out.println("Reserva de " + nome + ", Hotel: " + hotel.getNome() + ", Quarto: " + reserva.getQuarto().getNumero() + "\n");
                    encontrouReserva = true;
                }
            }
        }
        if (!encontrouReserva) {
            System.out.println("Nenhuma reserva encontrada para o cliente: " + nome + "\n");
        }
    }
}