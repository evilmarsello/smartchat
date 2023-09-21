package com.smartchat.conversai.domain.use_case.conversation

import com.smartchat.conversai.data.model.ConversationModel
import com.smartchat.conversai.domain.repository.ConversationRepository
import javax.inject.Inject

class CreateConversationUseCase @Inject constructor(
    private val conversationRepository: ConversationRepository
) {
    suspend operator fun invoke(conversation: ConversationModel) =
        conversationRepository.addConversation(conversation)
}