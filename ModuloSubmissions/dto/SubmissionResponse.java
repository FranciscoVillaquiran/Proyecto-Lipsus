package ModuloSubmissions.dto;

import java.time.LocalDateTime;

public class SubmissionResponse {

    private Long id;
    private Long userId;
    private Long problemId;
    private String language;
    private String status;
    private LocalDateTime submittedAt;

    public SubmissionResponse(Long id, Long userId, Long problemId, String language, String status, LocalDateTime submittedAt) {
        this.id = id;
        this.userId = userId;
        this.problemId = problemId;
        this.language = language;
        this.status = status;
        this.submittedAt = submittedAt;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getProblemId() {
        return problemId;
    }

    public String getLanguage() {
        return language;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getSubmittedAt() {
        return submittedAt;
    }
}
