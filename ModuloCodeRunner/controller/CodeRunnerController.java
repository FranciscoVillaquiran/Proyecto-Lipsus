package ModuloCodeRunner.controller;

import ModuloCodeRunner.dto.CodeExecutionRequest;
import ModuloCodeRunner.dto.CodeExecutionResponse;
import ModuloCodeRunner.service.CodeRunnerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/code-runner")
public class CodeRunnerController {

    private final CodeRunnerService codeRunnerService;

    public CodeRunnerController(CodeRunnerService codeRunnerService) {
        this.codeRunnerService = codeRunnerService;
    }

    @PostMapping("/run")
    public CodeExecutionResponse runCode(@RequestBody CodeExecutionRequest request) {
        return codeRunnerService.runCode(request);
    }
}
