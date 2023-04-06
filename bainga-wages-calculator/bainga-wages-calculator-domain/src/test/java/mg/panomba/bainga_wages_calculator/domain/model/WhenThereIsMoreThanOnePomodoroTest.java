package mg.panomba.bainga_wages_calculator.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("When there is more than one pomodoro")
class WhenThereIsMoreThanOnePomodoroTest {

    @Test
    @DisplayName("then group them by date")
    void thenGroupThemByDate() {
        //ARRANGE
        Commit commit1 = new Commit("id1", "author", LocalDateTime.of(2023, Month.APRIL, 6, 22, 20), "message1");
        Commit commit2 = new Commit("id2", "author", LocalDateTime.of(2023, Month.APRIL, 6, 23, 20), "message2");
        CommitRepository commitRepository = () -> List.of(commit1, commit2);
        BaingaWagesCalculator baingaWagesCalculator = new BaingaWagesCalculator(commitRepository);
        //ACT
        baingaWagesCalculator.createReport();
        List<DailyTask> dailyTasks = baingaWagesCalculator.dailyTasks();
        //ASSERT
        assertThat(dailyTasks.get(0).pomodoroList()).hasSize(2);
    }

}
