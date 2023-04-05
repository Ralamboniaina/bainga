package mg.panomba.bainga_wages_calculator.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Pomodoro {

    private final List<Commit> commits = new ArrayList<>();

    public void addCommit(Commit commit) {
        commits.add(commit);
    }
}
