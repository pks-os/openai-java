// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.openai.core.JsonValue
import com.openai.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BetaThreadRunCreateParamsTest {

    @Test
    fun createBetaThreadRunCreateParams() {
        BetaThreadRunCreateParams.builder()
            .threadId("thread_id")
            .assistantId("assistant_id")
            .include(listOf(RunStepInclude.STEP_DETAILS_TOOL_CALLS_FILE_SEARCH_RESULTS_CONTENT))
            .additionalInstructions("additional_instructions")
            .additionalMessages(
                listOf(
                    BetaThreadRunCreateParams.AdditionalMessage.builder()
                        .content(
                            BetaThreadRunCreateParams.AdditionalMessage.Content.ofTextContent(
                                "string"
                            )
                        )
                        .role(BetaThreadRunCreateParams.AdditionalMessage.Role.USER)
                        .attachments(
                            listOf(
                                BetaThreadRunCreateParams.AdditionalMessage.Attachment.builder()
                                    .fileId("file_id")
                                    .tools(
                                        listOf(
                                            BetaThreadRunCreateParams.AdditionalMessage.Attachment
                                                .Tool
                                                .ofCodeInterpreterTool(
                                                    CodeInterpreterTool.builder()
                                                        .type(
                                                            CodeInterpreterTool.Type
                                                                .CODE_INTERPRETER
                                                        )
                                                        .build()
                                                )
                                        )
                                    )
                                    .build()
                            )
                        )
                        .metadata(JsonValue.from(mapOf<String, Any>()))
                        .build()
                )
            )
            .instructions("instructions")
            .maxCompletionTokens(256L)
            .maxPromptTokens(256L)
            .metadata(JsonValue.from(mapOf<String, Any>()))
            .model(ChatModel.GPT_4O)
            .parallelToolCalls(true)
            .responseFormat(
                AssistantResponseFormatOption.ofBehavior(
                    AssistantResponseFormatOption.Behavior.AUTO
                )
            )
            .temperature(1.0)
            .toolChoice(
                AssistantToolChoiceOption.ofBehavior(AssistantToolChoiceOption.Behavior.NONE)
            )
            .tools(
                listOf(
                    AssistantTool.ofCodeInterpreterTool(
                        CodeInterpreterTool.builder()
                            .type(CodeInterpreterTool.Type.CODE_INTERPRETER)
                            .build()
                    )
                )
            )
            .topP(1.0)
            .truncationStrategy(
                BetaThreadRunCreateParams.TruncationStrategy.builder()
                    .type(BetaThreadRunCreateParams.TruncationStrategy.Type.AUTO)
                    .lastMessages(1L)
                    .build()
            )
            .build()
    }

    @Test
    fun getQueryParams() {
        val params =
            BetaThreadRunCreateParams.builder()
                .threadId("thread_id")
                .assistantId("assistant_id")
                .include(listOf(RunStepInclude.STEP_DETAILS_TOOL_CALLS_FILE_SEARCH_RESULTS_CONTENT))
                .additionalInstructions("additional_instructions")
                .additionalMessages(
                    listOf(
                        BetaThreadRunCreateParams.AdditionalMessage.builder()
                            .content(
                                BetaThreadRunCreateParams.AdditionalMessage.Content.ofTextContent(
                                    "string"
                                )
                            )
                            .role(BetaThreadRunCreateParams.AdditionalMessage.Role.USER)
                            .attachments(
                                listOf(
                                    BetaThreadRunCreateParams.AdditionalMessage.Attachment.builder()
                                        .fileId("file_id")
                                        .tools(
                                            listOf(
                                                BetaThreadRunCreateParams.AdditionalMessage
                                                    .Attachment
                                                    .Tool
                                                    .ofCodeInterpreterTool(
                                                        CodeInterpreterTool.builder()
                                                            .type(
                                                                CodeInterpreterTool.Type
                                                                    .CODE_INTERPRETER
                                                            )
                                                            .build()
                                                    )
                                            )
                                        )
                                        .build()
                                )
                            )
                            .metadata(JsonValue.from(mapOf<String, Any>()))
                            .build()
                    )
                )
                .instructions("instructions")
                .maxCompletionTokens(256L)
                .maxPromptTokens(256L)
                .metadata(JsonValue.from(mapOf<String, Any>()))
                .model(ChatModel.GPT_4O)
                .parallelToolCalls(true)
                .responseFormat(
                    AssistantResponseFormatOption.ofBehavior(
                        AssistantResponseFormatOption.Behavior.AUTO
                    )
                )
                .temperature(1.0)
                .toolChoice(
                    AssistantToolChoiceOption.ofBehavior(AssistantToolChoiceOption.Behavior.NONE)
                )
                .tools(
                    listOf(
                        AssistantTool.ofCodeInterpreterTool(
                            CodeInterpreterTool.builder()
                                .type(CodeInterpreterTool.Type.CODE_INTERPRETER)
                                .build()
                        )
                    )
                )
                .topP(1.0)
                .truncationStrategy(
                    BetaThreadRunCreateParams.TruncationStrategy.builder()
                        .type(BetaThreadRunCreateParams.TruncationStrategy.Type.AUTO)
                        .lastMessages(1L)
                        .build()
                )
                .build()
        val expected = QueryParams.builder()
        expected.put(
            "include[]",
            RunStepInclude.STEP_DETAILS_TOOL_CALLS_FILE_SEARCH_RESULTS_CONTENT.toString()
        )
        assertThat(params.getQueryParams()).isEqualTo(expected.build())
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
        val params =
            BetaThreadRunCreateParams.builder()
                .threadId("thread_id")
                .assistantId("assistant_id")
                .build()
        val expected = QueryParams.builder()
        assertThat(params.getQueryParams()).isEqualTo(expected.build())
    }

    @Test
    fun getBody() {
        val params =
            BetaThreadRunCreateParams.builder()
                .threadId("thread_id")
                .assistantId("assistant_id")
                .include(listOf(RunStepInclude.STEP_DETAILS_TOOL_CALLS_FILE_SEARCH_RESULTS_CONTENT))
                .additionalInstructions("additional_instructions")
                .additionalMessages(
                    listOf(
                        BetaThreadRunCreateParams.AdditionalMessage.builder()
                            .content(
                                BetaThreadRunCreateParams.AdditionalMessage.Content.ofTextContent(
                                    "string"
                                )
                            )
                            .role(BetaThreadRunCreateParams.AdditionalMessage.Role.USER)
                            .attachments(
                                listOf(
                                    BetaThreadRunCreateParams.AdditionalMessage.Attachment.builder()
                                        .fileId("file_id")
                                        .tools(
                                            listOf(
                                                BetaThreadRunCreateParams.AdditionalMessage
                                                    .Attachment
                                                    .Tool
                                                    .ofCodeInterpreterTool(
                                                        CodeInterpreterTool.builder()
                                                            .type(
                                                                CodeInterpreterTool.Type
                                                                    .CODE_INTERPRETER
                                                            )
                                                            .build()
                                                    )
                                            )
                                        )
                                        .build()
                                )
                            )
                            .metadata(JsonValue.from(mapOf<String, Any>()))
                            .build()
                    )
                )
                .instructions("instructions")
                .maxCompletionTokens(256L)
                .maxPromptTokens(256L)
                .metadata(JsonValue.from(mapOf<String, Any>()))
                .model(ChatModel.GPT_4O)
                .parallelToolCalls(true)
                .responseFormat(
                    AssistantResponseFormatOption.ofBehavior(
                        AssistantResponseFormatOption.Behavior.AUTO
                    )
                )
                .temperature(1.0)
                .toolChoice(
                    AssistantToolChoiceOption.ofBehavior(AssistantToolChoiceOption.Behavior.NONE)
                )
                .tools(
                    listOf(
                        AssistantTool.ofCodeInterpreterTool(
                            CodeInterpreterTool.builder()
                                .type(CodeInterpreterTool.Type.CODE_INTERPRETER)
                                .build()
                        )
                    )
                )
                .topP(1.0)
                .truncationStrategy(
                    BetaThreadRunCreateParams.TruncationStrategy.builder()
                        .type(BetaThreadRunCreateParams.TruncationStrategy.Type.AUTO)
                        .lastMessages(1L)
                        .build()
                )
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.assistantId()).isEqualTo("assistant_id")
        assertThat(body.additionalInstructions()).contains("additional_instructions")
        assertThat(body.additionalMessages())
            .contains(
                listOf(
                    BetaThreadRunCreateParams.AdditionalMessage.builder()
                        .content(
                            BetaThreadRunCreateParams.AdditionalMessage.Content.ofTextContent(
                                "string"
                            )
                        )
                        .role(BetaThreadRunCreateParams.AdditionalMessage.Role.USER)
                        .attachments(
                            listOf(
                                BetaThreadRunCreateParams.AdditionalMessage.Attachment.builder()
                                    .fileId("file_id")
                                    .tools(
                                        listOf(
                                            BetaThreadRunCreateParams.AdditionalMessage.Attachment
                                                .Tool
                                                .ofCodeInterpreterTool(
                                                    CodeInterpreterTool.builder()
                                                        .type(
                                                            CodeInterpreterTool.Type
                                                                .CODE_INTERPRETER
                                                        )
                                                        .build()
                                                )
                                        )
                                    )
                                    .build()
                            )
                        )
                        .metadata(JsonValue.from(mapOf<String, Any>()))
                        .build()
                )
            )
        assertThat(body.instructions()).contains("instructions")
        assertThat(body.maxCompletionTokens()).contains(256L)
        assertThat(body.maxPromptTokens()).contains(256L)
        assertThat(body.metadata()).contains(JsonValue.from(mapOf<String, Any>()))
        assertThat(body.model()).contains(ChatModel.GPT_4O)
        assertThat(body.parallelToolCalls()).contains(true)
        assertThat(body.responseFormat())
            .contains(
                AssistantResponseFormatOption.ofBehavior(
                    AssistantResponseFormatOption.Behavior.AUTO
                )
            )
        assertThat(body.temperature()).contains(1.0)
        assertThat(body.toolChoice())
            .contains(AssistantToolChoiceOption.ofBehavior(AssistantToolChoiceOption.Behavior.NONE))
        assertThat(body.tools())
            .contains(
                listOf(
                    AssistantTool.ofCodeInterpreterTool(
                        CodeInterpreterTool.builder()
                            .type(CodeInterpreterTool.Type.CODE_INTERPRETER)
                            .build()
                    )
                )
            )
        assertThat(body.topP()).contains(1.0)
        assertThat(body.truncationStrategy())
            .contains(
                BetaThreadRunCreateParams.TruncationStrategy.builder()
                    .type(BetaThreadRunCreateParams.TruncationStrategy.Type.AUTO)
                    .lastMessages(1L)
                    .build()
            )
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params =
            BetaThreadRunCreateParams.builder()
                .threadId("thread_id")
                .assistantId("assistant_id")
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.assistantId()).isEqualTo("assistant_id")
    }

    @Test
    fun getPathParam() {
        val params =
            BetaThreadRunCreateParams.builder()
                .threadId("thread_id")
                .assistantId("assistant_id")
                .build()
        assertThat(params).isNotNull
        // path param "threadId"
        assertThat(params.getPathParam(0)).isEqualTo("thread_id")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
