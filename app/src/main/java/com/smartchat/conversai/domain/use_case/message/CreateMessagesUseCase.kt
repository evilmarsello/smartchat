package com.smartchat.conversai.domain.use_case.message

import com.smartchat.conversai.data.model.MessageModel
import com.smartchat.conversai.domain.repository.MessageRepository
import javax.inject.Inject

class CreateMessagesUseCase @Inject constructor(
    private val messageRepository: MessageRepository
) {
    suspend operator fun invoke(message: MessageModel) =
        messageRepository.addMessage(message)
}