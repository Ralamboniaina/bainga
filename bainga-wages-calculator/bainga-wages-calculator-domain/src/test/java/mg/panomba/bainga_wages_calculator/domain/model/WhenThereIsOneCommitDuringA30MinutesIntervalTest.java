package mg.panomba.bainga_wages_calculator.domain.model;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("When there is one commit during a 30 minutes interval")
class WhenThereIsOneCommitDuringA30MinutesIntervalTest {

    @Test
    @DisplayName("then report should contain one line")
    void thenReportShouldContainOneLine() {
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
        assertThat(baingaWagesCalculator.dailyTasks().get(0).pomodoroList()).hasSize(1);
    }

}
