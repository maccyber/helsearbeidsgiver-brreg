package no.nav.helsearbeidsgiver

import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.serialization.Serializable
import java.net.URL

@Serializable
data class BrregRespons(
    val navn: String,
    val organisasjonsnummer: String,
    val sletteDato: String?
)

class BrregKlient(
    private val httpClient: HttpClient,
    private val url: URL = URL("https://data.brreg.no/enhetsregisteret/api/underenheter")
) {
    suspend fun hentVirksomhet(orgnr: String): BrregRespons {
        return httpClient.get("$url/$orgnr")
    }
}
