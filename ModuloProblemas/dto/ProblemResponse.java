package ModuloProblemas.dto;


public class ProblemResponse {


    private Long id;
    private String title;
    private String description;
    private String difficulty;
    private String topic;


    public ProblemResponse(Long id, String title, String description, String difficulty, String topic) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.difficulty = difficulty;
        this.topic = topic;
    }


    public Long getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }


    public String getDescription() {
        return description;
    }


    public String getDifficulty() {
        return difficulty;
    }


    public String getTopic() {
        return topic;
    }
}
