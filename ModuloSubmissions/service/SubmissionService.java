package ModuloSubmissions.service;

import ModuloSubmissions.dto.SubmissionRequest;
import ModuloSubmissions.dto.SubmissionResponse;
import ModuloSubmissions.model.Submission;
import ModuloSubmissions.repository.SubmissionRepository;

import ModuloCodeRunner.dto.CodeExecutionRequest;
import ModuloCodeRunner.dto.CodeExecutionResponse;
import ModuloCodeRunner.service.CodeRunnerService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubmissionService {

    private final SubmissionRepository submissionRepository;
    private final CodeRunnerService codeRunnerService;

    public SubmissionService(
            SubmissionRepository submissionRepository,
            CodeRunnerService codeRunnerService
    ) {
        this.submissionRepository = submissionRepository;
        this.codeRunnerService = codeRunnerService;
    }

    public SubmissionResponse createSubmission(SubmissionRequest request) {

        // 1 Ejecutar código
        CodeExecutionRequest execRequest = new CodeExecutionRequest();
        execRequest.setCode(request.getCode());
        execRequest.setLanguage(request.getLanguage());
        execRequest.setInput("");

        CodeExecutionResponse result = codeRunnerService.runCode(execRequest);

        // 2 Determinar status
        String status = result.isSuccess() ? "ACCEPTED" : "FAILED";

        // 3 Crear submission
        Submission submission = new Submission(
                request.getUserId(),
                request.getProblemId(),
                request.getCode(),
                request.getLanguage(),
                status
        );

        // 4 Guardar
        Submission saved = submissionRepository.save(submission);

        // 5 Respuesta
        return new SubmissionResponse(
                saved.getId(),
                saved.getUserId(),
                saved.getProblemId(),
                saved.getLanguage(),
                saved.getStatus(),
                saved.getSubmittedAt()
        );
    }

    public List<SubmissionResponse> getSubmissionsByUser(Long userId) {

        return submissionRepository.findByUserId(userId)
                .stream()
                .map(s -> new SubmissionResponse(
                        s.getId(),
                        s.getUserId(),
                        s.getProblemId(),
                        s.getLanguage(),
                        s.getStatus(),
                        s.getSubmittedAt()
                ))
                .collect(Collectors.toList());
    }

    public List<SubmissionResponse> getSubmissionsByProblem(Long problemId) {

        return submissionRepository.findByProblemId(problemId)
                .stream()
                .map(s -> new SubmissionResponse(
                        s.getId(),
                        s.getUserId(),
                        s.getProblemId(),
                        s.getLanguage(),
                        s.getStatus(),
                        s.getSubmittedAt()
                ))
                .collect(Collectors.toList());
    }
}
