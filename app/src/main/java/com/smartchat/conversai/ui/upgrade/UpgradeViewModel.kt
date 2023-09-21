package com.smartchat.conversai.ui.upgrade

import androidx.lifecycle.ViewModel
import com.smartchat.conversai.domain.use_case.upgrade.SetProVersionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UpgradeViewModel @Inject constructor(private val setProVersionUseCase: SetProVersionUseCase) :
    ViewModel() {

    fun setProVersion(isProVersion: Boolean) = setProVersionUseCase(isProVersion)
}