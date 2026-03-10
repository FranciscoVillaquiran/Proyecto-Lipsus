package ModuloCodeRunner.service;

import ModuloCodeRunner.dto.CodeExecutionRequest;
import ModuloCodeRunner.dto.CodeExecutionResponse;
import org.springframework.stereotype.Service;

@Service
public class CodeRunnerService {

    public CodeExecutionResponse runCode(CodeExecutionRequest request) {

        if(request.getCode() == null || request.getCode().isEmpty()) {

            return new CodeExecutionResponse(
                    null,
                    false,
                    "Code is empty"
            );
        }

        // Simulación
        String output = "Execution simulated for language: " + request.getLanguage();

        return new CodeExecutionResponse(
                output,
                true,
                null
        );
    }
}
