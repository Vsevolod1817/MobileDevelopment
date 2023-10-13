public class Score_credit extends Score{

    public String percent;

    public String finish_date;
    Score_credit(String name, String surname, String birthday, int amount, String percent, String finish_date){
        super(name, surname, birthday, amount);
        this.percent=percent;
        this.finish_date=finish_date;
    }

    @Override
    public String toString(){
        return getName() + " " + getSurname() + ", " + getBirthday() + ", " + getAmount() + ", " + this.percent + ", " + this.finish_date;
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
        return "Срок погашения кредита: " + finish_date;
    }

    @Override
    public boolean equals(Object o) {
        boolean result = false;
        if (o != null && o instanceof Score_credit) {
            Score_credit d = (Score_credit) o;
            if ((percent == d.percent)&&(finish_date==d.finish_date)) {
                result = true;
            }

        }
        return result;
    }
}
