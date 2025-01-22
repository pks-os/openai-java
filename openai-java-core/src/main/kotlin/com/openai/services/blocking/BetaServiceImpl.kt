// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.openai.core.ClientOptions
import com.openai.core.http.Headers
import com.openai.services.blocking.beta.AssistantService
import com.openai.services.blocking.beta.AssistantServiceImpl
import com.openai.services.blocking.beta.ThreadService
import com.openai.services.blocking.beta.ThreadServiceImpl
import com.openai.services.blocking.beta.VectorStoreService
import com.openai.services.blocking.beta.VectorStoreServiceImpl

class BetaServiceImpl
internal constructor(
    private val clientOptions: ClientOptions,
) : BetaService {

    companion object {

        private val DEFAULT_HEADERS = Headers.builder().put("OpenAI-Beta", "assistants=v2").build()
    }

    private val vectorStores: VectorStoreService by lazy { VectorStoreServiceImpl(clientOptions) }

    private val assistants: AssistantService by lazy { AssistantServiceImpl(clientOptions) }

    private val threads: ThreadService by lazy { ThreadServiceImpl(clientOptions) }

    override fun vectorStores(): VectorStoreService = vectorStores

    override fun assistants(): AssistantService = assistants

    override fun threads(): ThreadService = threads
}
