package spring.Annotation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
	
	
	@ExceptionHandler(value = ResourceNotFoundException.class)
	public ErrorObject handleResourceNotFoundException(ResourceNotFoundException resource)
	{
		ErrorObject errorobj=new ErrorObject();
		errorobj.setStatusCode(HttpStatus.NO_CONTENT.value());
		errorobj.setMessage(resource.getMessage());
		errorobj.setTimestamp(System.currentTimeMillis());
		errorobj.setErrorCode(HttpStatus.ACCEPTED.value());
		return errorobj;  
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorObject> handleNoDataFoundException(NoDataFoundException nodata)
	{
		ErrorObject errorobj=new ErrorObject();
		errorobj.setStatusCode(HttpStatus.NO_CONTENT.value());
		errorobj.setMessage(nodata.getMessage());
		errorobj.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<ErrorObject>(errorobj ,HttpStatus.OK);  
	}


}
