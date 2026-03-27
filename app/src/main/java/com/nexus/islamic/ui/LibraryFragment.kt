package com.nexus.islamic.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.nexus.islamic.R
import com.nexus.islamic.databinding.FragmentLibraryBinding
import com.nexus.islamic.viewmodel.IslamicViewModel

class LibraryFragment : Fragment(R.layout.fragment_library) {
    private val viewModel: IslamicViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentLibraryBinding.bind(view)

        binding.rvLibrary.layoutManager = LinearLayoutManager(context)

        // مراقبة البيانات وعرضها (مبدئياً سنعرض الآيات)
        viewModel.getItemsByType("آية").observe(viewLifecycleOwner) { items ->
            // هنا سنقوم بربط الـ Adapter في الدفعة القادمة
        }
    }
}
