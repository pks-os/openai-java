// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional

class BatchCreateParams
constructor(
    private val body: BatchCreateBody,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) {

    /**
     * The time frame within which the batch should be processed. Currently only `24h` is supported.
     */
    fun completionWindow(): CompletionWindow = body.completionWindow()

    /**
     * The endpoint to be used for all requests in the batch. Currently `/v1/chat/completions`,
     * `/v1/embeddings`, and `/v1/completions` are supported. Note that `/v1/embeddings` batches are
     * also restricted to a maximum of 50,000 embedding inputs across all requests in the batch.
     */
    fun endpoint(): Endpoint = body.endpoint()

    /**
     * The ID of an uploaded file that contains requests for the new batch.
     *
     * See [upload file](https://platform.openai.com/docs/api-reference/files/create) for how to
     * upload a file.
     *
     * Your input file must be formatted as a
     * [JSONL file](https://platform.openai.com/docs/api-reference/batch/request-input), and must be
     * uploaded with the purpose `batch`. The file can contain up to 50,000 requests, and can be up
     * to 200 MB in size.
     */
    fun inputFileId(): String = body.inputFileId()

    /** Optional custom metadata for the batch. */
    fun metadata(): Optional<Metadata> = body.metadata()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    @JvmSynthetic internal fun getBody(): BatchCreateBody = body

    @JvmSynthetic internal fun getHeaders(): Headers = additionalHeaders

    @JvmSynthetic internal fun getQueryParams(): QueryParams = additionalQueryParams

    @NoAutoDetect
    class BatchCreateBody
    @JsonCreator
    internal constructor(
        @JsonProperty("completion_window") private val completionWindow: CompletionWindow,
        @JsonProperty("endpoint") private val endpoint: Endpoint,
        @JsonProperty("input_file_id") private val inputFileId: String,
        @JsonProperty("metadata") private val metadata: Metadata?,
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * The time frame within which the batch should be processed. Currently only `24h` is
         * supported.
         */
        @JsonProperty("completion_window")
        fun completionWindow(): CompletionWindow = completionWindow

        /**
         * The endpoint to be used for all requests in the batch. Currently `/v1/chat/completions`,
         * `/v1/embeddings`, and `/v1/completions` are supported. Note that `/v1/embeddings` batches
         * are also restricted to a maximum of 50,000 embedding inputs across all requests in the
         * batch.
         */
        @JsonProperty("endpoint") fun endpoint(): Endpoint = endpoint

        /**
         * The ID of an uploaded file that contains requests for the new batch.
         *
         * See [upload file](https://platform.openai.com/docs/api-reference/files/create) for how to
         * upload a file.
         *
         * Your input file must be formatted as a
         * [JSONL file](https://platform.openai.com/docs/api-reference/batch/request-input), and
         * must be uploaded with the purpose `batch`. The file can contain up to 50,000 requests,
         * and can be up to 200 MB in size.
         */
        @JsonProperty("input_file_id") fun inputFileId(): String = inputFileId

        /** Optional custom metadata for the batch. */
        @JsonProperty("metadata") fun metadata(): Optional<Metadata> = Optional.ofNullable(metadata)

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var completionWindow: CompletionWindow? = null
            private var endpoint: Endpoint? = null
            private var inputFileId: String? = null
            private var metadata: Metadata? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(batchCreateBody: BatchCreateBody) = apply {
                completionWindow = batchCreateBody.completionWindow
                endpoint = batchCreateBody.endpoint
                inputFileId = batchCreateBody.inputFileId
                metadata = batchCreateBody.metadata
                additionalProperties = batchCreateBody.additionalProperties.toMutableMap()
            }

            /**
             * The time frame within which the batch should be processed. Currently only `24h` is
             * supported.
             */
            fun completionWindow(completionWindow: CompletionWindow) = apply {
                this.completionWindow = completionWindow
            }

            /**
             * The endpoint to be used for all requests in the batch. Currently
             * `/v1/chat/completions`, `/v1/embeddings`, and `/v1/completions` are supported. Note
             * that `/v1/embeddings` batches are also restricted to a maximum of 50,000 embedding
             * inputs across all requests in the batch.
             */
            fun endpoint(endpoint: Endpoint) = apply { this.endpoint = endpoint }

            /**
             * The ID of an uploaded file that contains requests for the new batch.
             *
             * See [upload file](https://platform.openai.com/docs/api-reference/files/create) for
             * how to upload a file.
             *
             * Your input file must be formatted as a
             * [JSONL file](https://platform.openai.com/docs/api-reference/batch/request-input), and
             * must be uploaded with the purpose `batch`. The file can contain up to 50,000
             * requests, and can be up to 200 MB in size.
             */
            fun inputFileId(inputFileId: String) = apply { this.inputFileId = inputFileId }

            /** Optional custom metadata for the batch. */
            fun metadata(metadata: Metadata) = apply { this.metadata = metadata }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            fun build(): BatchCreateBody =
                BatchCreateBody(
                    checkNotNull(completionWindow) {
                        "`completionWindow` is required but was not set"
                    },
                    checkNotNull(endpoint) { "`endpoint` is required but was not set" },
                    checkNotNull(inputFileId) { "`inputFileId` is required but was not set" },
                    metadata,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is BatchCreateBody && completionWindow == other.completionWindow && endpoint == other.endpoint && inputFileId == other.inputFileId && metadata == other.metadata && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(completionWindow, endpoint, inputFileId, metadata, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "BatchCreateBody{completionWindow=$completionWindow, endpoint=$endpoint, inputFileId=$inputFileId, metadata=$metadata, additionalProperties=$additionalProperties}"
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var body: BatchCreateBody.Builder = BatchCreateBody.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(batchCreateParams: BatchCreateParams) = apply {
            body = batchCreateParams.body.toBuilder()
            additionalHeaders = batchCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = batchCreateParams.additionalQueryParams.toBuilder()
        }

        /**
         * The time frame within which the batch should be processed. Currently only `24h` is
         * supported.
         */
        fun completionWindow(completionWindow: CompletionWindow) = apply {
            body.completionWindow(completionWindow)
        }

        /**
         * The endpoint to be used for all requests in the batch. Currently `/v1/chat/completions`,
         * `/v1/embeddings`, and `/v1/completions` are supported. Note that `/v1/embeddings` batches
         * are also restricted to a maximum of 50,000 embedding inputs across all requests in the
         * batch.
         */
        fun endpoint(endpoint: Endpoint) = apply { body.endpoint(endpoint) }

        /**
         * The ID of an uploaded file that contains requests for the new batch.
         *
         * See [upload file](https://platform.openai.com/docs/api-reference/files/create) for how to
         * upload a file.
         *
         * Your input file must be formatted as a
         * [JSONL file](https://platform.openai.com/docs/api-reference/batch/request-input), and
         * must be uploaded with the purpose `batch`. The file can contain up to 50,000 requests,
         * and can be up to 200 MB in size.
         */
        fun inputFileId(inputFileId: String) = apply { body.inputFileId(inputFileId) }

        /** Optional custom metadata for the batch. */
        fun metadata(metadata: Metadata) = apply { body.metadata(metadata) }

        fun additionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun putAdditionalHeader(name: String, value: String) = apply {
            additionalHeaders.put(name, value)
        }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.put(name, values)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun replaceAdditionalHeaders(name: String, value: String) = apply {
            additionalHeaders.replace(name, value)
        }

        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.replace(name, values)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun removeAdditionalHeaders(name: String) = apply { additionalHeaders.remove(name) }

        fun removeAllAdditionalHeaders(names: Set<String>) = apply {
            additionalHeaders.removeAll(names)
        }

        fun additionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun putAdditionalQueryParam(key: String, value: String) = apply {
            additionalQueryParams.put(key, value)
        }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.put(key, values)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.putAll(additionalQueryParams)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceAdditionalQueryParams(key: String, value: String) = apply {
            additionalQueryParams.replace(key, value)
        }

        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.replace(key, values)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.replaceAll(additionalQueryParams)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun removeAdditionalQueryParams(key: String) = apply { additionalQueryParams.remove(key) }

        fun removeAllAdditionalQueryParams(keys: Set<String>) = apply {
            additionalQueryParams.removeAll(keys)
        }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            body.additionalProperties(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            body.putAdditionalProperty(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                body.putAllAdditionalProperties(additionalBodyProperties)
            }

        fun removeAdditionalBodyProperty(key: String) = apply { body.removeAdditionalProperty(key) }

        fun removeAllAdditionalBodyProperties(keys: Set<String>) = apply {
            body.removeAllAdditionalProperties(keys)
        }

        fun build(): BatchCreateParams =
            BatchCreateParams(
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    class CompletionWindow
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val _24H = of("24h")

            @JvmStatic fun of(value: String) = CompletionWindow(JsonField.of(value))
        }

        enum class Known {
            _24H,
        }

        enum class Value {
            _24H,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                _24H -> Value._24H
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                _24H -> Known._24H
                else -> throw OpenAIInvalidDataException("Unknown CompletionWindow: $value")
            }

        fun asString(): String = _value().asStringOrThrow()

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is CompletionWindow && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    class Endpoint
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val V1_CHAT_COMPLETIONS = of("/v1/chat/completions")

            @JvmField val V1_EMBEDDINGS = of("/v1/embeddings")

            @JvmField val V1_COMPLETIONS = of("/v1/completions")

            @JvmStatic fun of(value: String) = Endpoint(JsonField.of(value))
        }

        enum class Known {
            V1_CHAT_COMPLETIONS,
            V1_EMBEDDINGS,
            V1_COMPLETIONS,
        }

        enum class Value {
            V1_CHAT_COMPLETIONS,
            V1_EMBEDDINGS,
            V1_COMPLETIONS,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                V1_CHAT_COMPLETIONS -> Value.V1_CHAT_COMPLETIONS
                V1_EMBEDDINGS -> Value.V1_EMBEDDINGS
                V1_COMPLETIONS -> Value.V1_COMPLETIONS
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                V1_CHAT_COMPLETIONS -> Known.V1_CHAT_COMPLETIONS
                V1_EMBEDDINGS -> Known.V1_EMBEDDINGS
                V1_COMPLETIONS -> Known.V1_COMPLETIONS
                else -> throw OpenAIInvalidDataException("Unknown Endpoint: $value")
            }

        fun asString(): String = _value().asStringOrThrow()

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Endpoint && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** Optional custom metadata for the batch. */
    @NoAutoDetect
    class Metadata
    @JsonCreator
    private constructor(
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(metadata: Metadata) = apply {
                additionalProperties = metadata.additionalProperties.toMutableMap()
            }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            fun build(): Metadata = Metadata(additionalProperties.toImmutable())
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Metadata && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() = "Metadata{additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is BatchCreateParams && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "BatchCreateParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
