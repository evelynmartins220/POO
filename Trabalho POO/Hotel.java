import java.util.ArrayList;
import java.util.List;

public class Hotel{
    private String nome;
    private String endereco;
    private List<Quarto> quartos;
    private List<Reserva> reservas;

    // construtor para criar um hotel
    Hotel(String nome, String endereco){
        this.setNome(nome);
        this.setEndereco(endereco);
        this.quartos = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    // setters
    // define o nome do hotel
    public void setNome(String nome){
        this.nome = nome;
    }

    // define o endereço do hotel
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

    // getters
    // retorna o nome do hotel
    public String getNome(){
        return this.nome;
    }

    // retorna o endereço do hotel
    public String getEndereco(){
        return this.endereco;
    }

    // retorna a lista de Reservas
    public List<Reserva> getReservas(){
        return this.reservas;
    }

    // método para adicionar uma reserva na lista de reservas
    public void adicionarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    // método para remover uma reserva da lista de reservas
    public void removerReserva(Reserva reserva) {
        reservas.remove(reserva);
    }

    // método para procurar uma reserva, percorre a lista de reservas e compara o parâmetro com o quarto da reserva
    public Reserva buscarReserva(Quarto quarto) {
        for (Reserva reserva : reservas) {
            if (reserva.getQuarto().equals(quarto)) {
                return reserva;
            }
        }
        return null;
    }

    // Método para verificar se um quarto com o mesmo número já existe
    public Quarto buscarQuarto(String numQuarto) {
        for (Quarto quarto : quartos) {
            if (quarto.getNumero().equals(numQuarto)) {
                return quarto;
            }
        }
        return null;
    }

    // adiciona um quarto na lista de quartos
    public void adicionarQuarto(Quarto quarto){
        quartos.add(quarto);
        System.out.println("\nQuarto adicionado!\n");
    }

    // remove um quarto da lista de quartos
    public void removerQuarto(Quarto quarto){
        quartos.remove(quarto);
        System.out.println("\nQuarto removido!\n");
    }

    //metodo que lista todos os quartos disponiveis
    public void listarQuartosDisponiveis(){
        boolean encontrouDisponivel = false;
        for(Quarto quarto : quartos){
            if(quarto.getDisponibilidade() == true){
                System.out.println("\nHotel: "+getNome()+"\n\tNúmero do quarto: " + quarto.getNumero() + "\n\tTipo: " + quarto.getTipo() + "\n\tPreço: " + quarto.getPreco()+"\n");
                encontrouDisponivel = true;
            }
        }
        if(!encontrouDisponivel){
            System.out.println("\nNão há quartos disponíveis\n");
        }
    }
}