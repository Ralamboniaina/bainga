package mg.panomba.bainga_wages_calculator.domain.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DailyTask {

    private final LocalDate date;
    private final List<Pomodoro> pomodoroList = new ArrayList<>();

    public DailyTask(Commit commit) {
        date = commit.date().toLocalDate();
        addCommit(commit);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DailyTask dailyTask)) return false;
        return Objects.equals(date, dailyTask.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date);
    }

    public List<Pomodoro> pomodoroList() {
        return pomodoroList;
    }

    public void addCommit(Commit commit) {
        Pomodoro pomodoro = new Pomodoro(commit);
        try {
            pomodoroList.get(pomodoroList.indexOf(pomodoro)).addCommit(commit);
        } catch (Exception e) {
            pomodoroList.add(pomodoro);
        }
    }
}
