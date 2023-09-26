import java.util.*;

public class Main {
    public static final String ROCK = "Камень";
    public static final String SCISSORS = "Ножницы";
    public static final String PAPER = "Бумага";

    static Map<Integer, String> rps = new HashMap<>();
    public static void setRPS(){
        rps.put(1, ROCK);
        rps.put(2, SCISSORS);
        rps.put(3, PAPER);
    }

    public static String getUserVariant() {
        int code = 0;
        boolean isInteger = false;

        while (isInteger == false) {
            Scanner scanner = new Scanner(System.in);

            if (scanner.hasNextInt()) {
                code = scanner.nextInt();
                if (code>=1 && code<=3) {
                    isInteger = true;
                }else {
                    System.out.print("Ошибка. Введите еще раз: ");
                }
            } else {
                System.out.print("Ошибка. Введите еще раз: ");
            }
        }
        return rps.get(code);
    }

    public static String getComputerVariant(){
        int code = (int) (1 + Math.random()*3);
        return rps.get(code);
    }

    public static String getWinObject(List<String> codes){
        String winValue = "";
        if (codes.contains(PAPER) && codes.contains(ROCK)){
            winValue =  PAPER;
        }else if (codes.contains(SCISSORS) && codes.contains(ROCK)){
            winValue =  ROCK;
        }else if (codes.contains(PAPER) && codes.contains(SCISSORS)){
            winValue = SCISSORS;
        }
        return winValue;
    }

    public static boolean finalGame(){
        String gameOver = "n";

        do {
            System.out.print("Завершаем игру [y/n]? :");
            Scanner s = new Scanner(System.in);
            gameOver = s.nextLine();
            if (gameOver.equals("n")) {
                return false;
            } else if (gameOver.equals("y")) {
                return true;
            }
        }while (!gameOver.equals("n") || !gameOver.equals("y"));
        return false;
    }

    public static void defineTheWinner(String winObject, String userVar, String computerVar){
        if (winObject.equals(userVar)) {
            System.out.println("Вы победили");
        } else if (winObject.equals(computerVar)) {
            System.out.println("Победил компьютер");
        } else {
            System.out.println("Ничья");
        }
    }
    public static void main(String[] args) {
        setRPS();

        do {
            System.out.println("-------------------------------------------------------");
            System.out.print("Введите значение: 1 - Камень, 2 - Ножницы, 3 - Бумага: ");

            String userVar = getUserVariant();
            String computerVar = getComputerVariant();
            System.out.println("Ваш вариант: " + userVar);
            System.out.println("Вариант компьютера: " + computerVar);

            List<String> values = new ArrayList<>();
            values.add(userVar);
            values.add(computerVar);
            String winObject = getWinObject(values);

            defineTheWinner(winObject, userVar, computerVar);

        }while (!finalGame());
    }
}