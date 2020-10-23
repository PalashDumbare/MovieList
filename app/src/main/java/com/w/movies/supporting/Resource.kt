package com.w.movies.supporting

data class Resource(val status: Status, val message: String?) {
    companion object {
        fun  done(): Resource = Resource(status = Status.Success,  message = null)
        fun  error(message: String): Resource = Resource(status = Status.Error,  message = message)
        fun  loading(): Resource = Resource(status = Status.Loading,  message = null)
    }
}