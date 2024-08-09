package com.example.tree.users.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tree.users.models.User
import com.example.tree.users.repositories.UserRepository

class UserProfileViewModel(private val userRepository: UserRepository) : ViewModel() {
    private val _user = MutableLiveData<User?>()
    val user: LiveData<User?> = _user


    fun loadUserProfile(userId: String) {
        userRepository.getUserWithCallback(userId) { user ->
            _user.value = user
        }
    }
    fun updateUser(user: User) {
        _user.value = user
    }
}