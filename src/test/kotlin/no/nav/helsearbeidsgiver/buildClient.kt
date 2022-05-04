package no.nav.helsearbeidsgiver

import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*

fun buildClient(): BrregKlient {
    val httpClient = HttpClient {
        install(JsonFeature) {
            serializer = KotlinxSerializer(
                kotlinx.serialization.json.Json {
                    ignoreUnknownKeys = true
                    explicitNulls = false
                }
            )
        }
    }
    return BrregKlient(httpClient)
}
