package ModuloSubmissions.controller;

import ModuloSubmissions.dto.SubmissionRequest;
import ModuloSubmissions.dto.SubmissionResponse;
import ModuloSubmissions.service.SubmissionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/submissions")
public class SubmissionController {

    private final SubmissionService submissionService;

    public SubmissionController(SubmissionService submissionService) {
        this.submissionService = submissionService;
    }

    @PostMapping
    public SubmissionResponse createSubmission(@RequestBody SubmissionRequest request) {
        return submissionService.createSubmission(request);
    }

    @GetMapping("/user/{userId}")
    public List<SubmissionResponse> getByUser(@PathVariable Long userId) {
        return submissionService.getSubmissionsByUser(userId);
    }

    @GetMapping("/problem/{problemId}")
    public List<SubmissionResponse> getByProblem(@PathVariable Long problemId) {
        return submissionService.getSubmissionsByProblem(problemId);
    }
}
