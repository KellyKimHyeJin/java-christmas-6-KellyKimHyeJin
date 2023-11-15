package christmas;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        inputView.inputDate();
        inputView.inputMenu();
        outputView.printMenu();
        outputView.printTotalPrice();
        outputView.printBonusMenu();
        outputView.printBenefit();
        outputView.printTotalBenefit();
        outputView.printPrice();
        outputView.printBadge();
    }
}
