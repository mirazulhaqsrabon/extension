
package com.extension.template

import androidx.annotation.Keep
import com.rk.extension.ExtensionAPI
import com.rk.extension.ExtensionContext

@Keep
@Suppress("unused")
class Main(context: ExtensionContext) : ExtensionAPI(context) {

    private var astroFileType: AstroFileType? = null

    override fun onLoad() {

        val astro = AstroFileType(context.resources)

        FileTypeManager.register(astro)

        astroFileType = astro
    }

    override fun onDispose() {

        astroFileType?.let {
            FileTypeManager.unregister(it)
        }

        astroFileType = null
    }
}
