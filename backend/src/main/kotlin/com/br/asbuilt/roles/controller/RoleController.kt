package com.br.asbuilt.roles.controller

import com.br.asbuilt.roles.RoleService
import com.br.asbuilt.roles.controller.requests.CreateRoleRequest
import com.br.asbuilt.roles.controller.responses.RoleResponse
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/roles")
class RoleController(val service: RoleService) {
    @PostMapping
    fun insert(@Valid @RequestBody role: CreateRoleRequest) =
        RoleResponse(service.insert(role.toRole()))
            .let { ResponseEntity.status(HttpStatus.CREATED).body(it) }

    @GetMapping
    fun list() =
        service.findAll()
            .map { RoleResponse(it) }
            .let { ResponseEntity.ok(it) }

}