package amintabite.U5_W2_D3.Controllers;


import amintabite.U5_W2_D3.Exceptions.BadRequestException;
import amintabite.U5_W2_D3.Exceptions.NotFoundException;
import amintabite.U5_W2_D3.Exceptions.ValidationException;
import amintabite.U5_W2_D3.Payloads.ErrorsPayload;
import amintabite.U5_W2_D3.Payloads.ValidationErrPayload;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(ValidationException.class)

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationErrPayload handleValidationErrors(ValidationException ex) {
        return new ValidationErrPayload(ex.getMessage(), LocalDateTime.now(), ex.getErrorsMessages());
    }





    @org.springframework.web.bind.annotation.ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorsPayload handleBadeRequest(BadRequestException ex){
        return new ErrorsPayload(ex.getMessage(), LocalDateTime.now());
    }



    @org.springframework.web.bind.annotation.ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorsPayload handleNotFouns(NotFoundException ex){
         return new ErrorsPayload(ex.getMessage(), LocalDateTime.now());

    }


    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ErrorsPayload handleServerError(Exception ex){

        ex.printStackTrace();
        return new ErrorsPayload("Errore generico", LocalDateTime.now());
    }








}
