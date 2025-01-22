// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.beta.threads

import com.openai.core.ClientOptions
import com.openai.core.JsonValue
import com.openai.core.RequestOptions
import com.openai.core.handlers.errorHandler
import com.openai.core.handlers.jsonHandler
import com.openai.core.handlers.mapJson
import com.openai.core.handlers.sseHandler
import com.openai.core.handlers.withErrorHandler
import com.openai.core.http.AsyncStreamResponse
import com.openai.core.http.Headers
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse.Handler
import com.openai.core.http.StreamResponse
import com.openai.core.http.map
import com.openai.core.http.toAsync
import com.openai.core.json
import com.openai.errors.OpenAIError
import com.openai.models.AssistantStreamEvent
import com.openai.models.BetaThreadRunCancelParams
import com.openai.models.BetaThreadRunCreateParams
import com.openai.models.BetaThreadRunListPageAsync
import com.openai.models.BetaThreadRunListParams
import com.openai.models.BetaThreadRunRetrieveParams
import com.openai.models.BetaThreadRunSubmitToolOutputsParams
import com.openai.models.BetaThreadRunUpdateParams
import com.openai.models.Run
import com.openai.services.async.beta.threads.runs.StepServiceAsync
import com.openai.services.async.beta.threads.runs.StepServiceAsyncImpl
import java.util.concurrent.CompletableFuture

class RunServiceAsyncImpl
internal constructor(
    private val clientOptions: ClientOptions,
) : RunServiceAsync {

    companion object {

        private val DEFAULT_HEADERS = Headers.builder().put("OpenAI-Beta", "assistants=v2").build()
    }

    private val errorHandler: Handler<OpenAIError> = errorHandler(clientOptions.jsonMapper)

    private val steps: StepServiceAsync by lazy { StepServiceAsyncImpl(clientOptions) }

    override fun steps(): StepServiceAsync = steps

    private val createHandler: Handler<Run> =
        jsonHandler<Run>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Create a run. */
    override fun create(
        params: BetaThreadRunCreateParams,
        requestOptions: RequestOptions
    ): CompletableFuture<Run> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("threads", params.getPathParam(0), "runs")
                .putAllQueryParams(clientOptions.queryParams)
                .replaceAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .replaceAllHeaders(DEFAULT_HEADERS)
                .replaceAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).thenApply { response
            ->
            response
                .use { createHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val createStreamingHandler: Handler<StreamResponse<AssistantStreamEvent>> =
        sseHandler(clientOptions.jsonMapper)
            .mapJson<AssistantStreamEvent>(includeEventAndData = true)
            .withErrorHandler(errorHandler)

    /** Create a run. */
    override fun createStreaming(
        params: BetaThreadRunCreateParams,
        requestOptions: RequestOptions
    ): AsyncStreamResponse<AssistantStreamEvent> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("threads", params.getPathParam(0), "runs")
                .putAllQueryParams(clientOptions.queryParams)
                .replaceAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .replaceAllHeaders(DEFAULT_HEADERS)
                .replaceAllHeaders(params.getHeaders())
                .body(
                    json(
                        clientOptions.jsonMapper,
                        params
                            .getBody()
                            .toBuilder()
                            .putAdditionalProperty("stream", JsonValue.from(true))
                            .build()
                    )
                )
                .build()
        return clientOptions.httpClient
            .executeAsync(request, requestOptions)
            .thenApply { response ->
                response
                    .let { createStreamingHandler.handle(it) }
                    .let { streamResponse ->
                        if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                            streamResponse.map { it.validate() }
                        } else {
                            streamResponse
                        }
                    }
            }
            .toAsync(clientOptions.streamHandlerExecutor)
    }

    private val retrieveHandler: Handler<Run> =
        jsonHandler<Run>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Retrieves a run. */
    override fun retrieve(
        params: BetaThreadRunRetrieveParams,
        requestOptions: RequestOptions
    ): CompletableFuture<Run> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("threads", params.getPathParam(0), "runs", params.getPathParam(1))
                .putAllQueryParams(clientOptions.queryParams)
                .replaceAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .replaceAllHeaders(DEFAULT_HEADERS)
                .replaceAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).thenApply { response
            ->
            response
                .use { retrieveHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val updateHandler: Handler<Run> =
        jsonHandler<Run>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Modifies a run. */
    override fun update(
        params: BetaThreadRunUpdateParams,
        requestOptions: RequestOptions
    ): CompletableFuture<Run> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("threads", params.getPathParam(0), "runs", params.getPathParam(1))
                .putAllQueryParams(clientOptions.queryParams)
                .replaceAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .replaceAllHeaders(DEFAULT_HEADERS)
                .replaceAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).thenApply { response
            ->
            response
                .use { updateHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val listHandler: Handler<BetaThreadRunListPageAsync.Response> =
        jsonHandler<BetaThreadRunListPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of runs belonging to a thread. */
    override fun list(
        params: BetaThreadRunListParams,
        requestOptions: RequestOptions
    ): CompletableFuture<BetaThreadRunListPageAsync> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("threads", params.getPathParam(0), "runs")
                .putAllQueryParams(clientOptions.queryParams)
                .replaceAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .replaceAllHeaders(DEFAULT_HEADERS)
                .replaceAllHeaders(params.getHeaders())
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
                .let { BetaThreadRunListPageAsync.of(this, params, it) }
        }
    }

    private val cancelHandler: Handler<Run> =
        jsonHandler<Run>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Cancels a run that is `in_progress`. */
    override fun cancel(
        params: BetaThreadRunCancelParams,
        requestOptions: RequestOptions
    ): CompletableFuture<Run> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments(
                    "threads",
                    params.getPathParam(0),
                    "runs",
                    params.getPathParam(1),
                    "cancel"
                )
                .putAllQueryParams(clientOptions.queryParams)
                .replaceAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .replaceAllHeaders(DEFAULT_HEADERS)
                .replaceAllHeaders(params.getHeaders())
                .apply { params.getBody().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).thenApply { response
            ->
            response
                .use { cancelHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val submitToolOutputsHandler: Handler<Run> =
        jsonHandler<Run>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /**
     * When a run has the `status: "requires_action"` and `required_action.type` is
     * `submit_tool_outputs`, this endpoint can be used to submit the outputs from the tool calls
     * once they're all completed. All outputs must be submitted in a single request.
     */
    override fun submitToolOutputs(
        params: BetaThreadRunSubmitToolOutputsParams,
        requestOptions: RequestOptions
    ): CompletableFuture<Run> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments(
                    "threads",
                    params.getPathParam(0),
                    "runs",
                    params.getPathParam(1),
                    "submit_tool_outputs"
                )
                .putAllQueryParams(clientOptions.queryParams)
                .replaceAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .replaceAllHeaders(DEFAULT_HEADERS)
                .replaceAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).thenApply { response
            ->
            response
                .use { submitToolOutputsHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val submitToolOutputsStreamingHandler: Handler<StreamResponse<AssistantStreamEvent>> =
        sseHandler(clientOptions.jsonMapper)
            .mapJson<AssistantStreamEvent>(includeEventAndData = true)
            .withErrorHandler(errorHandler)

    /**
     * When a run has the `status: "requires_action"` and `required_action.type` is
     * `submit_tool_outputs`, this endpoint can be used to submit the outputs from the tool calls
     * once they're all completed. All outputs must be submitted in a single request.
     */
    override fun submitToolOutputsStreaming(
        params: BetaThreadRunSubmitToolOutputsParams,
        requestOptions: RequestOptions
    ): AsyncStreamResponse<AssistantStreamEvent> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments(
                    "threads",
                    params.getPathParam(0),
                    "runs",
                    params.getPathParam(1),
                    "submit_tool_outputs"
                )
                .putAllQueryParams(clientOptions.queryParams)
                .replaceAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .replaceAllHeaders(DEFAULT_HEADERS)
                .replaceAllHeaders(params.getHeaders())
                .body(
                    json(
                        clientOptions.jsonMapper,
                        params
                            .getBody()
                            .toBuilder()
                            .putAdditionalProperty("stream", JsonValue.from(true))
                            .build()
                    )
                )
                .build()
        return clientOptions.httpClient
            .executeAsync(request, requestOptions)
            .thenApply { response ->
                response
                    .let { submitToolOutputsStreamingHandler.handle(it) }
                    .let { streamResponse ->
                        if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                            streamResponse.map { it.validate() }
                        } else {
                            streamResponse
                        }
                    }
            }
            .toAsync(clientOptions.streamHandlerExecutor)
    }
}
