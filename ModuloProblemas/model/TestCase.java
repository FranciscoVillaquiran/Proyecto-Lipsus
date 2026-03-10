package ModuloProblemas.model;


import jakarta.persistence.*;


@Entity
@Table(name = "test_cases")
public class TestCase {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(length = 2000)
    private String input;


    @Column(length = 2000)
    private String expectedOutput;


    @ManyToOne
    @JoinColumn(name = "problem_id")
    private Problem problem;


    public TestCase() {}


    public TestCase(String input, String expectedOutput, Problem problem) {
        this.input = input;
        this.expectedOutput = expectedOutput;
        this.problem = problem;
    }


    public Long getId() {
        return id;
    }


    public String getInput() {
        return input;
    }


    public void setInput(String input) {
        this.input = input;
    }


    public String getExpectedOutput() {
        return expectedOutput;
    }


    public void setExpectedOutput(String expectedOutput) {
        this.expectedOutput = expectedOutput;
    }


    public Problem getProblem() {
        return problem;
    }


    public void setProblem(Problem problem) {
        this.problem = problem;
    }
}
