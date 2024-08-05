package training.cm.ga.controller.advice;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import training.cm.ga.dto.ErrorEntity;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class ApplicationControllerAdvice {

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(EntityNotFoundException.class)
    public @ResponseBody ErrorEntity handleException(EntityNotFoundException exception){
        return new ErrorEntity(null, exception.getMessage());
    }

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(RuntimeException.class)
    public @ResponseBody ErrorEntity handleRuntimeException(RuntimeException exception){
        return new ErrorEntity(null, exception.getMessage());
    }
}
