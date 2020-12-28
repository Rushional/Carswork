package models.parameters;

public class ParameterInfo {
//    This should have been an id, but we made a really awkward database and decided not to bother editing it
//    It's really inconvenient to do is PostgreSQL, and it's not that important, so we decided not to waste our time
    private String parameterTypeName;
    private boolean isNumerical;

    public ParameterInfo(String parameterTypeName, boolean isNumerical) {
        this.parameterTypeName = parameterTypeName;
        this.isNumerical = isNumerical;
    }

    public boolean isNumerical() {
        return isNumerical;
    }

    public String getParameterTypeName() {
        return parameterTypeName;
    }
}
