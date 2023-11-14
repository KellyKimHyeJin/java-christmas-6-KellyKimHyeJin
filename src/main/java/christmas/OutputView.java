package christmas;

public class OutputView {
    InputView inputView = new InputView();

    public void printMenu(){
        System.out.println("12월 "+ inputView.date + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        System.out.println();
        System.out.println("<주문 메뉴>");
    }
}
