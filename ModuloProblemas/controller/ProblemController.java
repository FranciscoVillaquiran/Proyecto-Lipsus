package ModuloProblemas.controller;


import ModuloProblemas.dto.ProblemRequest;
import ModuloProblemas.dto.ProblemResponse;
import ModuloProblemas.service.ProblemService;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/problems")
public class ProblemController {


    private final ProblemService problemService;


    public ProblemController(ProblemService problemService) {
        this.problemService = problemService;
    }


    @PostMapping
    public ProblemResponse createProblem(@RequestBody ProblemRequest request) {
        return problemService.createProblem(request);
    }


    @GetMapping
    public List<ProblemResponse> getAllProblems() {
        return problemService.getAllProblems();
    }


    @GetMapping("/{id}")
    public ProblemResponse getProblem(@PathVariable Long id) {
        return problemService.getProblemById(id);
    }
}
