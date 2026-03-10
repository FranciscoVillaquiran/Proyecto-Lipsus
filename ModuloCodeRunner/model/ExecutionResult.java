package ModuloCodeRunner.model;

public class ExecutionResult {

    private String output;
    private boolean success;
    private String error;

    public ExecutionResult() {}

    public ExecutionResult(String output, boolean success, String error) {
        this.output = output;
        this.success = success;
        this.error = error;
    }

    public String getOutput() {
        return output;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getError() {
        return error;
    }
}
