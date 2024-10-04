package dev.carlosivis.medtrack.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.carlosivis.medtrack.data.local.entity.PrescriptionEntity

@Dao
interface PrescriptionDao {
    @Query("SELECT * FROM prescriptions WHERE medicationId = :medicationId")
    fun getPrescriptionsByMedication(medicationId: Int): List<PrescriptionEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPrescription(prescription: PrescriptionEntity)

    @Delete
    fun deletePrescription(prescription: PrescriptionEntity)
}
