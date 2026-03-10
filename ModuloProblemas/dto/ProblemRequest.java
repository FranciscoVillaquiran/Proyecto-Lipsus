package ModuloProblemas.dto;


public class ProblemRequest {


    private String title;
    private String description;
    private String difficulty;
    private String topic;


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public String getDifficulty() {
        return difficulty;
    }


    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }


    public String getTopic() {
        return topic;
    }


    public void setTopic(String topic) {
        this.topic = topic;
    }
}
