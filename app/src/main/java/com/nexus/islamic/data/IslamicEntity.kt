package com.nexus.islamic.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "islamic_items")
data class IslamicEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val type: String,          // "آية" أو "حديث" أو "ذكر"
    val content: String,       // النص الأساسي
    val source: String?,       // اسم السورة أو الكتاب [cite: 44, 49]
    val narrator: String?,     // الراوي (خاص بالأحاديث) [cite: 39]
    val number: String?,       // رقم الآية أو الحديث [cite: 44]
    val category: String,      // الفئة (صبر، توكل، صلاة...) [cite: 42, 43]
    val explanation: String?,  // التفسير أو الشرح [cite: 39, 44, 49]
    val repeatCount: Int = 1   // عدد التكرار المطلوب (خاص بالأذكار) [cite: 49]
)
