package com.openai.api.services.blocking

import com.openai.api.core.ClientOptions
import com.openai.api.core.RequestOptions
import com.openai.api.core.http.HttpMethod
import com.openai.api.core.http.HttpRequest
import com.openai.api.core.http.HttpResponse.Handler
import com.openai.api.errors.OpenAiError
import com.openai.api.models.ModerationCreateParams
import com.openai.api.models.ModerationCreateResponse
import com.openai.api.services.errorHandler
import com.openai.api.services.json
import com.openai.api.services.jsonHandler
import com.openai.api.services.withErrorHandler

class ModerationServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : ModerationService {

    private val errorHandler: Handler<OpenAiError> = errorHandler(clientOptions.jsonMapper)

    private val createHandler: Handler<ModerationCreateResponse> =
        jsonHandler<ModerationCreateResponse>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Classifies if text violates OpenAI's Content Policy */
    override fun create(
        params: ModerationCreateParams,
        requestOptions: RequestOptions
    ): ModerationCreateResponse {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("moderations")
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response
                .let { createHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }
}