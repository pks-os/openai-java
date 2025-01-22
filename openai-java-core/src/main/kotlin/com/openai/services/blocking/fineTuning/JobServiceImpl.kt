// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.fineTuning

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.handlers.errorHandler
import com.openai.core.handlers.jsonHandler
import com.openai.core.handlers.withErrorHandler
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse.Handler
import com.openai.core.json
import com.openai.errors.OpenAIError
import com.openai.models.FineTuningJob
import com.openai.models.FineTuningJobCancelParams
import com.openai.models.FineTuningJobCreateParams
import com.openai.models.FineTuningJobListEventsPage
import com.openai.models.FineTuningJobListEventsParams
import com.openai.models.FineTuningJobListPage
import com.openai.models.FineTuningJobListParams
import com.openai.models.FineTuningJobRetrieveParams
import com.openai.services.blocking.fineTuning.jobs.CheckpointService
import com.openai.services.blocking.fineTuning.jobs.CheckpointServiceImpl

class JobServiceImpl
internal constructor(
    private val clientOptions: ClientOptions,
) : JobService {

    private val errorHandler: Handler<OpenAIError> = errorHandler(clientOptions.jsonMapper)

    private val checkpoints: CheckpointService by lazy { CheckpointServiceImpl(clientOptions) }

    override fun checkpoints(): CheckpointService = checkpoints

    private val createHandler: Handler<FineTuningJob> =
        jsonHandler<FineTuningJob>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /**
     * Creates a fine-tuning job which begins the process of creating a new model from a given
     * dataset.
     *
     * Response includes details of the enqueued job including job status and the name of the
     * fine-tuned models once complete.
     *
     * [Learn more about fine-tuning](https://platform.openai.com/docs/guides/fine-tuning)
     */
    override fun create(
        params: FineTuningJobCreateParams,
        requestOptions: RequestOptions
    ): FineTuningJob {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("fine_tuning", "jobs")
                .putAllQueryParams(clientOptions.queryParams)
                .replaceAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .replaceAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response
                .use { createHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val retrieveHandler: Handler<FineTuningJob> =
        jsonHandler<FineTuningJob>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /**
     * Get info about a fine-tuning job.
     *
     * [Learn more about fine-tuning](https://platform.openai.com/docs/guides/fine-tuning)
     */
    override fun retrieve(
        params: FineTuningJobRetrieveParams,
        requestOptions: RequestOptions
    ): FineTuningJob {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("fine_tuning", "jobs", params.getPathParam(0))
                .putAllQueryParams(clientOptions.queryParams)
                .replaceAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .replaceAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response
                .use { retrieveHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val listHandler: Handler<FineTuningJobListPage.Response> =
        jsonHandler<FineTuningJobListPage.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** List your organization's fine-tuning jobs */
    override fun list(
        params: FineTuningJobListParams,
        requestOptions: RequestOptions
    ): FineTuningJobListPage {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("fine_tuning", "jobs")
                .putAllQueryParams(clientOptions.queryParams)
                .replaceAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .replaceAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response
                .use { listHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
                .let { FineTuningJobListPage.of(this, params, it) }
        }
    }

    private val cancelHandler: Handler<FineTuningJob> =
        jsonHandler<FineTuningJob>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Immediately cancel a fine-tune job. */
    override fun cancel(
        params: FineTuningJobCancelParams,
        requestOptions: RequestOptions
    ): FineTuningJob {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("fine_tuning", "jobs", params.getPathParam(0), "cancel")
                .putAllQueryParams(clientOptions.queryParams)
                .replaceAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .replaceAllHeaders(params.getHeaders())
                .apply { params.getBody().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                .build()
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response
                .use { cancelHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val listEventsHandler: Handler<FineTuningJobListEventsPage.Response> =
        jsonHandler<FineTuningJobListEventsPage.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Get status updates for a fine-tuning job. */
    override fun listEvents(
        params: FineTuningJobListEventsParams,
        requestOptions: RequestOptions
    ): FineTuningJobListEventsPage {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("fine_tuning", "jobs", params.getPathParam(0), "events")
                .putAllQueryParams(clientOptions.queryParams)
                .replaceAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .replaceAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response
                .use { listEventsHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
                .let { FineTuningJobListEventsPage.of(this, params, it) }
        }
    }
}
