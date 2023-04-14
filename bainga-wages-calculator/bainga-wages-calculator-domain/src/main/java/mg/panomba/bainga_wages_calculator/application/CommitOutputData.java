package mg.panomba.bainga_wages_calculator.application;

import mg.panomba.bainga_wages_calculator.domain.model.Commit;

public class CommitOutputData {
    private final Commit commit;

    public CommitOutputData(Commit commit) {
        this.commit = commit;
    }

    public String message() {
        return commit.message();
    }

    public String id() {
        return commit.id();
    }

}
