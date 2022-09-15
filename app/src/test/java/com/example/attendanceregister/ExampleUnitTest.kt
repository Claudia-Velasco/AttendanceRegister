package com.example.attendanceregister

import org.junit.Test

import org.junit.Assert.*
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalTime
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun Seniority_isCorrect() {
        val employee = Employee(
            id = 1,
            fullName = "Rodolfo Ibarra Orozco",
            curp = "IORO651220HOCRMN09",
            dateOfAdmission = LocalDate.parse("2000-09-08"),
            budgetKey = "ABCDE12345",
            academicLevel = AcademicLevel.DOCTORAL
        )
        assertEquals(22, employee.getSeniority())
    }
/*
    @Test
    fun insertSchedule() {


        val employee = Employee(
            id = 1,
            fullName = "Rodolfo Ibarra Orozco",
            curp = "IORO651220HOCRMN09",
            dateOfAdmission = LocalDate.parse("2000-09-08"),
            budgetKey = "ABCDE12345",
            academicLevel = AcademicLevel.DOCTORAL
        )

        val period = Period(
            initialDate = LocalDate.parse("2022-09-08"),
            finalDate = LocalDate.parse("2022-12-08"),
            description = "Hora laboral"
        )

        val detail = Schedule.Detail(
            dayOfWeek = DayOfWeek.of(Calendar.SUNDAY),
            checkIn = LocalTime.of(9, 0),
            checkOut = LocalTime.of(15, 0)
        )

        val schedule = Schedule.Builder(
            employee = employee,
            period = period
        )
            .addOne(detail)
            .build()
        assertEquals(true, schedule.getDetails())

    }

 */

}