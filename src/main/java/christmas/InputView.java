package christmas;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int date;
    public void inputDate(){
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        date = Integer.parseInt(Console.readLine());
        while(true){
            try{
                if(date <= 31 && date >= 1) break;
                IllegalArgumentException e = new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
                throw e;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                date = Integer.parseInt(Console.readLine());
            }
        }
    }




}
