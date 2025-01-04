// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BetaAssistantDeleteParamsTest {

    @Test
    fun createBetaAssistantDeleteParams() {
        BetaAssistantDeleteParams.builder().assistantId("assistant_id").build()
    }

    @Test
    fun getPathParam() {
        val params = BetaAssistantDeleteParams.builder().assistantId("assistant_id").build()
        assertThat(params).isNotNull
        // path param "assistantId"
        assertThat(params.getPathParam(0)).isEqualTo("assistant_id")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
