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

@NoAutoDetect
class FineTuningJobWandbIntegrationObject
@JsonCreator
private constructor(
    @JsonProperty("type") @ExcludeMissing private val type: JsonField<Type> = JsonMissing.of(),
    @JsonProperty("wandb")
    @ExcludeMissing
    private val wandb: JsonField<FineTuningJobWandbIntegration> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** The type of the integration being enabled for the fine-tuning job */
    fun type(): Type = type.getRequired("type")

    /**
     * The settings for your integration with Weights and Biases. This payload specifies the project
     * that metrics will be sent to. Optionally, you can set an explicit display name for your run,
     * add tags to your run, and set a default entity (team, username, etc) to be associated with
     * your run.
     */
    fun wandb(): FineTuningJobWandbIntegration = wandb.getRequired("wandb")

    /** The type of the integration being enabled for the fine-tuning job */
    @JsonProperty("type") @ExcludeMissing fun _type() = type

    /**
     * The settings for your integration with Weights and Biases. This payload specifies the project
     * that metrics will be sent to. Optionally, you can set an explicit display name for your run,
     * add tags to your run, and set a default entity (team, username, etc) to be associated with
     * your run.
     */
    @JsonProperty("wandb") @ExcludeMissing fun _wandb() = wandb

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): FineTuningJobWandbIntegrationObject = apply {
        if (!validated) {
            type()
            wandb().validate()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var type: JsonField<Type> = JsonMissing.of()
        private var wandb: JsonField<FineTuningJobWandbIntegration> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(
            fineTuningJobWandbIntegrationObject: FineTuningJobWandbIntegrationObject
        ) = apply {
            type = fineTuningJobWandbIntegrationObject.type
            wandb = fineTuningJobWandbIntegrationObject.wandb
            additionalProperties =
                fineTuningJobWandbIntegrationObject.additionalProperties.toMutableMap()
        }

        /** The type of the integration being enabled for the fine-tuning job */
        fun type(type: Type) = type(JsonField.of(type))

        /** The type of the integration being enabled for the fine-tuning job */
        fun type(type: JsonField<Type>) = apply { this.type = type }

        /**
         * The settings for your integration with Weights and Biases. This payload specifies the
         * project that metrics will be sent to. Optionally, you can set an explicit display name
         * for your run, add tags to your run, and set a default entity (team, username, etc) to be
         * associated with your run.
         */
        fun wandb(wandb: FineTuningJobWandbIntegration) = wandb(JsonField.of(wandb))

        /**
         * The settings for your integration with Weights and Biases. This payload specifies the
         * project that metrics will be sent to. Optionally, you can set an explicit display name
         * for your run, add tags to your run, and set a default entity (team, username, etc) to be
         * associated with your run.
         */
        fun wandb(wandb: JsonField<FineTuningJobWandbIntegration>) = apply { this.wandb = wandb }

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

        fun build(): FineTuningJobWandbIntegrationObject =
            FineTuningJobWandbIntegrationObject(
                type,
                wandb,
                additionalProperties.toImmutable(),
            )
    }

    class Type
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val WANDB = of("wandb")

            @JvmStatic fun of(value: String) = Type(JsonField.of(value))
        }

        enum class Known {
            WANDB,
        }

        enum class Value {
            WANDB,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                WANDB -> Value.WANDB
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                WANDB -> Known.WANDB
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

        return /* spotless:off */ other is FineTuningJobWandbIntegrationObject && type == other.type && wandb == other.wandb && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(type, wandb, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FineTuningJobWandbIntegrationObject{type=$type, wandb=$wandb, additionalProperties=$additionalProperties}"
}
