// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BetaThreadRunRetrieveParamsTest {

    @Test
    fun createBetaThreadRunRetrieveParams() {
        BetaThreadRunRetrieveParams.builder().threadId("thread_id").runId("run_id").build()
    }

    @Test
    fun getPathParam() {
        val params =
            BetaThreadRunRetrieveParams.builder().threadId("thread_id").runId("run_id").build()
        assertThat(params).isNotNull
        // path param "threadId"
        assertThat(params.getPathParam(0)).isEqualTo("thread_id")
        // path param "runId"
        assertThat(params.getPathParam(1)).isEqualTo("run_id")
        // out-of-bound path param
        assertThat(params.getPathParam(2)).isEqualTo("")
    }
}
