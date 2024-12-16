package com.isacetin.local_preference.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import com.isacetin.local_preference.UserPreference
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserDataStore @Inject constructor(private val dataStore: DataStore<Preferences>) : UserPreference {
    override fun token(): Flow<String> =
        dataStore.data
            .catch {
                emit(emptyPreferences())
            }.map { value: Preferences ->
                value[KEYS.KEY_TOKEN] ?: ""
            }

    override suspend fun saveToken(token: String) {
        dataStore.edit { preferences ->
            preferences[KEYS.KEY_TOKEN] = token
        }
    }

    override fun isFirstLaunch(): Flow<Boolean> =
        dataStore.data
            .catch {
                emit(emptyPreferences())
            }.map { value: Preferences ->
                value[KEYS.KEY_ONBOARDING] ?: true
            }

    override suspend fun saveFirstLaunch() {
        dataStore.edit { preferences ->
            preferences[KEYS.KEY_ONBOARDING] = false
        }
    }
}

object KEYS {
    val KEY_TOKEN = stringPreferencesKey("token_key")
    val KEY_ONBOARDING = booleanPreferencesKey("onboarding_key")
}
