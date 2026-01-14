package com.jclavijo.picoplaca.data.db

import androidx.room.Embedded
import androidx.room.Relation
import com.jclavijo.picoplaca.data.db.PicoPlacaRuleEntity
import com.jclavijo.picoplaca.data.db.TimeWindowEntity

data class PicoPlacaRuleWithWindows(

    @Embedded
    val rule: PicoPlacaRuleEntity,

    @Relation(
        parentColumn = "id",
        entityColumn = "ruleId"
    )
    val windows: List<TimeWindowEntity>
)
