package christmas;


public class OutputView {
    Service service = new Service();

    public void printMenu(){
        System.out.println(service.calculateMenu());
    }

    public void printTotalPrice(){
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(service.calculateTotalPrice());
    }

    public void printBonusMenu(){
        System.out.println("<증정 메뉴>");
        System.out.println(service.calculateBonusMenu());
    }

    public void printBenefit(){
        System.out.println("<혜택 내역>");
        System.out.println(service.calculateBenefit());
    }

    public void printTotalBenefit(){
        System.out.println("<총혜택 금액>");
        System.out.println(service.calculateTotalBenefit());
    }

    public void printPrice(){
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(service.calculatePrice());
    }

    public void printBadge(){
        System.out.println("<12월 이벤트 배지>");
        System.out.println(service.calculateBadge());
    }
}
