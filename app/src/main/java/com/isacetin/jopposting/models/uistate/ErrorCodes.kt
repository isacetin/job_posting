package com.isacetin.jopposting.models.uistate

@Suppress("ktlint:standard:property-naming")
object ErrorCodes {
    object Http {
        const val InternalServer = 501
        const val ServiceUnavailable = 503
        const val ResourceNotFound = 404
        const val BadRequest = 400
        const val Unauthorized = 401
    }
}
