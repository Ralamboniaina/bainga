package mg.panomba.bainga_wages_calculator.domain.model;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

public class DailyTask {
    public List<Pomodoro> pomodoroList() {
        return List.of(
                new Pomodoro(new Commit("id1", "author", LocalDateTime.of(2023, Month.APRIL, 6, 22, 20), "message1")),
                new Pomodoro(new Commit("id2", "author", LocalDateTime.of(2023, Month.APRIL, 6, 23, 20), "message2")));
    }
}
