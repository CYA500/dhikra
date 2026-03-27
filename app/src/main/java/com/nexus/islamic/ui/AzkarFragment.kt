package com.nexus.islamic.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.nexus.islamic.R
import com.nexus.islamic.databinding.FragmentLibraryBinding 

class AzkarFragment : Fragment(R.layout.fragment_library) {
    // نستخدم نفس تصميم المكتبة لعرض الأذكار بشكل أنيق
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // البرمجة هنا ستعتمد على عرض الأذكار المحفوظة مسبقاً في قاعدة البيانات
    }
}
