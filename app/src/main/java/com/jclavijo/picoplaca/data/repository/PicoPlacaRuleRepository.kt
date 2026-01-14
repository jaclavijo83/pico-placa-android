package com.jclavijo.picoplaca.data.repository

import com.jclavijo.picoplaca.core.model.PicoPlacaRule
import com.jclavijo.picoplaca.core.model.TimeWindow
import com.jclavijo.picoplaca.data.db.dao.PicoPlacaRuleDao

class PicoPlacaRuleRepository(
    private val ruleDao: PicoPlacaRuleDao
) {

    fun getAllRules(): List<PicoPlacaRule> {
        return ruleDao.getAllRulesWithWindows().map { ruleWithWindows ->

            val digits = ruleWithWindows.rule.restrictedLastDigits
                .split(",")
                .mapNotNull { it.trim().toIntOrNull() }
                .toSet()

            PicoPlacaRule(
                dayOfWeek = ruleWithWindows.rule.dayOfWeek,
                restrictedLastDigits = digits,
                windows = ruleWithWindows.windows.map {
                    TimeWindow(
                        startMinutes = it.startMinutes,
                        endMinutes = it.endMinutes
                    )
                }
            )
        }
    }
}
