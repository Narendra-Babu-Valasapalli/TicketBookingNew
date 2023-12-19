package com.example.BusTicketBooking.Exception;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class TicketGlobalExceptionHandler {

	@ExceptionHandler(TicketException.class)
	public ResponseEntity<TicketErrorInformation> handlerForUserException(TicketException e) {

		TicketErrorInformation er = new TicketErrorInformation();
		er.setOccuredAt(LocalDateTime.now());
		er.setErrorMessage(e.getMessage());
		er.setStatusCode(HttpStatus.BAD_REQUEST.value());

		return new ResponseEntity<TicketErrorInformation>(er, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<TicketErrorInformation> generalException(Exception e) {

		TicketErrorInformation er = new TicketErrorInformation();
		er.setOccuredAt(LocalDateTime.now());
		er.setErrorMessage("Internal Server error occured Exception :" + e.toString() + e.getLocalizedMessage());
		er.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());

		return new ResponseEntity<TicketErrorInformation>(er, HttpStatus.INTERNAL_SERVER_ERROR);

	}

//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public ResponseEntity<TicketErrorInformation> methodArugumentInvalidException(MethodArgumentNotValidException e) {
//
//		TicketErrorInformation er = new TicketErrorInformation();
//		er.setOccuredAt(LocalDateTime.now());
//		er.setStatusCode(HttpStatus.BAD_REQUEST.value());
//		BindingResult br = e.getBindingResult();
//		List<ObjectError> lor = br.getAllErrors();
//		Stream<String> allErrorMessages = lor.stream().map((ObjectError e1) -> e1.getDefaultMessage());
//		String errMessage = allErrorMessages.collect(Collectors.joining(","));
//
//		er.setErrorMessage(errMessage);
//		return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);
//
//	}
//	@ExceptionHandler(ConstraintViolationException.class)
//	public ResponseEntity<TicketErrorInformation> constraintHandler(ConstraintViolationException ce) {
//
//		TicketErrorInformation er = new TicketErrorInformation();
//		er.setOccuredAt(LocalDateTime.now());
//		er.setStatusCode(HttpStatus.BAD_REQUEST.value());
//		String errorMsg = ce.getConstraintViolations().stream().map(e -> e.getMessage())
//				.collect(Collectors.joining(", "));
//		er.setErrorMessage(errorMsg);
//		return new ResponseEntity<TicketErrorInformation>(er, HttpStatus.BAD_REQUEST);
//	}

}
