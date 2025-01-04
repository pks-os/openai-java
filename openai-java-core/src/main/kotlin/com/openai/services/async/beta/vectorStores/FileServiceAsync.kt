// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.openai.services.async.beta.vectorStores

import com.openai.core.RequestOptions
import com.openai.models.BetaVectorStoreFileCreateParams
import com.openai.models.BetaVectorStoreFileDeleteParams
import com.openai.models.BetaVectorStoreFileListPageAsync
import com.openai.models.BetaVectorStoreFileListParams
import com.openai.models.BetaVectorStoreFileRetrieveParams
import com.openai.models.VectorStoreFile
import com.openai.models.VectorStoreFileDeleted
import java.util.concurrent.CompletableFuture

interface FileServiceAsync {

    /**
     * Create a vector store file by attaching a
     * [File](https://platform.openai.com/docs/api-reference/files) to a
     * [vector store](https://platform.openai.com/docs/api-reference/vector-stores/object).
     */
    @JvmOverloads
    fun create(
        params: BetaVectorStoreFileCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<VectorStoreFile>

    /** Retrieves a vector store file. */
    @JvmOverloads
    fun retrieve(
        params: BetaVectorStoreFileRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<VectorStoreFile>

    /** Returns a list of vector store files. */
    @JvmOverloads
    fun list(
        params: BetaVectorStoreFileListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<BetaVectorStoreFileListPageAsync>

    /**
     * Delete a vector store file. This will remove the file from the vector store but the file
     * itself will not be deleted. To delete the file, use the
     * [delete file](https://platform.openai.com/docs/api-reference/files/delete) endpoint.
     */
    @JvmOverloads
    fun delete(
        params: BetaVectorStoreFileDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<VectorStoreFileDeleted>
}
