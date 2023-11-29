package domain.policy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("RandomCarMovePolicyTest")
class RandomCarMovePolicyTest {

    @DisplayName("random 테스트")
    @Test
    void random() throws Exception {
        // given / when / then
        for (int i = 0; i < 1000000; i++) {
            int move = new RandomCarMovePolicy().move();
            assertThat(move).isBetween(0, 9);
        }
    }

}
