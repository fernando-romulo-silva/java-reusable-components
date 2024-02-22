package org.reusablecomponent.infra.openapi.annotations.response.success;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@ApiResponse( //
		responseCode = "200",
		description = "Entities found or a empty array if didn't find anything",
		content = @Content(
				mediaType = "application/json",
				schema = @Schema(defaultValue = "")

		)
)
public @interface OpenApiEntityGet200 {

}
