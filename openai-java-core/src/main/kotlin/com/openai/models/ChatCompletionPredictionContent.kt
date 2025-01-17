// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.BaseDeserializer
import com.openai.core.BaseSerializer
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional

/**
 * Static predicted output content, such as the content of a text file that is being regenerated.
 */
@NoAutoDetect
class ChatCompletionPredictionContent
@JsonCreator
private constructor(
    @JsonProperty("content")
    @ExcludeMissing
    private val content: JsonField<Content> = JsonMissing.of(),
    @JsonProperty("type") @ExcludeMissing private val type: JsonField<Type> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /**
     * The content that should be matched when generating a model response. If generated tokens
     * would match this content, the entire model response can be returned much more quickly.
     */
    fun content(): Content = content.getRequired("content")

    /**
     * The type of the predicted content you want to provide. This type is currently always
     * `content`.
     */
    fun type(): Type = type.getRequired("type")

    /**
     * The content that should be matched when generating a model response. If generated tokens
     * would match this content, the entire model response can be returned much more quickly.
     */
    @JsonProperty("content") @ExcludeMissing fun _content(): JsonField<Content> = content

    /**
     * The type of the predicted content you want to provide. This type is currently always
     * `content`.
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): ChatCompletionPredictionContent = apply {
        if (validated) {
            return@apply
        }

        content().validate()
        type()
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var content: JsonField<Content>? = null
        private var type: JsonField<Type>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(chatCompletionPredictionContent: ChatCompletionPredictionContent) =
            apply {
                content = chatCompletionPredictionContent.content
                type = chatCompletionPredictionContent.type
                additionalProperties =
                    chatCompletionPredictionContent.additionalProperties.toMutableMap()
            }

        /**
         * The content that should be matched when generating a model response. If generated tokens
         * would match this content, the entire model response can be returned much more quickly.
         */
        fun content(content: Content) = content(JsonField.of(content))

        /**
         * The content that should be matched when generating a model response. If generated tokens
         * would match this content, the entire model response can be returned much more quickly.
         */
        fun content(content: JsonField<Content>) = apply { this.content = content }

        /**
         * The content used for a Predicted Output. This is often the text of a file you are
         * regenerating with minor changes.
         */
        fun content(textContent: String) = content(Content.ofTextContent(textContent))

        /**
         * An array of content parts with a defined type. Supported options differ based on the
         * [model](https://platform.openai.com/docs/models) being used to generate the response. Can
         * contain text inputs.
         */
        fun contentOfArrayOfContentParts(arrayOfContentParts: List<ChatCompletionContentPartText>) =
            content(Content.ofArrayOfContentParts(arrayOfContentParts))

        /**
         * The type of the predicted content you want to provide. This type is currently always
         * `content`.
         */
        fun type(type: Type) = type(JsonField.of(type))

        /**
         * The type of the predicted content you want to provide. This type is currently always
         * `content`.
         */
        fun type(type: JsonField<Type>) = apply { this.type = type }

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

        fun build(): ChatCompletionPredictionContent =
            ChatCompletionPredictionContent(
                checkRequired("content", content),
                checkRequired("type", type),
                additionalProperties.toImmutable(),
            )
    }

    /**
     * The content that should be matched when generating a model response. If generated tokens
     * would match this content, the entire model response can be returned much more quickly.
     */
    @JsonDeserialize(using = Content.Deserializer::class)
    @JsonSerialize(using = Content.Serializer::class)
    class Content
    private constructor(
        private val textContent: String? = null,
        private val arrayOfContentParts: List<ChatCompletionContentPartText>? = null,
        private val _json: JsonValue? = null,
    ) {

        /**
         * The content used for a Predicted Output. This is often the text of a file you are
         * regenerating with minor changes.
         */
        fun textContent(): Optional<String> = Optional.ofNullable(textContent)

        /**
         * An array of content parts with a defined type. Supported options differ based on the
         * [model](https://platform.openai.com/docs/models) being used to generate the response. Can
         * contain text inputs.
         */
        fun arrayOfContentParts(): Optional<List<ChatCompletionContentPartText>> =
            Optional.ofNullable(arrayOfContentParts)

        fun isTextContent(): Boolean = textContent != null

        fun isArrayOfContentParts(): Boolean = arrayOfContentParts != null

        /**
         * The content used for a Predicted Output. This is often the text of a file you are
         * regenerating with minor changes.
         */
        fun asTextContent(): String = textContent.getOrThrow("textContent")

        /**
         * An array of content parts with a defined type. Supported options differ based on the
         * [model](https://platform.openai.com/docs/models) being used to generate the response. Can
         * contain text inputs.
         */
        fun asArrayOfContentParts(): List<ChatCompletionContentPartText> =
            arrayOfContentParts.getOrThrow("arrayOfContentParts")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T {
            return when {
                textContent != null -> visitor.visitTextContent(textContent)
                arrayOfContentParts != null -> visitor.visitArrayOfContentParts(arrayOfContentParts)
                else -> visitor.unknown(_json)
            }
        }

        private var validated: Boolean = false

        fun validate(): Content = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitTextContent(textContent: String) {}

                    override fun visitArrayOfContentParts(
                        arrayOfContentParts: List<ChatCompletionContentPartText>
                    ) {
                        arrayOfContentParts.forEach { it.validate() }
                    }
                }
            )
            validated = true
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Content && textContent == other.textContent && arrayOfContentParts == other.arrayOfContentParts /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(textContent, arrayOfContentParts) /* spotless:on */

        override fun toString(): String =
            when {
                textContent != null -> "Content{textContent=$textContent}"
                arrayOfContentParts != null -> "Content{arrayOfContentParts=$arrayOfContentParts}"
                _json != null -> "Content{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Content")
            }

        companion object {

            /**
             * The content used for a Predicted Output. This is often the text of a file you are
             * regenerating with minor changes.
             */
            @JvmStatic fun ofTextContent(textContent: String) = Content(textContent = textContent)

            /**
             * An array of content parts with a defined type. Supported options differ based on the
             * [model](https://platform.openai.com/docs/models) being used to generate the response.
             * Can contain text inputs.
             */
            @JvmStatic
            fun ofArrayOfContentParts(arrayOfContentParts: List<ChatCompletionContentPartText>) =
                Content(arrayOfContentParts = arrayOfContentParts)
        }

        interface Visitor<out T> {

            fun visitTextContent(textContent: String): T

            fun visitArrayOfContentParts(
                arrayOfContentParts: List<ChatCompletionContentPartText>
            ): T

            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown Content: $json")
            }
        }

        class Deserializer : BaseDeserializer<Content>(Content::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Content {
                val json = JsonValue.fromJsonNode(node)

                tryDeserialize(node, jacksonTypeRef<String>())?.let {
                    return Content(textContent = it, _json = json)
                }
                tryDeserialize(node, jacksonTypeRef<List<ChatCompletionContentPartText>>()) {
                        it.forEach { it.validate() }
                    }
                    ?.let {
                        return Content(arrayOfContentParts = it, _json = json)
                    }

                return Content(_json = json)
            }
        }

        class Serializer : BaseSerializer<Content>(Content::class) {

            override fun serialize(
                value: Content,
                generator: JsonGenerator,
                provider: SerializerProvider
            ) {
                when {
                    value.textContent != null -> generator.writeObject(value.textContent)
                    value.arrayOfContentParts != null ->
                        generator.writeObject(value.arrayOfContentParts)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Content")
                }
            }
        }
    }

    class Type
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val CONTENT = of("content")

            @JvmStatic fun of(value: String) = Type(JsonField.of(value))
        }

        enum class Known {
            CONTENT,
        }

        enum class Value {
            CONTENT,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                CONTENT -> Value.CONTENT
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                CONTENT -> Known.CONTENT
                else -> throw OpenAIInvalidDataException("Unknown Type: $value")
            }

        fun asString(): String = _value().asStringOrThrow()

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Type && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ChatCompletionPredictionContent && content == other.content && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(content, type, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ChatCompletionPredictionContent{content=$content, type=$type, additionalProperties=$additionalProperties}"
}
