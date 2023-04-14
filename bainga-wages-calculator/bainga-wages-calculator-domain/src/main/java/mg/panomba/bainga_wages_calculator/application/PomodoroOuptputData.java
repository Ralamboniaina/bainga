package mg.panomba.bainga_wages_calculator.application;

import mg.panomba.bainga_wages_calculator.domain.model.Commit;
import mg.panomba.bainga_wages_calculator.domain.model.Pomodoro;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PomodoroOuptputData {

    private final Pomodoro pomodoro;

    public PomodoroOuptputData(Pomodoro pomodoro) {
        this.pomodoro = pomodoro;
    }

    public List<CommitOutputData> commits() {
        List<CommitOutputData> result = new ArrayList<>();
        for (Commit commit : pomodoro.commits()) result.add(new CommitOutputData(commit));
        return result;
    }

    public String interval() {
        String start = pomodoro.start().format(DateTimeFormatter.ofPattern("HH:mm"));
        String end = pomodoro.end().format(DateTimeFormatter.ofPattern("HH:mm"));
        return String.format("%s - %s", start, end);
    }
}
