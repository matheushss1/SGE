import java.util.Scanner;
import java.util.regex.*;


public class Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" --------------------------------------------------------------- ");
        System.out.println("|                 VAMOS CADASTRAR SEU USUARIO                   |");
        System.out.println("|           Para isso precisamos do seu nome completo           |");
        System.out.println(" --------------------------------------------------------------- ");
        System.out.println("                                                                 ");
        System.out.println("Digite seu nome completo:");
        String nomeCompleto = scanner.nextLine();
        Character primeiraLetra = nomeCompleto.charAt(0);
        String userName = primeiraLetra + "_";
        String ultimoNome = nomeCompleto.substring(nomeCompleto.lastIndexOf(" ") + 1);
        userName += ultimoNome;
        userName = userName.toLowerCase();
        System.out.println("Pronto, seu nome de usuário agora é: " + userName);
        String senha;
        String senhaInput = null;


        boolean senhaValida = false;
        while(!senhaValida) {
            System.out.println(" --------------------------------------------------------------- ");
            System.out.println("|                 VAMOS CADASTRAR SUA SENHA                     |");
            System.out.println("|                   Sua senha deve conter:                      |");
            System.out.println("| - Pelo menos 8 caracteres                                     |");
            System.out.println("| - 1 Letra Maiúsula                                            |");
            System.out.println("| - 1 Letra Minúscula                                           |");
            System.out.println("| - 1 Número                                                    |");
            System.out.println("| - 1 Caracter Especial                                         |");
            System.out.println(" --------------------------------------------------------------- ");
            System.out.println("                                                                 ");
            System.out.println("Senha:");
            senhaInput = scanner.nextLine();

            String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[-, !, @])(?=.*[A-Z])(?=.*\\d).+";

            Pattern padrao = Pattern.compile(regex);

            Matcher verificaPadrao = padrao.matcher(senhaInput);

            if(senhaInput.length() >= 8 && verificaPadrao.find()){
                System.out.println("CADASTRO REALIZADO COM SUCESSO");
                senhaValida = true;
            } else {
                System.out.println("Sua senha não atende aos requisitos.");
                senhaValida = false;
            }
        }
        senha = senhaInput;
        String nomeTeste;
        boolean usuarioLogar = false;
        while(usuarioLogar == false){
            System.out.println(" ---------------------------- ");
            System.out.println("|          LOGIN             |");
            System.out.println(" ---------------------------- ");
            System.out.println("                              ");
            System.out.println("Digite seu Nome de Usuário:");
            nomeTeste = scanner.nextLine();
            if(!nomeTeste.equals(userName)){
                System.out.println("Nome de Usuário inválido, tente novamente!");
                usuarioLogar = false;
            } else{
                usuarioLogar = true;
            }
        }
        boolean senhaLogar = false;
        String senhaTeste;
        while(senhaLogar == false){
            System.out.println("Digite sua senha:");
            senhaTeste = scanner.nextLine();
            if(!senhaTeste.equals(senha)){
                System.out.println("Senha incorreta, tente novamente!");
                senhaLogar = false;
            } else{
                System.out.println("LOGIN REALIZADO COM SUCESSO!");
                senhaLogar = true;
            }
        }

    }
}
