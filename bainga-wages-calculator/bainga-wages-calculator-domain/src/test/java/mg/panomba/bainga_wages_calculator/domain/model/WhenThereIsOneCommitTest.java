package mg.panomba.bainga_wages_calculator.domain.model;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("When there is one commit")
class WhenThereIsOneCommitTest {

    @Test
    @DisplayName("then report should contain one line")
    void thenReportShouldContainOneLine() {
        //ARRANGE
        CommitRepository commitRepository = () -> List.of(new Commit());
        BaingaWagesCalculator baingaWagesCalculator = new BaingaWagesCalculator(commitRepository);
        //ACT
        baingaWagesCalculator.createReport();
        //ASSERT
        assertThat(baingaWagesCalculator.numberOfPomodoro()).isEqualTo(1);
        assertThat(baingaWagesCalculator.hourSpent()).isCloseTo(0.5D, Percentage.withPercentage(0));
    }

}
