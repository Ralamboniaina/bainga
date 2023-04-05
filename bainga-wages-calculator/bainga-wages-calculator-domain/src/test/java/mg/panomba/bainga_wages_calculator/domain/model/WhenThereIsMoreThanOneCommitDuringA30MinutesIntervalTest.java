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
class WhenThereIsMoreThanOneCommitDuringA30MinutesIntervalTest {

    @Test
    @DisplayName("then report should contain one line")
    void thenReportShouldContainOneLine() {
        //ARRANGE
        Commit commit1 = new Commit(
                "id1",
                "author",
                LocalDateTime.of(2023, Month.APRIL, 5, 22, 15),
                "message1");
        Commit commit2 = new Commit(
                "id2",
                "author",
                LocalDateTime.of(2023, Month.APRIL, 5, 22, 25),
                "message2");
        CommitRepository commitRepository = () -> List.of(commit1, commit2);
        BaingaWagesCalculator baingaWagesCalculator = new BaingaWagesCalculator(commitRepository);
        //ACT
        baingaWagesCalculator.createReport();
        //ASSERT
        assertThat(baingaWagesCalculator.numberOfPomodoro()).isEqualTo(1);
        assertThat(baingaWagesCalculator.hourSpent()).isCloseTo(0.5D, Percentage.withPercentage(0));
        assertThat(baingaWagesCalculator.wages()).isCloseTo(BigDecimal.valueOf(5), Percentage.withPercentage(0));
        assertThat(baingaWagesCalculator.pomodoroList()).hasSize(1);
    }

}
