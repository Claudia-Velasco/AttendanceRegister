package com.example.attendanceregister

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalTime
import java.util.Calendar.*

@RequiresApi(Build.VERSION_CODES.O)
fun main() {
    val period = Period(
        initialDate = LocalDate.parse("2022-09-07"),
        finalDate = LocalDate.parse("2022-12-25"),
        description = "Horario laboral"
    )

    val employee = Employee(
        id = 1,
        fullName = "Guadalupe Velasco García",
        curp = "VEGG991129MOCLRL11",
        dateOfAdmission = LocalDate.parse("2000-09-08"),
        budgetKey = "ABCDE12345",
        academicLevel = AcademicLevel.ASSOCIATE
    )

    val listScheduleDetails: ArrayList<Schedule.Detail> = arrayListOf(
        Schedule.Detail(
            dayOfWeek = DayOfWeek.of(MONDAY),
            checkIn = LocalTime.of(9, 0),
            checkOut = LocalTime.of(15, 0)
        ),
        Schedule.Detail(
            dayOfWeek = DayOfWeek.of(TUESDAY),
            checkIn = LocalTime.of(9, 0),
            checkOut = LocalTime.of(15, 0)
        ),
        Schedule.Detail(
            dayOfWeek = DayOfWeek.of(WEDNESDAY),
            checkIn = LocalTime.of(9, 0),
            checkOut = LocalTime.of(15, 0)
        ),
        Schedule.Detail(
            dayOfWeek = DayOfWeek.of(THURSDAY),
            checkIn = LocalTime.of(9, 0),
            checkOut = LocalTime.of(15, 0)
        ),
        Schedule.Detail(
            dayOfWeek = DayOfWeek.of(FRIDAY),
            checkIn = LocalTime.of(9, 0),
            checkOut = LocalTime.of(15, 0)
        ),
        Schedule.Detail(
            dayOfWeek = DayOfWeek.of(SATURDAY),
            checkIn = LocalTime.of(9, 0),
            checkOut = LocalTime.of(15, 0)
        ),
        Schedule.Detail(
            dayOfWeek = DayOfWeek.of(SUNDAY),
            checkIn = LocalTime.of(9, 0),
            checkOut = LocalTime.of(15, 0)
        )
    )
    val schedule = Schedule.Builder(employee = employee, period = period)
        .addMany(listScheduleDetails)
        .build()

    val listPermissions: List<Permission> = listOf(
        Permission(
            employee = employee,
            date = LocalDate.parse("2022-09-12"),
            justification = "Visita al médico"
        ),
        Permission(
            employee = employee,
            date = LocalDate.parse("2022-09-14"),
            justification = "Trafico"
        ),
        Permission(
            employee = employee,
            date = LocalDate.parse("2022-09-15"),
            justification = "Trafico"
        )
    )

    val listCheckInOut: List<CheckInOut> = listOf(
        CheckInOut(
            date = LocalDate.parse("2022-09-11"),
            employee = employee,
            checkIn = LocalTime.of(9, 10),
            checkOut = LocalTime.of(15, 0)
        ),
        CheckInOut(
            date = LocalDate.parse("2022-09-13"),
            employee = employee,
            checkIn = LocalTime.of(9, 16),
            checkOut = LocalTime.of(15, 0)
        ),
        CheckInOut(
            date = LocalDate.parse("2022-09-16"),
            employee = employee,
            checkIn = LocalTime.of(9, 0),
            checkOut = LocalTime.of(11, 0)
        )
    )

    println(
        "Persona ${employee.fullName}     " +
                "Dia: ${listCheckInOut[0].date}      " +
                "Retardo: ${listCheckInOut[0].isRetardant(schedule, listPermissions)}           " +
                "Registro incorrecto: ${
                    listCheckInOut[0].isAbsenceForIncorrectRegistration(
                        schedule,
                        listPermissions
                    )
                }"
    )

    println(
        "Persona ${employee.fullName}     " +
                "Dia: ${listCheckInOut[1].date}      " +
                "Retardo: ${listCheckInOut[1].isRetardant(schedule, listPermissions)}           " +
                "Registro incorrecto: ${
                    listCheckInOut[1].isAbsenceForIncorrectRegistration(
                        schedule,
                        listPermissions
                    )
                }"
    )

    println(
        "Persona ${employee.fullName}     " +
                "Dia: ${listCheckInOut[2].date}      " +
                "Retardo: ${listCheckInOut[2].isRetardant(schedule, listPermissions)}           " +
                "Registro incorrecto: ${
                    listCheckInOut[2].isAbsenceForIncorrectRegistration(
                        schedule,
                        listPermissions
                    )
                }"
    )

    val incident = Incident(
        employee = employee,
        currentSchedule = schedule,
        checksInOut = listCheckInOut,
        permissions = listPermissions,
        initialDate = LocalDate.parse("2022-09-11"),
        finalDate = LocalDate.parse("2022-09-17")
    )

    println("Periodo reportado  Inicial: ${incident.initialDate}   Final: ${incident.finalDate}")
    println("Ausencias:  ${incident.getAbsences()}")

}
