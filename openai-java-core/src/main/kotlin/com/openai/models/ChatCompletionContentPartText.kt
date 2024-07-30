// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.toUnmodifiable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects

@JsonDeserialize(builder = ChatCompletionContentPartText.Builder::class)
@NoAutoDetect
class ChatCompletionContentPartText
private constructor(
    private val type: JsonField<Type>,
    private val text: JsonField<String>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    /** The type of the content part. */
    fun type(): Type = type.getRequired("type")

    /** The text content. */
    fun text(): String = text.getRequired("text")

    /** The type of the content part. */
    @JsonProperty("type") @ExcludeMissing fun _type() = type

    /** The text content. */
    @JsonProperty("text") @ExcludeMissing fun _text() = text

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): ChatCompletionContentPartText = apply {
        if (!validated) {
            type()
            text()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ChatCompletionContentPartText &&
            this.type == other.type &&
            this.text == other.text &&
            this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode =
                Objects.hash(
                    type,
                    text,
                    additionalProperties,
                )
        }
        return hashCode
    }

    override fun toString() =
        "ChatCompletionContentPartText{type=$type, text=$text, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var type: JsonField<Type> = JsonMissing.of()
        private var text: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(chatCompletionContentPartText: ChatCompletionContentPartText) = apply {
            this.type = chatCompletionContentPartText.type
            this.text = chatCompletionContentPartText.text
            additionalProperties(chatCompletionContentPartText.additionalProperties)
        }

        /** The type of the content part. */
        fun type(type: Type) = type(JsonField.of(type))

        /** The type of the content part. */
        @JsonProperty("type")
        @ExcludeMissing
        fun type(type: JsonField<Type>) = apply { this.type = type }

        /** The text content. */
        fun text(text: String) = text(JsonField.of(text))

        /** The text content. */
        @JsonProperty("text")
        @ExcludeMissing
        fun text(text: JsonField<String>) = apply { this.text = text }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            this.additionalProperties.putAll(additionalProperties)
        }

        @JsonAnySetter
        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            this.additionalProperties.put(key, value)
        }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun build(): ChatCompletionContentPartText =
            ChatCompletionContentPartText(
                type,
                text,
                additionalProperties.toUnmodifiable(),
            )
    }

    class Type
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Type && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val TEXT = Type(JsonField.of("text"))

            @JvmStatic fun of(value: String) = Type(JsonField.of(value))
        }

        enum class Known {
            TEXT,
        }

        enum class Value {
            TEXT,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                TEXT -> Value.TEXT
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                TEXT -> Known.TEXT
                else -> throw OpenAIInvalidDataException("Unknown Type: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }
}