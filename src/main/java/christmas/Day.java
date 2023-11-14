package christmas;

public enum Day {
    MONDAY(0),
    TUESDAY(1),
    WEDNESDAY(2),
    THURSDAY(3),
    FRIDAY(4),
    SATURDAY(5),
    SUNDAY(6);

    private int dayIdentify;
    Day(int dayIdentify){
        this.dayIdentify = dayIdentify;
    }

    public int getDayIdentify(){
        return this.dayIdentify;
    }
}
