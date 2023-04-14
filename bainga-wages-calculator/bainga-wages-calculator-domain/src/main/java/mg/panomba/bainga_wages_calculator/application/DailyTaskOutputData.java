package mg.panomba.bainga_wages_calculator.application;

import mg.panomba.bainga_wages_calculator.domain.model.DailyTask;
import mg.panomba.bainga_wages_calculator.domain.model.Pomodoro;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DailyTaskOutputData {
    private final DailyTask dailyTask;

    public DailyTaskOutputData(DailyTask dailyTask) {
        this.dailyTask = dailyTask;
    }

    public LocalDate date() {
        return dailyTask.date();
    }

    public List<PomodoroOuptputData> pomodoro() {
        List<PomodoroOuptputData> result = new ArrayList<>();
        for (Pomodoro pomodoro : dailyTask.pomodoroList()) {
            result.add(new PomodoroOuptputData(pomodoro));
        }
        return result;
    }

}
