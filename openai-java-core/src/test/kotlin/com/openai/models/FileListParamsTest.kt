// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.openai.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FileListParamsTest {

    @Test
    fun createFileListParams() {
        FileListParams.builder().purpose("purpose").build()
    }

    @Test
    fun getQueryParams() {
        val params = FileListParams.builder().purpose("purpose").build()
        val expected = mutableMapOf<String, List<String>>()
        expected.put("purpose", listOf("purpose"))
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
        val params = FileListParams.builder().build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }
}