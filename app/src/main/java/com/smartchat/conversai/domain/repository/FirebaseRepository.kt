package com.smartchat.conversai.domain.repository

interface FirebaseRepository {
    suspend fun isThereUpdate(): Boolean
}