package com.nexus.islamic.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.nexus.islamic.data.AppDatabase
import com.nexus.islamic.data.IslamicEntity
import kotlinx.coroutines.launch

class IslamicViewModel(application: Application) : AndroidViewModel(application) {
    private val dao = AppDatabase.getDatabase(application).islamicDao()

    // جلب البيانات حسب النوع (آية/حديث/ذكر) كتدفق بيانات مباشر
    fun getItemsByType(type: String): LiveData<List<IslamicEntity>> {
        return dao.getItemsByType(type).asLiveData()
    }

    // وظيفة الحفظ في قاعدة البيانات (تعمل في الخلفية لضمان سرعة التطبيق)
    fun insertItem(item: IslamicEntity) = viewModelScope.launch {
        dao.insertItem(item)
    }
}
