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

/**
 * A URL for the file that's generated when the assistant used the `code_interpreter` tool to
 * generate a file.
 */
@NoAutoDetect
class FilePathAnnotation
@JsonCreator
private constructor(
    @JsonProperty("type") @ExcludeMissing private val type: JsonField<Type> = JsonMissing.of(),
    @JsonProperty("text") @ExcludeMissing private val text: JsonField<String> = JsonMissing.of(),
    @JsonProperty("file_path")
    @ExcludeMissing
    private val filePath: JsonField<FilePath> = JsonMissing.of(),
    @JsonProperty("start_index")
    @ExcludeMissing
    private val startIndex: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("end_index")
    @ExcludeMissing
    private val endIndex: JsonField<Long> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** Always `file_path`. */
    fun type(): Type = type.getRequired("type")

    /** The text in the message content that needs to be replaced. */
    fun text(): String = text.getRequired("text")

    fun filePath(): FilePath = filePath.getRequired("file_path")

    fun startIndex(): Long = startIndex.getRequired("start_index")

    fun endIndex(): Long = endIndex.getRequired("end_index")

    /** Always `file_path`. */
    @JsonProperty("type") @ExcludeMissing fun _type() = type

    /** The text in the message content that needs to be replaced. */
    @JsonProperty("text") @ExcludeMissing fun _text() = text

    @JsonProperty("file_path") @ExcludeMissing fun _filePath() = filePath

    @JsonProperty("start_index") @ExcludeMissing fun _startIndex() = startIndex

    @JsonProperty("end_index") @ExcludeMissing fun _endIndex() = endIndex

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): FilePathAnnotation = apply {
        if (!validated) {
            type()
            text()
            filePath().validate()
            startIndex()
            endIndex()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var type: JsonField<Type> = JsonMissing.of()
        private var text: JsonField<String> = JsonMissing.of()
        private var filePath: JsonField<FilePath> = JsonMissing.of()
        private var startIndex: JsonField<Long> = JsonMissing.of()
        private var endIndex: JsonField<Long> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(filePathAnnotation: FilePathAnnotation) = apply {
            type = filePathAnnotation.type
            text = filePathAnnotation.text
            filePath = filePathAnnotation.filePath
            startIndex = filePathAnnotation.startIndex
            endIndex = filePathAnnotation.endIndex
            additionalProperties = filePathAnnotation.additionalProperties.toMutableMap()
        }

        /** Always `file_path`. */
        fun type(type: Type) = type(JsonField.of(type))

        /** Always `file_path`. */
        fun type(type: JsonField<Type>) = apply { this.type = type }

        /** The text in the message content that needs to be replaced. */
        fun text(text: String) = text(JsonField.of(text))

        /** The text in the message content that needs to be replaced. */
        fun text(text: JsonField<String>) = apply { this.text = text }

        fun filePath(filePath: FilePath) = filePath(JsonField.of(filePath))

        fun filePath(filePath: JsonField<FilePath>) = apply { this.filePath = filePath }

        fun startIndex(startIndex: Long) = startIndex(JsonField.of(startIndex))

        fun startIndex(startIndex: JsonField<Long>) = apply { this.startIndex = startIndex }

        fun endIndex(endIndex: Long) = endIndex(JsonField.of(endIndex))

        fun endIndex(endIndex: JsonField<Long>) = apply { this.endIndex = endIndex }

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

        fun build(): FilePathAnnotation =
            FilePathAnnotation(
                type,
                text,
                filePath,
                startIndex,
                endIndex,
                additionalProperties.toImmutable(),
            )
    }

    @NoAutoDetect
    class FilePath
    @JsonCreator
    private constructor(
        @JsonProperty("file_id")
        @ExcludeMissing
        private val fileId: JsonField<String> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /** The ID of the file that was generated. */
        fun fileId(): String = fileId.getRequired("file_id")

        /** The ID of the file that was generated. */
        @JsonProperty("file_id") @ExcludeMissing fun _fileId() = fileId

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): FilePath = apply {
            if (!validated) {
                fileId()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var fileId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(filePath: FilePath) = apply {
                fileId = filePath.fileId
                additionalProperties = filePath.additionalProperties.toMutableMap()
            }

            /** The ID of the file that was generated. */
            fun fileId(fileId: String) = fileId(JsonField.of(fileId))

            /** The ID of the file that was generated. */
            fun fileId(fileId: JsonField<String>) = apply { this.fileId = fileId }

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

            fun build(): FilePath = FilePath(fileId, additionalProperties.toImmutable())
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is FilePath && fileId == other.fileId && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(fileId, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "FilePath{fileId=$fileId, additionalProperties=$additionalProperties}"
    }

    class Type
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val FILE_PATH = of("file_path")

            @JvmStatic fun of(value: String) = Type(JsonField.of(value))
        }

        enum class Known {
            FILE_PATH,
        }

        enum class Value {
            FILE_PATH,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                FILE_PATH -> Value.FILE_PATH
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                FILE_PATH -> Known.FILE_PATH
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

        return /* spotless:off */ other is FilePathAnnotation && type == other.type && text == other.text && filePath == other.filePath && startIndex == other.startIndex && endIndex == other.endIndex && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(type, text, filePath, startIndex, endIndex, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FilePathAnnotation{type=$type, text=$text, filePath=$filePath, startIndex=$startIndex, endIndex=$endIndex, additionalProperties=$additionalProperties}"
}
