// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.fineTuning.jobs

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse.Handler
import com.openai.errors.OpenAIError
import com.openai.models.FineTuningJobCheckpointListPageAsync
import com.openai.models.FineTuningJobCheckpointListParams
import com.openai.services.errorHandler
import com.openai.services.jsonHandler
import com.openai.services.withErrorHandler
import java.util.concurrent.CompletableFuture

class CheckpointServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : CheckpointServiceAsync {

    private val errorHandler: Handler<OpenAIError> = errorHandler(clientOptions.jsonMapper)

    private val listHandler: Handler<FineTuningJobCheckpointListPageAsync.Response> =
        jsonHandler<FineTuningJobCheckpointListPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** List checkpoints for a fine-tuning job. */
    override fun list(
        params: FineTuningJobCheckpointListParams,
        requestOptions: RequestOptions
    ): CompletableFuture<FineTuningJobCheckpointListPageAsync> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("fine_tuning", "jobs", params.getPathParam(0), "checkpoints")
                .putAllQueryParams(clientOptions.queryParams)
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).thenApply { response
            ->
            response
                .use { listHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
                .let { FineTuningJobCheckpointListPageAsync.of(this, params, it) }
        }
    }
}