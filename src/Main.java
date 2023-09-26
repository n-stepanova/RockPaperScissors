import java.util.*;

public class Main {
    static Map<Integer, String> rps = new HashMap<>();
    public static void setRPS(){
        rps.put(1, "Камень");
        rps.put(2, "Ножницы");
        rps.put(3, "Бумага");
    }

    public static String getUserVariant() {
        int code = 1;
        boolean isInteger = false;

        while (isInteger == false) {
            Scanner scanner = new Scanner(System.in);

            if (scanner.hasNextInt()) {
                code = scanner.nextInt();
                if (code>=1 && code<=3) {
                    isInteger = true;
                } else {
                    System.out.println("Ошибка");
                }
            } else {
                System.out.println("Ошибка");
            }
        }
        return rps.get(code);
    }

    public static String getComputerVariant(){
        int code = (int) (1 + Math.random()*3);
        return rps.get(code);
    }

    public static String getWinObject(List<String> v){
        if (v.contains("Бумага") && v.contains("Камень")){
            return "Бумага";
        }else if (v.contains("Ножницы") && v.contains("Камень")){
            return "Камень";
        }else if (v.contains("Бумага") && v.contains("Ножницы")){
            return "Ножницы";
        }
        return "";
    }

    public static void showInfo(){
        System.out.println("Выберите значение: 1 - Камень, 2 - Ножницы, 3 - Бумага");
    }

    public static void main(String[] args) {
        setRPS();
        showInfo();
        String userVar = getUserVariant();
        String computerVar = getComputerVariant();
        System.out.println("Ваш вариант: " + userVar);
        System.out.println("Вариант компьютера: " + computerVar);
        List<String> values = new ArrayList<>();
        values.add(userVar);
        values.add(computerVar);

        String winObject = getWinObject(values);
        if (winObject==userVar){
            System.out.println("Вы победили");
        }else if (winObject==computerVar){
            System.out.println("Победил компьютер");
        }else {
            System.out.println("Ничья");
        }
    }
}