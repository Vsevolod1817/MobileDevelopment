public class Score_deposit extends Score {

    protected String percent;

    protected String finish_date;

    protected String current_date;
    Score_deposit(String name, String surname, String birthday, int amount, String percent, String finish_date, String current_date) {
        super(name, surname, birthday, amount);
        this.percent = percent;
        this.finish_date = finish_date;
        this.current_date = current_date;
    }

    public void setPercent(String percent){
        this.percent = percent;
    }

    public String getPercent(){
        return percent;
    }

    public void setFinish_date(String finish_date){
        this.finish_date = finish_date;
    }

    public String getFinish_date(){
        return finish_date;
    }

    public void setCurrent_date(String current_date){
        this.current_date = current_date;
    }

    public String getCurrent_date(){
        return current_date;
    }

    public double calculateInterestForPeriod(int numberOfMonths) {
        // Преобразуйте процент в формат, подходящий для расчета (например, 5% -> 0.05)
        double interestRate = Double.parseDouble(percent) / 100.0;

        // Рассчитайте сумму процентов за истекший период
        double interestAmount = amount * interestRate * numberOfMonths;

        return interestAmount;
    }

    @Override
    public String toString(){
        return getName() + " " + getSurname() + ", " + getBirthday() + ", " + getAmount() + ", " + this.percent + ", " + this.finish_date + ", " + this.current_date;
    }

    @Override
    public boolean equals(Object o) {
        boolean result = false;
        if (o != null && o instanceof Score_deposit) {
            Score_deposit d = (Score_deposit) o;
            if ((percent == d.percent)&&(finish_date==d.finish_date)&&(current_date==d.current_date)) {
                result = true;
            }

        }
        return result;
    }

}