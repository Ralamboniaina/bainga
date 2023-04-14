package mg.panomba.bainga_wages_calculator.domain.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pomodoro {

    private final LocalDateTime start;
    private final LocalDateTime end;
    private final List<Commit> commits = new ArrayList<>();

    public Pomodoro(Commit commit) {
        start = commit.date()
                .withMinute(commit.date().getMinute() < 30 ? 0 : 30)
                .withSecond(0)
                .withNano(0);
        end = commit.date()
                .withHour(start.getMinute() == 30 ? commit.date().getHour() + 1 : commit.date().getHour())
                .withMinute(commit.date().getMinute() < 30 ? 30 : 0)
                .withSecond(0)
                .withNano(0);
        commits.add(commit);
    }

    public LocalDateTime start() {
        return start;
    }

    public LocalDateTime end() {
        return end;
    }

    public List<Commit> commits() {
        return commits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pomodoro pomodoro)) return false;
        return Objects.equals(start, pomodoro.start) && Objects.equals(end, pomodoro.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }

    public void addCommit(Commit commit) {
        commits.add(commit);
    }
}
