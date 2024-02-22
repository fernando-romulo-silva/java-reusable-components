package org.reusablecomponent.infra.openapi.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
//
@RequestBody( //
		description = "A existed entity" //
) //
public @interface UpdateEntityRequestBody {

}
