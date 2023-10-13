public class Score_salary extends Score{

    protected int monthlySalary;

    Score_salary(String name, String surname, String birthday, int amount, int monthlySalary)
    {
        super(name, surname, birthday, amount);
        this.monthlySalary = monthlySalary;
    }

    public void setMonthlySalary(int monthlySalary){
        this.monthlySalary = monthlySalary;
    }

    public int getMonthlySalary(){
        return monthlySalary;
    }

    // Метод для выполнения автоплатежа
    public String makeAutoPayment() {
        if (amount >= monthlySalary) {
            amount -= monthlySalary;
            return "Автоплатеж выполнен успешно. Новый баланс: " + amount;
        } else {
            return "Недостаточно средств для автоплатежа";
        }
    }

    @Override
    public boolean equals(Object o) {
        boolean result = false;
        if (o != null && o instanceof Score_salary) {
            Score_salary d = (Score_salary) o;
            if ((monthlySalary == d.monthlySalary)) {
                result = true;
            }

        }
        return result;
    }

    @Override
    public String toString(){
        return getName() + " " + getSurname() + ", " + getBirthday() + ", " + getAmount() + ", " + this.monthlySalary;
    }

}