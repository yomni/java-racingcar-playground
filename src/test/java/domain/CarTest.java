package domain;

import domain.policy.Move;
import domain.policy.Stop;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Car Test")
class CarTest {

    @DisplayName("[success] 자동차_객체_생성 테스트")
    @Test
    void 성공_자동차_생성() throws Exception {
        // given // when
        String carNamePobi = "pobi";
        String carNameCrong = "crong";
        String carNameHonux = "honux";

        Car pobi = new Car(carNamePobi);
        Car crong = new Car(carNameCrong);
        Car honux = new Car(carNameHonux);

        // then
        assertThat(pobi).isNotNull();
        assertThat(crong).isNotNull();
        assertThat(honux).isNotNull();

        assertThat(pobi.getName()).isEqualTo(carNamePobi);
        assertThat(crong.getName()).isEqualTo(carNameCrong);
        assertThat(honux.getName()).isEqualTo(carNameHonux);
    }

    @DisplayName("[success] 자동차_객체_위치 포함 생성 테스트")
    @Test
    void 성공_자동차_생성_with_position() throws Exception {
        // given
        String carNamePobi = "pobi";
        int position = 3;

        // when
        Car pobi = new Car(carNamePobi, position);

        // then
        assertThat(pobi).isNotNull();
        assertThat(pobi.getName()).isEqualTo(carNamePobi);
        assertThat(pobi.getPosition()).isEqualTo(position);
    }

    @DisplayName("[exception] 자동차 이름 길이 제한 테스트")
    @Test
    void 예외_자동차_이름_길이_제한() throws Exception {
        // given
        String longCarName = "looooooong";
        String emptyCarName = "";
        String nullCarName = null;

        // when // then
        assertThatThrownBy(() -> new Car(longCarName)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Car(emptyCarName)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Car(nullCarName)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("[success] 자동차_전진 테스트")
    @Test
    void 성공_자동차_전진_1STEP() throws Exception {
        // given
        Car yomni = new Car("yomni");

        // when
        yomni.move(new Move());

        // then
        assertThat(yomni.getPosition()).isEqualTo(1);
    }

    @DisplayName("[success] 자동차_전진 - 복합 케이스 테스트")
    @Test
    void 성공_자동차_전진_COMBINE() throws Exception {
        // given
        Car yomni = new Car("yomni");

        // when
        yomni.move(new Move());
        yomni.move(new Stop());
        yomni.move(new Stop());
        yomni.move(new Move());
        yomni.move(new Move());
        yomni.move(new Stop());
        yomni.move(new Move());

        // then
        assertThat(yomni.getPosition()).isEqualTo(4);
    }
}
