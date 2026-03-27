package com.nexus.islamic.ui

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.nexus.islamic.R
import com.nexus.islamic.data.IslamicEntity
import com.nexus.islamic.databinding.FragmentAddBinding
import com.nexus.islamic.viewmodel.IslamicViewModel

class AddContentFragment : Fragment(R.layout.fragment_add) {
    private val viewModel: IslamicViewModel by viewModels()
    private var _binding: FragmentAddBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentAddBinding.bind(view)

        // إعداد قائمة الفئات (Dropdown)
        val categories = listOf("توكل", "طمأنينة", "صبر", "صلاة", "صيام", "عام")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, categories)
        binding.autoCompleteCategory.setAdapter(adapter)

        binding.btnSave.setOnClickListener {
            val content = binding.etContent.text.toString()
            if (content.isNotEmpty()) {
                val newItem = IslamicEntity(
                    type = if (binding.btnTypeAyah.isChecked) "آية" else "حديث",
                    content = content,
                    source = binding.etSource.text.toString(),
                    narrator = binding.etNarrator.text.toString(),
                    category = binding.autoCompleteCategory.text.toString(),
                    number = null,
                    explanation = null
                )
                viewModel.insertItem(newItem)
                Toast.makeText(context, "تم الحفظ في الروضة بنجاح", Toast.LENGTH_SHORT).show()
                binding.etContent.text?.clear()
            }
        }
    }
}
