package pl.adam.pko.model.network.response

sealed class HttpResult<out T> {
    data class Success<out T>(val data: T) : HttpResult<T>()
    data class Failure(val error: Throwable) : HttpResult<Nothing>()
}

inline fun <T : Any> HttpResult<T>.onSuccess(action: (T) -> Unit): HttpResult<T> {
    if (this is HttpResult.Success) {
        action(data)
    }
    return this
}

inline fun <T : Any, R : Any> HttpResult<T>.map(map: (T) -> R) = when (this) {
    is HttpResult.Success -> HttpResult.Success(map(data))
    is HttpResult.Failure -> this
}

inline fun <T : Any> HttpResult<T>.onError(action: (throwable: Throwable) -> Unit): HttpResult<T> {
    if (this is HttpResult.Failure) {
        action(error)
    }
    return this
}