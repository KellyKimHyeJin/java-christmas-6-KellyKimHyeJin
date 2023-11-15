package christmas;

import java.util.List;
import java.util.Objects;

public class OutputView {
    InputView inputView = new InputView();
    List<Menu> menuList = Menu.orderedMenu();
    int totalPrice = 0;
    int weekendDiscount = 0;
    int weekdayDiscount = 0;
    int christmasDiscount = 0;
    int totalDiscount = 0;
    Boolean giveDiscount = false;

    public void printMenu(){
        System.out.println("12월 "+ inputView.date + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        System.out.println();
        System.out.println("<주문 메뉴>");
        for(Menu menu : menuList){
            System.out.print(menu.getMenuName()+ " " + menu.getMenuNumber());
        }
        System.out.println();
    }

    public void printTotalPrice(){
        System.out.println("<할인 전 총주문 금액>");
        for(Menu menu : menuList){
            totalPrice += menu.getMenuNumber()* menu.getMenuPrice();
        }
        System.out.print(totalPrice);
        System.out.println("원");
        System.out.println();
    }

    public void printBonusMenu(){
        System.out.println("<증정 메뉴>");
        if(totalPrice > 120000){
            System.out.println("샴페인 1개");
            System.out.println();
            return;
        }
        System.out.println("없음");
        System.out.println();
    }

    public void printBenefit(){
        System.out.println("<혜택 내역>");
        if(totalPrice < 10000){
            System.out.println("없음");
        }
        if(totalPrice > 120000) {
            giveDiscount = true;
            System.out.println("증정 이벤트: -25,000원");
        }
        int identifier = (inputView.date - 1) % 7;
        if(identifier == Day.SUNDAY.getDayIdentify() || inputView.date==25){
            System.out.println("특별 할인: -1,000원");
        }
        if(inputView.date <= 25){
            christmasDiscount = (inputView.date-1)*100 +1000;
            System.out.println("크리스마스 디데이 할인: -" + christmasDiscount + "원");
        }
        if(identifier == Day.FRIDAY.getDayIdentify()|| identifier == Day.SATURDAY.getDayIdentify()) {
            for(Menu menu: menuList){
                if(Objects.equals(menu.getMenuKind(), "메인")){
                    weekendDiscount += 2023;
                }
            }
            System.out.println("주말 할인: -" + weekendDiscount + "원");
            System.out.println();
            return;
        }
        if(identifier == Day.SUNDAY.getDayIdentify()|| identifier == Day.MONDAY.getDayIdentify() ||
                identifier == Day.TUESDAY.getDayIdentify() || identifier == Day.WEDNESDAY.getDayIdentify() ||
                identifier == Day.THURSDAY.getDayIdentify()){
            for(Menu menu: menuList){
                if(Objects.equals(menu.getMenuKind(), "디저트")){
                    weekdayDiscount += 2023;
                }
            }
            System.out.println("평일 할인: -" + weekdayDiscount + "원");
        }
        if(weekendDiscount==0 && weekdayDiscount==0 && christmasDiscount==0 && giveDiscount==false){
            System.out.println("없음");
        }
        System.out.println();
    }

    public void printTotalBenefit(){
        System.out.println("<총혜택 금액>");
        totalDiscount = weekdayDiscount + weekendDiscount + christmasDiscount;
        if(giveDiscount){
            totalDiscount += 25000;
        }
        System.out.println("-" + totalDiscount + "원");
        System.out.println();
    }

    public void printPrice(){
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(totalPrice-totalDiscount + "원");
        System.out.println();
    }

    public void printBadge(){
        System.out.println("<12월 이벤트 배지>");
        if(totalDiscount >= 5000 && totalDiscount <10000) {
            System.out.println("별");
        } else if(totalDiscount >=10000 && totalDiscount <20000){
            System.out.println("트리");
        } else if(totalDiscount >=20000){
            System.out.println("산타");
        }
    }
}
