package com.example.dotaapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.Date
@Parcelize()
data class Team(
    val id: Int,
    val name: String,
    val country : String,
    val logo: String?,
    val region: String?,
    val profit: String?,
    val startDate: Date?,
    val endDate: Date?
):Parcelable
