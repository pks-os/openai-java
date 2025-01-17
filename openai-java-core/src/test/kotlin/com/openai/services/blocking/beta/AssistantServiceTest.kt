// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.beta

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.core.JsonValue
import com.openai.models.AssistantResponseFormatOption
import com.openai.models.AutoFileChunkingStrategyParam
import com.openai.models.BetaAssistantCreateParams
import com.openai.models.BetaAssistantDeleteParams
import com.openai.models.BetaAssistantListParams
import com.openai.models.BetaAssistantRetrieveParams
import com.openai.models.BetaAssistantUpdateParams
import com.openai.models.ChatModel
import com.openai.models.CodeInterpreterTool
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class AssistantServiceTest {

    @Test
    fun callCreate() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val assistantService = client.beta().assistants()
        val assistant =
            assistantService.create(
                BetaAssistantCreateParams.builder()
                    .model(ChatModel.GPT_4O)
                    .description("description")
                    .instructions("instructions")
                    .metadata(JsonValue.from(mapOf<String, Any>()))
                    .name("name")
                    .responseFormat(AssistantResponseFormatOption.Behavior.AUTO)
                    .temperature(1.0)
                    .toolResources(
                        BetaAssistantCreateParams.ToolResources.builder()
                            .codeInterpreter(
                                BetaAssistantCreateParams.ToolResources.CodeInterpreter.builder()
                                    .addFileId("string")
                                    .build()
                            )
                            .fileSearch(
                                BetaAssistantCreateParams.ToolResources.FileSearch.builder()
                                    .addVectorStoreId("string")
                                    .addVectorStore(
                                        BetaAssistantCreateParams.ToolResources.FileSearch
                                            .VectorStore
                                            .builder()
                                            .chunkingStrategy(
                                                AutoFileChunkingStrategyParam.builder()
                                                    .type(AutoFileChunkingStrategyParam.Type.AUTO)
                                                    .build()
                                            )
                                            .addFileId("string")
                                            .metadata(JsonValue.from(mapOf<String, Any>()))
                                            .build()
                                    )
                                    .build()
                            )
                            .build()
                    )
                    .addTool(
                        CodeInterpreterTool.builder()
                            .type(CodeInterpreterTool.Type.CODE_INTERPRETER)
                            .build()
                    )
                    .topP(1.0)
                    .build()
            )
        println(assistant)
        assistant.validate()
    }

    @Test
    fun callRetrieve() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val assistantService = client.beta().assistants()
        val assistant =
            assistantService.retrieve(
                BetaAssistantRetrieveParams.builder().assistantId("assistant_id").build()
            )
        println(assistant)
        assistant.validate()
    }

    @Test
    fun callUpdate() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val assistantService = client.beta().assistants()
        val assistant =
            assistantService.update(
                BetaAssistantUpdateParams.builder()
                    .assistantId("assistant_id")
                    .description("description")
                    .instructions("instructions")
                    .metadata(JsonValue.from(mapOf<String, Any>()))
                    .model("model")
                    .name("name")
                    .responseFormat(AssistantResponseFormatOption.Behavior.AUTO)
                    .temperature(1.0)
                    .toolResources(
                        BetaAssistantUpdateParams.ToolResources.builder()
                            .codeInterpreter(
                                BetaAssistantUpdateParams.ToolResources.CodeInterpreter.builder()
                                    .addFileId("string")
                                    .build()
                            )
                            .fileSearch(
                                BetaAssistantUpdateParams.ToolResources.FileSearch.builder()
                                    .addVectorStoreId("string")
                                    .build()
                            )
                            .build()
                    )
                    .addTool(
                        CodeInterpreterTool.builder()
                            .type(CodeInterpreterTool.Type.CODE_INTERPRETER)
                            .build()
                    )
                    .topP(1.0)
                    .build()
            )
        println(assistant)
        assistant.validate()
    }

    @Test
    fun callList() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val assistantService = client.beta().assistants()
        val listAssistantsResponse =
            assistantService.list(BetaAssistantListParams.builder().build())
        println(listAssistantsResponse)
        listAssistantsResponse.data().forEach { it.validate() }
    }

    @Test
    fun callDelete() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val assistantService = client.beta().assistants()
        val assistantDeleted =
            assistantService.delete(
                BetaAssistantDeleteParams.builder().assistantId("assistant_id").build()
            )
        println(assistantDeleted)
        assistantDeleted.validate()
    }
}
