package mg.panomba.bainga_wages_calculator.domain.model;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("When bainga wages calculator has been initialized")
class WhenBaingaWagesCalculatorHasBeenInitializedTest {

    @Test
    @DisplayName("then report should be empty")
    void thenReportShouldBeEmpty() {
        //ARRANGE
        BaingaWagesCalculator baingaWagesCalculator;
        //ACT
        baingaWagesCalculator = new BaingaWagesCalculator(List::of);
        //ASSERT
        assertThat(baingaWagesCalculator.numberOfPomodoro()).isZero();
        assertThat(baingaWagesCalculator.hourSpent()).isZero();
        assertThat(baingaWagesCalculator.wages()).isCloseTo(BigDecimal.ZERO, Percentage.withPercentage(0));
        assertThat(baingaWagesCalculator.dailyTasks()).isEmpty();
    }

}
