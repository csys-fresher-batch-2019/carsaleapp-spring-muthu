package com.chainsys.carsaleapp.validator;

import org.springframework.stereotype.Component;

import com.chainsys.carsaleapp.exception.ValidatorException;
import com.chainsys.carsaleapp.model.CarDetail;
@Component
public class CarDetailValidator {

	public void validateCarForSave(CarDetail carDetail) throws ValidatorException {
		 if(carDetail.getCarName()==null  ||"".equals(carDetail.getCarName().trim())) {
			 throw new ValidatorException("Enter car name");
		 }
	}

}
