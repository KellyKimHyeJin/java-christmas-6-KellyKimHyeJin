package christmas;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class MenuTest extends NsTest {

    @Test
    void 메뉴이름_받아오기(){
        Assertions.assertThat(Menu.equalName("크리스마스파스타").getMenuKind()).isEqualTo("메인");
        Assertions.assertThat(Menu.equalName("초코케이크").getMenuKind()).isEqualTo("디저트");
    }

    @Test
    void 주문내역_받아오기(){
        Menu.TAPAS.setMenuNumber(2);
        Menu.BBQRIBS.setMenuNumber(1);
        List<Menu> menuList = Menu.orderedMenu();
        Assertions.assertThat(menuList.get(0).equalName("타파스").getMenuNumber()).isEqualTo(2);
        Assertions.assertThat(menuList.get(1).equalName("바비큐립").getMenuNumber()).isEqualTo(1);
    }
    @Override
    protected void runMain() {

    }
}
