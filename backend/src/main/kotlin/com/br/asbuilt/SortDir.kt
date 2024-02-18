package com.br.asbuilt

import com.br.asbuilt.exception.BadRequestException

enum class SortDir {
    ASC, DESC;

    companion object {
        fun findOrThrow(sortDir: String) =
            values().find { it.name == sortDir.uppercase() }
                ?: throw BadRequestException("Invalid sort dir!")
    }
}