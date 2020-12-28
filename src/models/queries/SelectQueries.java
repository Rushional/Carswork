package models.queries;

// I wanted to separate the usage of QueryController from models.queries and QueryData,
// and tried to make it as abstract and independent as possible
public enum SelectQueries {
    WORKERS, OWNED_MODELS, CARS, POTENTIAL_MODELS, ORDERS, PARAMETERS_OUTPUT, PARAMETERS_LIST,
    NUMERICAL, QUALITATIVE, SERVICES
}
