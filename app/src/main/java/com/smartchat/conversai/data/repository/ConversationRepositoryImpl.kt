package com.smartchat.conversai.data.repository

import com.smartchat.conversai.data.model.ConversationModel
import com.smartchat.conversai.data.source.local.ConversAIDao
import com.smartchat.conversai.domain.repository.ConversationRepository
import javax.inject.Inject


class ConversationRepositoryImpl @Inject constructor(
    private val conversAIDao: ConversAIDao

) : ConversationRepository {
    override suspend fun getConversations(): MutableList<ConversationModel> =
        conversAIDao.getConversations()

    override suspend fun addConversation(conversation: ConversationModel) =
        conversAIDao.addConversation(conversation)

    override suspend fun deleteConversation(conversationId: String) {
        conversAIDao.deleteConversation(conversationId)
        conversAIDao.deleteMessages(conversationId)
    }


    override suspend fun deleteAllConversation() = conversAIDao.deleteAllConversation()

}