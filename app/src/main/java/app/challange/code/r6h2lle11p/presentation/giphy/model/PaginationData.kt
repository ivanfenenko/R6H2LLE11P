package app.challange.code.r6h2lle11p.presentation.giphy.model

import com.giphy.sdk.core.models.Media

class PaginationData {

    var data = arrayListOf<Media>()
    var isLoading = false

    fun offset() = data.size

}
