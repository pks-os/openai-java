// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BetaVectorStoreFileBatchCancelParamsTest {

    @Test
    fun createBetaVectorStoreFileBatchCancelParams() {
        BetaVectorStoreFileBatchCancelParams.builder()
            .vectorStoreId("vector_store_id")
            .batchId("batch_id")
            .build()
    }

    @Test
    fun getPathParam() {
        val params =
            BetaVectorStoreFileBatchCancelParams.builder()
                .vectorStoreId("vector_store_id")
                .batchId("batch_id")
                .build()
        assertThat(params).isNotNull
        // path param "vectorStoreId"
        assertThat(params.getPathParam(0)).isEqualTo("vector_store_id")
        // path param "batchId"
        assertThat(params.getPathParam(1)).isEqualTo("batch_id")
        // out-of-bound path param
        assertThat(params.getPathParam(2)).isEqualTo("")
    }
}
