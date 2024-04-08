package kz.rdd.core.utils

class AppConfig() {
    private val defaultServerConfiguration = ServerConfiguration.PROD

    private val currentServerConfiguration: ServerConfiguration
        get() = defaultServerConfiguration

    val baseUrl get() = currentServerConfiguration.baseUrl
}