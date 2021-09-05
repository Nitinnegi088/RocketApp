package com.example.racketapp.viewModel

import androidx.lifecycle.*
import com.example.racketapp.repository.RocketRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RocketViewModel @Inject constructor(private val rocketRepository: RocketRepository):
    ViewModel(){

    val rockets = rocketRepository.getRocketData().asLiveData()

}