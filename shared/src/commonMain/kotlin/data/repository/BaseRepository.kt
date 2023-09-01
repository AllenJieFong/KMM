package data.repository

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

abstract class BaseRepository {

    val json = Json {
        ignoreUnknownKeys = true
    }

    val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(json)
        }
    }

    val headersMap = mutableMapOf(
        "x-req-source" to "ANDROID",
        "x-auth-token" to "hxjtgAwEqVh772HFWTP3Nc0eROqO5iEcsdXUKJx6nhI=",
        "lang" to "zh-tw",
        "locale" to "tw"
    )

    suspend inline fun <reified T> getApi(url: String): T {
        val res = httpClient
            .get(url) {
                headers {
                    headersMap.forEach {
                        append(it.key, it.value)
                    }
                }
            }
            .body<String>()
        return json.decodeFromString(res)
    }

    fun close() {
        httpClient.close()
    }
}