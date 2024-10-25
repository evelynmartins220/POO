import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Sistema{

    Scanner scanner = new Scanner(System.in);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    Administrador admin = new Administrador(null, null);

    // adiciona um hotel ao sistema
    public void adicionarHotel(){
        System.out.println("\nInforme o nome do hotel:\n");
        String nomeHotel = scanner.nextLine();

        System.out.println("\nInforme o endereço do hotel:\n");
        String enderecoHotel = scanner.nextLine();

        Hotel hotel = new Hotel(nomeHotel, enderecoHotel);

        if(admin.buscarHotel(nomeHotel) != null){
            System.out.println("\nEsse hotel já foi adicionado!\n");
        }else{
            admin.adicionarHotel(hotel);
        }
    }

    // remove um hotel do sistema
    public void removerHotel(){
        System.out.println("\nInforme o nome do hotel:");
        String nomeHotel = scanner.nextLine();

        Hotel hotel = admin.buscarHotel(nomeHotel);
        if(hotel != null){
            admin.removerHotel(hotel);
        }else{
            System.out.println("\nHotel não encontrado\n");
        }
    }

    //lista todos os hoteis cadastrados no sistema
    public void listarHoteis(){
        admin.listarHoteis();
    }

    // adiciona um quarto a um hotel específico
    public void adicionarQuarto(){
        System.out.println("\nInforme o nome do hotel para adicionar o quarto:");
        String nomeHotel = scanner.nextLine();

        Hotel hotel = admin.buscarHotel(nomeHotel);
        if(hotel != null){
            System.out.println("\nInforme o número do quarto:\n");
            String numQuarto = scanner.nextLine();

            Quarto q = hotel.buscarQuarto(numQuarto);
            if(q != null){
                System.out.println("\nEsse quarto já existe\n");
            }else{
                System.out.println("\nInforme tipo do quarto:\n");
                String tipoQuarto = scanner.nextLine();

                System.out.println("\nInforme preço do quarto:\n");
                double precoQuarto = scanner.nextDouble();
                scanner.nextLine();
                
                Quarto quarto = new Quarto(numQuarto, tipoQuarto, precoQuarto);
                hotel.adicionarQuarto(quarto);
            }
        }else{
            System.out.println("\nHotel não encontrado\n");
        }
    }

    // remove um quarto de um hotel específico
    public void removerQuarto(){
        System.out.println("\nInforme o nome do hotel para remover o quarto:\n");
        String nomeHotel = scanner.nextLine();

        Hotel hotel = admin.buscarHotel(nomeHotel);
        if(hotel != null){
            System.out.println("\nInforme o número do quarto:\n");
            String numQuarto = scanner.nextLine();

            Quarto quarto = hotel.buscarQuarto(numQuarto);
            if(quarto != null){
                hotel.removerQuarto(quarto);
            }else{
                System.out.println("\nQuarto não encontrado\n");
            }
        }
    }

    // lista todos os quartos disponíveis de um hotel específico
    public void listarQuartosDisponiveis(){
        System.out.println("\nInforme o nome do hotel:\n");
        String nomeHotel = scanner.nextLine();
        Hotel hotel = admin.buscarHotel(nomeHotel);

        if(hotel != null){
            hotel.listarQuartosDisponiveis();
        }else{
            System.out.println("Hotel não encontrado.");
        }
    }

    // faz uma reserva para um cliente em um hotel específico
    public void fazerReserva(){
        System.out.println("\nInforme nome:\n");
        String nome = scanner.nextLine();

        System.out.println("\nInforme email:\n");
        String email = scanner.nextLine();

        System.out.println("\nInforme telefone:\n");
        String telefone = scanner.nextLine();
        
        Cliente cliente = new Cliente(nome, email, telefone);

        System.out.println("\nInforme nome do hotel:\n");
        String nomeHotel = scanner.nextLine();
        Hotel hotel = admin.buscarHotel(nomeHotel);

        if(hotel != null){
            System.out.println("\nInforme o número do quarto:\n");
            String numQuarto = scanner.nextLine();
            Quarto quarto = hotel.buscarQuarto(numQuarto);

            if(quarto != null){
                System.out.println("\nInforme a data de check in e check out:\n");

                String checkInStr = scanner.nextLine();
                LocalDateTime dataCheckIn = LocalDateTime.parse(checkInStr, formatter);

                String checkOutStr = scanner.nextLine();
                LocalDateTime dataCheckOut = LocalDateTime.parse(checkOutStr, formatter);

                cliente.fazerReserva(hotel, quarto, dataCheckIn, dataCheckOut);
            }else{
                System.out.println("\nQuarto não encontrado.\n");
            }
        }else{
            System.out.println("\nHotel não encontrado.\n");
        }
    }

    // cancela a reserva de um cliente em um hotel específico
    public void cancelarReserva(){
        System.out.println("\nInforme o nome do cliente:\n");
        String nome = scanner.nextLine();

        System.out.println("\nInforme nome do hotel:\n");
        String nomeHotel = scanner.nextLine();
        Hotel hotel = admin.buscarHotel(nomeHotel);

        if(hotel != null){
            System.out.println("\nInforme o número do quarto:\n");
            String numQuarto = scanner.nextLine();
            Quarto quarto = hotel.buscarQuarto(numQuarto);

            if(quarto != null){
                Reserva reserva = hotel.buscarReserva(quarto);

                if(reserva != null){
                    Cliente cliente = reserva.getCliente();

                    if(cliente.getNome().equals(nome)){
                        cliente.cancelarReserva(hotel, quarto, reserva);
                    }else{
                        System.out.println("\nCliente não encontrado.\n");
                    }
                }else{
                    System.out.println("\nReserva não encontrada.\n");
                }
            }else{
                System.out.println("\nQuarto não encontrado.\n");
            }
        }else{
            System.out.println("\nHotel não encontrado.\n");
        }

    }

    //lista todas as reservas de um cliente específico
    public void listarReservasCliente(){
        System.out.println("\nInforme o nome do cliente:\n");
        String nome = scanner.nextLine();
        admin.listarReservasCliente(nome);
    }
}