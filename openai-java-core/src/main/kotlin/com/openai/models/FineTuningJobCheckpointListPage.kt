// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.services.blocking.fineTuning.jobs.CheckpointService
import java.util.Objects
import java.util.Optional
import java.util.stream.Stream
import java.util.stream.StreamSupport

class FineTuningJobCheckpointListPage
private constructor(
    private val checkpointsService: CheckpointService,
    private val params: FineTuningJobCheckpointListParams,
    private val response: Response,
) {

    fun response(): Response = response

    fun data(): List<FineTuningJobCheckpoint> = response().data()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is FineTuningJobCheckpointListPage && checkpointsService == other.checkpointsService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(checkpointsService, params, response) /* spotless:on */

    override fun toString() =
        "FineTuningJobCheckpointListPage{checkpointsService=$checkpointsService, params=$params, response=$response}"

    fun hasNextPage(): Boolean {
        return !data().isEmpty()
    }

    fun getNextPageParams(): Optional<FineTuningJobCheckpointListParams> {
        if (!hasNextPage()) {
            return Optional.empty()
        }

        return Optional.of(
            FineTuningJobCheckpointListParams.builder()
                .from(params)
                .after(data().last().id())
                .build()
        )
    }

    fun getNextPage(): Optional<FineTuningJobCheckpointListPage> {
        return getNextPageParams().map { checkpointsService.list(it) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(
            checkpointsService: CheckpointService,
            params: FineTuningJobCheckpointListParams,
            response: Response
        ) =
            FineTuningJobCheckpointListPage(
                checkpointsService,
                params,
                response,
            )
    }

    @NoAutoDetect
    class Response
    @JsonCreator
    constructor(
        @JsonProperty("data")
        private val data: JsonField<List<FineTuningJobCheckpoint>> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        private var validated: Boolean = false

        fun data(): List<FineTuningJobCheckpoint> = data.getNullable("data") ?: listOf()

        @JsonProperty("data")
        fun _data(): Optional<JsonField<List<FineTuningJobCheckpoint>>> = Optional.ofNullable(data)

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate(): Response = apply {
            if (!validated) {
                data().map { it.validate() }
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Response && data == other.data && additionalProperties == other.additionalProperties /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(data, additionalProperties) /* spotless:on */

        override fun toString() = "Response{data=$data, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var data: JsonField<List<FineTuningJobCheckpoint>> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(page: Response) = apply {
                this.data = page.data
                this.additionalProperties.putAll(page.additionalProperties)
            }

            fun data(data: List<FineTuningJobCheckpoint>) = data(JsonField.of(data))

            fun data(data: JsonField<List<FineTuningJobCheckpoint>>) = apply { this.data = data }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                this.additionalProperties.put(key, value)
            }

            fun build() = Response(data, additionalProperties.toImmutable())
        }
    }

    class AutoPager
    constructor(
        private val firstPage: FineTuningJobCheckpointListPage,
    ) : Iterable<FineTuningJobCheckpoint> {

        override fun iterator(): Iterator<FineTuningJobCheckpoint> = iterator {
            var page = firstPage
            var index = 0
            while (true) {
                while (index < page.data().size) {
                    yield(page.data()[index++])
                }
                page = page.getNextPage().orElse(null) ?: break
                index = 0
            }
        }

        fun stream(): Stream<FineTuningJobCheckpoint> {
            return StreamSupport.stream(spliterator(), false)
        }
    }
}
