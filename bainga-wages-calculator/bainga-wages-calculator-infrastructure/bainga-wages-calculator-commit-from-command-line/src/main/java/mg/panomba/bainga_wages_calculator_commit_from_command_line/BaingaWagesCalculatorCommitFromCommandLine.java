package mg.panomba.bainga_wages_calculator_commit_from_command_line;

import mg.panomba.bainga_wages_calculator.domain.model.Commit;
import mg.panomba.bainga_wages_calculator.domain.model.CommitRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BaingaWagesCalculatorCommitFromCommandLine implements CommitRepository {
    private final String projectDirectory;

    public BaingaWagesCalculatorCommitFromCommandLine(String projectDirectory) {
        this.projectDirectory = projectDirectory;
    }

    @Override
    public List<Commit> list() {
        List<Commit> result = new ArrayList<>();
        try {
            Process process = Runtime.getRuntime().exec(String.format("git -C %s log --date=iso", projectDirectory));

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            String commitId = "";
            String authorName = "";
            String commitMessage = "";
            LocalDateTime commitDate = LocalDateTime.now();
            boolean isNextLineCommitMessage = false;
            while ((line = reader.readLine()) != null) {
                if (line.trim().startsWith("commit"))
                    commitId = line.replace("commit ", "");
                else if (line.trim().startsWith("Author: "))
                    authorName = line.replace("Author: ", "");
                else if (line.trim().startsWith("Date: "))
                    commitDate = LocalDateTime.parse(line.replace("Date:", "").trim(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss Z"));
                else if (line.isEmpty())
                    isNextLineCommitMessage = true;
                else if (isNextLineCommitMessage) {
                    commitMessage = line.trim();
                    result.add(new Commit(commitId, authorName, commitDate, commitMessage));
                    isNextLineCommitMessage = false;
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException();
        }
        return result;
    }
}
