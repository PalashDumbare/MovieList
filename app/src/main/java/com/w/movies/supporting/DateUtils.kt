package com.w.movies.supporting

import java.text.ParseException
import java.text.SimpleDateFormat

class DateUtils {
    companion object{
        fun convertDate(date: String, fromFormat: String, toFormat: String): String? {
            var date = date
            try {
                val simpleDateFormat = SimpleDateFormat(fromFormat)
                val dateFormat = SimpleDateFormat(toFormat)
                val parse = simpleDateFormat.parse(date)
                date = dateFormat.format(parse)
            } catch (e: ParseException) {
                // TODO Auto-generated catch block
                e.printStackTrace()
            }
            return date
        }
        }
}