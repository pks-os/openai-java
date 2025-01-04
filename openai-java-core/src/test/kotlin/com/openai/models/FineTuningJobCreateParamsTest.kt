// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FineTuningJobCreateParamsTest {

    @Test
    fun createFineTuningJobCreateParams() {
        FineTuningJobCreateParams.builder()
            .model(FineTuningJobCreateParams.Model.BABBAGE_002)
            .trainingFile("file-abc123")
            .hyperparameters(
                FineTuningJobCreateParams.Hyperparameters.builder()
                    .batchSize(
                        FineTuningJobCreateParams.Hyperparameters.BatchSize.ofBehavior(
                            FineTuningJobCreateParams.Hyperparameters.BatchSize.Behavior.AUTO
                        )
                    )
                    .learningRateMultiplier(
                        FineTuningJobCreateParams.Hyperparameters.LearningRateMultiplier.ofBehavior(
                            FineTuningJobCreateParams.Hyperparameters.LearningRateMultiplier
                                .Behavior
                                .AUTO
                        )
                    )
                    .nEpochs(
                        FineTuningJobCreateParams.Hyperparameters.NEpochs.ofBehavior(
                            FineTuningJobCreateParams.Hyperparameters.NEpochs.Behavior.AUTO
                        )
                    )
                    .build()
            )
            .integrations(
                listOf(
                    FineTuningJobCreateParams.Integration.builder()
                        .type(FineTuningJobCreateParams.Integration.Type.WANDB)
                        .wandb(
                            FineTuningJobCreateParams.Integration.Wandb.builder()
                                .project("my-wandb-project")
                                .entity("entity")
                                .name("name")
                                .tags(listOf("custom-tag"))
                                .build()
                        )
                        .build()
                )
            )
            .method(
                FineTuningJobCreateParams.Method.builder()
                    .dpo(
                        FineTuningJobCreateParams.Method.Dpo.builder()
                            .hyperparameters(
                                FineTuningJobCreateParams.Method.Dpo.Hyperparameters.builder()
                                    .batchSize(
                                        FineTuningJobCreateParams.Method.Dpo.Hyperparameters
                                            .BatchSize
                                            .ofAuto(
                                                FineTuningJobCreateParams.Method.Dpo.Hyperparameters
                                                    .BatchSize
                                                    .Auto
                                                    .AUTO
                                            )
                                    )
                                    .beta(
                                        FineTuningJobCreateParams.Method.Dpo.Hyperparameters.Beta
                                            .ofAuto(
                                                FineTuningJobCreateParams.Method.Dpo.Hyperparameters
                                                    .Beta
                                                    .Auto
                                                    .AUTO
                                            )
                                    )
                                    .learningRateMultiplier(
                                        FineTuningJobCreateParams.Method.Dpo.Hyperparameters
                                            .LearningRateMultiplier
                                            .ofAuto(
                                                FineTuningJobCreateParams.Method.Dpo.Hyperparameters
                                                    .LearningRateMultiplier
                                                    .Auto
                                                    .AUTO
                                            )
                                    )
                                    .nEpochs(
                                        FineTuningJobCreateParams.Method.Dpo.Hyperparameters.NEpochs
                                            .ofAuto(
                                                FineTuningJobCreateParams.Method.Dpo.Hyperparameters
                                                    .NEpochs
                                                    .Auto
                                                    .AUTO
                                            )
                                    )
                                    .build()
                            )
                            .build()
                    )
                    .supervised(
                        FineTuningJobCreateParams.Method.Supervised.builder()
                            .hyperparameters(
                                FineTuningJobCreateParams.Method.Supervised.Hyperparameters
                                    .builder()
                                    .batchSize(
                                        FineTuningJobCreateParams.Method.Supervised.Hyperparameters
                                            .BatchSize
                                            .ofAuto(
                                                FineTuningJobCreateParams.Method.Supervised
                                                    .Hyperparameters
                                                    .BatchSize
                                                    .Auto
                                                    .AUTO
                                            )
                                    )
                                    .learningRateMultiplier(
                                        FineTuningJobCreateParams.Method.Supervised.Hyperparameters
                                            .LearningRateMultiplier
                                            .ofAuto(
                                                FineTuningJobCreateParams.Method.Supervised
                                                    .Hyperparameters
                                                    .LearningRateMultiplier
                                                    .Auto
                                                    .AUTO
                                            )
                                    )
                                    .nEpochs(
                                        FineTuningJobCreateParams.Method.Supervised.Hyperparameters
                                            .NEpochs
                                            .ofAuto(
                                                FineTuningJobCreateParams.Method.Supervised
                                                    .Hyperparameters
                                                    .NEpochs
                                                    .Auto
                                                    .AUTO
                                            )
                                    )
                                    .build()
                            )
                            .build()
                    )
                    .type(FineTuningJobCreateParams.Method.Type.SUPERVISED)
                    .build()
            )
            .seed(42L)
            .suffix("x")
            .validationFile("file-abc123")
            .build()
    }

    @Test
    fun getBody() {
        val params =
            FineTuningJobCreateParams.builder()
                .model(FineTuningJobCreateParams.Model.BABBAGE_002)
                .trainingFile("file-abc123")
                .hyperparameters(
                    FineTuningJobCreateParams.Hyperparameters.builder()
                        .batchSize(
                            FineTuningJobCreateParams.Hyperparameters.BatchSize.ofBehavior(
                                FineTuningJobCreateParams.Hyperparameters.BatchSize.Behavior.AUTO
                            )
                        )
                        .learningRateMultiplier(
                            FineTuningJobCreateParams.Hyperparameters.LearningRateMultiplier
                                .ofBehavior(
                                    FineTuningJobCreateParams.Hyperparameters.LearningRateMultiplier
                                        .Behavior
                                        .AUTO
                                )
                        )
                        .nEpochs(
                            FineTuningJobCreateParams.Hyperparameters.NEpochs.ofBehavior(
                                FineTuningJobCreateParams.Hyperparameters.NEpochs.Behavior.AUTO
                            )
                        )
                        .build()
                )
                .integrations(
                    listOf(
                        FineTuningJobCreateParams.Integration.builder()
                            .type(FineTuningJobCreateParams.Integration.Type.WANDB)
                            .wandb(
                                FineTuningJobCreateParams.Integration.Wandb.builder()
                                    .project("my-wandb-project")
                                    .entity("entity")
                                    .name("name")
                                    .tags(listOf("custom-tag"))
                                    .build()
                            )
                            .build()
                    )
                )
                .method(
                    FineTuningJobCreateParams.Method.builder()
                        .dpo(
                            FineTuningJobCreateParams.Method.Dpo.builder()
                                .hyperparameters(
                                    FineTuningJobCreateParams.Method.Dpo.Hyperparameters.builder()
                                        .batchSize(
                                            FineTuningJobCreateParams.Method.Dpo.Hyperparameters
                                                .BatchSize
                                                .ofAuto(
                                                    FineTuningJobCreateParams.Method.Dpo
                                                        .Hyperparameters
                                                        .BatchSize
                                                        .Auto
                                                        .AUTO
                                                )
                                        )
                                        .beta(
                                            FineTuningJobCreateParams.Method.Dpo.Hyperparameters
                                                .Beta
                                                .ofAuto(
                                                    FineTuningJobCreateParams.Method.Dpo
                                                        .Hyperparameters
                                                        .Beta
                                                        .Auto
                                                        .AUTO
                                                )
                                        )
                                        .learningRateMultiplier(
                                            FineTuningJobCreateParams.Method.Dpo.Hyperparameters
                                                .LearningRateMultiplier
                                                .ofAuto(
                                                    FineTuningJobCreateParams.Method.Dpo
                                                        .Hyperparameters
                                                        .LearningRateMultiplier
                                                        .Auto
                                                        .AUTO
                                                )
                                        )
                                        .nEpochs(
                                            FineTuningJobCreateParams.Method.Dpo.Hyperparameters
                                                .NEpochs
                                                .ofAuto(
                                                    FineTuningJobCreateParams.Method.Dpo
                                                        .Hyperparameters
                                                        .NEpochs
                                                        .Auto
                                                        .AUTO
                                                )
                                        )
                                        .build()
                                )
                                .build()
                        )
                        .supervised(
                            FineTuningJobCreateParams.Method.Supervised.builder()
                                .hyperparameters(
                                    FineTuningJobCreateParams.Method.Supervised.Hyperparameters
                                        .builder()
                                        .batchSize(
                                            FineTuningJobCreateParams.Method.Supervised
                                                .Hyperparameters
                                                .BatchSize
                                                .ofAuto(
                                                    FineTuningJobCreateParams.Method.Supervised
                                                        .Hyperparameters
                                                        .BatchSize
                                                        .Auto
                                                        .AUTO
                                                )
                                        )
                                        .learningRateMultiplier(
                                            FineTuningJobCreateParams.Method.Supervised
                                                .Hyperparameters
                                                .LearningRateMultiplier
                                                .ofAuto(
                                                    FineTuningJobCreateParams.Method.Supervised
                                                        .Hyperparameters
                                                        .LearningRateMultiplier
                                                        .Auto
                                                        .AUTO
                                                )
                                        )
                                        .nEpochs(
                                            FineTuningJobCreateParams.Method.Supervised
                                                .Hyperparameters
                                                .NEpochs
                                                .ofAuto(
                                                    FineTuningJobCreateParams.Method.Supervised
                                                        .Hyperparameters
                                                        .NEpochs
                                                        .Auto
                                                        .AUTO
                                                )
                                        )
                                        .build()
                                )
                                .build()
                        )
                        .type(FineTuningJobCreateParams.Method.Type.SUPERVISED)
                        .build()
                )
                .seed(42L)
                .suffix("x")
                .validationFile("file-abc123")
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.model()).isEqualTo(FineTuningJobCreateParams.Model.BABBAGE_002)
        assertThat(body.trainingFile()).isEqualTo("file-abc123")
        assertThat(body.hyperparameters())
            .contains(
                FineTuningJobCreateParams.Hyperparameters.builder()
                    .batchSize(
                        FineTuningJobCreateParams.Hyperparameters.BatchSize.ofBehavior(
                            FineTuningJobCreateParams.Hyperparameters.BatchSize.Behavior.AUTO
                        )
                    )
                    .learningRateMultiplier(
                        FineTuningJobCreateParams.Hyperparameters.LearningRateMultiplier.ofBehavior(
                            FineTuningJobCreateParams.Hyperparameters.LearningRateMultiplier
                                .Behavior
                                .AUTO
                        )
                    )
                    .nEpochs(
                        FineTuningJobCreateParams.Hyperparameters.NEpochs.ofBehavior(
                            FineTuningJobCreateParams.Hyperparameters.NEpochs.Behavior.AUTO
                        )
                    )
                    .build()
            )
        assertThat(body.integrations())
            .contains(
                listOf(
                    FineTuningJobCreateParams.Integration.builder()
                        .type(FineTuningJobCreateParams.Integration.Type.WANDB)
                        .wandb(
                            FineTuningJobCreateParams.Integration.Wandb.builder()
                                .project("my-wandb-project")
                                .entity("entity")
                                .name("name")
                                .tags(listOf("custom-tag"))
                                .build()
                        )
                        .build()
                )
            )
        assertThat(body.method())
            .contains(
                FineTuningJobCreateParams.Method.builder()
                    .dpo(
                        FineTuningJobCreateParams.Method.Dpo.builder()
                            .hyperparameters(
                                FineTuningJobCreateParams.Method.Dpo.Hyperparameters.builder()
                                    .batchSize(
                                        FineTuningJobCreateParams.Method.Dpo.Hyperparameters
                                            .BatchSize
                                            .ofAuto(
                                                FineTuningJobCreateParams.Method.Dpo.Hyperparameters
                                                    .BatchSize
                                                    .Auto
                                                    .AUTO
                                            )
                                    )
                                    .beta(
                                        FineTuningJobCreateParams.Method.Dpo.Hyperparameters.Beta
                                            .ofAuto(
                                                FineTuningJobCreateParams.Method.Dpo.Hyperparameters
                                                    .Beta
                                                    .Auto
                                                    .AUTO
                                            )
                                    )
                                    .learningRateMultiplier(
                                        FineTuningJobCreateParams.Method.Dpo.Hyperparameters
                                            .LearningRateMultiplier
                                            .ofAuto(
                                                FineTuningJobCreateParams.Method.Dpo.Hyperparameters
                                                    .LearningRateMultiplier
                                                    .Auto
                                                    .AUTO
                                            )
                                    )
                                    .nEpochs(
                                        FineTuningJobCreateParams.Method.Dpo.Hyperparameters.NEpochs
                                            .ofAuto(
                                                FineTuningJobCreateParams.Method.Dpo.Hyperparameters
                                                    .NEpochs
                                                    .Auto
                                                    .AUTO
                                            )
                                    )
                                    .build()
                            )
                            .build()
                    )
                    .supervised(
                        FineTuningJobCreateParams.Method.Supervised.builder()
                            .hyperparameters(
                                FineTuningJobCreateParams.Method.Supervised.Hyperparameters
                                    .builder()
                                    .batchSize(
                                        FineTuningJobCreateParams.Method.Supervised.Hyperparameters
                                            .BatchSize
                                            .ofAuto(
                                                FineTuningJobCreateParams.Method.Supervised
                                                    .Hyperparameters
                                                    .BatchSize
                                                    .Auto
                                                    .AUTO
                                            )
                                    )
                                    .learningRateMultiplier(
                                        FineTuningJobCreateParams.Method.Supervised.Hyperparameters
                                            .LearningRateMultiplier
                                            .ofAuto(
                                                FineTuningJobCreateParams.Method.Supervised
                                                    .Hyperparameters
                                                    .LearningRateMultiplier
                                                    .Auto
                                                    .AUTO
                                            )
                                    )
                                    .nEpochs(
                                        FineTuningJobCreateParams.Method.Supervised.Hyperparameters
                                            .NEpochs
                                            .ofAuto(
                                                FineTuningJobCreateParams.Method.Supervised
                                                    .Hyperparameters
                                                    .NEpochs
                                                    .Auto
                                                    .AUTO
                                            )
                                    )
                                    .build()
                            )
                            .build()
                    )
                    .type(FineTuningJobCreateParams.Method.Type.SUPERVISED)
                    .build()
            )
        assertThat(body.seed()).contains(42L)
        assertThat(body.suffix()).contains("x")
        assertThat(body.validationFile()).contains("file-abc123")
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params =
            FineTuningJobCreateParams.builder()
                .model(FineTuningJobCreateParams.Model.BABBAGE_002)
                .trainingFile("file-abc123")
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.model()).isEqualTo(FineTuningJobCreateParams.Model.BABBAGE_002)
        assertThat(body.trainingFile()).isEqualTo("file-abc123")
    }
}
