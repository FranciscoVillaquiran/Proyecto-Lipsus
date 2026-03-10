package ModuloProblemas.model;


import jakarta.persistence.*;
import java.util.List;


@Entity
@Table(name = "problems")
public class Problem {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String title;


    @Column(length = 5000)
    private String description;


    private String difficulty;


    private String topic;


    @OneToMany(mappedBy = "problem", cascade = CascadeType.ALL)
    private List<TestCase> testCases;


    public Problem() {}


    public Problem(String title, String description, String difficulty, String topic) {
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


    public List<TestCase> getTestCases() {
        return testCases;
    }


    public void setTestCases(List<TestCase> testCases) {
        this.testCases = testCases;
    }
}
