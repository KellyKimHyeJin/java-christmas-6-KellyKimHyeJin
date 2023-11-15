package christmas;

import java.text.DecimalFormat;
import java.util.Objects;

public class Service {

    InputView inputView = new InputView();
    int totalPrice = 0;
    int weekendDiscount = 0;
    int weekdayDiscount = 0;
    int christmasDiscount = 0;
    int totalDiscount = 0;
    Boolean giveDiscount = false;

    public String calculateMenu(){
        StringBuffer sb = new StringBuffer();
        sb.append("12월 "+ inputView.date + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n\n");
        sb.append("<주문 메뉴>\n");
        for(Menu menu : inputView.menu.orderedMenu()){
            sb.append(menu.getMenuName()+ " " + menu.getMenuNumber() + "개\n");
        }
        return sb.toString();
    }

    public String calculateTotalPrice(){
        for(Menu menu : inputView.menu.orderedMenu()){
            totalPrice += menu.getMenuNumber()* menu.getMenuPrice();
        }
        DecimalFormat df = new DecimalFormat("###,###");
        String total = df.format(totalPrice);
        return total + "원\n";
    }

    public String calculateBonusMenu(){
        if(totalPrice > 120000){
            return "샴페인 1개\n";
        }
        return "없음\n";
    }

    public String calculateBenefit(){
        StringBuffer sb = new StringBuffer();
        if(totalPrice < 10000){
            return "없음\n";
        }
        if(totalPrice > 120000) {
            giveDiscount = true;
            sb.append("증정 이벤트: -25,000원\n");
        }
        int identifier = (inputView.date - 1) % 7;
        if(identifier == Day.SUNDAY.getDayIdentify() || inputView.date==25){
            sb.append("특별 할인: -1,000원\n");
        }
        if(inputView.date <= 25){
            christmasDiscount = (inputView.date-1)*100 +1000;
            DecimalFormat df = new DecimalFormat("###,###");
            String christmas = df.format(christmasDiscount);
            sb.append("크리스마스 디데이 할인: -" + christmas + "원\n");
        }
        if(identifier == Day.FRIDAY.getDayIdentify()|| identifier == Day.SATURDAY.getDayIdentify()) {
            for(Menu menu: inputView.menu.orderedMenu()){
                if(Objects.equals(menu.getMenuKind(), "메인")){
                    weekendDiscount += 2023;
                }
            }
            if(weekendDiscount>0){
                DecimalFormat df = new DecimalFormat("###,###");
                String weekend = df.format(weekendDiscount);
                sb.append("주말 할인: -" + weekend + "원\n");
            }
        }
        if(identifier == Day.SUNDAY.getDayIdentify()|| identifier == Day.MONDAY.getDayIdentify() ||
                identifier == Day.TUESDAY.getDayIdentify() || identifier == Day.WEDNESDAY.getDayIdentify() ||
                identifier == Day.THURSDAY.getDayIdentify()){
            for(Menu menu: inputView.menu.orderedMenu()){
                if(Objects.equals(menu.getMenuKind(), "디저트")){
                    weekdayDiscount += 2023;
                }
            }
            if(weekdayDiscount > 0){
                DecimalFormat df = new DecimalFormat("###,###");
                String weekday = df.format(weekdayDiscount);
                sb.append("평일 할인: -" + weekday + "원\n");
            }
        }
        if(totalPrice >10000 && weekendDiscount==0 && weekdayDiscount==0 && christmasDiscount==0 && giveDiscount==false){
            return "없음\n";
        }
        return sb.toString();
    }

    public String calculateTotalBenefit(){
        totalDiscount = weekdayDiscount + weekendDiscount + christmasDiscount;
        if(giveDiscount){
            totalDiscount += 25000;
        }
        if(totalDiscount>0){
            DecimalFormat df = new DecimalFormat("###,###");
            String discount = df.format(totalDiscount);
            return "-" + discount + "원\n";
        }
        return "없음\n";
    }

    public String calculatePrice(){
        DecimalFormat df = new DecimalFormat("###,###");
        String calculate = df.format(totalPrice-totalDiscount);
        return calculate + "원\n";
    }

    public String calculateBadge(){
        if(totalDiscount >= 5000 && totalDiscount <10000) {
            return "별";
        } else if(totalDiscount >=10000 && totalDiscount <20000){
            return "트리";
        } else if(totalDiscount >=20000){
            return "산타";
        }
        return "없음";
    }

}
