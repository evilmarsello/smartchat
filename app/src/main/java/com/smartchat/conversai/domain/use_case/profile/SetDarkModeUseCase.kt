package com.smartchat.conversai.domain.use_case.profile

import com.smartchat.conversai.domain.repository.PreferenceRepository
import javax.inject.Inject

class SetDarkModeUseCase @Inject constructor(
    private val preferenceRepository: PreferenceRepository
) {
    operator fun invoke(isDarkMode: Boolean) = preferenceRepository.setDarkMode(isDarkMode)
}
