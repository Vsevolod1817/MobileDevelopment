public abstract class Score implements Personal{
    protected String name;
    protected String surname;
    protected String birthday;
    protected int amount;

    Score(String name, String surname, String birthday, int amount) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.amount = amount;
    }

    protected Score() {
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public String getSurname(){
        return surname;
    }

    public void setBirthday(String birthday){
        this.birthday = birthday;
    }

    public String getBirthday(){
        return birthday;
    }

    public void setAmount(int amount){
        this.amount=amount;
    }

    public String getAmount(){
        return "Баланс: " + amount;
    }

    public String Pluscash(int amount){
        this.amount+=amount;
        return "Баланс пополнен!";
    }

    public String Minuscash(int amount){
        this.amount-=amount;
        return "Деньги сняты!";
    }

    public String Close(){
        this.amount = 0;
        return "Счет закрыт";
    }

    @Override
    public String toString(){
        return this.name + " " + this.surname + ", " + this.birthday + ", " + this.amount;
    }

    @Override
    public boolean equals(Object o) {
        boolean result = false;
        if (o != null && o instanceof Score) {
            Score d = (Score) o;
            if ((amount == d.amount)&&(name==d.name)&&(surname==d.surname)&&(birthday==d.birthday)) {
                result = true;
            }
        }
        return result;
    }
}