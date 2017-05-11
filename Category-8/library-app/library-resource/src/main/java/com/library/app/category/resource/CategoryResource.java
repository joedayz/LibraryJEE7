package com.library.app.category.resource;

import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.library.app.category.model.Category;
import com.library.app.category.services.CategoryServices;
import com.library.app.common.json.JsonUtils;
import com.library.app.common.json.OperationResultJsonWriter;
import com.library.app.common.model.HttpCode;
import com.library.app.common.model.OperationResult;

public class CategoryResource {

	private Logger logger = LoggerFactory.getLogger(getClass());

	CategoryServices categoryServices;

	CategoryJsonConverter categoryJsonConverter;

	public Response add(final String body) {
		logger.debug("Adding a new category with body {}", body);
		Category category = categoryJsonConverter.convertFrom(body);

		category = categoryServices.add(category);
		final OperationResult result = OperationResult.success(JsonUtils.getJsonElementWithId(category.getId()));

		logger.debug("Returning the operation result after adding category: {}", result);
		return Response.status(HttpCode.CREATED.getCode()).entity(OperationResultJsonWriter.toJson(result)).build();
	}
}