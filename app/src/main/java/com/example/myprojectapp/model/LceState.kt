package com.example.myprojectapp.model

sealed class LceState<out T> {
    object Loading : LceState<Nothing>()

    data class Content<T>(val data: T) : LceState<T>()

    data class Error(val throwable: Throwable) : LceState<Nothing>()
}