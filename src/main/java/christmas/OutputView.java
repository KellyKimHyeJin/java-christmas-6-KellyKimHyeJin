package christmas;

import java.util.List;

public class OutputView {
    InputView inputView = new InputView();
    List<Menu> menuList = Menu.orderedMenu();

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
        int totalPrice  = 0;
        for(Menu menu : menuList){
            totalPrice += menu.getMenuNumber()* menu.getMenuPrice();
        }
        System.out.print(totalPrice);
        System.out.println("원");
        System.out.println();
    }

    public void printBonusMenu(){
        System.out.println("<증정 메뉴>");

        System.out.println();
    }

    public void printBenefit(){
        System.out.println("<혜택 내역>");

        System.out.println();
    }

    public void printTotalBenefit(){
        System.out.println("<총혜택 금액>");

        System.out.println();
    }

    public void printPrice(){
        System.out.println("<할인 후 예상 결제 금액>");

        System.out.println();
    }

    public void printBadge(){
        System.out.println("<12월 이벤트 배지>");
    }
}
