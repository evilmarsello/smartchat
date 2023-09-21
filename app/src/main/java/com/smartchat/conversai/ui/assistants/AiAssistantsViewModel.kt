package com.smartchat.conversai.ui.assistants

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smartchat.conversai.data.model.AiAssistantModel
import com.smartchat.conversai.domain.use_case.upgrade.IsProVersionUseCase
import com.smartchat.conversai.domain.use_case.upgrade.SetProVersionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AiAssistantsViewModel @Inject constructor(
    private val isProVersionUseCase: IsProVersionUseCase,
    private val setProVersionUseCase: SetProVersionUseCase
): ViewModel() {
    val showVertical = mutableStateOf(false)
    val verticalShowList = mutableStateListOf<AiAssistantModel>()
    val selectedValue = mutableStateOf("")
    val isProVersion = mutableStateOf(false)

    fun setProVersion(isPro: Boolean) {
        setProVersionUseCase(isPro)
        isProVersion.value = isPro
    }

    fun getProVersion() = viewModelScope.launch {
        isProVersion.value = isProVersionUseCase()
    }
}