package com.project.Book_Project.Exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
@Getter
// The "ResourceNotFoundException" class inherits from the RuntimeException class, indicating that it is an exception that can be thrown when the program runs.
public class ResourceNotFoundException extends RuntimeException{
        // Fields that save informations about the resource that didn't found.
        private String resourceName;
        private String fieldName;
        private long fieldValue;

        public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue){

            super(String.format("%s not found with %s : '%s'", resourceName,fieldName,fieldValue));
            this.resourceName = resourceName;
            this.fieldName = fieldName;
            this.fieldValue = fieldValue;
        }
}
