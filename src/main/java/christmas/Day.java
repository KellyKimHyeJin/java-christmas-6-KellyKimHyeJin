package christmas;

public enum Day {
    MONDAY(3),
    TUESDAY(4),
    WEDNESDAY(5),
    THURSDAY(6),
    FRIDAY(0),
    SATURDAY(1),
    SUNDAY(2);

    private int dayIdentify;
    Day(int dayIdentify){
        this.dayIdentify = dayIdentify;
    }

    public int getDayIdentify(){
        return this.dayIdentify;
    }
}
