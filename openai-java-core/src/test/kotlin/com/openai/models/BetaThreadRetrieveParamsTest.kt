// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BetaThreadRetrieveParamsTest {

    @Test
    fun createBetaThreadRetrieveParams() {
        BetaThreadRetrieveParams.builder().threadId("thread_id").build()
    }

    @Test
    fun getPathParam() {
        val params = BetaThreadRetrieveParams.builder().threadId("thread_id").build()
        assertThat(params).isNotNull
        // path param "threadId"
        assertThat(params.getPathParam(0)).isEqualTo("thread_id")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
