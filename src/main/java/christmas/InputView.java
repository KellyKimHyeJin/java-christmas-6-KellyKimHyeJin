package christmas;

import camp.nextstep.edu.missionutils.Console;

import java.util.Objects;
import java.util.StringTokenizer;

public class InputView {

    public static int date;
    public static Menu menu;
    public void inputDate(){
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        String dateString = Console.readLine();
        while(true){
            try{
                date = Integer.parseInt(dateString);
                break;
            } catch (IllegalArgumentException e){
                System.out.println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
                dateString = Console.readLine();
            }
            try{
                if(date <= 31 && date >= 1) break;
                IllegalArgumentException e = new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
                throw e;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                dateString = Console.readLine();
            }
        }
    }

    public void inputMenu() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        String totalMenu = Console.readLine();
        int AppitizerNumber = 0;
        int mainNumber = 0;
        int dessertNumber = 0;
        int drinkNumber = 0;
        while (true) {
            try {
                StringTokenizer st = new StringTokenizer(totalMenu, ",-");
                while (st.hasMoreTokens()) {
                    menu = Menu.equalName(st.nextToken());
                    if(Objects.equals(menu.getMenuKind(), "애피타이저")){
                        AppitizerNumber++;
                    } else if(Objects.equals(menu.getMenuKind(), "매인")){
                        mainNumber++;
                    } else if(Objects.equals(menu.getMenuKind(), "디저트")){
                        dessertNumber++;
                    } else if(Objects.equals(menu.getMenuKind(), "음료")){
                        drinkNumber++;
                    }
                    if(drinkNumber > 0 && AppitizerNumber==0 && mainNumber==0 && dessertNumber==0){
                        IllegalArgumentException e = new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
                        throw e;
                    }
                    if(drinkNumber + AppitizerNumber + mainNumber + dessertNumber > 20){
                        IllegalArgumentException e = new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
                        throw e;
                    }
                    menu.setMenuNumber(Integer.parseInt(st.nextToken()));
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                totalMenu = Console.readLine();
            }
        }
    }
}
