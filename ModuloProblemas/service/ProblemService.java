package ModuloProblemas.service;


import ModuloProblemas.dto.ProblemRequest;
import ModuloProblemas.dto.ProblemResponse;
import ModuloProblemas.model.Problem;
import ModuloProblemas.repository.ProblemRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProblemService {


    private final ProblemRepository problemRepository;


    public ProblemService(ProblemRepository problemRepository) {
        this.problemRepository = problemRepository;
    }


    public ProblemResponse createProblem(ProblemRequest request) {


        Problem problem = new Problem(
                request.getTitle(),
                request.getDescription(),
                request.getDifficulty(),
                request.getTopic()
        );


        Problem saved = problemRepository.save(problem);


        return new ProblemResponse(
                saved.getId(),
                saved.getTitle(),
                saved.getDescription(),
                saved.getDifficulty(),
                saved.getTopic()
        );
    }


    public List<ProblemResponse> getAllProblems() {


        return problemRepository.findAll()
                .stream()
                .map(problem -> new ProblemResponse(
                        problem.getId(),
                        problem.getTitle(),
                        problem.getDescription(),
                        problem.getDifficulty(),
                        problem.getTopic()
                ))
                .collect(Collectors.toList());
    }


    public ProblemResponse getProblemById(Long id) {


        Problem problem = problemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Problem not found"));


        return new ProblemResponse(
                problem.getId(),
                problem.getTitle(),
                problem.getDescription(),
                problem.getDifficulty(),
                problem.getTopic()
        );
    }
}
