package mg.panomba.bainga_wages_calculator.domain.model;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("When commit time is between 0 and 30 minutes")
class WhenCommitTimeIsBetween0And30MinutesTest {

    @Test
    @DisplayName("then start time is 0 minute and end time is 30 minutes")
    void thenStartTimeIs0MinuteAndEndTimeIs30Minutes() {
        //ARRANGE
        Commit commit = new Commit(
                "id",
                "author",
                LocalDateTime.of(2023, Month.APRIL, 5, 22, 25),
                "message");
        CommitRepository commitRepository = () -> List.of(commit);
        BaingaWagesCalculator baingaWagesCalculator = new BaingaWagesCalculator(commitRepository);
        //ACT
        baingaWagesCalculator.createReport();
        //ASSERT
        assertThat(baingaWagesCalculator.numberOfPomodoro()).isEqualTo(1);
        assertThat(baingaWagesCalculator.hourSpent()).isCloseTo(0.5D, Percentage.withPercentage(0));
        assertThat(baingaWagesCalculator.wages()).isCloseTo(BigDecimal.valueOf(5), Percentage.withPercentage(0));
        assertThat(baingaWagesCalculator.pomodoroList().get(0).start()).isEqualTo(LocalDateTime.of(2023, Month.APRIL, 5, 22, 0));
        assertThat(baingaWagesCalculator.pomodoroList().get(0).end()).isEqualTo(LocalDateTime.of(2023, Month.APRIL, 5, 22, 30));
    }

}
