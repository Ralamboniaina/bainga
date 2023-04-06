package mg.panomba.bainga_wages_calculator.domain.model;

import java.time.LocalDateTime;

public class Commit {
    private final String id;
    private final String author;
    private final LocalDateTime date;
    private final String message;

    public Commit(String id, String author, LocalDateTime date, String message) {
        this.id = id;
        this.author = author;
        this.date = date;
        this.message = message;
    }

    public String id() {
        return id;
    }

    public String author() {
        return author;
    }

    public LocalDateTime date() {
        return date;
    }

    public String message() {
        return message;
    }
}
