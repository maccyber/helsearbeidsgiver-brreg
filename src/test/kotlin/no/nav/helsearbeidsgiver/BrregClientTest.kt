package no.nav.helsearbeidsgiver

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class BrregClientTest {
    val brregClient = buildClient()

    @Test
    fun `Tester brreg navn`() {
        runBlocking {
            val respons = brregClient.hentVirksomhet("874568112")
            assertEquals("FAGSKOLEN VESTFOLD OG TELEMARK AVD PORSGRUNN", respons.navn)
        }
    }
}
