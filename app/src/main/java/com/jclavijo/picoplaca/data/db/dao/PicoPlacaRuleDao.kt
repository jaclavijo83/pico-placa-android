package com.jclavijo.picoplaca.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.jclavijo.picoplaca.data.db.PicoPlacaRuleWithWindows

@Dao
interface PicoPlacaRuleDao {

    @Transaction
    @Query("SELECT * FROM pico_placa_rules")
    fun getAllRulesWithWindows(): List<PicoPlacaRuleWithWindows>
}
