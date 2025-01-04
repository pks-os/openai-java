// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional

/**
 * Represents a completion response from the API. Note: both the streamed and non-streamed response
 * objects share the same shape (unlike the chat endpoint).
 */
@NoAutoDetect
class Completion
@JsonCreator
private constructor(
    @JsonProperty("id") @ExcludeMissing private val id: JsonField<String> = JsonMissing.of(),
    @JsonProperty("choices")
    @ExcludeMissing
    private val choices: JsonField<List<CompletionChoice>> = JsonMissing.of(),
    @JsonProperty("created")
    @ExcludeMissing
    private val created: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("model") @ExcludeMissing private val model: JsonField<String> = JsonMissing.of(),
    @JsonProperty("system_fingerprint")
    @ExcludeMissing
    private val systemFingerprint: JsonField<String> = JsonMissing.of(),
    @JsonProperty("object")
    @ExcludeMissing
    private val object_: JsonField<Object> = JsonMissing.of(),
    @JsonProperty("usage")
    @ExcludeMissing
    private val usage: JsonField<CompletionUsage> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** A unique identifier for the completion. */
    fun id(): String = id.getRequired("id")

    /** The list of completion choices the model generated for the input prompt. */
    fun choices(): List<CompletionChoice> = choices.getRequired("choices")

    /** The Unix timestamp (in seconds) of when the completion was created. */
    fun created(): Long = created.getRequired("created")

    /** The model used for completion. */
    fun model(): String = model.getRequired("model")

    /**
     * This fingerprint represents the backend configuration that the model runs with.
     *
     * Can be used in conjunction with the `seed` request parameter to understand when backend
     * changes have been made that might impact determinism.
     */
    fun systemFingerprint(): Optional<String> =
        Optional.ofNullable(systemFingerprint.getNullable("system_fingerprint"))

    /** The object type, which is always "text_completion" */
    fun object_(): Object = object_.getRequired("object")

    /** Usage statistics for the completion request. */
    fun usage(): Optional<CompletionUsage> = Optional.ofNullable(usage.getNullable("usage"))

    /** A unique identifier for the completion. */
    @JsonProperty("id") @ExcludeMissing fun _id() = id

    /** The list of completion choices the model generated for the input prompt. */
    @JsonProperty("choices") @ExcludeMissing fun _choices() = choices

    /** The Unix timestamp (in seconds) of when the completion was created. */
    @JsonProperty("created") @ExcludeMissing fun _created() = created

    /** The model used for completion. */
    @JsonProperty("model") @ExcludeMissing fun _model() = model

    /**
     * This fingerprint represents the backend configuration that the model runs with.
     *
     * Can be used in conjunction with the `seed` request parameter to understand when backend
     * changes have been made that might impact determinism.
     */
    @JsonProperty("system_fingerprint") @ExcludeMissing fun _systemFingerprint() = systemFingerprint

    /** The object type, which is always "text_completion" */
    @JsonProperty("object") @ExcludeMissing fun _object_() = object_

    /** Usage statistics for the completion request. */
    @JsonProperty("usage") @ExcludeMissing fun _usage() = usage

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): Completion = apply {
        if (!validated) {
            id()
            choices().forEach { it.validate() }
            created()
            model()
            systemFingerprint()
            object_()
            usage().map { it.validate() }
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<String> = JsonMissing.of()
        private var choices: JsonField<List<CompletionChoice>> = JsonMissing.of()
        private var created: JsonField<Long> = JsonMissing.of()
        private var model: JsonField<String> = JsonMissing.of()
        private var systemFingerprint: JsonField<String> = JsonMissing.of()
        private var object_: JsonField<Object> = JsonMissing.of()
        private var usage: JsonField<CompletionUsage> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(completion: Completion) = apply {
            id = completion.id
            choices = completion.choices
            created = completion.created
            model = completion.model
            systemFingerprint = completion.systemFingerprint
            object_ = completion.object_
            usage = completion.usage
            additionalProperties = completion.additionalProperties.toMutableMap()
        }

        /** A unique identifier for the completion. */
        fun id(id: String) = id(JsonField.of(id))

        /** A unique identifier for the completion. */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The list of completion choices the model generated for the input prompt. */
        fun choices(choices: List<CompletionChoice>) = choices(JsonField.of(choices))

        /** The list of completion choices the model generated for the input prompt. */
        fun choices(choices: JsonField<List<CompletionChoice>>) = apply { this.choices = choices }

        /** The Unix timestamp (in seconds) of when the completion was created. */
        fun created(created: Long) = created(JsonField.of(created))

        /** The Unix timestamp (in seconds) of when the completion was created. */
        fun created(created: JsonField<Long>) = apply { this.created = created }

        /** The model used for completion. */
        fun model(model: String) = model(JsonField.of(model))

        /** The model used for completion. */
        fun model(model: JsonField<String>) = apply { this.model = model }

        /**
         * This fingerprint represents the backend configuration that the model runs with.
         *
         * Can be used in conjunction with the `seed` request parameter to understand when backend
         * changes have been made that might impact determinism.
         */
        fun systemFingerprint(systemFingerprint: String) =
            systemFingerprint(JsonField.of(systemFingerprint))

        /**
         * This fingerprint represents the backend configuration that the model runs with.
         *
         * Can be used in conjunction with the `seed` request parameter to understand when backend
         * changes have been made that might impact determinism.
         */
        fun systemFingerprint(systemFingerprint: JsonField<String>) = apply {
            this.systemFingerprint = systemFingerprint
        }

        /** The object type, which is always "text_completion" */
        fun object_(object_: Object) = object_(JsonField.of(object_))

        /** The object type, which is always "text_completion" */
        fun object_(object_: JsonField<Object>) = apply { this.object_ = object_ }

        /** Usage statistics for the completion request. */
        fun usage(usage: CompletionUsage) = usage(JsonField.of(usage))

        /** Usage statistics for the completion request. */
        fun usage(usage: JsonField<CompletionUsage>) = apply { this.usage = usage }

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

        fun build(): Completion =
            Completion(
                id,
                choices.map { it.toImmutable() },
                created,
                model,
                systemFingerprint,
                object_,
                usage,
                additionalProperties.toImmutable(),
            )
    }

    class Object
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val TEXT_COMPLETION = of("text_completion")

            @JvmStatic fun of(value: String) = Object(JsonField.of(value))
        }

        enum class Known {
            TEXT_COMPLETION,
        }

        enum class Value {
            TEXT_COMPLETION,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                TEXT_COMPLETION -> Value.TEXT_COMPLETION
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                TEXT_COMPLETION -> Known.TEXT_COMPLETION
                else -> throw OpenAIInvalidDataException("Unknown Object: $value")
            }

        fun asString(): String = _value().asStringOrThrow()

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Object && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is Completion && id == other.id && choices == other.choices && created == other.created && model == other.model && systemFingerprint == other.systemFingerprint && object_ == other.object_ && usage == other.usage && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, choices, created, model, systemFingerprint, object_, usage, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Completion{id=$id, choices=$choices, created=$created, model=$model, systemFingerprint=$systemFingerprint, object_=$object_, usage=$usage, additionalProperties=$additionalProperties}"
}
