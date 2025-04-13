package Demo.validate.exist;

public class ExistValue {
    private String type;
    private String errorMessage;

    public ExistValue(String type, String errorMessage) {
        this.type = type;
        this.errorMessage = errorMessage;
    }

    public String getType() {
        return type;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}

