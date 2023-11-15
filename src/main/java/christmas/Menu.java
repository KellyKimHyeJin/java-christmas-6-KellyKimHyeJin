package christmas;

import java.util.ArrayList;
import java.util.List;

public enum Menu {
    MUSHROOMSOUP("양송이수프",6000,"애피타이저",0),
    TAPAS("타파스",5500,"애피타이저",0),
    CAESARSALAD("시저샐러드",8000,"애피타이저",0),
    TBONESTEAK("티본스테이크", 55000,"메인",0),
    BBQRIBS("바비큐립",54000,"메인",0),
    SEAFOODPASTA("해산물파스타",35000,"메인",0),
    CHRISTMASPASTA("크리스마스파스타",25000,"메인",0),
    CHOCOLATECAKE("초코케이크",15000,"디저트",0),
    ICECREAM("아이스크림",5000,"디저트",0),
    ZEROCOLA("제로콜라",3000,"음료",0),
    REDWINE("레드와인",60000,"음료",0),
    CHAMPAGNE("샴페인",25000,"음료",0);
    private String name;
    private int price;
    private String kind;
    private int number;

    Menu(String name, int price, String kind, int number){
        this.name = name;
        this.price = price;
        this.kind = kind;
        this.number = number;
    }

    public void setMenuNumber(int number){
        this.number = number;
    }

    public int getMenuNumber(){
        return this.number;
    }
    public String getMenuName(){
        return this.name;
    }

    public int getMenuPrice(){
        return this.price;
    }

    public String getMenuKind(){
        return this.kind;
    }

    public static Menu equalName(String name){
        for(Menu menu: Menu.values()){
            if(menu.getMenuName().equals(name)){
                return menu;
            }
        }
        return null;
    }

    public static List<Menu> orderedMenu(){
        List<Menu> menuList = new ArrayList<>();
        for(Menu menu: Menu.values()){
            if(menu.getMenuNumber() >= 1){
                menuList.add(menu);
            }
        }
        return menuList;
    }
}
