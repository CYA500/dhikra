package com.nexus.islamic.ui

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.View
import androidx.fragment.app.Fragment
import com.nexus.islamic.R
import com.nexus.islamic.databinding.FragmentTasbihBinding

class TasbihFragment : Fragment(R.layout.fragment_tasbih) {
    private var counter = 0
    private var target = 33
    private var _binding: FragmentTasbihBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentTasbihBinding.bind(view)

        // إعداد النقر على منطقة التسبيح
        binding.btnTapArea.setOnClickListener {
            incrementCounter()
        }

        // إعداد أزرار الأهداف
        binding.btn33.setOnClickListener { setTarget(33) }
        binding.btn100.setOnClickListener { setTarget(100) }
    }

    private fun incrementCounter() {
        counter++
        if (counter > target) counter = 1 // إعادة البدء بعد اكتمال الدورة
        
        updateUI()
        performHapticFeedback()
    }

    private fun setTarget(newTarget: Int) {
        target = newTarget
        counter = 0
        binding.progressRing.max = target
        updateUI()
    }

    private fun updateUI() {
        binding.tvCounter.text = counter.toString()
        binding.progressRing.progress = counter
    }

    // وظيفة الاهتزاز لمحاكاة ملمس السبحة الحقيقية
    private fun performHapticFeedback() {
        val vibrator = requireContext().getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            vibrator.vibrate(VibrationEffect.createOneShot(30, VibrationEffect.DEFAULT_AMPLITUDE))
        } else {
            vibrator.vibrate(30)
        }
    }
}
