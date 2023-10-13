public class main {
    public static void main(String[] args) {
//      Демонстрация установки значений
        /*Score_salary sc = new Score_salary("Vsevolod", "Epifantsev", "25.12.2002", 200);
        System.out.println(sc.getAmount());
        sc.setAmount(3000);
        System.out.println(sc.getAmount());*/
//      Создание массива уникальных объектов
        Score_salary ss = new Score_salary("Vsevolod", "Epifantsev", "25.12.2002", 200, 100);
        Score[] array = new Score[3];
        array[0] = new Score_salary("Vsevolod", "Epifantsev", "25.12.2002", 200, 100);
        array[1] = new Score_credit("Vsevolod", "Epifantsev", "25.12.2002", 300, "10", "25.11.2025");
        array[2] = new Score_deposit("Vsevolod", "Epifantsev", "25.12.2002", 400, "5",  "25.11.2025", "25.10.2025");
        for (Score i:array){
//            System.out.println(i.getAmount());
            System.out.println(i.toString());
        }
        // Вызываем метод makeAutoPayment для выполнения автоплатежа
        // String result = ss.makeAutoPayment();
        // Выводим результат на экран
        // System.out.println(result);
        /*int numberOfMonthsPassed = 1; // Пример: 1 месяц прошел
        double interestAmount = sd.calculateInterestForPeriod(numberOfMonthsPassed);

        System.out.println("Сумма процентов за " + numberOfMonthsPassed + " месяц(а): " + interestAmount);*/
//      Проверка на уникальность объектов

        /*if(array[0].equals(array[2]))
        {
            System.out.println("Объекты равны");
        }
        else { System.out.println("Объекты не равны");
        }*/
        /*System.out.println(sc.getAmount());
        System.out.println(sc.Pluscash(500));
        System.out.println(sc.getAmount());
        System.out.println(sc.Minuscash(800));
        System.out.println(sc.getAmount());
        System.out.println(sc.Close());
        System.out.println(sc.getAmount());*/
    }
}