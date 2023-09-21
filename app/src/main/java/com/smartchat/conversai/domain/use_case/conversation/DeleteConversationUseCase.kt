package com.smartchat.conversai.domain.use_case.conversation

import com.smartchat.conversai.domain.repository.ConversationRepository
import javax.inject.Inject

class DeleteConversationUseCase @Inject constructor(
    private val conversationRepository: ConversationRepository
) {
    suspend operator fun invoke(conversationId: String) =
        conversationRepository.deleteConversation(conversationId)
}